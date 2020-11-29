package nl.inholland.endassignment.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Notifications {
    public static void infoBox(String infoMessage, String titleBar)
    {
        successNotification(infoMessage, titleBar, null);
    }

    public static void successNotification(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    public static void errorNotification(String errorMessage, String titleBar, String headerMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    public static Alert confirmNotification(String confirmMessage, String titleBar, String headerMessage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(confirmMessage);
        alert.showAndWait();
        return alert;
    }
}
