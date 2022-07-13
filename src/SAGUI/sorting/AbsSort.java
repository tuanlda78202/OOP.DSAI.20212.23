package SAGUI.sorting;

import SAGUI.visualization.ManipulateVisualizer;

public abstract class AbsSort implements swap {

    private ManipulateVisualizer manipulateVisualizer;

    private int length;
    private int[] array;
    private boolean isSorting; 
    private boolean isPause;
    private boolean isStop;

    public ManipulateVisualizer getManipulateVisualizer() {
        return manipulateVisualizer;
    }

	public void setManipulateVisualizer(ManipulateVisualizer manipulateVisualizer) {
        this.manipulateVisualizer = manipulateVisualizer;
    }

    public AbsSort(int length, int[] array, boolean isSorting, boolean isPause, boolean isStop, ManipulateVisualizer mv) {
        this.length = length;
        this.array = array;
        this.isSorting = isSorting;
        this.isPause = isPause;
        this.isStop = isStop;
        this.manipulateVisualizer = mv;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    abstract public void sort(int start, int end);

    public boolean isIsSorting() {
        return isSorting;
    }

    public void setIsSorting(boolean isSorting) {
        this.isSorting = isSorting;
    }

    public boolean isIsPause() {
        return isPause;
    }

    public void setIsPause(boolean isPause) {
        this.isPause = isPause;
    }

    public boolean isIsStop() {
        return isStop;
    }

    public void setIsStop(boolean isStop) {
        this.isStop = isStop;
    }

    @Override
    public void swap(int i1, int i2) {
        int tmp = this.array[i1];
        this.array[i1] = this.array[i2];
        this.array[i2] = tmp;

        getManipulateVisualizer().updateArrayAccessed(5);
    }

}
