package General;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class Patient {

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate dob;
    private Admission admission;

    public Patient(String patientFirstName, String patientLastName, int patientAge, LocalDate patientDateOfBirth, Admission patientAdmission) {

        firstName = patientFirstName;
        lastName = patientLastName;
        age = patientAge;
        dob = patientDateOfBirth;
        admission = patientAdmission;
    }

    public static String getJSONPath(){
        return File.separator + System.getProperty("user.dir") + File.separator + "JSON_files" + File.separator + "patient.json";
    }

    public static void writeJSONFile(Patient patient) throws IOException{

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create(); 
        FileWriter writer = new FileWriter(getJSONPath());
        writer.write(gson.toJson(patient));   
        writer.close();
    }

    public static Patient readJSONFile() throws FileNotFoundException{

        GsonBuilder builder = new GsonBuilder(); 
        Gson gson = builder.create(); 
        BufferedReader bufferedReader = new BufferedReader(new FileReader(getJSONPath()));   
        Patient patient = gson.fromJson(bufferedReader, Patient.class); 
        return patient; 
    }

    public String toString(){
        String toReturn = "fname: " + firstName + "|| lname: " + lastName + "|| age: " + age + "|| dob: " + "|| admission: {" + admission +"}";
        return toReturn;
    }

    public String getPatientFirstName() {
        return firstName;
    }

    public String getPatientLastName() {
        return lastName;
    }

    public int getPatientAge() {
        return age;
    }

    public LocalDate getPatientDateOfBirth() {
        return dob;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }
}