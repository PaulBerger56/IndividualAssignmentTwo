import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Map {

    private ArrayList<Room> rooms;

    public Map(String startingMap, String startingItems, String startingPuzzles) {
        this.rooms = addRooms(startingMap);
        fillRooms(startingItems, startingPuzzles);
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

    public void fillRooms(String startingItems, String startingPuzzles) {
        //reads in the item and puzzle files and puts them in the appropriate rooms
        File itemFile = new File(startingItems);
        File puzzleFile = new File(startingPuzzles);
        ArrayList<Item> tempItems = new ArrayList<>();
        ArrayList<Puzzle> tempPuzzles = new ArrayList<>();

        // read in both items and puzzles
        try {
            Scanner itemInput = new Scanner(itemFile);
            Scanner puzzleInput = new Scanner(puzzleFile);

            while(itemInput.hasNextLine()) {
                String itemLine = itemInput.nextLine();
                String[] itemPieces = itemLine.split("~");

                String itemName = itemPieces[0];
                String itemDescription = itemPieces[1];
                int itemStartingRoom = Integer.parseInt(itemPieces[2]);

                tempItems.add(new Item(itemName, itemDescription, itemStartingRoom));
            }

            while(puzzleInput.hasNextLine()) {
                String puzzleLine = puzzleInput.nextLine();
                String[] puzzlePieces = puzzleLine.split("~");

                String puzzleName = puzzlePieces[0];
                String puzzleQuestion = puzzlePieces[1];
                String puzzleSolution = puzzlePieces[2];
                int puzzleTries = Integer.parseInt(puzzlePieces[3]);

                tempPuzzles.add(new Puzzle(puzzleName, puzzleQuestion, puzzleSolution, puzzleTries));
            }

            itemInput.close();
            puzzleInput.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // set the items in the appropriate rooms
        for(Item i: tempItems) {
            this.rooms.get(i.getStartingRoom()-1).addItemToRoom(i);
        }

        // set the puzzles in the appropriate rooms
        // loops through all of the puzzles
        for(Puzzle p: tempPuzzles) {
            // while loop guesses a random room number.  If the room does not have a puzzle,
            // the current one is added.  If not, the random number is tried again until the current puzzle
            // is placed in a room.
            while(true) {
                int index = (int) (Math.random() * this.rooms.size());
                if (!this.rooms.get(index).doesRoomContainPuzzle()) {
                    this.rooms.get(index).addPuzzleToRoom(p);
                    break;
                }
            }
        }
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

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
