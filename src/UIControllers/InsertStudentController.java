/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import domain.Student;
import file.StudentFile;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Jesus
 */
public class InsertStudentController implements Initializable {
    
    
    Student student;
    StudentFile insert = new StudentFile();
    ObservableList<String> careerList = FXCollections
            .observableArrayList("Agronomía", "Educación", "Informática");
    
    @FXML
    private BorderPane borderpane_base;

    @FXML
    private JFXTextField tfd_studentYear;

    @FXML
    private JFXTextField tfd_studentName;

    @FXML
    private JFXTextField tfd_studentSurnames;

    @FXML
    private JFXComboBox<String> cbx_studentCareer;
    
    @FXML
    private JFXButton btn_addStudent;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbx_studentCareer.setItems(careerList);
    }

    @FXML
    private void insertingStudents(ActionEvent event) throws IOException {
        String name = tfd_studentName.getText();
        String surnames = tfd_studentSurnames.getText();
        String career = cbx_studentCareer.getValue();
        if (name.isEmpty() || surnames.isEmpty()) {
            System.out.println("No deje campos sin llenar");
            return;
            
        }
        int year;
        try {
            year = Integer.parseInt(tfd_studentYear.getText());
        } catch (NumberFormatException nfe) {
            System.out.println("Escriba un año válido");
            return;
        }
        String id;
        id = insert.generateID(career, year);

        try {
            insert.studentFile(new File("students.dat"));
            System.out.println("Se le ha asignado el carnet: " + id);
            insert.insertStudent(new Student(name, surnames, career, id, year));
            insert.close();
        } catch (IOException ioe) {
            System.out.println("Ocurrió  un problema al añadir el estudiante.");
        }
        tfd_studentName.clear();
        tfd_studentSurnames.clear();
        tfd_studentYear.clear();
        cbx_studentCareer.setPromptText("Carrera");
        tfd_studentName.requestFocus();
    }
}
