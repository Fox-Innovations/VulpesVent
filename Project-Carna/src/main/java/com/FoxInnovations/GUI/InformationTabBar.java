package com.FoxInnovations.GUI;

import java.io.FileNotFoundException;

import com.FoxInnovations.Information.AdmissionInfo;
import com.FoxInnovations.Information.PatientInfo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InformationTabBar {

    private PatientInfo patient;
    private TabPane informationTabPane;

    private Tab systemInformationTab;
    private Tab operatingInformationTab;
    private Tab patientInformationTab;
    private Tab patientAdmissionInformationTab;
    private TextArea systemInformationText;
    private TextArea operatingInformationText;
    private GridPane patientInformationGrid;
    private TextArea patientAdmissionInformationText;

    public InformationTabBar(int w, int h, int x, int y) {

        informationTabPane = new TabPane();

        // #TODO Remake text infos as labels within a gridPane
        // tab; it will make it cleaner

        informationTabPane.relocate(x, y);
        informationTabPane.setPrefSize(w, h);
        informationTabPane.setBackground(
                new Background(new BackgroundFill(Paint.valueOf("3E3E3E"), new CornerRadii(0), new Insets(0))));
        //informationTabPane.getStylesheets().add(getClass().getResource("infoTabBar.css").toExternalForm());
        informationTabPane.getStylesheets().add(getClass().getResource("infoTabBar.css").toExternalForm());

        systemInformationText = new TextArea("");
        operatingInformationText = new TextArea("");
        patientInformationGrid = new GridPane();
        patientAdmissionInformationText = new TextArea("");

        systemInformationTab = new Tab("System", systemInformationText);
        operatingInformationTab = new Tab("Operating", operatingInformationText);
        patientInformationTab = new Tab("Patient", patientInformationGrid);
        patientAdmissionInformationTab = new Tab("Admission", patientAdmissionInformationText);
        SettingsTab settingsTab = new SettingsTab(this);

        systemInformationTab.setClosable(false);
        operatingInformationTab.setClosable(false);
        patientInformationTab.setClosable(false);
        patientAdmissionInformationTab.setClosable(false);
        settingsTab.getSettingsTab().setClosable(false);

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

        Label patientFName = new Label("Patient First Name ");
        Label patientLName = new Label("Patient Last Name: ");
        Label patientAge = new Label("Patient Age: ");
        Label patientDOB = new Label("Patient Date of Birth: ");
        Text patientFNameText = new Text(patient.getPatientFirstName());
        Text patientLNameText = new Text(patient.getPatientLastName());
        Text patientAgeText = new Text(patient.getPatientAge() + "");
        Text patientDOBText = new Text(patient.getPatientDateOfBirth() + "");

        patientInformationGrid.add(new Text(), 0, 0);
        patientInformationGrid.add(patientFName, 0, 1);
        patientInformationGrid.add(patientLName, 0, 2);
        patientInformationGrid.add(patientAge, 0, 3);
        patientInformationGrid.add(patientDOB, 0, 4);
        patientInformationGrid.add(patientFNameText, 1, 1);
        patientInformationGrid.add(patientLNameText, 1, 2);
        patientInformationGrid.add(patientAgeText, 1, 3);
        patientInformationGrid.add(patientDOBText, 1, 4);

        patientFName.setTextFill(Paint.valueOf("ffffff"));
        patientFName.setFont(new Font(24));
        patientLName.setTextFill(Paint.valueOf("ffffff"));
        patientLName.setFont(new Font(24));
        patientAge.setTextFill(Paint.valueOf("ffffff"));
        patientAge.setFont(new Font(24));
        patientDOB.setTextFill(Paint.valueOf("ffffff"));
        patientDOB.setFont(new Font(24));
        patientFNameText.setFill(Paint.valueOf("ffffff"));
        patientFNameText.setFont(new Font(24));
        patientLNameText.setFill(Paint.valueOf("ffffff"));
        patientLNameText.setFont(new Font(24));
        patientAgeText.setFill(Paint.valueOf("ffffff"));
        patientAgeText.setFont(new Font(24));
        patientDOBText.setFill(Paint.valueOf("ffffff"));
        patientDOBText.setFont(new Font(24));

        patientInformationGrid.setHgap(12);
        patientInformationGrid.setVgap(12);

        patientInformationGrid.setAlignment(Pos.TOP_CENTER);

        patientInformationGrid.setBackground(
                new Background(new BackgroundFill(Paint.valueOf("3E3E3E"), new CornerRadii(0.0, 0.0, 5.0, 5.0, false), new Insets(0))));

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