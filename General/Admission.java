package General;

import java.time.LocalDate;

public class Admission {

    private LocalDate admissionDate;
    private String diagnosis;
    private String drFirstName;
    private String drLastName;

    public Admission(LocalDate dateOfAdmission, String patientDiagnosis, String doctorFirstName, String doctorLastName) {

        admissionDate = dateOfAdmission;
        diagnosis = patientDiagnosis;
        drFirstName = doctorFirstName;
        drLastName = doctorLastName;
    }

    public String toString(){
        String toReturn = "AdmissionDate: " + admissionDate + "|| diagnosis: " + diagnosis + "|| drlname: " +drLastName+ "|| drfname: " + drFirstName;
        return toReturn;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getDrFirstName() {
        return drFirstName;
    }

    public String getDrLastName() {
        return drLastName;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setDrFirstName(String drFirstName) {
        this.drFirstName = drFirstName;
    }

    public void setDrLastName(String drLastName) {
        this.drLastName = drLastName;
    }
}