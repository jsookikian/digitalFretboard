import javafx.scene.transform.Scale;

/**
 * Created by jsookikian on 12/8/15.
 */
public class Fretboard {
    final static int StringCount = 6;
    final static GuitarString[] strings = new GuitarString[StringCount];

    public Fretboard(NoteHashTable table){
        //Initialized to standard tuning
        strings[0] = new GuitarString("E", 4, table);
        strings[1] = new GuitarString("B", 3, table);
        strings[2] = new GuitarString("G", 3, table);
        strings[3] = new GuitarString("D", 3, table);
        strings[4] = new GuitarString("A", 2, table);
        strings[5] = new GuitarString("E", 2, table);
    }

    public static void printFretboard() {
        System.out.print("         1     ");
        for(int i = 2; i < 24; i++){
            if (i < 10)
                System.out.print("      " + i + "     ");
            else
                System.out.print("     " + i + "     ");
        }
        System.out.println();
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i].String_[0] + "|");
                for (int j = 1; j < strings[i].String_.length; j++) {
                    if (strings[i].String_[j].noteLength == 1)
                        System.out.print("----" + strings[i].String_[j] + "----|");
                    else
                        System.out.print("--" + strings[i].String_[j] + "--|");
                }
                System.out.println();
            }
    }

    public static void printNote(Note[] notes){
        System.out.print("         1     ");
        for(int i = 2; i < 24; i++){
            if (i < 10)
                System.out.print("      " + i + "     ");
            else
                System.out.print("     " + i + "     ");
        }
        System.out.println();
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i].String_[0] + "|");
            for (int j = 1; j < strings[i].String_.length; j++)
            {
                if (ScaleAlgorithm.containsNote(strings[i].String_[j], notes)) {
                    if (strings[i].String_[j].noteLength == 1)
                        System.out.print("----" + strings[i].String_[j] + "----|");
                    else
                        System.out.print("--" +strings[i].String_[j] + "--|");
                }
                else {
                    System.out.print("-----------|");
                }
            }
            System.out.println();
        }
        System.out.println("\n");

    }

    public static void printScale(Note[] scale){
        System.out.print("         1     ");
        for(int i = 2; i < 24; i++){
            if (i < 10)
                System.out.print("      " + i + "     ");
            else
                System.out.print("     " + i + "     ");
        }
        System.out.println();
        for (int i = 0; i < strings.length; i++)
        {
            System.out.print(strings[i].String_[0] +"|");
            for (int j = 1; j < strings[i].String_.length; j++)
            {
                if (ScaleAlgorithm.contains(strings[i].String_[j], scale))
                {
                    if (strings[i].String_[j].noteLength == 1)
                        System.out.print("----" + strings[i].String_[j] + "----|");
                    else
                        System.out.print("--" +strings[i].String_[j] + "--|");
                }
                else
                {
                    System.out.print("-----------|");
                }
            }
            System.out.println();
        }
        System.out.println("\n");

    }

    public static void printIonianScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.ionianScale(note, table);
        printScale(scale);
    }

    public static void printDorianScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.dorianScale(note, table);
        printScale(scale);
    }

    public static void printPhrygianScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.phrygianScale(note, table);
        printScale(scale);
    }

    public static void printLydianScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.lydianScale(note, table);
        printScale(scale);
    }

    public static void printMixolydianScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.mixolydianScale(note, table);
        printScale(scale);
    }

    public static void printAeolianScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.aeolianScale(note, table);
        printScale(scale);
    }

    public static void printLocrianScale(String note, NoteHashTable table) {
        Note[] scale = ScaleAlgorithm.locrianScale(note, table);
        printScale(scale);
    }

    public static void printMinorPentatonicScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.minorPentatonicScale(note, table);
        printScale(scale);
    }

    public static void printMajorPentatonicScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.majorPentatonicScale(note, table);
        printScale(scale);
    }

    public static void printMinorBluesPentatonicScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.minorBluesPentatonicScale(note, table);
        printScale(scale);
    }

    public static void printMajorBluesPentatonicScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.majorBluesPentatonicScale(note, table);
        printScale(scale);
    }

    public static void printDiatonicScale(String note, NoteHashTable table){
        Note[] scale = ScaleAlgorithm.majorDiatonicScale(note, table);
        printScale(scale);
    }
}
