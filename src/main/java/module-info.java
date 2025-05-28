module com.bi.fmsui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.bi.fmsui to javafx.fxml;
    exports com.bi.fmsui;
}