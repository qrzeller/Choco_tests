package com.chocoTest.app.model.Solver;

/**
 * Created by qtask on 09.05.2017.
 *
 * Map calendar schedule constraint and task constraint to simplified integer based on the sensibility
 */
public class EventAndConstraintMapper {
    private int sensibility = 30;


    /**
     * Shift the integer to get rid of the unused minuts we do not want.
     *
     * For example if the sensibility is 30 minuts we need only 1 bit in the minuts area.
     * If the sensibility is 1h 0bits, 15minuts 4 bits, etc...
     */
    private void shiftRight(){
        //TODO
    }

    /**
     * This function use the parameter sensibility to define the global duration of tasks.
     * The preemption could be done after a duration of this time.
     * @param sensibility
     * Used to define the size of a task in minuts
     */
    public void setSensibility(int sensibility){
        this.sensibility = sensibility;
    }


}
