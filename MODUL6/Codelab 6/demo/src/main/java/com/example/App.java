package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Form Login");
        Scene loginScene = createLoginScene(primaryStage);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private Scene createLoginScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        primaryStage.setTitle("Form Login");
        
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        TextField textUsername = new TextField();
        grid.add(userName, 0, 1);
        grid.add(textUsername, 1, 1);

        Label password = new Label("Password:");
        PasswordField textpassword = new PasswordField();
        grid.add(password, 0, 2);
        grid.add(textpassword, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 3);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setText(""); // Clear any previous messages
                String username = textUsername.getText();
                String Inpassword = textpassword.getText();
                if (username.equalsIgnoreCase("Admin") && Inpassword.equalsIgnoreCase("Admin")) {
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Akun anda ditemukan");
                    primaryStage.setScene(createSecondScene(primaryStage, username));
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Password atau username salah!!");
                }
            }
        });

        return new Scene(grid, 300, 275);
    }

    private Scene createSecondScene(Stage primaryStage, String nama) {

        primaryStage.setTitle("Form 2");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Halo " + nama);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Button btn = new Button("Log out");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 3);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Handle logout action or transition to another scene if needed
                actiontarget.setFill(Color.BLUE);
                actiontarget.setText("Kembali");
                primaryStage.setScene(createLoginScene(primaryStage));
            }
        });

        return new Scene(grid, 300, 275);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
