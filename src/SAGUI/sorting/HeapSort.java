package SAGUI.sorting;
<<<<<<< HEAD

=======
>>>>>>> 947db6e13ded73b55630a0204a01fb4297634589
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

<<<<<<< HEAD
	public void checkPause() {
        while (!getManipulateVisualizer().isIsSorting()) {
            getManipulateVisualizer().setSortingProcessMsg(String.format("Heap sort: Stop"));
            if (getManipulateVisualizer().isIsStop()) {
                break;
            }
        }
	}
	
=======
>>>>>>> 947db6e13ded73b55630a0204a01fb4297634589
    public HeapSort(int length, int[] array, boolean isSorting, boolean isPause, boolean isStop, ManipulateVisualizer mv) {
        super(length, array, isSorting, isPause, isStop, mv);
    }
    
    public void heapify(int n, int i, boolean buildingHeap) {
<<<<<<< HEAD
		checkPause();
        if (getManipulateVisualizer().isIsStop()) {
            return;
        }
    	int largest = i; 
=======
		int largest = i; 
>>>>>>> 947db6e13ded73b55630a0204a01fb4297634589
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
<<<<<<< HEAD
			setCurrent(i);
			setCheck(largest);
			
=======
			this.setCurrent(i);
			this.setCheck(largest);
>>>>>>> 947db6e13ded73b55630a0204a01fb4297634589
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
<<<<<<< HEAD
			
		    swap(i, largest);
            getManipulateVisualizer().setCompared(getManipulateVisualizer().getCompared() + 1);
            getManipulateVisualizer().setArrayAccessed(getManipulateVisualizer().getArrayAccessed() + 2);

            getManipulateVisualizer().updateProcess(getLength(), getArray(), getCurrent(), getCheck());
            getManipulateVisualizer().delay();
            heapify(n, largest, buildingHeap);
=======
		    this.swap(i, largest);
            this.getManipulateVisualizer().setCompared(getManipulateVisualizer().getCompared() + 1);
            this.getManipulateVisualizer().setArrayAccessed(getManipulateVisualizer().getArrayAccessed() + 2);
            this.getManipulateVisualizer().updateProcess(this.getLength(), this.getArray(), this.getCurrent(), this.getCheck());
            this.getManipulateVisualizer().delay();
            this.heapify(n, largest, buildingHeap);
>>>>>>> 947db6e13ded73b55630a0204a01fb4297634589
		}    	
    }
    
    public void buildHeap() {
        int n = this.getLength();
        for (int i=n/2-1; i>=0; i--) {
<<<<<<< HEAD
			checkPause();
            if (getManipulateVisualizer().isIsStop()) {
                break;
            }
        	heapify(n, i, true);
        }
=======
        	heapify(n, i, true);
        }
        for (int i=0; i<n; i++) {
        	System.out.print(this.getArray()[i] + " ");
        }
        this.getManipulateVisualizer().updateProcess(this.getLength(), this.getArray(), this.getCurrent(), this.getCheck());
        this.getManipulateVisualizer().delay();
        this.getManipulateVisualizer().setIsSorting(false);
        System.out.println("");
>>>>>>> 947db6e13ded73b55630a0204a01fb4297634589
    }
    
    @Override
    public void sort(int start, int end) {
        //getData().setStop(false);
    	int n = this.getLength();
<<<<<<< HEAD
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
=======
        setIsStop(false);
		for (int i = n - 1; i >= 0; i--) {
            while (!getManipulateVisualizer().isIsSorting()) {
                getManipulateVisualizer().setSortingProcessMsg(String.format("Heap sort: Stop"));
                if (getManipulateVisualizer().isIsStop()) {
                    break;
                }
            }
            if (getManipulateVisualizer().isIsStop()) {
                break;
            }
			this.swap(i, 0);
			this.getManipulateVisualizer().setCompared(getManipulateVisualizer().getCompared() + 1);
            this.getManipulateVisualizer().setArrayAccessed(getManipulateVisualizer().getArrayAccessed() + 2);
			this.getManipulateVisualizer().updateProcess(this.getLength(), this.getArray(), this.getCurrent(), this.getCheck());
            this.getManipulateVisualizer().delay();
		    heapify(i, 0, false);
		}        
		for (int i=0; i<n; i++) {
			System.out.print(this.getArray()[i] + " ");
		}
    }
}
>>>>>>> 947db6e13ded73b55630a0204a01fb4297634589
