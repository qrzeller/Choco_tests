package com.chocoTest.app.model.Solver;
import org.chocosolver.solver.Solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Quentin Zeller on 23.04.2017.
 *
 * http://choco-solver.readthedocs.io/en/latest/2_modelling.html
 * https://media.readthedocs.org/pdf/choco-solver/latest/choco-solver.pdf
 *
 * The @class VariableAncConstrain set all the value/task in the solver cutting them into sub-task with their respective
 * constraint
 *
 *
 */
public class VariableAndConstraint {
    private Model model;
    private ArrayList<IntVar> vars;
    private IntVar universe;

    private int upperBound = Integer.MAX_VALUE;
    private int lowerBound = 0;

    public VariableAndConstraint(int universe){
        model = new Model("A day constraint of " + universe +"slot");
        vars = new ArrayList<IntVar>(24);// At least one day.
    }


    /**
     * Set the lower and upperbound of the task variable we get.
     * @param from Usually the current day and hour
     * @param to The max time value we want to compute.
     */
    public void setDomain(int from, int to){
        lowerBound = from;
        upperBound = to;
    }


    /**
     * Add task where the duration is one hour
     * @param taskName the name of the task
     * @param from When we can start the task
     * @param to When we must finish the task
     * @param duration The duration of the task in increment of sensibility.
     */
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


    /**
     * Say that not all constraint need to be satisfiable
     */
    public void reifyingAll(){
        //TODO
    }

    /**
     * Some constraint does not need to be satisfied
     * @param vars The constraint that does not need to be satisfied.
     */
    public void reifyingSome(int[] vars){
        //TODO
    }
}
