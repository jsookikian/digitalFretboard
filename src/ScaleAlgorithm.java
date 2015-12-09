/**
 * Created by jsookikian on 12/8/15.
 */

public class ScaleAlgorithm {


    public static int getNote(String note) {
        int noteIndex = -1;
        if (note.equalsIgnoreCase("A"))
            noteIndex = 1;
        else if (note.equalsIgnoreCase("A#") || note.equalsIgnoreCase("Bb"))
            noteIndex = 2;
        else if (note.equalsIgnoreCase("B"))
            noteIndex = 3;
        else if (note.equalsIgnoreCase("C"))
            noteIndex = 4;
        else if (note.equalsIgnoreCase("C#") || note.equalsIgnoreCase("Db"))
            noteIndex = 5;
        else if (note.equalsIgnoreCase("D"))
            noteIndex = 6;
        else if (note.equalsIgnoreCase("D#") || note.equalsIgnoreCase("Eb"))
            noteIndex = 7;
        else if (note.equalsIgnoreCase("E"))
            noteIndex = 8;
        else if (note.equalsIgnoreCase("F"))
            noteIndex = 9;
        else if (note.equalsIgnoreCase("F#") || note.equalsIgnoreCase("Gb"))
            noteIndex = 10;
        else if (note.equalsIgnoreCase("G"))
            noteIndex = 11;
        else if (note.equalsIgnoreCase("G#") || note.equalsIgnoreCase("Ab"))
            noteIndex = 12;
        return noteIndex;
    }

    public static int getNote(String note, int octaveNum) {
        int noteIndex = -1;
        int octave = (octaveNum - 1) * 12;
        if (note.equalsIgnoreCase("A"))
            noteIndex = 1 + octave;
        else if (note.equalsIgnoreCase("A#") || note.equalsIgnoreCase("Bb"))
            noteIndex = 2 + octave;
        else if (note.equalsIgnoreCase("B"))
            noteIndex = 3 + octave;
        else if (note.equalsIgnoreCase("C"))
            noteIndex = 4 + octave;
        else if (note.equalsIgnoreCase("C#") || note.equalsIgnoreCase("Db"))
            noteIndex = 5 + octave;
        else if (note.equalsIgnoreCase("D"))
            noteIndex = 6 + octave;
        else if (note.equalsIgnoreCase("D#") || note.equalsIgnoreCase("Eb"))
            noteIndex = 7 + octave;
        else if (note.equalsIgnoreCase("E"))
            noteIndex = 8 + octave;
        else if (note.equalsIgnoreCase("F"))
            noteIndex = 9 + octave;
        else if (note.equalsIgnoreCase("F#") || note.equalsIgnoreCase("Gb"))
            noteIndex = 10 + octave;
        else if (note.equalsIgnoreCase("G"))
            noteIndex = 11 + octave;
        else if (note.equalsIgnoreCase("G#") || note.equalsIgnoreCase("Ab"))
            noteIndex = 12 + octave;
        return noteIndex;
    }

    public static Note[] allNotes(String note, NoteHashTable table) {
        int i = getNote(note);
        Note[] notes = new Note[9];
        int noteIndex = 0;
        while (i < 98) {
            Note key = new Note("", 0, 0, i);

            if (table.find(key) != null) {
                notes[noteIndex++] = table.find(key);
                i+=12;
            }
        }
        return notes;
    }

