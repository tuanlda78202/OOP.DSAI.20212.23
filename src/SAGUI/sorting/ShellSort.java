package SAGUI.sorting;

import SAGUI.visualization.ManipulateVisualizer;

public class ShellSort extends AbsSort{
	
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
    
	public ShellSort(int length, int[] array, boolean isSorting, boolean isPause, boolean isStop, ManipulateVisualizer mv) {
        super(length, array, isSorting, isPause, isStop, mv);
    }
	
<<<<<<< HEAD
	public void checkPause() {
        while (!getManipulateVisualizer().isIsSorting()) {
            getManipulateVisualizer().setSortingProcessMsg(String.format("Bubble sort: Stop"));
            if (getManipulateVisualizer().isIsStop()) {
                break;
            }
        }
	}
	
=======
>>>>>>> 947db6e13ded73b55630a0204a01fb4297634589
	@Override
	public void sort(int start, int end) {
		int n = this.getLength();
		for (int gap = n/2; gap > 0; gap /= 2){
<<<<<<< HEAD
			checkPause();
			if (getManipulateVisualizer().isIsStop()) {
                break;
            }
			for (int i = gap; i < n; i += 1){
				checkPause();
				if (getManipulateVisualizer().isIsStop()) {
                    break;
                }
		        int temp = this.getArray()[i]; 
		        int j;
		        setCurrent(i);
		        for (j = i; j >= gap && this.getArray()[j - gap] > temp; j -= gap) {
		        	checkPause();
		        	if (getManipulateVisualizer().isIsStop()) {
	                    break;
	                }
		        	this.getArray()[j] = this.getArray()[j - gap];
		        	setCheck(j - gap);
		        	getManipulateVisualizer().setSortingProcessMsg(
                            String.format("Shell sort: Gap size: %d."
                            		+ " Comparing elements at position %d with the right side of the gap at position %d ", 
                            		gap, j - gap, i));
=======
			for (int i = gap; i < n; i += 1){
		        int temp = this.getArray()[i]; 
		        int j;
		        for (j = i; j >= gap && this.getArray()[j - gap] > temp; j -= gap) {
		        	this.getArray()[j] = this.getArray()[j - gap];
		        	setCurrent(j);
		        	setCheck(j - gap);
		        	getManipulateVisualizer().setSortingProcessMsg(
                            String.format("Shell sort: Set elements at position %d by elements at position %d ", j,
                                    j - gap));
>>>>>>> 947db6e13ded73b55630a0204a01fb4297634589
		        	
		        	getManipulateVisualizer().setCompared(getManipulateVisualizer().getCompared() + 1);
		            getManipulateVisualizer().setArrayAccessed(getManipulateVisualizer().getArrayAccessed() + 2);

		            getManipulateVisualizer().updateProcess(getLength(), getArray(), getCurrent(), getCheck());
		            getManipulateVisualizer().delay();
		        }
		        this.getArray()[j] = temp;
		        
		        getManipulateVisualizer().setCompared(getManipulateVisualizer().getCompared() + 1);
	            getManipulateVisualizer().setArrayAccessed(getManipulateVisualizer().getArrayAccessed() + 2);

	            getManipulateVisualizer().updateProcess(getLength(), getArray(), getCurrent(), getCheck());
	            getManipulateVisualizer().delay();
		    }
		}		
	}
}
