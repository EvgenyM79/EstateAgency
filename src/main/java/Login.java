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

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Агенство недвижимости");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Добро пожаловать!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Имя пользователя:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Пароль:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btnIn = new Button("Вход");
        Button btnOut = new Button("Выход");
        HBox hbBtnIn = new HBox(10);
        HBox hbBtnOut = new HBox(10);
        hbBtnIn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnIn.getChildren().add(btnIn);
        hbBtnOut.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnOut.getChildren().add(btnOut);

        grid.add(hbBtnIn, 1, 4);
        grid.add(hbBtnOut, 2, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btnIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Sign in button pressed");

            }
        });

        btnOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        });

        Scene scene = new Scene(grid, 600, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
