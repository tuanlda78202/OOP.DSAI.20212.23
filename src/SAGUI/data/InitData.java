// author @tuanlda78202

// Package Data
package SAGUI.data;
import SAGUI.visualization.ManipulateVisualizer;
// Random 
import java.util.Random;

public class InitData { 
    // Declare var 
    private int length;
    private int[] array;
    private boolean isSorting;
    private boolean isPause;
    private boolean isStop;

    private Random rd = new Random();

    // Method Init Data
    public InitData(int len, boolean isSorting, boolean isPause, boolean isStop) {
        this.length = len;
        this.isSorting = isSorting;
        this.isPause = isPause;
        this.isStop = isStop;
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

    public boolean isSorting() {
        return isSorting;
    }

    public void setSorting(boolean _isSorting) {
        this.isSorting = _isSorting;
    }

    public boolean isPause() {
        return isPause;
    }

    public void setPause(boolean _isPause) {
        this.isPause = _isPause;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean _isStop) {
        this.isStop = _isStop;
    }

    public boolean isSorted() {
        for (int i = 0; i < length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
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
        for (int x = 0; x < 50; x++) {
            for (int i = 0; i < length; i++) {
                int rand = rd.nextInt(length);
                swap(rand, i);
            }
        }
        isSorting = false;
        new ManipulateVisualizer(length, array, isSorting, isPause, isStop, -1, -1).initialize();
    }
}