    public static Note[] generateBluesPentatonicScale(String note, NoteHashTable table, int offset){
        int i = getNote(note);
        if (i == -1)
            throw new NoSuchNoteException();
        int scaleIndex = 0;
        Note[] scale = new Note[58];
        while (i < 98) {
            Note Root = new Note("", 0, 0, i + offset);
            Note Three = new Note("", 0, 0, i + 2 + offset);
            Note Five = new Note("", 0, 0, i + 4 + offset);
            Note FlatSeventh = new Note("", 0, 0, i + 3 + offset);
            Note Seventh = new Note("", 0, 0, i + 7 + offset);
            Note Ninth = new Note("", 0, 0, i + 9 + offset);


            if (table.find(Root) != null)
                scale[scaleIndex++] = table.find(Root);
            if (table.find(Three) != null)
                scale[scaleIndex++] = table.find(Three);
            if (table.find(Five) != null)
                scale[scaleIndex++] = table.find(Five);
            if (table.find(FlatSeventh) != null)
                scale[scaleIndex++] = table.find(FlatSeventh);
            if (table.find(Seventh) != null)
                scale[scaleIndex++] = table.find(Seventh);
            if (table.find(Ninth) != null)
                scale[scaleIndex++] = table.find(Ninth);
            i += 12;
        }
        return scale;
    }

    public static Note[] generateDiatonicScale(String note, NoteHashTable table, int offset){
        int i = getNote(note);
        if (i == -1)
            throw new NoSuchNoteException();
        int scaleIndex = 0;
        Note[] scale = new Note[58];
        while (i < 98) {
            Note Root = new Note("", 0, 0, i + offset);
            Note Three = new Note("", 0, 0, i + 2 + offset);
            Note Five = new Note("", 0, 0, i + 4 + offset);
            Note FlatSeventh = new Note("", 0, 0, i + 5 + offset);
            Note Seventh = new Note("", 0, 0, i + 7 + offset);
            Note Ninth = new Note("", 0, 0, i + 9 + offset);
            Note Flat = new Note("", 0, 0, i + 11 + offset);


            if (table.find(Root) != null)
                scale[scaleIndex++] = table.find(Root);
            if (table.find(Three) != null)
                scale[scaleIndex++] = table.find(Three);
            if (table.find(Five) != null)
                scale[scaleIndex++] = table.find(Five);
            if (table.find(FlatSeventh) != null)
                scale[scaleIndex++] = table.find(FlatSeventh);
            if (table.find(Seventh) != null)
                scale[scaleIndex++] = table.find(Seventh);
            if (table.find(Ninth) != null)
                scale[scaleIndex++] = table.find(Ninth);
            if (table.find(Ninth) != null)
                scale[scaleIndex++] = table.find(Flat);
            i += 12;
        }
        return scale;
    }

    public static Note[] generatePentatonicScale(String note, NoteHashTable table, int offset){
        int i = getNote(note);
        if (i == -1)
            throw new NoSuchNoteException();
        int scaleIndex = 0;
        Note[] scale = new Note[58];
        while (i < 98) {
            Note Note1 = new Note("", 0, 0, i + offset);
            Note Note2 = new Note("", 0, 0, i + 2 + offset);
            Note Note3 = new Note("", 0, 0, i + 4 + offset);
            Note Note4 = new Note("", 0, 0, i + 7 + offset);
            Note Note5 = new Note("", 0, 0, i + 9 + offset);


            if (table.find(Note1) != null)
                scale[scaleIndex++] = table.find(Note1);
            if (table.find(Note2) != null)
                scale[scaleIndex++] = table.find(Note2);
            if (table.find(Note3) != null)
                scale[scaleIndex++] = table.find(Note3);
            if (table.find(Note4) != null)
                scale[scaleIndex++] = table.find(Note4);
            if (table.find(Note5) != null)
                scale[scaleIndex++] = table.find(Note5);
            i += 12;
        }
        return scale;
    }

