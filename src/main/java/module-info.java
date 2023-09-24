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
    requires java.sql;
    requires org.json;

    opens com.example.myfairlady to javafx.fxml,javafx.graphics;
    exports com.example.myfairlady to javafx.graphics, javafx.fxml;
    exports com.example.myfairlady.SceneController to javafx.fxml,javafx.graphics;
    opens  com.example.myfairlady.SceneController to javafx.fxml,javafx.graphics;
    exports com.example.myfairlady.SceneController.StoreControllers to javafx.fxml, javafx.graphics;
    opens com.example.myfairlady.SceneController.StoreControllers to javafx.fxml, javafx.graphics;
    opens com.example.myfairlady.DataTypes to javafx.fxml, javafx.graphics, javafx.base;
    exports com.example.myfairlady.DataTypes to javafx.fxml, javafx.graphics, javafx.base;
    exports  com.example.myfairlady.SceneController.AdminControllers to javafx.fxml, javafx.graphics;
    opens com.example.myfairlady.SceneController.AdminControllers to javafx.fxml, javafx.graphics;
    exports com.example.myfairlady.UtilityClasses to javafx.fxml, javafx.graphics;
    opens com.example.myfairlady.UtilityClasses to javafx.fxml, javafx.graphics;
    exports com.example.myfairlady.SceneController.FairControllers to javafx.fxml, javafx.graphics;
    opens com.example.myfairlady.SceneController.FairControllers to javafx.fxml, javafx.graphics;
}