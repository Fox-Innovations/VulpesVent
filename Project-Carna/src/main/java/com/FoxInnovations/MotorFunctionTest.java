package com.FoxInnovations;

import com.FoxInnovations.Control.MotorControl;
import com.pi4j.io.gpio.PinState; 


public class MotorFunctionTest {
    public static void main(String [] args){

        //These are not real pin numbers, they are placeholders.
        MotorControl motorController = new MotorControl(1, 2, 3, 4, 5, 6);

        motorController.toggleEnable();
        motorController.setStep(PinState.LOW, PinState.LOW, PinState.LOW);
        motorController.run(0.5, 1);
        
        motorController.toggleDir();
        motorController.run(0.5, 1);

        motorController.setStep(PinState.HIGH, PinState.HIGH, PinState.HIGH);
        motorController.run(0.5, 1);

    }
}
