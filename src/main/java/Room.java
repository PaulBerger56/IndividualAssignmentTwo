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

    public Room(int roomNumber, String name, boolean visited, int westExit, int northExit, int eastExit, int southExit) {
        this.roomNumber = roomNumber;
        this.name = name;
        this.visited = visited;
        this.westExit = westExit;
        this.northExit = northExit;
        this.eastExit = eastExit;
        this.southExit = southExit;
        this.description = new ArrayList<>();
    }


    public void addDescription(String description) {
        this.description.add(description);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getName() {
        return name;
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
