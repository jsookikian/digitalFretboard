/**
 * Created by jsookikian on 12/5/15.
 */
public class Note {
    public String note;
    public int noteLength;
    public int octave;
    public double frequency;
    int noteIndex;

    public Note(String name, int octaveNum, double frequency, int noteIndex){
        this.note = name;
        this.octave = octaveNum;
        this.frequency = frequency;
        this.noteIndex = noteIndex;
        this.noteLength = note.length();
    }

    public boolean equals(Object other) {
        if (other instanceof Note) {
            Note o = (Note) other;
            if (noteIndex == o.noteIndex) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public String toString() {
        return "(" + note + ")" ;
    }

    public int hashCode(){
        return ((Integer)noteIndex).hashCode();
    }
}



