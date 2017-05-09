package com.chocoTest.app;

import com.chocoTest.app.model.Solver.VariableAndConstraint;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        VariableAndConstraint var = new VariableAndConstraint(24);
        var.addTaskHour("Eat",11,14,2);
        var.addTaskHour("WorkAfternoon", 12,20,5);
        var.addTaskHour("sleepMorning", 1,12,4);
        var.addTaskHour("sleepEvening", 19,24,3);
        var.addTaskHour("workMorning",4,12,2);

        System.out.println(var.solve());




    }
}
