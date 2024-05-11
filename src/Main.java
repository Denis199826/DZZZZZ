import service.ToyManager;
import service.ToyPicker;

public class Main {
    public static void main(String[] args) {
        ToyManager toyManager = new ToyManager();
        toyManager.addNewToy(1, "Apple", 10, 30);
        toyManager.addNewToy(2, "Bird", 20, 50);
        toyManager.setToyWeight(1, 20);
        ToyPicker toyPicker = new ToyPicker();
        toyPicker.choosePrizeToy(toyManager.getToys());
    }
}