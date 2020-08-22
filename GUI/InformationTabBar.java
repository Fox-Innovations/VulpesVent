package GUI;

import java.io.FileNotFoundException;
import Information.*;
import javafx.scene.control.*;

public class InformationTabBar {

    private PatientInfo patient;
    private TabPane informationTabPane;

    private Tab systemInformationTab;
    private Tab operatingInformationTab;
    private Tab patientInformationTab;
    private Tab patientAdmissionInformationTab;
    private TextArea systemInformationText;
    private TextArea operatingInformationText;
    private TextArea patientInformationText;
    private TextArea patientAdmissionInformationText;

    public InformationTabBar(int x, int y) {



        informationTabPane = new TabPane();

        //#TODO give this a scene so that you dont have to have it for the settings tab; it will make it cleaner

        informationTabPane.relocate(10, 10);
        informationTabPane.setPrefSize(x, y);

        systemInformationText = new TextArea("");
        operatingInformationText = new TextArea("");
        patientInformationText = new TextArea("");
        patientAdmissionInformationText = new TextArea("");

        systemInformationTab = new Tab("System", systemInformationText);
        operatingInformationTab = new Tab("Operating", operatingInformationText);
        patientInformationTab = new Tab("Patient", patientInformationText);
        patientAdmissionInformationTab = new Tab("Admission", patientAdmissionInformationText);

        SettingsTab settingsTab = new SettingsTab(this);

        informationTabPane.getTabs().add(patientInformationTab);
        informationTabPane.getTabs().add(patientAdmissionInformationTab);
        informationTabPane.getTabs().add(systemInformationTab);
        informationTabPane.getTabs().add(operatingInformationTab);
        informationTabPane.getTabs().add(settingsTab.getSettingsTab());

        try {

            patient = PatientInfo.readJSONFile();
            placePatientText(patient);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void refresh() {
        try {
            placePatientText(patient);
            // placeAdmissionText(patient);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TabPane getInformationTabBar() {
        return informationTabPane;
    }

    private void placePatientText(PatientInfo patient) throws FileNotFoundException {

        patient = PatientInfo.readJSONFile();
        String toSet = "";
        toSet += "Patient First Name: \t\t" + patient.getPatientFirstName();
        toSet += "\nPatient Last Name: \t\t" + patient.getPatientLastName();
        toSet += "\nPatient Age: \t\t\t" + patient.getPatientAge();
        toSet += "\nPatient Date of Birth: \t" + patient.getPatientDateOfBirth();

        patientInformationText.setText(toSet);

        placeAdmissionText(patient);

    }

    private void placeAdmissionText(PatientInfo patient) {

        AdmissionInfo admission = patient.getAdmission();

        String toSet = "";
        toSet += "Date of Admission: \t\t" + admission.getAdmissionDate();
        toSet += "\nDoctors First Name: \t" + admission.getDrFirstName();
        toSet += "\nDoctors Last Name: \tDr." + admission.getDrLastName();
        toSet += "\nPatient Diagnosis: \t\t" + admission.getDiagnosis();

        patientAdmissionInformationText.setText(toSet);
    }

}