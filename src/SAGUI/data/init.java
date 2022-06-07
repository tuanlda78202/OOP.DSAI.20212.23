// author @tuanlda78202
// Package Data
package SAGUI.data;

// Random 
import java.util.Random;

public class init { 
    // Declare var 
    private int length;
    private int[] array;
    
    private Random rd = new Random();

    // Method Init Data
    public init(int len) { 
        this.length = len;
    }

    // Getter 
    public int getLength() { 
        return length;
    }

    public int[] getArray() {
        return array;
    }

    // Setter 
    public void setLength(int _length) {
        this.length = _length;
    }

    public void setArray(int[] _array) { 
        this.array = _array;
    }

    // Init basic assign Array 
    public void basicArray() { 
        array = new int[length];
        for (int i = 0; i < length; i++) { 
            array[i] = i + 1;
        }
    }

    // Swap element by position
    public void swap(int p1, int p2) { 
        int tempt = array[p1];
        array[p1] = array[p2];
        array[p2] = tempt;
    }

    // Generate Random Array 
    public void genRandomArr() { 
        basicArray();
        for (int x = 0; x < 100; x++) {
            for (int i = 0; i < length; i++) {
                int rand = rd.nextInt(length);
                swap(rand, i);
            }
        }
    }
}