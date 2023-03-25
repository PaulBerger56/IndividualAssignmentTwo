import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static Map currentMap;

    public static void main(String[] args) {

        mainMenu();


    }

    public static void mainMenu() {

        while(true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Hello and Welcome to my text game!\n" +
                    "Enter 1 to start a new Game\n" +
                    "Enter 2 to continue a saved game (in progress)\n" +
                    "Enter 3 to save current game (in progress)\n" +
                    "Enter 4 to quit the game");
            System.out.println();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Starting a new game");
                    newGame();
                    break;
                case 2:
                    System.out.println("Please enter the name of the save file you would like to load");
                    String saveFile = scanner.nextLine();
                    loadGame(saveFile, "StartingItems", "StartingPuzzles");
                    break;
                case 3:
                    System.out.println("Saving current game");
                    save(currentMap);
                    break;
                case 4:
                    System.out.println("Quitting the game. Thank you for playing!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, that was an invalid input. Please choose from the options.");
                    System.out.println();
            }
        }

    }

    // Starts a new game with the default map
    public static void newGame() {
        currentMap = new Map("StartingMap.txt", "StartingItems.txt", "StartingPuzzles.txt");
        System.out.println("What is your name explorer?");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        play(1, player);
    }

    // IN PROGRESS!
    // Loads a save file from a .txt file with a previous game's details
    public static void loadGame(String saveFile, String itemFile, String puzzleFile) {
        currentMap = new Map(saveFile, itemFile, puzzleFile);
        // Get the player from the save file somehow
        Player savedPlayer = new Player("SavedPlayer");
        play(1, savedPlayer);
    }

    //IN PROGRESS
    // Saves the current game by writing a .txt file that can later be
    // read back in
    public static void save(Map currentMap) {
        System.out.println("Sorry, this doesn't do anything yet");
        mainMenu();
    }

    // starts the game loop
    // asks for the starting room so when we load in a save file
    // we can continue the player from where they were.
    public static void play(int startingRoom, Player currentPlayer) {
        int currentRoom = startingRoom;
        currentPlayer.setCurrentRoomNumber(currentRoom);
        ArrayList<Room> currentGameRooms = currentMap.getRooms();


        while(true) {
            //get the index of the current room by subtracting room number by 1
            int index = currentRoom - 1;
            int previousRoom = currentPlayer.getPreviousRoomNumber();

            System.out.println("Current room: " + currentRoom);
            System.out.println("Previous room: " + previousRoom);

            // reset the puzzle from the previous room if not solved
            //if the previous room has a puzzle, and that puzzle is not solved
            if(currentGameRooms.get(previousRoom).doesRoomContainPuzzle()
                    && !currentGameRooms.get(previousRoom).getPuzzle().isSolved()) {
                currentGameRooms.get(previousRoom).getPuzzle().resetPuzzle();
            }

            // Line to break the messages apart and increase readability
            System.out.println("------------------------------------------------------------------------------");

            // If there is a puzzle in the room, the player will automatically play it
            if(currentGameRooms.get(index).doesRoomContainPuzzle() && !currentGameRooms.get(index).getPuzzle().isSolved()
                    && currentGameRooms.get(index).getPuzzle().getTries()>0) {
                currentGameRooms.get(index).getPuzzle().play();
            }

            // if the room has been visited, print a message
            if(currentGameRooms.get(index).isVisited()) {
                System.out.println("This looks familiar...");
            }
            // Print room message and all descriptions to the user
            System.out.println("You are curently in Room " + currentGameRooms.get(index).getRoomNumber() + " The " + currentGameRooms.get(index).getName());
            for(String description: currentGameRooms.get(index).getDescription()) {
                System.out.println(description);
            }

            System.out.println();

            while(true) {
                // set the players current room
                currentPlayer.setCurrentRoomNumber(currentRoom);
                System.out.println("Which direction would you like to go? (N,S,E,W)\n" +
                        "Or type mm for main menu");

                String command = scanner.nextLine().toLowerCase();

                switch (command) {
                    case "w":
                        // check if the current room has a new room available in the direction entered
                        if(currentMap.doesRoomContainDirection(currentRoom, "w")){
                            // Set the current room as visited before moving on
                            currentGameRooms.get(index).setVisited();
                            // Change the current room to the value of the next room direction
                            // and change the values for the player's previous room
                            currentPlayer.setPreviousRoomNumber(currentRoom);
                            currentRoom = currentGameRooms.get(index).getWestExit();

                        } else {
                            System.out.println("------------------------------------------------------------------------------");
                            System.out.println("Sorry, there is nothing in that direction");
                        }
                        break;

                    case "n":
                        // check if the current room has a new room available in the direction entered
                        if(currentMap.doesRoomContainDirection(currentRoom, "n")){
                            // Set the current room as visited before moving on
                            currentGameRooms.get(index).setVisited();
                            // Change the current room to the value of the next room direction
                            currentPlayer.setPreviousRoomNumber(currentRoom);
                            currentRoom = currentGameRooms.get(index).getNorthExit();
                        } else {
                            System.out.println("------------------------------------------------------------------------------");
                            System.out.println("Sorry, there is nothing in that direction");
                        }
                        break;

                    case "e":
                        // check if the current room has a new room available in the direction entered
                        if(currentMap.doesRoomContainDirection(currentRoom, "e")){
                            // Set the current room as visited before moving on
                            currentGameRooms.get(index).setVisited();
                            // Change the current room to the value of the next room direction
                            currentPlayer.setPreviousRoomNumber(currentRoom);
                            currentRoom = currentGameRooms.get(index).getEastExit();
                        } else {
                            System.out.println("------------------------------------------------------------------------------");
                            System.out.println("Sorry, there is nothing in that direction");
                        }
                        break;

                    case "s":
                        // check if the current room has a new room available in the direction entered
                        if(currentMap.doesRoomContainDirection(currentRoom, "s")){
                            // Set the current room as visited before moving on
                            currentGameRooms.get(index).setVisited();
                            // Change the current room to the value of the next room direction
                            currentPlayer.setPreviousRoomNumber(currentRoom);
                            currentRoom = currentGameRooms.get(index).getSouthExit();
                        } else {
                            System.out.println("------------------------------------------------------------------------------");
                            System.out.println("Sorry, there is nothing in that direction");
                        }
                        break;

                    case "explore":
                        // prints the inventory of the current room
                        currentGameRooms.get(currentRoom).printRoomInventory();
                        break;
                    case "mm":
                        System.out.println("Returning to Main Menu");
                        System.out.println();
                        mainMenu();

                    default:
                        System.out.println("------------------------------------------------------------------------------");
                        System.out.println("Sorry. That was an invalid input");
                }
                break;
            }
        }
    }
}
