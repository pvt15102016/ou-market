module com.pvt.oumarket {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires org.apache.commons.codec;
    opens com.pvt.oumarket to javafx.fxml;
    exports com.pvt.oumarket;
    exports com.pvt.pojo;
}
