import java.util.ArrayList;

public class Player {

    private final String name;
    private int healthPoints;
    private int currentRoomNumber;
    private int previousRoomNumber;
    private ArrayList<Item> inventory;

    // Constructor for new game that takes in the name, but starts everything else as default
    public Player(String name) {
        this.name = name;
        this.healthPoints = 500;
        this.currentRoomNumber = 1;
        this.previousRoomNumber = 0;
        this.inventory = new ArrayList<>();
    }

    // Constructor for previously saved game
    public Player(String savedName, int savedHealthPoints, int savedCurrentRoomNumber, int savedPreviousRoomNumber, ArrayList<Item> savedItems) {
        this.name = savedName;
        this.healthPoints = savedHealthPoints;
        this.currentRoomNumber = savedCurrentRoomNumber;
        this.previousRoomNumber = savedPreviousRoomNumber;
        this.inventory = new ArrayList<>(savedItems);
    }

    // Adds to hp pool with no cap currently
    public int addHealthPoints(int additionalHP) {
        this.healthPoints += additionalHP;
        return this.healthPoints;
    }

    // Subtracts from current hp pool
    public int reduceHealthPoints(int subtractionAmount) {
        if((this.healthPoints - subtractionAmount) <= 0) {
            return 0;
        } else {
            this.healthPoints -= subtractionAmount;
            return this.healthPoints;
        }
    }

    public int getCurrentRoomNumber() {
        return currentRoomNumber;
    }

    public void setCurrentRoomNumber(int currentRoomNumber) {
        this.currentRoomNumber = currentRoomNumber;
    }

    public int getPreviousRoomNumber() {
        return previousRoomNumber;
    }

    public void setPreviousRoomNumber(int previousRoomNumber) {
        this.previousRoomNumber = previousRoomNumber;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    public ArrayList<Item> getItems() {
        return inventory;
    }
}
