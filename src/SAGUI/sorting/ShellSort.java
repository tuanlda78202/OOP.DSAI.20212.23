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
	
	public void checkPause() {
        while (!getManipulateVisualizer().isIsSorting()) {
            getManipulateVisualizer().setSortingProcessMsg(String.format("Bubble sort: Stop"));
            if (getManipulateVisualizer().isIsStop()) {
                break;
            }
        }
	}
	
	@Override
	public void sort(int start, int end) {
		setIsStop(false);
		int n = this.getLength();
		for (int gap = n/2; gap > 0; gap /= 2){
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
                            String.format("Shell sort: Current Gap size = %d."
                            		+ " Comparing elements at position %d with the right side of the gap at position %d ", 
                            		gap, j - gap,i));
		        	
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
