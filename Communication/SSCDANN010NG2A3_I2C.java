package Communication;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

// The SSCDANN010NG2A3 is the pressure sensor used to determine the PSI or cmH2O of the pressure system 
public class SSCDANN010NG2A3_I2C {

    // SSCDANN010NG2A3 address pin
    // Address pin not connected (FLOATING)
    public static int SSCDANN010NG2A3_ADDR;

    // SSCDANN010NG2A3 HEX Registers
    public static byte SSCDANN010NG2A3_REG_ID;
    public static byte SSCDANN010NG2A3_DATA_0;
    public static byte SSCDANN010NG2A3_DATA_1;
    public static byte SSCDANN010NG2A3_REG_CONTROL;

    // SSCDANN010NG2A3 Power control values HEX
    public static byte SSCDANN010NG2A3_POWER_UP;
    public static byte SSCDANN010NG2A3_POWER_DOWN;

    // I2C Bus ID
    public static I2CBus i2c;

    // I2C Device declaration
    public static I2CDevice device;

    //Hrz Cycle time
    public static int hrz;

    public SSCDANN010NG2A3_I2C(int I2CBusID, int hrzCycle, int ADDR, byte REG_ID, byte DATA_0, byte DATA_1, byte REG_CONTROL,
            byte POWER_UP, byte POWER_DOWN) throws UnsupportedBusNumberException, IOException {

        i2c = I2CFactory.getInstance(I2CBusID);
                
        hrz = hrzCycle;
        SSCDANN010NG2A3_ADDR = ADDR;
        SSCDANN010NG2A3_REG_ID = REG_ID;
        SSCDANN010NG2A3_DATA_0 = DATA_0;
        SSCDANN010NG2A3_DATA_1 = DATA_1;
        SSCDANN010NG2A3_REG_CONTROL = REG_CONTROL;
        SSCDANN010NG2A3_POWER_UP = POWER_UP;
        SSCDANN010NG2A3_POWER_DOWN = POWER_DOWN;

        device = i2c.getDevice(SSCDANN010NG2A3_ADDR);

    }

    //Starts the device so that data can be read
    public static void powerUp() throws IOException {

        device.write(SSCDANN010NG2A3_REG_CONTROL, SSCDANN010NG2A3_POWER_UP);
    }

    //Powers down the device so that it is no longer running and data can no longer be read
    public static void powerDown() throws IOException {

        device.write(SSCDANN010NG2A3_REG_CONTROL, SSCDANN010NG2A3_POWER_DOWN);
    }

    //read the current values
    public static int[] read() throws IOException, InterruptedException {
        
        int data0 = device.read(SSCDANN010NG2A3_DATA_0);
        int data1 = device.read(SSCDANN010NG2A3_DATA_0);
        int [] toReturn = {data0, data1};
        
        //Hopefully this sleeps the thread that is excecuting this so that only it sleeps
        //Sleeps for a single cycle time so that the data can be retrieved, this may be unessicary
        //#TODO check to make sure that this is actually necessary
        Thread.currentThread();
        Thread.sleep((long) (Math.pow(hrz, -1) * 1000));

        return toReturn;
    }

}