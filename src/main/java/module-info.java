module com.example.myfairlady {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;

    opens com.example.myfairlady to javafx.fxml;
    exports com.example.myfairlady;
    exports com.example.myfairlady.SceneController;
    opens com.example.myfairlady.SceneController to javafx.fxml;
}