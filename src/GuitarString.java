/**
 * Created by jsookikian on 12/8/15.
 */
public class GuitarString {
    public Note[] String_ = new Note[24];
    public String note;

    public GuitarString(String openNote, int octave, NoteHashTable table){
        note = openNote;
        int noteIndex = ScaleAlgorithm.getNote(openNote, octave);

        for (int i = 0; i < String_.length; i++){
            if(table.find(new Note("", 0, 0, i+1)) != null){
                String_[i] = table.find(new Note("", 0, 0, noteIndex++));
            }
        }
    }
}
