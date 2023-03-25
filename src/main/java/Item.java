public class Item {

    private final String name;
    private final String description;

    private final int startingRoom;

    public Item(String name, String description, int startingRoom) {
        this.name = name;
        this.description = description;
        this.startingRoom = startingRoom;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStartingRoom() {
        return this.startingRoom;
    }
}
