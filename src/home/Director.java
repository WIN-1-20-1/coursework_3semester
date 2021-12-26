package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Director{

    @FXML
    private Label DirectorLabel;

    @FXML
    private ListView<String> DirectorListView;

    @FXML
    private Button LogOutButton;

    String[] option = {"Liste aller Abdeckungsbereiche anzeigen", "Budget für Marketing", "Budget für Gehälter", "Werbeintegration", "Das richtige Budget für Marketing", "Das richtige Budget für die Gehälter", "Gehalt eines Mitarbeiters ändern", "Zeigen Sie die Liste der Geräte für den Bau von Objekten"};

    String aktuelleOption;

    @FXML
    void initialize(){
        DirectorLabel.setText( "Hallo, " + Controller.name);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        DirectorListView.getItems().addAll(option);
        DirectorListView.setOnMouseClicked(event -> {
            aktuelleOption = DirectorListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Liste aller Abdeckungsbereiche anzeigen" -> Methods.loadStage("ClientsAreas", event);
                case "Budget für Marketing" -> Methods.alert("Marketing", Methods.getBudget("marketing") + "€");
                case "Budget für Gehälter" -> Methods.alert("Gehälter", Methods.getBudget("salary") + "€");
                case "Werbeintegration" -> Methods.loadStage("Projects", event);
                case "Das richtige Budget für die Marketing" -> Methods.alert("Aktuelle Marketingmittel anzeigen", Methods.markFunds() + "€");
                case "Das richtige Budget für die Gehälter" -> Methods.alert("Ausgegebenes Budget für Gehalt", Methods.getUsedBudgetForSalary() + "€");
                case "Gehalt eines Mitarbeiters ändern" -> Methods.loadStage("ChangeSalary", event);
                case "Zeigen Sie die Liste der Geräte für den Bau von Objekten" -> Methods.loadStage("Equipment", event);
                default -> {}
            }
        });
    }
}
