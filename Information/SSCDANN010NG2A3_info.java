package Information;

import java.util.ArrayList;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import Communication.SSCDANN010NG2A3_I2C;

public class SSCDANN010NG2A3_info {

    public static ArrayList<int[]> values;

    public SSCDANN010NG2A3_info() {
        values = new ArrayList<int[]>();
    }

    private static String getJSONPath() {
        // #TODO add in project carna to this file name, this does not work on other
        // computers
        return File.separator + System.getProperty("user.dir") + File.separator + "JSON_files" + File.separator
                + "patient.json";
    }

    //this should be scheduled to repeat to a multiple of the hrz cycle 
    public static void updateJSON() {

        try {

            SSCDANN010NG2A3_info.addCurrentValue();
            writeJSON();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int[][] getValues() throws FileNotFoundException {
        return readJSON();
    }

    private static void writeJSON() throws IOException {

        int [][] toWrite = SSCDANN010NG2A3_info.valuesToArray();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter(getJSONPath());
        writer.write(gson.toJson(toWrite));
        writer.close();
    }

    private static int[][] readJSON() throws FileNotFoundException {

        GsonBuilder builder = new GsonBuilder(); 
        Gson gson = builder.create(); 
        BufferedReader bufferedReader = new BufferedReader(new FileReader(SSCDANN010NG2A3_info.getJSONPath()));   
        int[][] readfrom = gson.fromJson(bufferedReader, int[][].class); 
        return readfrom; 
    }

    private static void addCurrentValue() throws IOException {
        try {
            int[] toAdd = SSCDANN010NG2A3_I2C.read();
            values.add(toAdd);
        } catch (InterruptedException e) {
            System.out.println("Data read has been inturupted");
            e.printStackTrace();
        }
    }

    private static int[][] valuesToArray(){

        int[][] toReturn = new int[values.size()][2];

        for(int i = 0; i < values.size(); i++) {

            toReturn[i][0] = values.get(i)[0];
            toReturn[i][1] = values.get(i)[1];
        }

        return toReturn;
    }

}