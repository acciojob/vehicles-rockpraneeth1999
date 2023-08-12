package com.driver;

public class F1 extends Car {

    public F1(String name, boolean isManual) {
        //Use arbitrary values for parameters which are not mentioned
        super(name, 4, 2, 7, isManual, "Formula 1", 1);
    }

    public void accelerate(int rate){
        int newSpeed = getCurrentSpeed()+rate; //set the value of new speed by using currentSpeed and rate
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */

        if (newSpeed < 0) {
            newSpeed = 0; // Ensure speed is not negative
        }

        int newGear;

        if (newSpeed == 0) {
            newGear = 1; // Stop the car, set gear as 1
        } else if (newSpeed <= 50) {
            newGear = 1;
        } else if (newSpeed <= 100) {
            newGear = 2;
        } else if (newSpeed <= 150) {
            newGear = 3;
        } else if (newSpeed <= 200) {
            newGear = 4;
        } else if (newSpeed <= 250) {
            newGear = 5;
        } else {
            newGear = 6;
        }

        super.changeGear(newGear);

        if (newSpeed > 0) {
            changeSpeed(newSpeed, getCurrentDirection());
        }
    }
}
