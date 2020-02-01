import javafx.application.Application;
import javafx.beans.binding.When;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestButton extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button b1 = new Button("B1");
        Button b2 = new Button("B2");
        Button b3 = new Button("B3");
        Button visibleBtn = new Button("Make Invisible");

        visibleBtn.setOnAction(e -> b2.setVisible(!b2.isVisible()));

        visibleBtn.textProperty().bind(
                new When(b2.visibleProperty()).then("Invisible").otherwise(
                        "Visible"));

        b2.managedProperty().bind(b2.visibleProperty());

        HBox root = new HBox();
        root.getChildren().addAll(visibleBtn, b1, b2, b3);

        Scene scene = new Scene(root, 600, 300);
        stage.setScene(scene);
        stage.setTitle("");
        stage.show();
    }
}
