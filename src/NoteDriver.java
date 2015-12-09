import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class NoteDriver {

    //Main method for the driver to run in.
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);  //System In Scanner
        String noteFile = "src/noteData.txt";                    //variable for the file name.

        Scanner noteData;                                 //A Scanner to read the file
        try {
            noteData = new Scanner(new File(noteFile));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        int collectionSize = noteData.nextInt();
        NoteHashTable table = new NoteHashTable(collectionSize);
        noteData.nextLine();


        Scanner parser;
        int noteIndex = 1;
        //Conditions for a valid student.
        for (int i = 0; i < collectionSize; i++) {
            parser = new Scanner(noteData.nextLine());
            double frequency = -1;
            int octave = -1;
            String note = "";
            boolean valid = true;


            //First Check if the next value is a String.
            //If not, then it is not a valid note
            if (parser.hasNext()) {
                String value = parser.next();
                if (value.length() == 2) {
                    note = value.substring(0, 1);

                    octave = Character.getNumericValue(value.charAt(1));
                } else {
                    note = value.substring(0, 2) + value.substring(3, 6);
                    octave = Character.getNumericValue(value.charAt(2));
                }
            } else {
                valid = false;
            }

            //Next check the first value to see if it is a Long type.
            //If it is, then it is still a valid Note.
            if (parser.hasNextDouble()) {
                frequency = parser.nextDouble();
            } else {
                valid = false;
            }

            parser.nextDouble(); //Skip wavelength value.

            if (frequency <= 0)
                valid = false;

            //Check if the id is not already in the table.
            Note dummy = new Note(note, octave, frequency, 0);
            if (table.find(dummy) != null) {
                valid = false;
            }

            //Only if the line read is valid, then create a new student and
            //add it to the hash table.
            if (valid) {
                Note newNote = new Note(note, octave, frequency, noteIndex);
                table.insert(newNote);
                noteIndex++;
            }
        }
        Fretboard fretboard = new Fretboard(table);
        boolean running = true;  //Value to determine if the program is still running.

        String instructions =
                "\nChoose one of the following operations by entering provided letter:\n"
                        + "o - print the content of the hash table\n"
                        + "i - ionian scale (major)\n"
                        + "d - dorian scale\n"
                        + "p - phrygian scale\n"
                        + "l - lydian scale\n"
                        + "m - mixolydian scale\n"
                        + "a - aeolian scale (minor)\n"
                        + "L - Locrian scale\n"
                        + "f - print fretboard\n"
                        + "n - print specific note\n"
                        + "q - Quit the program\n";

        System.out.print(instructions);
        while (running) {
            System.out.println("Please enter a command: ");
            String command = in.nextLine();
            //make sure only the command being processed and nothing longer.
            if (command.length() != 1) {
                System.out.println("Command not recognized. Please enter a proper command.");
                continue;
            }

            switch (command.charAt(0)) {
                case 'i': {
                    System.out.println("Please enter a note");
                    try{
                        String note = in.next();
                        fretboard.printIonianScale(note, table);
                    } catch (ScaleAlgorithm.NoSuchNoteException e){
                        System.out.println("You entered an invalid note");
                    }
                    in.nextLine();
                    break;
                }
                case 'd': {
                    System.out.println("Please enter a note");
                    try{
                        String note = in.next();
                        fretboard.printDorianScale(note, table);
                    } catch (ScaleAlgorithm.NoSuchNoteException e){
                        System.out.println("You entered an invalid note");
                    }
                    in.nextLine();
                    break;
                }
                
                case 'p': {
                    System.out.println("Please enter a note");
                    try{
                        String note = in.next();
                        fretboard.printPhrygianScale(note, table);
                    } catch (ScaleAlgorithm.NoSuchNoteException e){
                        System.out.println("You entered an invalid note");
                    }
                    in.nextLine();
                    break;
                }
                case 'l':
                {
                    System.out.println("Please enter a note");
                    try{
                        String note = in.next();
                        fretboard.printLydianScale(note, table);
                    } catch (ScaleAlgorithm.NoSuchNoteException e){
                        System.out.println("You entered an invalid note");
                    }
                    in.nextLine();
                    break;
                }
                case 'm': {
                    System.out.println("Please enter a note");
                    try{
                        String note = in.next();
                        fretboard.printMixolydianScale(note, table);
                    } catch (ScaleAlgorithm.NoSuchNoteException e){
                        System.out.println("You entered an invalid note");
                    }
                    in.nextLine();
                    break;
                }
                case 'a': {
                    System.out.println("Please enter a note");
                    try{
                        String note = in.next();
                        fretboard.printAeolianScale(note, table);
                    } catch (ScaleAlgorithm.NoSuchNoteException e){
                        System.out.println("You entered an invalid note");
                    }
                    in.nextLine();
                    break;
                }
                case 'L':  {
                    System.out.println("Please enter a note");
                    try{
                        String note = in.next();
                        fretboard.printLocrianScale(note, table);
                    } catch (ScaleAlgorithm.NoSuchNoteException e){
                        System.out.println("You entered an invalid note");
                    }
                    in.nextLine();
                    break;
                }

                case 'n':  {
                    System.out.println("Please enter a note");
                    try{
                        String note = in.next();
                        Note[] notes = ScaleAlgorithm.allNotes(note, table);
                        fretboard.printNote(notes);
                    } catch (ScaleAlgorithm.NoSuchNoteException e){
                        System.out.println("You entered an invalid note");
                    }
                    in.nextLine();
                    break;
                }
                case 'o': //print out the hash table.
                    table.printTable();
                    break;
                case 'f':
                    fretboard.printFretboard();
                    break;
                case 'q': //quit the program
                    running = false;
                    System.out.println("The program is exiting. Goodbye.");
                    break;

                default:
                    System.out.println("What you entered did not correspond to an operation.");
                    break;
            }
        }
    }

}
