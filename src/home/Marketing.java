package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Marketing {

    @FXML
    private Label MarketingLabel;

    @FXML
    private ListView<String> MarketingListView;

    @FXML
    private Button LogOutButton;

    String[] option = {"Liste der Kategorien für Marketing anzeigen", "Werbeintegration", "Geben Sie Ihr Budget für Werbung aus"};

    String aktuelleOption;

    @FXML
    void initialize(){
        MarketingLabel.setText( "Hallo, " + Controller.name);
        MarketingListView.getItems().addAll(option);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        MarketingListView.setOnMouseClicked(event -> {
            aktuelleOption = MarketingListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Liste der Kategorien für Marketing anzeigen" -> Methods.alert("Kategorien", "Marketing " + Methods.getBudget("marketing") + "€" + "\n Salary " + Methods.getBudget("salary") + "€");
                case "Werbeintegration" -> Methods.loadStage("Projects", event);
                case "Geben Sie Ihr Budget für Werbung aus" -> Methods.loadStage("Promotion", event);
                default -> {}
                }
            });
    }
}
