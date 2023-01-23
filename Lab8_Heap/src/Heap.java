public class Heap {
    int load=0;
    int [] hArray = new int[100]; 

    Heap() { }
    // Exercise 1 a)  
    void reheapUp(int currentIndex) {
       //  add your code here 
    	int Parent = (currentIndex-1)/2;
    	if(hArray[currentIndex]>hArray[Parent]) {
    		swap(hArray,currentIndex,Parent);
    		reheapUp(Parent);
    	}	
    		
    	
    }
        
    // Exercise  2 b) 
    void insert(int data) {
    //add your code here
    	hArray[load] = data;
    	if(load != 0)
    		reheapUp(load);
    	load++;
    	
        
    }
    
    // Exercise  3  
    void reheapDown(int currentIndex) {
    // add your code here
    
    	int LeftChild = (2*currentIndex)+1;
    	int RightChild = (2*currentIndex)+2;
    	
    	if(RightChild <= load-1) {
    		if(hArray[RightChild]>hArray[LeftChild]) {
    			if(hArray[currentIndex]<hArray[RightChild]) {
    				swap(hArray,currentIndex,RightChild);
    				reheapDown(RightChild);
    			}
    		}
    		else {
    			if(hArray[currentIndex]<hArray[LeftChild]) {
    				swap(hArray,currentIndex,LeftChild);
    				reheapDown(LeftChild);
    				}
    			}	
    		}
    }
    // Exercise  4  delete the root and return the value of the deleted root 
    int deleteRoot() {
       if(load == 0)
    	   return -1;  // replace this line with your code  
       int temp = hArray[0];
       hArray[0] = hArray[load-1];
       load--;
       reheapDown(0);
       return temp;
    }
 

    void makeHeapSort() {
	// add your code here
    	if(findLevel(load-1) != 0) {
    		for(int i = 0;i<load;i++) {
    			for(int j = 0;j<load;j++) {
    				if(hArray[i]>hArray[j])
    					swap(hArray,i,j);
    			}
    		}
    		printHeapArray();
    	}
    	
    	
    		

    	
	}
    
    //swap in the array A the values at ind1 and ind2
    void swap(int [] A, int ind1, int ind2) {
	int temp = A[ind1];
	A[ind1] = A[ind2];
	A[ind2] = temp;
    }
        
    //print the heap Array
    void printHeapArray() {
	for (int i = 0; i < load; i++)
	    System.out.print(hArray[i] + " ");
	    System.out.println();
	}
    
    
    int findLevel(int nodeindex) {
	int parent = (nodeindex - 1) / 2;
	int level = 0;

	if (parent > 0)
	    level++;

	while (parent > 0) {
	    parent = (parent - 1) / 2;
	    level++;
	}
	return level;
	}
   
}