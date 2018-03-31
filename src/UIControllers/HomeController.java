/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIControllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Jesus
 */
public class HomeController implements Initializable {
    @FXML
    private BorderPane borderpane_base;

    @FXML
    private JFXButton btn_regStudent;

    @FXML
    private JFXButton btn_regBook;

    @FXML
    private Label label;

    @FXML
    private JFXButton btn_newLoan;
    
    @FXML
    private ImageView img_settings;

    @FXML
    private void paneRegStudent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/InsertStudent.fxml"));
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
    
    @FXML
    private void settings(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Interface/Credits.fxml"));
        borderpane_base.setCenter(root);
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
