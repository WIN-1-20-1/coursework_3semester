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

    String[] option = {"Категории", "Рекламная интеграция", "Новая рекламная интеграция"};

    String aktuelleOption;

    @FXML
    void initialize(){
        MarketingLabel.setText( "Привет, " + Controller.name);
        MarketingListView.getItems().addAll(option);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        MarketingListView.setOnMouseClicked(event -> {
            aktuelleOption = MarketingListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Категории" -> Methods.alert("Категории", "Маркетинг " + Methods.getBudget("marketing") + "€" + "\n Зарплаты " + Methods.getBudget("salary") + "€");
                case "Рекламная интеграция" -> Methods.loadStage("Projects", event);
                case "Новая рекламная интеграция" -> Methods.loadStage("Promotion", event);
                default -> {}
                }
            });
    }
}
