package SAGUI.sorting;

import SAGUI.visualization.ManipulateVisualizer;

public class ManipulateSortingProcess {

    private ManipulateVisualizer manipulateVisualizer;
    private int current;
    private int check;
    private int length;
    private int[] array;
    private boolean isSorting;
    private boolean isPause;
    private boolean isStop;

    private int speed;
    private int curAlg;

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCurAlg() {
        return curAlg;
    }

    public void setCurAlg(int curAlg) {
        this.curAlg = curAlg;
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

    public ManipulateVisualizer getManipulateVisualizer() {
        return manipulateVisualizer;
    }

    public void setManipulateVisualizer(ManipulateVisualizer manipulateVisualizer) {
        this.manipulateVisualizer = manipulateVisualizer;
    }

    public ManipulateSortingProcess(int len, int[] array, boolean isSorting, boolean isPause, boolean isStop, int speed, int current, int check) {
        this.length = len;
        this.array = array;
        this.isSorting = isSorting;
        this.isPause = isPause;
        this.isStop = isStop;
        this.speed = speed;
        this.current = current;
        this.check = check;
        manipulateVisualizer = new ManipulateVisualizer(length, array, isSorting, isPause, isStop, current, check);
    }

    public boolean isSorted() {
        return manipulateVisualizer.isIsSorted();
    }

    public void init() {
        manipulateVisualizer.initialize();

        sorting(false);
    }

    public void sorting(boolean printMsg) {
        length = manipulateVisualizer.getLength();
        array = manipulateVisualizer.getArray();
        isSorting = manipulateVisualizer.isIsSorting();
        isPause = manipulateVisualizer.isIsPause();
        isStop = manipulateVisualizer.isIsStop();
        curAlg = manipulateVisualizer.getCurAlg();
        
        if (!isSorted()) {
        	printMsg = false;
        }
        
        if (manipulateVisualizer.isIsSorting()) {
            try {
                switch (curAlg) {
                    case 0:  // Bubble sort
                        BubbleSort bubbleSort = new BubbleSort(length, array, isSorting, isPause, isStop, manipulateVisualizer);
                        bubbleSort.sort(0, length - 1);
                        break;
                    
                    case 1:  // Heap sort
                        HeapSort heapSort = new HeapSort(length, array, isSorting, isPause, isStop, manipulateVisualizer);
                        heapSort.buildHeap();
                        heapSort.sort(0, length - 1);
                        break;
                       
                    case 2: // Shell Sort
                    	ShellSort shellSort = new ShellSort(length, array, isSorting, isPause, isStop, manipulateVisualizer);
                        shellSort.sort(0, length - 1);
                        break;
                } 
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        if (!manipulateVisualizer.isIsPause()) {
            reset();
        }
     // update when sort done
        if (isSorted() && !printMsg) {
        	manipulateVisualizer.updateWhenSortDone();
        	if (!printMsg) {
	        	manipulateVisualizer.showSortedMsg();
	        	printMsg = true;
        	}
        }

        pause();
        sorting(printMsg);
    }

    public void pause() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }

        //sorting();
    }

    public void reset() {
        isSorting = false;
        manipulateVisualizer.setIsSorting(false);
        setCurrent(-1);
        setCheck(-1);
        Update();
    }

    public void delay() {
        try {
            Thread.sleep(speed);
        } catch (Exception e) {
        }
    }

    public void Update() {
        manipulateVisualizer.updateProcess(length, array, current, check);
    }

}