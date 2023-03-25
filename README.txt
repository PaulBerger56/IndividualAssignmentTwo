The entire map and descriptions are in a single line in the txt file.
The Values are delimited by a "~", and there can be several descriptions
which are delimited by "@".
All the room values are saved in a room object which are all added to an Arraylist.

The format is:
<Room Number>~<Room Name>~<Visited Flag>~<Room Connections>~<Descriptions>

<Room Number>
A single integer that is saved as roomNumber in a Room object.

<Room Name>
A String name that is saved as name in a Room Object.

<Visited Flag>
A boolean value that says whether the room has been visited or not.  Even though we could just make the room
constructors set the default value to false, I kept this in the file to help with save states. A save state will create
a txt file with all the map data, but will have previously visited rooms set to true.

<Room Connections>
4 integers that represent the connections of one room to the others. Each room has a specific room number and these
numbers represent the connection to each other. If a value is 0, it means that there is no
connection there. The format is West, North, East, South.

<Description>
Each description is a string value. Multiple can be added in one line by delimiting them with "@". These values are then
saved into an ArrayList<String>.


------------------------------------------------------------------------------------------------------------------------


StartingMap.txt is the default Map for my game and is laid out below.
Puzzles will be added to Random Rooms.
StartingItems.txt will put items in specific rooms.

____________________________
|       |        |         |        1 - Coastal Town - Flowers
|   1   |    2   |    3    |        2 - The Forest - No Item
|_______|________|_________|        3 - Rocky Cliffs - No Item
|       |        |         |        4 - Sewers - Cheeseburger
|   4   |    5   |    6    |        5 - Mines - Sword
|_______|________|_________|        6 - Mountain Summit - No Item
|       |        |         |        7 - Swamp Lands - Mush
|   7   |    8   |    9    |        8 - Misty Forest - No Item
|_______|________|_________|        9 - Shipwreck Beach - Hat


------------------------------------------------------------------------------------------------------------------------


Items:
Items are read in from a .txt file.  StartingItems.txt will be the default unless specified otherwise
The Items are read into an ArrayList and then added to the inventory of their specified room.
The values will all be on one line and delimited by "~".

The Item text file format is:
<Item Name>~<Item Description>~<Starting Room>

<Item Name>
The name of the Item as a String Value.

<Item Description>
A brief description of the Item as a String Value

<Starting Room>
The Room Number that the item will spawn at the start of the game saved as an int Value.


------------------------------------------------------------------------------------------------------------------------


Puzzles:
Puzzles are read in from a .txt file.  StartingPuzzles.txt will be the default unless specified otherwise.
The Puzzles are read in and saved in a temporary ArrayList.  They are then randomly placed in different Rooms.
Each room can only hold one puzzle. The puzzles are set in their place at the beginning of the game and cannot be moved
after initialization. Each puzzle has a certain number of attempts. If the user answers incorrectly for each number of
attempts, they will be returned to the room that the puzzle is in. If they leave the room and return, the puzzle tries
will be reset, and they can try again.  If they user gets the correct answer, the puzzle will be solved and become
inaccessible for the rest of the current game. The values will all be on one line and delimited by "~".

The Puzzle text file format is:
<Puzzle Name>~<Puzzle Question>~<Puzzle Solution>~<Number of Attempts>

<Puzzle Name>
The name of the Puzzle as a String value.

<Puzzle Question>
The Question that the puzzle is asking saved as a String value.

<Puzzle Solution>
The answer to the puzzle question saved as a String value.

<Number of Attempts>
The number of attempts that the user has to solve the puzzle in one sitting saved as an int Value.


------------------------------------------------------------------------------------------------------------------------


User Manual:
Upon Starting the game you will be greeted by the main menu which has 4 options:

"1" New Game - This starts a new game which uses the default map and all visited flags are set to false.

"2" Continue a Saved Game (in progress) - This will allow you to load a save file which has visited room
            flags set to true.

"3" Save Current Game (in progress) - This will allow you to create a save file of your current game that
            saves the visited room flag states in their current value.

"4" Quit the Game - This will exit out of the program completely.


During the Game you have 10 options, all of which are case-insensitive:

"mm" - will return you to the main menu.

"n" - will move you to the room North of your current position if there is one available.

"s" - will move you to the room South of your current position if there is one available.

"e" - will move you to the room East of your current position if there is one available.

"w" - will move you to the room West of your current position if there is one available.

"explore" - prints a list of all the Items contained in the current room.

"pickup <item-name>" - removes the item from the current room's inventory and adds it to the player's inventory.

"drop <item-name>" - removes the item from the player's inventory and adds it to the current room's inventory.

"inspect <item-name>" - if the specific item is inside the player's inventory, that item's description will be printed.

"inventory" - prints the names of all the items in the player's inventory.


If the player enters a room with a puzzle, that puzzle will be started immediately.  A question will be asked, and the
user needs to type in their answer and press enter.  The answers are case-insensitive, so capitalization is not needed.


How to quit:
At this point there is no winning or losing the game, so it will run forever. If you would like to quit,
either stop the running process in your IDE, or return to the main menu in game and select the quit option.