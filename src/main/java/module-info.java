module com.bi.fmsui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires transitive com.freight;


    opens com.bi.fmsui to javafx.fxml;
    exports com.bi.fmsui;
}