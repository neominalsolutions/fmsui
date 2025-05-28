package com.bi.fmsui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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



}
