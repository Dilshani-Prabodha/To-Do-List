package controller;

//import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.ToDoList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ToDoListFormController {

    public VBox vBoxCompletedList;
    @FXML
    private TextField txtAddTask;

    @FXML
    private VBox vBoxToDoList;

    @FXML
    void btnAddTaskOnAction(ActionEvent event) {
        ToDoList toDoList = new ToDoList(txtAddTask.getText());
        HBox hbox = new HBox(10);

        Label newLabel = new Label(toDoList.getAddListText());
        newLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        newLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));
        CheckBox newCheckBox = new CheckBox("");

        hbox.getChildren().addAll(newCheckBox, newLabel);
        vBoxToDoList.getChildren().add(hbox);
        txtAddTask.setText("");

        //--------------------------------------------
        newCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Label additionalLabel = new Label(newLabel.getText() + " is completed!");
                additionalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                additionalLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));

                vBoxCompletedList.getChildren().add(additionalLabel);

                vBoxToDoList.getChildren().remove(hbox);
                hbox.getChildren().remove(newLabel);

                newCheckBox.setDisable(true);
//
//                String SQL = "INSERT INTO CompletedTaskList (task_title, completion_date) VALUES (?, ?)";
//                try {
//                    Connection connection = DBConnection.getInstance().getConnection();
//                    PreparedStatement psTm = connection.prepareStatement(SQL);
//                    psTm.setObject(2,toDoList.getAddListText());
//                    //psTm.setObject(4,CURDATE());
//
//                } catch (SQLException e) {
//                    new Alert(Alert.AlertType.ERROR,"Error : "+e.getMessage()).show();
//                }
            } else {

            }
        });
    }
}
