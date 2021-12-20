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

    String[] option = {"Liste der Kategorien für Marketing anzeigen", "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von marketing-Websites", "Marketingbudget anzeigen", "Geben Sie Ihr Budget für Werbung aus"};

    String aktuelleOption;

    @FXML
    void initialize(){
        MarketingLabel.setText( "Hallo, " + Controller.name);
        MarketingListView.getItems().addAll(option);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        MarketingListView.setOnMouseClicked(event -> {
            aktuelleOption = MarketingListView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            switch (aktuelleOption) {
                case "Liste der Kategorien für Marketing anzeigen" -> Methods.alert("Kategorien", "Marketing " + Methods.getBudget("marketing") + "€" + "\n Salary " + Methods.getBudget("salary") + "€");
                case "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von marketing-Websites" -> {}
                case "Marketingbudget anzeigen" -> Methods.alert("Marketing", Methods.getBudget("marketing") + "€");
                case "Geben Sie Ihr Budget für Werbung aus" -> Methods.loadStage("Promotion", event);
                default -> {}
                }
            });
    }
}
