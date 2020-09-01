package com.FoxInnovations.Control;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Controls all digital general-purpose-input-output (GPIO) signals that actuate
 * the stepper motor via the Sparkfun "Big Easy Driver" module
 */
public class MotorControl {

    private final GpioPinDigitalOutput STEP;
    private final GpioPinDigitalOutput DIR;
    private final GpioPinDigitalOutput MS1;
    private final GpioPinDigitalOutput MS2;
    private final GpioPinDigitalOutput MS3;
    private final GpioPinDigitalOutput EN;
     

    public MotorControl(int stepPin, int dirPin, int MS1Pin, int MS2Pin, int MS3Pin, int ENPin) {
        // Create the controller instance
        final GpioController gpio = GpioFactory.getInstance();

        // Identify each motor pin communicating with the pi. All pins are set as output
        // pins.
        STEP = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(stepPin), "step");
        DIR = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(dirPin), "direction");
        MS1 = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(MS1Pin), "MS1");
        MS2 = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(MS2Pin), "MS2");
        MS3 = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(MS3Pin), "MS3");
        EN = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(ENPin), "EN");
    }
}