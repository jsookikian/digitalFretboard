# digitalFretboard
A java program to emulate a guitar fretboard and show notes and scales. I implemented my own hash-table using open-addressing to handle collisions,

##To Run
Copy the repository by running this command in terminal
``` bash
git clone https://github.com/jsookikian/digitalFretboard.git
```
Then, move into the new directory
``` bash
cd digitalFretboard
```

All you need to do is run this script to run the program
``` bash
sh RunFretboard.sh
```
In order for the scales and notes to be printed correctly, you may need to resize the terminal window you are working in.

##Usage
As soon as you run the program, you will be prompted with a menu. Select any of the choices (case-sensitive) to select that scale or type 'n' to print a specific note. 


```
Choose one of the following operations by entering provided letter:
i - ionian scale (major)
d - dorian scale
p - phrygian scale
l - lydian scale
m - mixolydian scale
a - aeolian scale (minor)
L - Locrian scale

P - Major Pentatonic scale
M - Minor Pentatonic scale

B - Major Blues Pentatonic scale
b - Minor Blues Pentatonic scale

D - Diatonic scale

f - print fretboard
n - print specific note
q - Quit the program
Please enter a command: 
```
Then enter any root note to print out the scale for that note.
