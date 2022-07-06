// Package Data
package SAGUI.data;
import java.util.Random;

public class InitData { 

    private Random rd = new Random();

    public InitData() {
    }

	// Generate Random Array 
    public int[] genRandomArr(int length) { 
    	int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = rd.nextInt(length+1);
        }
        return array;
    }
}





