package com.FoxInnovations.Information;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LiveDataInfo {

    private static double currentTidalVolume;
    private static double currentPSI;
    private static double currentBPM;
    private static ScheduledExecutorService scheduler;

    public LiveDataInfo(){
        
        scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {

            refresh();

        }, 0, 10, TimeUnit.MILLISECONDS);
        

    }

    public static void refresh(){

        setCurrentTidalVolume();
        setCurrentBPM();
        setCurrentPSI();
    }

    private static void setCurrentTidalVolume(){
        //retieves data from mass flow sensor
        //if no available input set as null
    }

    private static void setCurrentPSI(){
        //retrieves data from pressure sensor
        //if no available input set as null
    }

    private static void setCurrentBPM(){
        //value calculated based off cycles per minute;
        //if no available input set as null
    }   

    public static double getCurrentTidalVolume(){
        return  currentTidalVolume;
    }

    public static double getCurrentPSI(){
        return currentPSI;
    }

    public static double getCurrentBPM(){
        return currentBPM;
    }
}