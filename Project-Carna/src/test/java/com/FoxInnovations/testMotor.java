package com.FoxInnovations;

import com.pi4j.io.gpio.PinState;
import java.util.Scanner;

public class testMotor{

    private static MotorControl motorController;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String promptMessage = "";
        promptMessage+= "Would you like to run:";
        promptMessage+= "\n(1)Basic Functionality Test";

        System.out.println(promptMessage);
        String torun = in.next();
        if(torun.equals("1")){
            basicFunctionalityTest();
        }
        

    }

    public static void basicFunctionalityTest(){

        // L L L == Full Step
        // H L L == Half Step
        // L H L == Quarter Step
        // H H L == Eighth Step
        // H H H == Sixteenth Step

        motorController.setEnableOn();
        
        //Full rotation forward
        motorController.setStep(PinState.LOW, PinState.LOW, PinState.LOW);
        motorController.setDIRHigh();
        motorController.run(0.5, 1);

        //Full rotation backward
        motorController.setDIRLOW();
        motorController.run(0.5, 1);

        //Half rotation forward
        motorController.setStep(PinState.HIGH, PinState.LOW, PinState.LOW);
        motorController.setDIRHigh();
        motorController.run(0.5, 1);

        //Half rotation backwards
        motorController.setDIRLOW();
        motorController.run(0.5, 1);

        //Quarter rotation forwards
        motorController.setStep(PinState.LOW, PinState.HIGH, PinState.LOW); 
        motorController.setDIRHigh();
        motorController.run(0.5, 1);

        //Quarter rotation backwards
        motorController.setDIRLOW();
        motorController.run(0.5, 1);

        //Eighth rotation forwards
        motorController.setStep(PinState.HIGH, PinState.HIGH, PinState.LOW);
        motorController.setDIRHigh();
        motorController.run(0.5, 1);

        //Eight rotation backwards
        motorController.setDIRLOW();
        motorController.run(0.5, 1);

        //Sixteenth rotation forwards
        motorController.setStep(PinState.HIGH, PinState.HIGH, PinState.HIGH);
        motorController.setDIRHigh();
        motorController.run(0.5, 1);

        //Sixteenth rotation backwards
        motorController.setDIRLOW();
        motorController.run(0.5, 1);

        //disable
        motorController.setEnableOff();

    }

}