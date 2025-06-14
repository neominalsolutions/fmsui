package com.bi.fmsui;


import com.freight.dtos.FreightRequestDto;
import com.freight.services.FreightService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

// Best practise.

public class FreightController {
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
        // Buttona tıklandığında servis çağır

       // Text içinden gelen değerleri Parsa ettik.
       // Wrapper Types
       double weight = Double.parseDouble(txtWeight.getText());
       double width = Double.parseDouble(txtWidth.getText());
       double height = Double.parseDouble(txtHeight.getText());
       double length = Double.parseDouble(txtLength.getText());
       double unitPrice = Double.parseDouble(txtUnitPrice.getText());
       String freightType = cmbFreightType.getValue();
       LocalDate shippedDate = dtShippedDate.getValue();
       boolean lightFreight = rbLight.isSelected();

       var request = new FreightRequestDto(lightFreight,weight,height,length,width,unitPrice,shippedDate,freightType);


       FreightService freightService = new FreightService();
       var response = freightService.handle(request);


       // Gelen değeri mesaj kutusunda gösterdik
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Kargo Ücreti Hesaplama");
       alert.setHeaderText("Freight Service Price " + response.getListPrice());
       alert.showAndWait(); // mesaj olarak göster



   }

}
