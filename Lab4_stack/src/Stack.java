class Stack < T > {

    private SList < T > list = new SList < T > ();

    Stack() {}

    void push(T element) {
        //Ex1a
    	list.addFirst(element);
        
    }

    T pop() {
    	//Ex1b replace this with your code
    	if(list.isEmpty() == true)
    		return null;
    	return list.removeFirst();
    	
        
        
    }

    T peek() {
    	//Ex1c replace this with your code
    	if(list.isEmpty() == true)
    		return null;
    	return list.get(0);
       

        
    }

    boolean isEmpty() {
        return list.isEmpty();
    }



    Stack < T > copyStack() {
        Stack < T > rvStack = reverseStack();
        return rvStack.reverseStack();
    }

    void printVertical() {
        list.printVertical();
    }

    
   static void binaryConversion(int x) {

        Stack < Integer > answer = new Stack < Integer > ();
        //Ex2: write your code here
        while(x > 1) {
        	answer.push(x%2);
        	x = x/2;
        }
        answer.push(x%2);
        
        answer.printVertical();
    }

     Stack < T > reverseStack() { 
    	    //Ex3 replace this line with your code
    	    if(list.isEmpty() == true)
        		return null;
    	    Stack < T > rvStack = new Stack < T > ();
    	    
    	    int i = 0;
    	    while(i < list.size) {
    	    	rvStack.push(list.getElementAtIndex(i));
    	    	i++;
    	    }
    	    return rvStack;
    	   
    	    
    	    
    	    
       
        
    }
    static boolean isPalindrome(String word) { 
    	//Ex4 : write your code here
    	//Ex.4 replace this line with your code
    	int size = word.length();
    	
    	for(int i = size-1; i>0;i--) {
    		if(word.charAt(i) != word.charAt(size-1-i))
    			return false;
    	}
    	return true;
    	
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;  
    }

    public static int evalPostfix(String[] input) {
        Stack < Integer > S = new Stack < Integer > ();
        //Ex5 : write your code here
        // replace this line with your code
        for(int i= 0; i< input.length;i++) {
        	String k = input[i];
        	if(isInteger(k) == true) {
        		int j = Integer.parseInt(k);
        		S.push(j);
        	}
        	else {
        		if(k == "+") {
        			int a = S.pop();
        			int b = S.pop();
        			S.push(b+a);
        		}
        		else if(k == "-") {
        			int a = S.pop();
        			int b = S.pop();
        			S.push(b-a);
        		}
        		else if(k == "*") {
        			int a = S.pop();
        			int b = S.pop();
        			S.push(b*a);
        		}
        		else if(k == "%") {
        			int a = S.pop();
        			int b = S.pop();
        			S.push(b%a);
        		}	
        		else {
        			int a = S.pop();
        			int b = S.pop();
        			S.push(b/a);
        		}
        			
        	}
        	
        }
        
        if(S.isEmpty() == true)
        	return 0; 
        return S.pop();
    }
}
