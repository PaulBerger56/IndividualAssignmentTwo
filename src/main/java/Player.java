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
        this.previousRoomNumber = 1;
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

    public void printInventory() {
        // Either prints the player's inventory, or gives them an empty message
        // I would add in print description here, but that would make inspect redundant
        if(this.inventory.isEmpty()) {
            System.out.println("--------------------------------------");
            System.out.println("You didn't pick up any items yet");
            System.out.println();
        } else {
            System.out.println("--------------------------------------");
            System.out.println("Items in " + this.name + "'s inventory:");
            for(Item i: this.inventory) {
                System.out.println(i.getName());
            }
        }
    }

    public void addItemToPlayer(Item item) {
        this.inventory.add(item);
        System.out.println("--------------------------------------");
        System.out.println(item.getName() + " has been added to " + this.name + "'s inventory");
    }

    public boolean doesPlayerHaveItem(String itemName) {
        for(Item i: this.inventory) {
            if(i.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public String getItemDescription(String itemName) {
        // returns a specific Item's description, or gives a message that it does not exist
        for(Item i: this.inventory) {
            if(i.getName().equalsIgnoreCase(itemName)) {
                return i.getName() + ": " + i.getDescription();
            }
        }
        return "Sorry, you don't have an item by that name";
    }

    public Item removeItemFromPlayer(String itemName) {
        // removes a specific item from the room inventory.
        // adding to player inventory will be implemented elsewhere
        for(Item i: this.inventory) {
            if(i.getName().equalsIgnoreCase(itemName)) {
                System.out.println(i.getName() + " has been removed from " + this.name + "'s inventory");
                this.inventory.remove(i);
                return i;
            }
        }
        return null;
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



    public ArrayList<Item> getItems() {
        return inventory;
    }
}
