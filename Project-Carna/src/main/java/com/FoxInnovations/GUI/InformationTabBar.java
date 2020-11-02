package com.FoxInnovations.GUI;

import java.io.FileNotFoundException;

import com.FoxInnovations.Information.AdmissionInfo;
import com.FoxInnovations.Information.PatientInfo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
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
    private GridPane patientAdmissionInformationGrid;

    public InformationTabBar(int w, int h, int x, int y) {

        informationTabPane = new TabPane();

        // #TODO Remake text infos as labels within a gridPane
        // tab; it will make it cleaner

        informationTabPane.relocate(x, y);
        informationTabPane.setPrefSize(w, h);
        informationTabPane.setBackground(
                new Background(new BackgroundFill(Paint.valueOf("3E3E3E"), new CornerRadii(0), new Insets(0))));
        informationTabPane.getStylesheets().add(getClass().getResource("tabs.css").toExternalForm());

        systemInformationText = new TextArea("");
        operatingInformationText = new TextArea("");
        patientInformationGrid = new GridPane();
        patientAdmissionInformationGrid = new GridPane();

        systemInformationTab = new Tab("System", systemInformationText);
        operatingInformationTab = new Tab("Operating", operatingInformationText);
        patientInformationTab = new Tab("Patient", patientInformationGrid);
        patientAdmissionInformationTab = new Tab("Admission", patientAdmissionInformationGrid);
        SettingsTab settingsTab = new SettingsTab(this);

        informationTabPane.getTabs().add(patientInformationTab);
        informationTabPane.getTabs().add(patientAdmissionInformationTab);
        informationTabPane.getTabs().add(systemInformationTab);
        informationTabPane.getTabs().add(operatingInformationTab);
        informationTabPane.getTabs().add(settingsTab.getSettingsTab());

        for(int i = 0; i< informationTabPane.getTabs().size(); i++){
            informationTabPane.getTabs().get(i).setClosable(false);
        }

        try {

            patient = PatientInfo.readJSONFile();
            placePatientText(patient);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void refresh() {
        try {
            removePatientText();
            placePatientText(patient);
            placeAdmissionText(patient);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TabPane getInformationTabBar() {
        return informationTabPane;
    }

    private void removePatientText() throws FileNotFoundException {
        patientInformationGrid.getChildren().clear();
        patientAdmissionInformationGrid.getChildren().clear();

    }

    private void placePatientText(PatientInfo patient) throws FileNotFoundException {

        patient = PatientInfo.readJSONFile();

        Label patientFName = new Label("Patient First Name: ");
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

        // //Sets Label styling 
        for(int col = 0; col < 2; col++){
            for(int row = 1; row<5; row++){
                getNodeFromGridPane(patientInformationGrid, col, row)
                    .setStyle("-fx-text-fill: #ffffff; -fx-font-size: 18pt; -fx-fill: #ffffff;");
            }
        }

        patientInformationGrid.setHgap(12);
        patientInformationGrid.setVgap(12);

        patientInformationGrid.setAlignment(Pos.TOP_CENTER);

        patientInformationGrid.setBackground(
                new Background(new BackgroundFill(Paint.valueOf("3E3E3E"), new CornerRadii(0.0, 0.0, 5.0, 5.0, false), new Insets(0))));

        placeAdmissionText(patient);

    }

    private void placeAdmissionText(PatientInfo patient) {

        AdmissionInfo admission = patient.getAdmission();

        // String toSet = "";
        // toSet += "Date of Admission: \t\t" + admission.getAdmissionDate();
        // toSet += "\nDoctors First Name: \t" + admission.getDrFirstName();
        // toSet += "\nDoctors Last Name: \tDr." + admission.getDrLastName();
        // toSet += "\nPatient Diagnosis: \t\t" + admission.getDiagnosis();

        // patientAdmissionInformationText.setText(toSet);


        // patient = PatientInfo.readJSONFile();

        Label admissionDate = new Label("Date of Admission: ");
        Label doctorFName = new Label("Doctor First Name: ");
        Label doctorLName = new Label("Doctor Last Name: ");
        Label patientDiagnosis = new Label("Diagnosis: ");
        Text doctorFNameText = new Text(admission.getDrFirstName());
        Text doctorLNameText = new Text(admission.getDrLastName());
        Text diagnosisText = new Text(admission.getDiagnosis());
        Text admissionDateText = new Text(admission.getAdmissionDate() + "");

        patientAdmissionInformationGrid.add(new Text(), 0, 0);
        patientAdmissionInformationGrid.add(patientDiagnosis, 0, 1);
        patientAdmissionInformationGrid.add(admissionDate, 0, 2);
        patientAdmissionInformationGrid.add(doctorFName, 0, 3);
        patientAdmissionInformationGrid.add(doctorLName, 0, 4);
        patientAdmissionInformationGrid.add(diagnosisText, 1, 1);
        patientAdmissionInformationGrid.add(admissionDateText, 1, 2);
        patientAdmissionInformationGrid.add(doctorFNameText, 1, 3);
        patientAdmissionInformationGrid.add(doctorLNameText, 1, 4);

        // //Sets Label styling 
        for(int col = 0; col < 2; col++){
            for(int row = 1; row<5; row++){
                getNodeFromGridPane(patientAdmissionInformationGrid, col, row)
                    .setStyle("-fx-text-fill: #ffffff; -fx-font-size: 16pt; -fx-fill: #ffffff;");
            }
        }

        patientAdmissionInformationGrid.setHgap(12);
        patientAdmissionInformationGrid.setVgap(12);

        patientAdmissionInformationGrid.setAlignment(Pos.TOP_CENTER);

        patientAdmissionInformationGrid.setBackground(
                new Background(new BackgroundFill(Paint.valueOf("3E3E3E"), 
                new CornerRadii(0.0, 0.0, 5.0, 5.0, false), new Insets(0))));

    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}