/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIControllers;

import domain.Student;
import file.InsertStudent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jesus
 */
public class InsertStudentController implements Initializable {
    Student student;
    InsertStudent inserting = new InsertStudent();
    String id;
    file.InsertStudent insert = new InsertStudent();
    ObservableList<String> careerList = FXCollections
            .observableArrayList("Agronomía", "Educación", "Informática");
    
    @FXML
    private TextField tfd_studentYear;

    @FXML
    private TextField tfd_studentName;

    @FXML
    private TextField tfd_studentSurnames;

    @FXML
    private ComboBox<String> cbx_studentCareer;

//    @FXML
//    private Button btn_insertStudent;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbx_studentCareer.setValue("Escoja una carrera");
        cbx_studentCareer.setItems(careerList);
    }
    
    @FXML
    private void insertingStudents(ActionEvent event){
        String name = tfd_studentName.getText();
        String surnames = tfd_studentSurnames.getText();
        String career = cbx_studentCareer.getValue();
        int year = Integer.parseInt(tfd_studentYear.getText());
        id = inserting.generateID(career, year);
        student = new Student(name, surnames, career, id, year);
    } 
}