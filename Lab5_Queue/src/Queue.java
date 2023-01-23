public class Queue<T> {
	SList<T> list = new SList<T>();

	Queue() {
	}

	void enqueue(T element) {
	//Exercise 1a
		list.addLast(element);
	}

	T dequeue() {
	//Exercise 1b
		return list.removeFirst();
	}

	T queuefront() {
      //Exercise 1c
		return list.first.element;
	}

	T queuerear() {
	  //Exercise 1d
		return list.last.element;
	}
     boolean isEmpty() {
		return list.isEmpty(); 
	}

     // Copy this Queue (itself) to another Queue
	Queue<T> copyQueue() 
	{
		//Exercise 2
		//replace this line of code with yours
		if(isEmpty() == true)
	           return null;
		Queue<T> temp = new Queue<T>();
		int i = 0;
		while(i < list.size) {
			temp.enqueue(list.getElementAtIndex(i));
	    	i++;
	    }
		return temp;
	}

	// Check if this Queue(itself) has the same content as Q2 
	boolean isIdentical(Queue<T> Q2) 
	{
		//Exercise 3
		//replace this line of code with yours
		if(list.size != Q2.list.size)
          return false; 
		
		for(int i = 0; i<list.size;i++) {
			if(list.getElementAtIndex(i) != Q2.list.getElementAtIndex(i))
				return false;
		}
		return true;
	}


	void printHorizontal() {
		Node<T> walker = list.first;
		for (int i = 0; i < list.size; i++) {
			System.out.print(walker.element + " ");
			walker = walker.next;
		}
		System.out.println();
	}

}