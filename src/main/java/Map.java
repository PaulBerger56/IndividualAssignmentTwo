import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Map {

    private ArrayList<Room> rooms;

    public Map(String startingMap) {
        this.rooms = addRooms(startingMap);
    }

    public ArrayList<Room> addRooms(String startingMap) {
        ArrayList<Room> addedRooms = new ArrayList<>();
        ArrayList<String> tempList = new ArrayList<>();
        File inputFile = new File(startingMap);

        // reads in the file with scanner
        try{
            Scanner input = new Scanner(inputFile);

            while(input.hasNextLine()) {
                tempList.add(input.nextLine());
            }
            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // Splits the initial file using "~"
        for(String line: tempList) {
            String[] split = line.split("~");

            int roomNumber = Integer.parseInt(split[0]);
            String name = split[1];
            boolean visited = Boolean.getBoolean(split[2]);
            String directions = split[3];
            String description = split[4];

            // Breaks the directions into specific West, North, East, South
            String[] specificDirections = directions.split(",");
            int west = Integer.parseInt(specificDirections[0]);
            int north = Integer.parseInt(specificDirections[1]);
            int east = Integer.parseInt(specificDirections[2]);
            int south = Integer.parseInt(specificDirections[3]);

            // Creates new Room objects and adds them to the arraylist. DOES NOT HAVE DESCRIPTION YET
            addedRooms.add(new Room(roomNumber, name, visited,west, north, east, south));

            // Breaks the Description down, then adds it to the arraylist of the current Room.
            String[] brokenDescriptions = description.split("@");

            // Since we only have up to the current room, we use addedRooms.size()-1 to
            // get to our current index
            for (String brokenDescription : brokenDescriptions) {
                addedRooms.get(addedRooms.size() - 1).addDescription(brokenDescription);
            }
        }
        return addedRooms;
    }

    // checks to see if the current room has a connecting room based on the direction
    // entered.
    public boolean doesRoomContainDirection(int currentRoomNumber, String direction) {
        int index = currentRoomNumber - 1;
        boolean result = false;

        switch (direction.toLowerCase()) {
            case "w":
                if(rooms.get(index).getWestExit() != 0) {
                    result = true;
                }
                break;

            case "n":
                if(rooms.get(index).getNorthExit() != 0) {
                    result = true;
                }
                break;

            case "e":
                if(rooms.get(index).getEastExit() != 0) {
                    result = true;
                }
                break;

            case "s":
                if(rooms.get(index).getSouthExit() != 0) {
                    result = true;
                }
                break;

            default:
                break;
        }
        return result;
    }

//    public int move(int currentRoomNumber) {
//        // checks to see if the current room is connected to the room to move to
//        int index = currentRoomNumber -1;
//        if(rooms.get(index).getWestExit() != 0 || rooms.get(index).getNorthExit() != 0
//           || rooms.get(index).getEastExit() != 0 || rooms.get(index).getSouthExit() != 0) {
//            return true;
//        }
//        return false;
//    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
