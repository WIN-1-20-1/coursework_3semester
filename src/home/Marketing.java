package home;

import home.Methonds.Methods;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class Marketing {

    @FXML
    private Label MarketingLabel;

    @FXML
    private ListView<String> MarketingListView;

    @FXML
    private Button LogOutButton;

    String[] option = {"Liste aller Abdeckungsbereiche anzeigen", "Liste der Budgetkategorien anzeigen", "Zeigen Sie das zugewiesene budget für eine bestimmte Kategorie von Orten für marketing", "Aktuelle Marketingmittel anzeigen", "Zeigen Sie das für das Gehalt erforderliche Gesamtbudget an", "Erhöhen Sie das Gehalt eines Mitarbeiters", "Senken Sie das Gehalt eines Mitarbeiters", "Zeigen Sie die Liste der Geräte für den Bau von Objekten"};

    String aktuelleOption;

    @FXML
    void initialize(){
        MarketingLabel.setText( "Hallo, " + Controller.name);

        MarketingListView.getItems().addAll(option);
        LogOutButton.setOnAction(Methods::logOut);
        MarketingListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            aktuelleOption = MarketingListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Liste aller Abdeckungsbereiche anzeigen":
                    break;
                case "Liste der Budgetkategorien anzeigen":
                    break;

            }
        });
        MarketingListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + MarketingListView.getSelectionModel().getSelectedItem());
            }
        });
    }
}