    public static Note[] generateMajorScale(String note, NoteHashTable table, int offset) {
        int i = getNote(note);
        if (i == -1)
            throw new NoSuchNoteException();
        int scaleIndex = 0;
        Note[] scale = new Note[58];
        while (i < 98) {
            Note Tonic = new Note("", 0, 0, i + offset);
            Note Supertonic = new Note("", 0, 0, i + 2 + offset);
            Note Mediant = new Note("", 0, 0, i + 4 + offset);
            Note Subdominant = new Note("", 0, 0, i + 5 + offset);
            Note Dominant = new Note("", 0, 0, i + 7 + offset);
            Note Submediant = new Note("", 0, 0, i + 9 + offset);
            Note Leading = new Note("", 0, 0, i + 11 + offset);

            if (table.find(Tonic) != null)
                scale[scaleIndex++] = table.find(Tonic);
            if (table.find(Supertonic) != null)
                scale[scaleIndex++] = table.find(Supertonic);
            if (table.find(Mediant) != null)
                scale[scaleIndex++] = table.find(Mediant);
            if (table.find(Subdominant) != null)
                scale[scaleIndex++] = table.find(Subdominant);
            if (table.find(Dominant) != null)
                scale[scaleIndex++] = table.find(Dominant);
            if (table.find(Submediant) != null)
                scale[scaleIndex++] = table.find(Submediant);
            if (table.find(Leading) != null)
                scale[scaleIndex++] = table.find(Leading);
            i += 12;
        }
        return scale;

    }

    public static Note[] ionianScale(String note, NoteHashTable table) {
        int offset = 0;
        return generateMajorScale(note, table, offset);
    }

    public static Note[] dorianScale(String note, NoteHashTable table) {

        int offset = 2;
        return generateMajorScale(note, table, offset);
    }

    public static Note[] phrygianScale(String note, NoteHashTable table) {
        int offset = 4;
        return generateMajorScale(note, table, offset);
    }

    public static Note[] lydianScale(String note, NoteHashTable table) {
        int offset = 5;
        return generateMajorScale(note, table, offset);
    }

    public static Note[] mixolydianScale(String note, NoteHashTable table) {

        int offset = 7;
        return generateMajorScale(note, table, offset);
    }

    public static Note[] aeolianScale(String note, NoteHashTable table) {
        int offset = 9;
        return generateMajorScale(note, table, offset);
    }

    public static Note[] locrianScale(String note, NoteHashTable table) {
        int offset = 10;
        return generateMajorScale(note, table, offset);
    }

    public static Note[] minorPentatonicScale(String note, NoteHashTable table){
        int offset = 3;
        return generatePentatonicScale(note, table, offset);
    }

    public static Note[] majorPentatonicScale(String note, NoteHashTable table){
        int offset = 0;
        return generatePentatonicScale(note, table, offset);
    }

    public static Note[] majorBluesPentatonicScale(String note, NoteHashTable table){
        int offset = 0;
        return generateBluesPentatonicScale(note, table, offset);
    }

    public static Note[] minorBluesPentatonicScale(String note, NoteHashTable table){
        int offset = 3;
        return generateBluesPentatonicScale(note, table, offset);
    }

    public static Note[] majorDiatonicScale(String note, NoteHashTable table){
        int offset = 0;
        return generateDiatonicScale(note, table, offset);
    }

    public static class NoSuchNoteException extends RuntimeException {
        public NoSuchNoteException() {
            super();
        }

        public NoSuchNoteException(String message) {
            super(message);
        }
    }

    public static void printScale(Note[] scale) {
        for (int i = 0; i < scale.length; i++) {
            if (scale[i] != null)
                System.out.print(scale[i]);
            if ((i + 1) % 7 == 0)
                System.out.println();
        }
    }

    public static boolean contains(Note key, Note[] scale) {
        boolean contains = false;
        for (int i = scale.length - 1; i >= 0; i--) {
            if (scale[i] != null) {
                if (key.noteIndex == scale[i].noteIndex) {
                    contains = true;
                    break;
                }
            }
        }
        return contains;
    }

    public static boolean containsNote(Note key, Note[] notes) {
        boolean contains = false;
        for (int i = notes.length - 2; i >= 0; i--) {
            if (key.noteIndex == notes[i].noteIndex) {
                contains = true;
                break;
            }
        }
        return contains;
    }


}
