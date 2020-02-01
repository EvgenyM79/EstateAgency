import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.SQLException;

public class JavafxView extends Application {

    private TextField fName, lName, email, mobileNo;
    private DatePicker date;
    private Button savebtn, exitbtn;

    /*@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Агенство недвижимости");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        Text scenetitle = new Text("Welcome");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        //grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        //grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        //grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }*/

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX 8 Tutorial 60 - JavaFX Hibernate Integration");

        Group root = new Group();
        Scene scene = new Scene(root, 600, 300);

        fName = new TextField();
        fName.setTooltip(new Tooltip("Enter First Name"));
        //fName.setFont(Font.("SanSerif", 15);
        fName.setPromptText("First Name");
        fName.setMaxWidth(200);

        lName = new TextField();
        lName.setTooltip(new Tooltip("Enter Last Name"));
        lName.setFont(Font.font("SanSerif", 15));
        lName.setPromptText("Last Name");
        lName.setMaxWidth(200);

        email = new TextField();
        email.setTooltip(new Tooltip("Enter Email"));
        email.setFont(Font.font("SanSerif", 15));
        email.setPromptText("Email");
        email.setMaxWidth(200);

        mobileNo = new TextField();
        mobileNo.setTooltip(new Tooltip("Enter Mobile Number"));
        mobileNo.setFont(Font.font("SanSerif", 15));
        mobileNo.setPromptText("Mobile No");
        mobileNo.setMaxWidth(200);

        date = new DatePicker();
        date.setTooltip(new Tooltip("Enter Date of Birth"));
        date.setPromptText("Date of Birth");
        date.setMaxWidth(200);
        date.setStyle("-fx-font-size:15");

        //Hibernate Configuration
        ObjectDAO obj = new ObjectDAO();
        User user = new User();

        savebtn = new Button("Сохранить");
        savebtn.setTooltip(new Tooltip("Save the User Details"));
        savebtn.setFont(Font.font("SanSerif", 15));

        exitbtn = new Button("Выход");
        exitbtn.setTooltip(new Tooltip("Save the User Details"));
        exitbtn.setFont(Font.font("SanSerif", 15));


        /*savebtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {


            }
        });*/

        exitbtn.setOnAction(e ->{
            clearFields();
            primaryStage.close();
        });

        savebtn.setOnAction(e ->{
            user.setFirstName(fName.getText());
            user.setLastName(lName.getText());
            user.setEmail(email.getText());
            user.setDate(date.getEditor().getText());
            user.setMobileNo(mobileNo.getText());

            try {
                obj.save(user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            clearFields();
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(fName, lName, date, email, mobileNo, savebtn,exitbtn);
        vbox.setPadding(new Insets(10));
        root.getChildren().add(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearFields() {
        // TODO Auto-generated method stub
        fName.clear();
        lName.clear();
        email.clear();
        mobileNo.clear();
        date.getEditor().setText(null);
        date.setValue(null);
    }

    public static void main(String[] args) {
        launch(args);

    }


}
