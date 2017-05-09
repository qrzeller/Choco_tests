package com.chocoTest.app.model.Solver;

/**
 * Created by Quentin Zeller on 09.05.2017.
 *
 * Some functions helping the model
 */
public class Tools {

    /**
     * to know the fraction of an hour the sensibility is.
     * @param minuts
     * @return
     */
    public static int getFractionOfHour(int minuts){
        switch (minuts){
            case 60 :
                return 1;
            case 0  :
                return 1;
            case 30 : return 2;
            case 15 : return 4;
            case 1  :
                System.out.println("not a power of two!");
                return 60;
            default :
                System.out.println("There is probably a problem");
                return 0;
        }
    }
}
