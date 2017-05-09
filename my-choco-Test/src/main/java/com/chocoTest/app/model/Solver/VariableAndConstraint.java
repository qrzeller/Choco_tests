package com.chocoTest.app.model.Solver;
import org.chocosolver.solver.Solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qtask on 23.04.2017.
 *
 * http://choco-solver.readthedocs.io/en/latest/2_modelling.html
 * https://media.readthedocs.org/pdf/choco-solver/latest/choco-solver.pdf
 *
 *
 */
public class VariableAndConstraint {
    private Model model;
    private ArrayList<IntVar> vars;
    private IntVar universe;

    public VariableAndConstraint(int universe){
        model = new Model("A day constraint of " + universe +"slot");
        vars = new ArrayList<IntVar>(24);// At least one day.
    }

    public void setDomain(){

    }


    public void addTaskHour(String taskName, int from, int to, int duration) {
        for(int i = 0; i < duration ; i++){
            IntVar var = model.intVar(taskName+"_"+i, from, to);
            vars.add(var);
        }
    }
    public String solve(){
        String response = "";
        IntVar[] array = vars.toArray(new IntVar[0]);
        model.allDifferent(array).post();

        String status;
        if(model.getSolver().solve()){
            status = "Found!\n";
        }else
        {
            status = "not found \n";
        }
        for(IntVar v :vars){
            response += v.getValue() + " : " +v.getName() +"\n";
        }
        String[] sorted = response.split("\n");
        Arrays.sort(sorted);

        String result = "";
        for(String l:sorted){
            if(!Character.isDigit(l.charAt(1))) result+=l + "\n";
        }
        for(String l:sorted){
            if(Character.isDigit(l.charAt(1))) result+=l + "\n";
        }

        return status + result;
    }

    /* Allowing all constraint not to be satisfied-->
    See Reify
     */
    public void reifyingAll(){
        //TODO
    }
    public void reifyingSome(int[] vars){
        //TODO
    }
}
