// author @tuanlda78202
package SAGUI.main;

import java.util.Random;
public class main {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = rd.nextInt(101);
        }
    }
}
