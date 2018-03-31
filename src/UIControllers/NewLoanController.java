/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIControllers;

import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Jesus
 */
public class NewLoanController implements Initializable {
    @FXML
    private JFXDatePicker dp_start;
    
    @FXML
    private JFXDatePicker dp_end;
    
    
    @FXML
    Callback<DatePicker, DateCell> daysBefore = dp -> {
        return new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                
                super.updateItem(item, empty);
                
                this.setDisable(false);
                
                // deshabilitar las fechas anteriores
                if (item.isBefore(LocalDate.now())) {
                    this.setDisable(true);
                }
                
                // fines de semana en color rojo
                DayOfWeek dayweek = item.getDayOfWeek();
                if (dayweek == DayOfWeek.SATURDAY || dayweek == DayOfWeek.SUNDAY) {
                    this.setTextFill(Color.RED);
                    this.setDisable(true);
                }
            }
        };  };
    
    @FXML
    Callback<DatePicker, DateCell> dayReturn = dr -> {
        return new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                
                super.updateItem(item, empty);
                
                this.setDisable(false);
                
                // deshabilitar las fechas anteriores
                if (item.isBefore(dp_start.getValue())) {
                    this.setDisable(true);
                }
                
                // fines de semana en color rojo
                DayOfWeek dayweek = item.getDayOfWeek();
                if (dayweek == DayOfWeek.SATURDAY || dayweek == DayOfWeek.SUNDAY) {
                    this.setTextFill(Color.RED);
                    this.setDisable(true);
                }
            }
        };  };

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dp_start.setDayCellFactory(daysBefore);
        dp_end.setDayCellFactory(dayReturn);
    }
    
}
