// author @tuanlda78202

package SAGUI.main;
import SAGUI.sorting.ManipulateSortingProcess;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] array = new int[50];
        for (int i = 0; i < 50; i++) {
            array[i] = rd.nextInt(51);
        }
        new ManipulateSortingProcess(50, array, false, true, false, 50, -1, -1).init();
    }
}