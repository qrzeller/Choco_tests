package com.chocoTest.app.model;
import org.chocosolver.solver.Solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.SetVar;

import java.util.ArrayList;

/**
 * Created by qtask on 23.04.2017.
 */
public class VariableAndConstraint {
    private Model model;
    private ArrayList<SetVar> vars;
    private SetVar universe;
    public VariableAndConstraint(int universe){
        model = new Model("A day constraint of " + universe +"slot");
        vars = new ArrayList<SetVar>(24);
        //this.universe = model.setVar("universe", 1 , 24);

    }

    public void addTask(String taskName, int from, int to, int duration) {
        for(int i = 0; i < duration ; i++){
            SetVar var = model.setVar(taskName, from, to);
            vars.add(var);
        }
    }
    public String solve(){
        String response = "";
        SetVar[] array = vars.toArray(new SetVar[0]);
        model.allDisjoint(array).post();
        
        if(model.getSolver().solve()){
            response += "Found!";
        }else
        {
            response += "not found :";
        }
        for(SetVar v :vars){
            response += v.getValue() + " : " +v.getName() +"\n";
        }
        return response;
    }
}
