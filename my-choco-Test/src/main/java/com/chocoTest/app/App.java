package com.chocoTest.app;

import com.chocoTest.app.model.VariableAndConstraint;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        VariableAndConstraint var = new VariableAndConstraint(24);
        var.addTask("Eat",11,14,2);
        var.addTask("WorkAfternoon", 12,20,5);
        var.addTask("sleepMorning", 1,12,4);
        var.addTask("sleepEvening", 19,24,3);
        var.addTask("workMorning",4,12,2);

        System.out.println(var.solve());




    }
}
