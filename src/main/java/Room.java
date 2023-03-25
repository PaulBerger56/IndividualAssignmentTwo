import java.sql.Array;
import java.util.ArrayList;

public class Room {

    private int roomNumber;
    private String name;
    private boolean visited;
    private int westExit;
    private int northExit;
    private int eastExit;
    private int southExit;
    private ArrayList<String> description;

    private ArrayList<Item> roomItems;

    private Puzzle puzzle;

    public Room(int roomNumber, String name, boolean visited, int westExit, int northExit, int eastExit, int southExit) {
        this.roomNumber = roomNumber;
        this.name = name;
        this.visited = visited;
        this.westExit = westExit;
        this.northExit = northExit;
        this.eastExit = eastExit;
        this.southExit = southExit;
        this.description = new ArrayList<>();
        this.roomItems = new ArrayList<>();
        this.puzzle = null;
    }

    public boolean doesRoomContainItem(String itemName) {
        for(Item i: this.roomItems) {
            if(i.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesRoomContainPuzzle() {
        return this.puzzle != null;
    }

    public Item removeItemFromRoom(String itemName) {
        // removes a specific item from the room inventory.
        // adding to player inventory will be implemented elsewhere
        for(Item i: this.roomItems) {
            if(i.getName().equalsIgnoreCase(itemName)) {
                System.out.println();
                System.out.println("------------------------------------------------------------------------------");
                System.out.println(i.getName() + " has been removed from the room");
                this.roomItems.remove(i);
                return i;
            }
        }
        return null;
    }

    public void printRoomInventory() {
        if(this.roomItems.isEmpty()) {
            System.out.println();
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("There are no items in this room");
        } else {
            System.out.println();
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Items in the " + this.name + ":");
            for(Item i: this.roomItems) {
                System.out.println(i.getName());
            }
        }
    }


    public void addDescription(String description) {
        this.description.add(description);
    }

    public void addPuzzleToRoom(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void addItemToRoom(Item item) {
        this.roomItems.add(item);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getName() {
        return name;
    }

    public Puzzle getPuzzle() {
        return this.puzzle;
    }

    // sets visited status to true
    public void setVisited() {
        this.visited = true;
    }

    public boolean isVisited() {
        return visited;
    }


    public int getWestExit() {
        return westExit;
    }

    public int getNorthExit() {
        return northExit;
    }

    public int getEastExit() {
        return eastExit;
    }

    public int getSouthExit() {
        return southExit;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", name='" + name + '\'' +
                ", visited=" + visited +
                ", westExit=" + westExit +
                ", northExit=" + northExit +
                ", eastExit=" + eastExit +
                ", southExit=" + southExit +
                ", description=" + description +
                '}';
    }
}
