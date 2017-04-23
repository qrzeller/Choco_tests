package com.chocoTest.app.model;
import org.chocosolver.solver.Solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qtask on 23.04.2017.
 */
public class VariableAndConstraint {
    private Model model;
    private ArrayList<IntVar> vars;
    private IntVar universe;
    public VariableAndConstraint(int universe){
        model = new Model("A day constraint of " + universe +"slot");
        vars = new ArrayList<IntVar>(24);
        //this.universe = model.setVar("universe", 1 , 24);

    }

    public void addTask(String taskName, int from, int to, int duration) {
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
}
