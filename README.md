ABOUT THE GAME :
This game is an adaptation of the Stick
Hero mobile game, where the player needs 
to extend a stick to pass through platforms
and collect cherries. The objective is to 
cover maximum pillars without falling.

HOW TO PLAY :
Use U key to extend the stick.
Use F key to flip the character.
Collect cherries to earn points.
Your current score is displayed on top center.
Avoid falling off the platforms while extending the stick.


KEY POINTS :
1) RUN THE JUNITTEST FILE SEPERATELY TO SEE THE RESULT OF THE TEST TAKEN .
2) The stick generation starts from the middle of the pillar . 
3) To collect the cherries press f .
4) cherries are updated once the hero reaches back to starting pillar after transition .


DESIGN PATTERNS USED : 

1) Observer Pattern
The Timeline classes and methods like startCherryCollisionCheck and checkCherryCollision
exhibit aspects of the Observer pattern.  certain actions (checkCherryCollision) observe
changes or events (such as collisions) and react accordingly.
in methods like onKeyPressed and onKeyReleased, different actions
are performed based on specific key events. These methods act as
observers waiting for certain events (key presses or releases) and
trigger corresponding actions.

2) State pattern
The boolean flags like isGrowing, canGrowAndFall, and hasRotated
control different states of the game (e.g., whether the stick is
growing, allowed to grow or fall, or if rotation has occurred). 
These flags alter the behavior of the game's actions based on the
current state, resembling the State pattern's behavior.

3) Singleton Pattern
In the HelloApplication class, the Application class employs the
Singleton pattern as it has a single instance throughout the 
application's lifecycle. The launch() method is responsible for
initializing this single instance of the Application.

4) Factory Method Pattern
The FXMLLoader in the HelloApplication class uses a factory
method pattern to instantiate controller objects and load
FXML-based views. fxmlLoader.load() creates instances of 
the controllers and loads the corresponding FXML layouts.
fxmlLoader.getController() retrieves the associated controller instance.




FUNCTIONS :
1)onKeyPressed(): This checks the input "u" anf "f".

2)startCherryCollisionCheck(): check if the hero interacts with cherry or not after every 0.1 sec .

3)manageCherries():make use of 2 random number generator to generate cherries.

4)checkCherryCollision(): set the visibility of the cherry to 0 , whenever its bounds are interacted 

5)onKeyReleased(): checks the fall function . if not fall the transition of hero and pillars takes place .
if the length of pillar is shorter or longer wrt to fitted on next pillar , the hero fall and game over screen is directed .

6)displayGameOverScreen(): display score and cherry count . also allows restart and revive .

7)generatePillars() : generate pillars at random distance and of random width ranging from 90 to 140 .

8)growStick(): make the stick grow when u is pressed . 

9)reposition(): once the sticks lands perfectly on the next platform it reposition the stick in the middle of the new starting platform .

10)saveScore():saves the current high score of the game in a file ("hs.txt")

11)displayScore(): display the current high score (ON TERMINAL) by taking all the scores from the file in which they are saved and apply MAX function to display the highest of those score.
