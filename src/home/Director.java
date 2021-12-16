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

    String[] option = {"Liste aller Abdeckungsbereiche anzeigen", "Budget für Marketing", "Budget für Gehälter", "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von Orten für marketing", "Aktuelle Marketingmittel anzeigen", "Zeigen Sie das für das Gehalt erforderliche Gesamtbudget an", "Gehalt eines Mitarbeiters ändern", "Zeigen Sie die Liste der Geräte für den Bau von Objekten"};

    String aktuelleOption;

    @FXML
    void initialize(){
        DirectorLabel.setText( "Hallo, " + Controller.name);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        DirectorListView.getItems().addAll(option);
        DirectorListView.setOnMouseClicked(event -> {
            aktuelleOption = DirectorListView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            switch (aktuelleOption) {
                case "Liste aller Abdeckungsbereiche anzeigen" -> Methods.loadStage("ClientsAreas", event);
                case "Budget für Marketing" -> {
                    alert.setTitle("Marketing");
                    alert.setHeaderText(Methods.getBudget("marketing") + "€");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                }
                case "Budget für Gehälter" -> {
                    alert.setTitle("Gehälter");
                    alert.setHeaderText(Methods.getBudget("salary") + "€");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                }
                case "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von Orten für marketing" -> Methods.loadStage("Projects", event);
                case "Aktuelle Marketingmittel anzeigen" -> {
                    alert.setTitle("Aktuelle Marketingmittel anzeigen");
                    alert.setHeaderText(Methods.markFunds() + "€");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                }
                case "Zeigen Sie das für das Gehalt erforderliche Gesamtbudget an" -> {
                    alert.setTitle("Ausgegebenes Budget für Gehalt");
                    alert.setHeaderText(Methods.getUsedBudgetForSalary() + "€");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.print("");
                        }
                    });
                }
                case "Gehalt eines Mitarbeiters ändern" -> Methods.loadStage("ChangeSalary", event);
                case "Zeigen Sie die Liste der Geräte für den Bau von Objekten" -> Methods.loadStage("Equipment", event);
                default -> {
                }
            }
        });
    }
}
