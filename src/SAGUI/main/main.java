// author @tuanlda78202

package SAGUI.main;
import SAGUI.data.InitData;
import SAGUI.sorting.ManipulateSortingProcess;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        int[] array = new InitData().genRandomArr(50);
        new ManipulateSortingProcess(50, array, false, true, false, 50, -1, -1).init();
    }
}