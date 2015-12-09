import java.util.Iterator;

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.NoSuchElementException;

/**
 * Created by jsookikian on 12/8/15.
 */
public class NoteHashTable {
    private HashEntry[] table;   //A private array of Hash Entries for the hash table.
    private int total;           // a variable to contain the current size of the collection

    //A class to create a HashEntry object
    private class HashEntry {
        public Note element;   //variable for an Note element to containt the object that is being hashed.
        public boolean isActive; //variable to indicate whether the element is active or not.

    }

    //A constructor to create an empty hash table.
    public NoteHashTable(int count) {
        int tableSize = nextPrime(2 * count);
        table = new HashEntry[tableSize];
        total = 0;
    }

    //A method to create and return an Iterator.
    public Iterator iterator() {
        return new Iter();
    }


    //A private class to create our implementation of an Iterator.
    private class Iter implements Iterator {
        public int cursor;   //keeps track of the current element.

        //A constructor to create an Iterator.
        public Iter() {
            cursor = 0;
            for (int i = cursor; i < table.length; i++) {
                if (table[i] != null && table[i].isActive) {
                    cursor = i;
                    break;
                } else if (i == table.length - 1) {
                    cursor = table.length;
                }
            }
        }

        //A method to check if the iterator has a next element.
        public boolean hasNext() {
            return cursor < table.length;
        }

        //A method to advance the Iterator forward.
        public Note next() {
            Note current = table[cursor].element;
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException();
            }

            cursor++;
            while (cursor < table.length) {
                if (table[cursor] != null && table[cursor].isActive) {
                    break;
                }
                cursor++;
            }

            return current;
        }

        //A method to throw an exception since we do not suppor the implementation
        //of the remove() method.
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    //A private method to get the next prime number.
    private static int nextPrime(int num) {
        int nextPrime = num + 1;
        if (num >= 2) {
            while (!isPrime(nextPrime))
                nextPrime++;
        }
        return nextPrime;
    }

    //a private method to check if a given number is prime or not.
    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    //A method to correctly hash and insert an Note into the hash table.
    public void insert(Note item) {

        int index = findPosition(item);

        if (table[index] == null) {
            HashEntry entry = new HashEntry();
            entry.element = item;
            entry.isActive = true;
            table[index] = entry;
            total++;

            if (total * 2 >= table.length) {
                rehash();
            }
        } else {
            if (!table[index].isActive) {
                table[index].isActive = true;
            }
        }
    }

    /*
     * A private method to rehash the elements.
     * This method resizes the table and clears out inactive elements
     */
    private void rehash() {
        int tableSize = nextPrime(table.length * 2);
        HashEntry[] temp = table;
        table = new HashEntry[tableSize];
        total = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null && temp[i].isActive) {
                int index = findPosition(temp[i].element);
                table[index] = temp[i];
                table[index].isActive = true;
                total++;
            }
        }
    }

    /*
     * A private method to hash an object.
     */
    private int hash(Note x) {
        return x.hashCode() % table.length;
    }

    /*
     * A private method to find the correct position of an
     * Note in the table, and calls the generic findPosition method.
     */
    private int findPosition(Note x) {
        return findPosition_Table(x, table);
    }

    /*
     *  A private method to find the correct postion of an
     *  Note in the hash table, and it uses the current table
     *  as a parameter.
     */
    private int findPosition_Table(Note o, HashEntry[] hashTable) {
        int i = 0;
        int hashValue = hash(o);
        int index = hashValue;
        while (hashTable[index] != null && !hashTable[index].element.equals(o)) {
            i++;
            index = (hashValue + (i * i)) % hashTable.length;
        }
        return index;
    }

    /*
     * A method to delete an object from the table
     * This method only makes the object inactive.
     */
    public void delete(Note item) {
        int index = findPosition(item);
        if (table[index] != null && table[index].isActive) {
            table[index].isActive = false;
        }
    }


    /*
     * A  method to check whether an Note
     * is in the hash table or not.
     */
    public Note find(Note item) {
        int index = findPosition(item);
        if (table[index] != null && table[index].isActive) {
            return table[index].element;
        }
        return null;
    }

    /*
     *  A method to return the current size
     *  of the collection.
     */
    public int elementCount() {
        int result = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].isActive) {
                result++;
            }
        }
        return result;
    }

    /*
     *  A method to check whether the table is empty.
     */
    public boolean isEmpty() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].isActive) {
                return false;
            }
        }
        return true;
    }

    /*
     * A method to empty the hash table.
     */
    public void makeEmpty() {
        table = new HashEntry[table.length];
        total = 0;
    }

    /*
     * A method to output the table.
     */
    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            String result;
            if (table[i] == null) {
                System.out.println("[" + i + "]: empty");
            } else if (!table[i].isActive) {
                System.out.println("[" + i + "]: " + table[i].element + ", inactive");
            } else {
                System.out.println("[" + i + "]: " + table[i].element + ", active");
            }

        }
    }
}


