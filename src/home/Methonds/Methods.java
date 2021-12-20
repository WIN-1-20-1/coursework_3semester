package home.Methonds;

import com.mongodb.client.model.Filters;
import home.Controller;
import home.Database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Methods {

    public static void loadStage(String fxml, MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("fxml/" + fxml + ".fxml")));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadStage(String fxml, ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Controller.class.getResource("fxml/" + fxml + ".fxml")));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void auth(ActionEvent event, String login , String password) {
        Document founded = Database.users.find(new Document("login", login)).first();
        if (founded != null && password.equals(founded.getString("password"))) {
            String userPosition = founded.getString("position");
            Controller.name = founded.getString("name");
            Controller.position = userPosition;
            Controller.id = founded.getObjectId("_id");
            loadStage(userPosition, event);

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fehlermeldung");
            alert.setHeaderText("Falsches Login oder Passwort");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.print("");
                }
            });
        }
    }

    public static ArrayList<Document> getTasks(){
        ArrayList<Document> tasks = new ArrayList<Document>();
        for (Document document : Database.foundedTasks) {
            if (!document.getString("status").equals("completed")) {
                tasks.add(document);
            }
        }
        return tasks;
    }

    public static void completeTask(Document document) {
        Database.tasks.updateOne(Filters.eq("_id", document.getObjectId("_id")), new Document(
                "$set",
                new Document("status", "completed")
        ));
    }

    public static String getSalary(ObjectId id) {
        Document founded = Database.users.find(new Document("_id", id)).first();
        assert founded != null;
        return String.valueOf(founded.getInteger("salary"));
    }

    public static ArrayList<String> getMarkCat() {
        ArrayList<String> categories = new ArrayList<String>();
        for (Document document : Database.foundedBudgets) {
            String category = document.getString("place");
            if (!categories.contains(category) && category != null){
                categories.add(category);
            }
        }
        return categories;
    }

    public static float calculateClietnsPerArea(String area) {
        float result;
        float people = 0;
        float clients = 0;
        for (Document document : Database.foundedClients) {
            if(!document.getString("place").equals("")){
                people++;
            }
        }
        for (Document document : Database.foundedClients) {
            if(document.getString("place").equals(area)){
                clients++;
            }
        }
        result = (clients/people) * 100;
        return result;
    }

    public static int markFunds(){
        int funds = 0;
        for (Document document : Database.foundedBudgets) {
            if ("marketing".equals(document.getString("type"))) {
                funds += document.getInteger("cost");
            }
        }
        return funds;
    }

    public static ArrayList<String> getEquipment() {
        ArrayList<String> equipment = new ArrayList<String>();
        for (Document document : Database.foundedEquipment) {
            String str = document.getString("name") + ": " +document.getString("quantity");
            equipment.add(str);
        }
        return equipment;
    }
    
    public static int getBudget(String category) {
        int res = 0;
        for (Document document : Database.foundedBudgets) {
            if (document.getObjectId("_id").toString().equals("606624505afe5468c793940f")) {
                res = Integer.parseInt(document.getString(category));
            }
        }
        return res;
    }

    public static int getUsedBudgetForSalary(){
        int res = 0;
        for (Document document : Database.foundedUsers){
            if (document.getInteger("salary") != null && document.getInteger("salary") > 0){
                res += document.getInteger("salary");
            }
        }
        return res;
    }

    public static ArrayList<String> getProjects(){
        ArrayList<String> projects = new ArrayList<>();
        for (Document document : Database.foundedBudgets){
           if (document.getString("name of event") != null) projects.add(document.getString("name of event"));
        }
        return projects;
    }

    public static ArrayList<String> getWorkers() {
        ArrayList<String> workers = new ArrayList<>();
        for (Document document : Database.foundedUsers) {
            if (document.getString("position").equals("worker")) workers.add(document.getString("name"));
        }
        return workers;
    }

    public static void increaseSalary(String name, int salary) {
        int newSalary = 0;
        for (Document document : Database.foundedUsers){
            if (document.getString("name").equals(name)){
                newSalary = document.getInteger("salary") + salary;
            }
        }
        Database.users.updateOne(Filters.eq("name", name), new Document(
                "$set",
                new Document("salary", newSalary)
        ));
    }

    public static void decreaseSalary(String name, int salary) {
        int newSalary = 0;
        for (Document document : Database.foundedUsers){
            if (document.getString("name").equals(name)){
                newSalary = document.getInteger("salary") - salary;
            }
        }
        Database.users.updateOne(Filters.eq("name", name), new Document(
                "$set",
                new Document("salary", newSalary)
        ));
    }

    public static Map<String, Integer> calculateByCategory(){
        Map<String, Integer> res = new HashMap<>();
        int sell = 0;
        int rent = 0;
        for (Document document : Database.foundedObjects) {
            if (document.getInteger("rentPrice") != null && document.getInteger("sellPrice") != null) {
                sell++;
                rent++;
            } else if (document.getInteger("rentPrice") != null){
                rent++;
            } else if (document.getInteger("sellPrice") != null){
                sell++;
            }
        }
        res.put("Sell", sell);
        res.put("Rent", rent);
        return res;
    }

    public static Map<String, Integer> calculateTotalAmount(){
        Map<String, Integer> res = new HashMap<>();
        int sell = 0;
        int rent = 0;
        for (Document document : Database.foundedObjects) {
            if (document.getInteger("rentPrice") != null && document.getInteger("sellPrice") != null) {
                sell += document.getInteger("sellPrice");
                rent += document.getInteger("rentPrice");
            } else if (document.getInteger("rentPrice") != null){
                rent += document.getInteger("rentPrice");
            } else if (document.getInteger("sellPrice") != null){
                sell += document.getInteger("sellPrice");
            }
        }
        res.put("Sell", sell);
        res.put("Rent", rent);
        return res;
    }

    public static void createNewProject(String name, String place, int price) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (getBudget("marketing") > price) {
            Document document = new Document();
            document.append("place", place);
            document.append("type", "marketing");
            document.append("cost", price);
            document.append("name of event", name);
            Database.budget.insertOne(document);
            alert.setTitle("Erfolg");
            alert.setHeaderText("Projekt erfolgreich erstellt");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.print("");
                }
            });
        } else {
            alert.setTitle("Ahtung");
            alert.setHeaderText("Nicht genug Geld. Sprechen Sie mit dem Regisseur.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.print("");
                }
            });
        }

    }

    public static ArrayList<String> ShowAllClients() {
        ArrayList<String> clients = new ArrayList<>();
        for (Document document : Database.foundedClients) {
            clients.add(document.getString("name"));
        }
        return clients;
    }

    public static ArrayList<String> ShowApartments() {
        ArrayList<String> apartments = new ArrayList<>();
        for (Document document : Database.foundedObjects) {
            apartments.add(document.getString("address"));
        }
        return apartments;
    }

    public static ArrayList<String> ShowFreeApartments() {
        ArrayList<String> apartments = new ArrayList<>();
        for (Document document : Database.foundedObjects) {
            if (document.getString("status").equals("free")) {
                apartments.add(document.getString("address"));
            }
        }
        return apartments;
    }

    public static ArrayList<String> ShowFreeApartmentsRent() {
        ArrayList<String> apartments = new ArrayList<>();
        for (Document document : Database.foundedObjects) {
            if (document.getString("status").equals("free")) {
                apartments.add(Integer.toString(document.getInteger("rentPrice")));
            }
        }
        return apartments;
    }

    public static ArrayList<String> ShowFreeApartmentsSell() {
        ArrayList<String> apartments = new ArrayList<>();
        for (Document document : Database.foundedObjects) {
            if (document.getString("status").equals("free")) {
                apartments.add(Integer.toString(document.getInteger("sellPrice")));
            }
        }
        return apartments;
    }

    public static boolean BoolFoundApartments(String foundedAddress) {
        int step = 1;
        for (Document document : Database.foundedObjects)
            if (document.getString("address").contains(foundedAddress))
                step++;
        if (step != 2) {
            return false;
        } else
            return true;
    }

    public static boolean BoolFoundClients(String foundedName) {
        int step = 1;
        for (Document document : Database.foundedClients)
            if (document.getString("name").contains(foundedName))
                step++;
        if (step != 2) {
            return false;
        } else
            return true;
    }

    public static Document FoundApartments(String foundedAddress) {
        int step = 1;
        for (Document document : Database.foundedObjects)
            if (document.getString("address").contains(foundedAddress))
                step++;
        if (step == 2) {
            for (Document document : Database.foundedObjects)
                if (document.getString("address").contains(foundedAddress)) {
                    return document;
                }
        }
        return null;
    }

    public static Document FoundClient(String foundedName) {
        int step = 1;
        for (Document document : Database.foundedClients) {
            if (document.getString("name").contains(foundedName))
                step++;
        }
        if (step == 2) {
            for (Document document : Database.foundedClients)
                if (document.getString("name").contains(foundedName)) {
                    return document;
                }
        }
        return null;
    }

    public static boolean BoolRentApartment(Document Apartments, Document Client) {
        if (Apartments != null && Client != null &&
                Apartments.getString("status").equals("free") &&
                Apartments.getInteger("rentPrice") != null) {
            return true;
        } else
            return false;
    }

    public static boolean RentApartment(Document Apartments, Document Client) {
        if (Apartments != null && Client != null &&
                Apartments.getString("status").equals("free") &&
                Apartments.getInteger("rentPrice") != null) {
            Database.objects.updateOne(Filters.eq("_id", Apartments.getObjectId("_id")), new Document(
                    "$set",
                    new Document("status", "rent")
            ));
            Database.objects.updateOne(Filters.eq("_id", Apartments.getObjectId("_id")), new Document(
                    "$set",
                    new Document("owner", Client.getObjectId("_id"))
            ));
            return true;
        } else
            return false;
    }

    public static boolean BoolSellApartment(Document Apartments, Document Client) {
        if (Apartments != null && Client != null &&
                Apartments.getString("status").equals("free") &&
                Apartments.getInteger("sellPrice") != null) {
            return true;
        } else
            return false;
    }

    public static boolean SellApartment(Document Apartments, Document Client) {
        if (Apartments != null && Client != null &&
                Apartments.getString("status").equals("free") &&
                Apartments.getInteger("sellPrice") != null) {
            Database.objects.updateOne(Filters.eq("_id", Apartments.getObjectId("_id")), new Document(
                    "$set",
                    new Document("status", "sell")
            ));
            Database.objects.updateOne(Filters.eq("_id", Apartments.getObjectId("_id")), new Document(
                    "$set",
                    new Document("owner", Client.getObjectId("_id"))
            ));
            return true;
        } else
            return false;
    }

    public static String getApartmentRentPrise(String apartmentAddress) {
        Document Apartment = FoundApartments(apartmentAddress);
        if (Apartment.getInteger("rentPrice") != null) {
            return Integer.toString(Apartment.getInteger("rentPrice"));
        }
        return "Nicht verkauft";
    }

    public static String getApartmentSellPrise(String apartmentAddress) {
        Document Apartment = FoundApartments(apartmentAddress);
        if (Apartment.getInteger("sellPrice") != null) {
            return Integer.toString(Apartment.getInteger("sellPrice"));
        }
        return "Nicht verkauft";
    }

    public static String getApartmentStatus(String apartmentAddress) {
        Document Apartment = FoundApartments(apartmentAddress);
        switch (Apartment.getString("status")){
            case "rented":
                return "mieten";
            case "rent":
                return "mieten";
            case "sell":
                return "verkauft";
            case "sold":
                return "verkauft";
            case "free":
                return "kostenlos";
        }
        return Apartment.getString("status");
    }

    public static String getApartmentOwner(String apartmentAddress) {
        Document Apartment = FoundApartments(apartmentAddress);
        if (Apartment.get("owner") == null) return "nicht verkauft";
        for (Document document : Database.foundedClients) {
            if (document.get("_id").equals(Apartment.get("owner"))) {
                return document.getString("name");
            }
        }
        return "";
    }

    public static String getClientPhone(String foundedName) {
        for (Document document : Database.foundedClients)
            if (document.getString("name").contains(foundedName)) {
                return document.getString("phoneNumber");
            }
        return null;
    }

    public static String getClientPlace(String foundedName) {
        for (Document document : Database.foundedClients)
            if (document.getString("name").contains(foundedName)) {
                return document.getString("place");
            }
        return null;
    }

    public static ArrayList<String> getClientApartments(String foundedName) {
        Document Client = null;
        for (Document document : Database.foundedClients) {
            if (document.getString("name").contains(foundedName)) {
                Client = document;
            }
        }
        ArrayList<String> Apartments = new ArrayList<>();
        for (Document document : Database.foundedObjects) {
            Object owner = document.get("owner");
            Object client = Client.get("_id");

            if (owner.equals(client))
                Apartments.add(document.getString("address"));
        }
        return Apartments;
    }

    public static void alert(String title, String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(text);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.print("");
            }
        });
    }

}
