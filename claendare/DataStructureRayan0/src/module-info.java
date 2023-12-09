module DataStructureRayan0 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.compiler;


	opens application to javafx.graphics, javafx.fxml,javafx.base;
}
