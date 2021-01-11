package nl.inholland.endassignment.util;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ExitModal {
    public Stage dialog;

    private GridPane gridPane;
    private VBox vBox;
    private Button closeButton;
    private Button cancelButton;

    public ExitModal(String title, String message, Stage parentStage){
        gridPane = new GridPane();
        vBox = new VBox();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label messageLabel = new Label(message);
        GridPane.setConstraints(messageLabel, 0, 0);

        closeButton = new Button("OK");
        GridPane.setConstraints(closeButton, 0, 1);

        cancelButton = new Button("Cancel");
        GridPane.setConstraints(cancelButton, 1, 1);

        closeButton.setOnAction(actionEvent -> {
            dialog.close();
            parentStage.close();
        });

        cancelButton.setOnAction(actionEvent -> {
            dialog.close();
        });



        gridPane.getChildren().addAll(messageLabel, closeButton,
                cancelButton);

        vBox.getChildren().addAll(gridPane);
        Scene scene = new Scene(vBox);

        dialog =  new Stage();
        dialog.setTitle(title);
        dialog.setScene(scene);
        dialog.setWidth(250);
        dialog.setHeight(150);
        dialog.initOwner(parentStage.getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();



    }
}
