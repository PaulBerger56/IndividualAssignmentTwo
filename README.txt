The entire map and descriptions are in a single line in the txt file.
The Values are delimited by a "~", and there can be several descriptions
which are delimited by "@".
All of the values are saved in a room object which are all added to an Arraylist.

The format is:
<Room Number>~<Room Name>~<Visited Flag>~<Room Connections>~<Descriptions>

<Room Number>
A single integer that is saved as roomNumber in a Room object.

<Room Name>
A String name that is saved as name in a Room Object.

<Visited Flag>
A boolean value that says whether the room has been visited or not.  Even though we could just make the room constructors
set the default value to false, I kept this in the file to help with save states. A save state will create a txt file with
all of the map data, but will have previously visited rooms set to true.

<Room Connections>
4 integers that represent the connections of one room to the others. Each room has a specific room number and these
numbers represent the connection to each other. If a value is 0, it means that there is no
connection there. The format is West, North, East, South.

<Description>
Each description is a string value. Multiple can be added in one line by delimiting them with "@". These values are then
saved into an ArrayList<String>.

StartingMap.txt is the default Map for my game and is laid out below.

____________________________
|       |        |         |        1 - Coastal Town
|   1   |    2   |    3    |        2 - The Forest
|_______|________|_________|        3 - Rocky Cliffs
|       |        |         |        4 - Sewers
|   4   |    5   |    6    |        5 - Mines
|_______|________|_________|        6 - Mountain Summit
|       |        |         |        7 - Swamp Lands
|   7   |    8   |    9    |        8 - Misty Forest
|_______|________|_________|        9 - Shipwreck Beach


User Manual:
Upon Starting the game you will be greeted by the main menu which has 4 options:

"1" New Game - This starts a new game which uses the default map and all visited flags are set to false.

"2" Continue a Saved Game (in progress) - This will allow you to load a save file which has visited room
            flags set to true.

"3" Save Current Game (in progress) - This will allow you to create a save file of your current game that
            saves the visited room flag states in their current value.

"4" Quit the Game - This will exit out of the program completely.


During the Game you have 5 options:

"mm" - will return you to the main menu.

"n" - will move you to the room North of your current position if there is one available.

"s" - will move you to the room South of your current position if there is one available.

"e" - will move you to the room East of your current position if there is one available.

"w" - will move you to the room West of your current position if there is one available.

How to quit:
At this point there is no winning or losing the game, so it will run forever. If you would like to quit,
either stop the running process in your IDE, or return to the main menu in game and select the quit option.