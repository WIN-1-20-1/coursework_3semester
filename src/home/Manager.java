package home;

import home.Methonds.Methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Map;

public class Manager {

    @FXML
    private Label ManagerLabel;

    @FXML
    private ListView<String> ManagerListView;

    @FXML
    private Button LogOutButton;

    String[] option = {"Liste der Mitarbeiter anzeigen", "Aufgabenliste anzeigen", "Liste aller Abdeckungsbereiche anzeigen", "Zeigen Sie den Betrag für Immobilien", "Berechnen Sie% nach Immobilienkategorie"};

    String aktuelleOption;

    @FXML
    void initialize(){
        ManagerLabel.setText( "Hallo, " + Controller.name);

        ManagerListView.getItems().addAll(option);
        LogOutButton.setOnAction(event -> Controller.loadStage("Home", event));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        ManagerListView.setOnMouseClicked(event -> {
            aktuelleOption = ManagerListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Liste der Mitarbeiter anzeigen" -> Controller.loadStage("WorkerList", event);
                case "Aufgabenliste anzeigen" -> Controller.loadStage("Tasks", event);
                case "Liste aller Abdeckungsbereiche anzeigen" -> Controller.loadStage("ClientsAreas", event);
                case "Zeigen Sie den Betrag für Immobilien" -> {
                    Map<String, Integer> category = Methods.calculateByCategory();
                    alert.setTitle("Zeigen Sie den Betrag für Immobilien");
                    alert.setHeaderText("Fur Rent " + category.get("Rent") + "\n Fur Sell " + category.get("Sell"));
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                }
                case "Berechnen Sie% nach Immobilienkategorie" -> {
                    Map<String, Integer> category = Methods.calculateTotalAmount();
                    alert.setTitle("Zeigen Sie den Betrag für Immobilien");
                    alert.setHeaderText("Fur Rent " + category.get("Rent") + "€" + "\n Fur Sell " + category.get("Sell") + "€");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                }
                default -> {}
            }
        });
    }
}
