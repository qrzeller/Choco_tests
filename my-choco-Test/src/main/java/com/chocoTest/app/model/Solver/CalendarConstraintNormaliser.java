package com.chocoTest.app.model.Solver;

/**
 * Created by Quentin Zeller on 09.05.2017.
 *
 * Take care of transforming calendar event to tasks usable by the solver
 *
 * For example a task that begin at 10h15 and end at 11h must be transformed into two ConstraintTask of 10h and 10h30
 * when the semsibilyty is 30 minuts
 */
public class CalendarConstraintNormaliser {

    /**
     * Transform the start and stop date with the precision of the sensibility.
     * @return return the task we pass in parameter.
     */
    public Task normalizeTask(Task t){
        t.startDateTime();
        t.endDateTime();
        t.deadline();
        //TODO
    }
}
