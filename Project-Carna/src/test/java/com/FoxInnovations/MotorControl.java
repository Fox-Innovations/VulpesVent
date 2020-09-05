package com.FoxInnovations;

import java.util.Timer;
import java.util.TimerTask;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Controls all digital general-purpose-input-output (GPIO) signals that actuate
 * the stepper motor via the Sparkfun "Big Easy Driver" module
 * 
 * Implementation Guide:
 * construct MotorControl object
 * use setEnableOn() method to enable motor (can be changed)
 * use setStep() method to set step type (can be changed)
 * use either setDirHigh() or setDirLow() methods to set motor direction (can be changed)
 * {
 *  ...implementation...
 * }
 * use setEnableOff() to disable motor
 */
public class MotorControl {

    private final GpioPinDigitalOutput STEP;
    private final GpioPinDigitalOutput DIR;
    private final GpioPinDigitalOutput MS1;
    private final GpioPinDigitalOutput MS2;
    private final GpioPinDigitalOutput MS3;
    private final GpioPinDigitalOutput EN;
    // change to actual value
    private final int MAX_TICKS_PER_SEC = 1000;
    private final int TICKS_PER_ROTAION = 100;

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

    public void run(double speed, double numRotations) {

        int totalTicks = (int) (numRotations * TICKS_PER_ROTAION);
        // speed is a percentage of the maximum speed
        int ticksPerSec = (int) (MAX_TICKS_PER_SEC * speed);
        // this is how frequently a tick action is meant to be performed, the interval
        // between ticks
        long schedulerInterval = 1000 / ticksPerSec;

        Timer timer = new Timer();
        TimerTask step = new TimerTask() {

            private int counter = 0;

            public void run() {
                takeStep();
                if (++counter >= totalTicks) {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(step, 0, schedulerInterval);
    }

    public void run(double speed, long timeInMillis, boolean diferentiator) {

        int ticksPerSec = (int) (MAX_TICKS_PER_SEC * speed);
        // this is how frequently a tick action is meant to be performed, the interval
        // between ticks
        long schedulerInterval = 1000 / ticksPerSec;
        long currentTime = System.currentTimeMillis();
        long targetTime = currentTime + timeInMillis;

        Timer timer = new Timer();
        TimerTask step = new TimerTask() {

            private long counter = System.currentTimeMillis();;

            public void run() {
                takeStep();
                if (counter >= targetTime || counter + schedulerInterval >= targetTime) {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(step, 0, schedulerInterval);

    }

    public void takeStep() {
        STEP.setState(PinState.LOW);
        STEP.setState(PinState.HIGH);
    }

    public void setStep(PinState ms1State, PinState ms2State, PinState ms3State) {

        // L L L == Full Step
        // H L L == Half Step
        // L H L == Quarter Step
        // H H L == Eight Step
        // H H H == Sixteenth Step

        MS1.setState(ms1State);
        MS2.setState(ms2State);
        MS3.setState(ms3State);
    }

    public void toggleDir() {
        if (DIR.getState().equals(PinState.LOW)) {
            this.setDIRHigh();
        } else if (DIR.getState().equals(PinState.HIGH)) {
            this.setDIRLOW();
        }
    }

    public void setDIRHigh() {
        DIR.setState(PinState.HIGH);
    }

    public void setDIRLOW() {
        DIR.setState(PinState.LOW);
    }

    public void toggleEnable() {
        if (EN.getState().equals(PinState.LOW)) {
            EN.setState(PinState.HIGH);
        } else if (EN.getState().equals(PinState.HIGH)) {
            EN.setState(PinState.LOW);
        }
    }

    public void setEnableOn() {
        EN.setState(PinState.HIGH);
    }

    public void setEnableOff() {
        EN.setState(PinState.LOW);
    }

}
