package com.bi.fmsui;


import com.freight.dtos.FreightRequestDto;
import com.freight.models.StandardFreight;
import com.freight.services.FreightService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

// Best practise.

public class Freight2Controller {
    @FXML
    private TextField txtWeight;
    @FXML
    private TextField txtWidth;
    @FXML
    private TextField txtHeight;
    @FXML
    private TextField txtLength;
    @FXML
    private TextField txtUnitPrice;
    @FXML
    private ComboBox<String> cmbFreightType;
    @FXML
    private RadioButton rbLight; // Hafif Paket
    @FXML
    private RadioButton rbHeavy; // Ağır Paket
    @FXML
    private DatePicker dtShippedDate; // Gönderim tarihi

    // Ekran ilk yüklendiğinde yapıalcak olan işlemler
    @FXML
    void initialize() {

        // Uygulama açıldığında kargo tiplerini yükle
        cmbFreightType.getItems().addAll("Standard", "International","Express");

        rbHeavy.setSelected(true);
        txtWidth.setDisable(true);
        txtLength.setDisable(true);
        txtHeight.setDisable(true);

        txtWeight.setText("0");
        txtWidth.setText("0");
        txtHeight.setText("0");
        txtLength.setText("0");
        txtUnitPrice.setText("0");
        dtShippedDate.setValue(LocalDate.now());
        cmbFreightType.setValue("Standard");

    }


    @FXML
   protected void  onRadioButtonChange(){
       // radio button değişimine göre ekranda bazı ınput disabled et.

        // Hafif olan ağırlık seçili olduğunda
        if(rbLight.isSelected()){
            this.txtWeight.setDisable(true);
            this.txtWidth.setDisable(false);
            this.txtHeight.setDisable(false);
            this.txtLength.setDisable(false);
        } else {
            this.txtWidth.setDisable(true);
            this.txtHeight.setDisable(true);
            this.txtLength.setDisable(true);
            this.txtWeight.setDisable(false);
        }

   }

   @FXML
    protected void onCalculate(){
       // Eğer Servis olmasaydı nasıl yazacaktık.

       if(cmbFreightType.getSelectionModel().getSelectedItem().equals("Standard")){
           if(rbLight.isSelected()){

               double weight = Double.parseDouble(txtWeight.getText());
               StandardFreight sf = new StandardFreight(weight);

               double unitPrice = Double.parseDouble(txtUnitPrice.getText());

               double listPrice = sf.calculatePrice(unitPrice);

               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Standard Freight");
               alert.setHeaderText("");
               alert.setContentText("Fiyat " +  listPrice);
               alert.showAndWait();

           } else {


               double width = Double.parseDouble(txtWidth.getText());
               double height = Double.parseDouble(txtHeight.getText());
               double length = Double.parseDouble(txtLength.getText());

               StandardFreight sf = new StandardFreight(height,width,length);

               double unitPrice = Double.parseDouble(txtUnitPrice.getText());

               double listPrice = sf.calculatePrice(unitPrice);


               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Standard Freight");
               alert.setHeaderText("");
               alert.setContentText("Fiyat " +  listPrice);
               alert.showAndWait();

           }

       }




   }

}
