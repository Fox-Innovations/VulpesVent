from EmulatorGUI import GPIO
import time 

class PythonMotorController  
    step = 0
    dir = 0   
    ms1 = 0 
    ms2 = 0
    ms3 = 0
    en = 0

    def __init__ (self, stepPin, dirPin, ms1Pin, ms2Pin, ms3Pin, enPin)
        self.step = stepPin
        self.dir = dirPin
        self.ms1 = ms1Pin
        self.ms2 = ms2Pin
        self.ms3 = ms3Pin
        self.en = enPin
    

