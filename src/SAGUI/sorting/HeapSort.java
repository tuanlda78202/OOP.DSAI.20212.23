package SAGUI.sorting;

import SAGUI.visualization.ManipulateVisualizer;

public class HeapSort extends AbsSort{
	
    private int current = -1;
    private int check = -1;

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

	public void checkPause() {
        while (!getManipulateVisualizer().isIsSorting()) {
            getManipulateVisualizer().setSortingProcessMsg(String.format("Heap sort: Stop"));
            if (getManipulateVisualizer().isIsStop()) {
                break;
            }
        }
	}
	
    public HeapSort(int length, int[] array, boolean isSorting, boolean isPause, boolean isStop, ManipulateVisualizer mv) {
        super(length, array, isSorting, isPause, isStop, mv);
    }
    
    public void heapify(int n, int i, boolean buildingHeap) {
		checkPause();
        if (getManipulateVisualizer().isIsStop()) {
            return;
        }
    	int largest = i; 
		int l = 2 * i + 1; 
		int r = 2 * i + 2; 
		String nxt = "";
		if (l < n && this.getArray()[l] > this.getArray()[largest]) {
		    largest = l;
		    nxt = "left";
		}
		if (r < n && this.getArray()[r] > this.getArray()[largest]) {
		    largest = r;
		    nxt = "right";
		}
		if (largest != i) {
			setCurrent(i);
			setCheck(largest);
			
			if (buildingHeap) {
			    getManipulateVisualizer().setSortingProcessMsg(
	                    String.format("Building Heap: Swap elements at position %d to the %s at position %d because %d less than %d", 
	                    		i, nxt, largest, getArray()[i], getArray()[largest]));
			}
			else {
				getManipulateVisualizer().setSortingProcessMsg(
	                    String.format("Doing Heap sort: Swap elements at position %d to the %s at position %d because %d less than %d", 
	                    		i, nxt, largest, getArray()[i], getArray()[largest]));
			}
			
		    swap(i, largest);
            getManipulateVisualizer().setCompared(getManipulateVisualizer().getCompared() + 1);
            getManipulateVisualizer().setArrayAccessed(getManipulateVisualizer().getArrayAccessed() + 2);

            getManipulateVisualizer().updateProcess(getLength(), getArray(), getCurrent(), getCheck());
            getManipulateVisualizer().delay();
            heapify(n, largest, buildingHeap);
		}    	
    }
    
    public void buildHeap() {
        int n = this.getLength();
        for (int i=n/2-1; i>=0; i--) {
			checkPause();
            if (getManipulateVisualizer().isIsStop()) {
                break;
            }
        	heapify(n, i, true);
        }
    }
    @Override
    public void sort(int start, int end) {
        //getData().setStop(false);
    	int n = this.getLength();
        //setIsStop(false);
		for (int i = n - 1; i >= 0; i--) {
			checkPause();
            if (getManipulateVisualizer().isIsStop()) {
                break;
            }
			swap(i, 0);
			getManipulateVisualizer().setCompared(getManipulateVisualizer().getCompared() + 1);
            getManipulateVisualizer().setArrayAccessed(getManipulateVisualizer().getArrayAccessed() + 2);
			getManipulateVisualizer().updateProcess(this.getLength(), this.getArray(), this.getCurrent(), this.getCheck());
            getManipulateVisualizer().delay();
		    heapify(i, 0, false);
		}        
    }
}
