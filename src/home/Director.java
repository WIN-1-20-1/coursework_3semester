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

    String[] option = {"Процент клиентов на регион", "Бюджет для маркетинга", "Бюджет для зарплат", "Рекламная интеграция", "Нужный бюджет для маркетинга", "Нужный бюджет для зарплат", "Изменить зарплату сотрудника", "Оборудование"};

    String aktuelleOption;

    @FXML
    void initialize(){
        DirectorLabel.setText( "Привет, " + Controller.name);
        LogOutButton.setOnAction(event -> Methods.loadStage("Home", event));
        DirectorListView.getItems().addAll(option);
        DirectorListView.setOnMouseClicked(event -> {
            aktuelleOption = DirectorListView.getSelectionModel().getSelectedItem();
            switch (aktuelleOption) {
                case "Процент клиентов на регион" -> Methods.loadStage("ClientsAreas", event);
                case "Бюджет для маркетинга" -> Methods.alert("Маркетинг", Methods.getBudget("marketing") + "€");
                case "Бюджет для зарплат" -> Methods.alert("Зарплаты", Methods.getBudget("salary") + "€");
                case "Рекламная интеграция" -> Methods.loadStage("Projects", event);
                case "Нужный бюджет для маркетинга" -> Methods.alert("Нужный бюджет для маркетинга", Methods.markFunds() + "€");
                case "Нужный бюджет для зарплат" -> Methods.alert("Нужный бюджет для зарплат", Methods.getUsedBudgetForSalary() + "€");
                case "Изменить зарплату сотрудника" -> Methods.loadStage("ChangeSalary", event);
                case "Оборудование" -> Methods.loadStage("Equipment", event);
                default -> {}
            }
        });
    }
}
