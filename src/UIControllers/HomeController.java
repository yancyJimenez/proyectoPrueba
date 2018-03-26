/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Jesus
 */
public class HomeController implements Initializable {
    @FXML
    private BorderPane borderpane_base;

    @FXML
    private Button btn_regStudent;

    @FXML
    private Button btn_regBook;

    @FXML
    private Button btn_credits;
    
    @FXML
    private Label label;
    
    @FXML
    private Button btn_newLoan;
    
    @FXML
    private void paneRegStudent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/InsertStudent.fxml"));
        borderpane_base.setCenter(root);
    }
    
    @FXML
    private void paneCredits(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/Credits.fxml"));
        borderpane_base.setCenter(root);
    }
    
    @FXML
    private void paneRegMaterial(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/insertMaterial.fxml"));
        borderpane_base.setCenter(root);
    }
    
    @FXML
    private void paneNewLoan(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/newLoan.fxml"));
        borderpane_base.setCenter(root);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
