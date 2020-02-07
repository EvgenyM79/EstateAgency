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

    private TextField userTextField;
    private PasswordField pwBox;
    private Button btnIn, btnOut;
    private HBox hbBtnIn, hbBtnOut;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("   Агенство недвижимости");
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 600, 275);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Добро пожаловать!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Имя пользователя:");
        grid.add(userName, 0, 1);

        userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Пароль:");
        grid.add(pw, 0, 2);

        pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        btnIn = new Button("Вход");
        btnOut = new Button("Выход");
        hbBtnIn = new HBox(10);
        hbBtnOut = new HBox(10);
        hbBtnIn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnIn.getChildren().add(btnIn);
        hbBtnOut.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtnOut.getChildren().add(btnOut);

        grid.add(hbBtnIn, 1, 4);
        grid.add(hbBtnOut, 2, 4);

        final Text actiontarget = new Text();
        final Integer[] numEnter = {0};
        grid.add(actiontarget, 1, 6);

        btnIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                numEnter[0] ++;
                System.out.println(numEnter[0]);
                if (numEnter[0]==3){
                    primaryStage.close();
                }
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Ошибка...");
                System.out.println(userTextField.getText());
                System.out.println(pwBox.getText());
                clearFields();
            }
        });

        btnOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        });

        //Scene scene = new Scene(grid, 600, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void clearFields() {
        // TODO Auto-generated method stub
        userTextField.clear();
        pwBox.clear();
    }
}
