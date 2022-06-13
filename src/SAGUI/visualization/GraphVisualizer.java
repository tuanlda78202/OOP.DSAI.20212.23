// author @tuanlda78202

package SAGUI.visualization;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Integer.max;
import javax.swing.JPanel;

public class GraphVisualizer extends JPanel {

    private int rectangle_width;
    private int length;
    private int[] array;
    private int current;
    private int check;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getRectangle_width() {
        return rectangle_width;
    }

    public void setRectangle_width(int rectangle_width) {
        this.rectangle_width = rectangle_width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public GraphVisualizer(int recWid, int length, int[] ar, int cur, int check) {
        setBackground(Color.black);
        this.rectangle_width = recWid;
        this.length = length;
        this.array = ar;
        this.current = cur;
        this.check = check;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //InitializeData data = new InitializeData();
        //ManipulateVisualizer manipulateVisualizer = new ManipulateVisualizer();
        //SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        
        int maxHeight = -1;
        for (int i = 0; i < length; i++) {
            maxHeight = max(maxHeight, array[i]);
        }
        
        for (int i = 0; i < length; i++) {
            int HEIGHT = array[i] * (600/maxHeight); // set height of element in graph.
            g.setColor(Color.white);
            if (current > -1 && i == current) {
                g.setColor(Color.green); // color of current traversing element
            }
            if (check > -1 && i == check) {
                g.setColor(Color.red); // color of current checking element
            }
            int curRectPosX = i * rectangle_width;
            // fill rectangle element in graph
            g.fillRect(curRectPosX, 0, rectangle_width, HEIGHT);

            g.setColor(Color.black);

            // draw outline of rectangle element in graph
            g.drawRect(curRectPosX, 0, rectangle_width, HEIGHT);

        }
        //repaint();
    }
}
