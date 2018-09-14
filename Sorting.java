
public class Sorting<T> {
	
	/**
	 * 
	 * @author Allen Tran
	 * @version July 01 2018
	 *
	 */

	
	public int pass = 0;
	public int cmp = 0;
	public int exch = 0;
	public int k = 0;
	public int[][] twoDTable = new int[10][4];
	public long tE;
	
	
	public void BubbleSort(LinkedList<T> list){

		LinkedNode<T> last = null;
		LinkedNode<T> current = list.getHead();
		LinkedNode<T> runner = current.getNext();
		int row = 0;
		int col = 0;
		int twoDTable2[][] = new int[10][4];

		int n = 0;
		int j = list.getSize();
		
		
		long startTime = System.currentTimeMillis();
		
		//CStop when we get to end of the list
		while(n != j){
			
		
					
		//Check is runner is null
		while(runner != null){
			cmp++;
			//If there is no prev node set which means we are starting at the head
			if(last == null){
				
				
				// compare the two nodes
				
				if(current.compareTo(runner.getData()) > 0){
				exch++;
				current.setNext(runner.getNext());
				runner.setNext(current);
				list.setHead(runner);
				list.getHead().setNext(current);
				runner = current.getNext();
				last = list.getHead();
				
				
				}else{
					
					// set the runner to the right position
					
					current = current.getNext();
					runner = runner.getNext();
					last = list.getHead();
				}
				
				}else{
					
					// compare the two nodes
					
					if(current.compareTo(runner.getData()) > 0){
						exch++;
						current.setNext(runner.getNext());
						runner.setNext(current);
						last.setNext(runner);
						runner = current.getNext();				
						last = last.getNext();

						
						
					}else{
						
						// set the runner to the right position
						
						current = current.getNext();
						runner = runner.getNext();
						last = last.getNext();
						
						
					}
					
				}
			
				}	
		
		last = null;
		current = list.getHead();
		runner = current.getNext();
		n++;
		pass++;

		}
		
		long time = System.currentTimeMillis() - startTime;
		

		tE = time;
		
		twoDTable2[row][col++] = pass;
		twoDTable2[row][col++] = cmp;
		twoDTable2[row][col++] = exch;
	
		addInto2DTable(twoDTable2);
	}

public void ShellSort(LinkedList<T> list){
		
		LinkedNode<T> current;
		LinkedNode<T> runner;
        LinkedNode<T> prevCurrent;
        LinkedNode<T> prevRunner;
        int maxrow = 30;
        int[][] twoDTable2 = new int[maxrow][4];
        int col = 0;
        int row = 0;  
        
        // calculate gap size
        int n = list.getSize() / 3;
		int gapSize = 1;
		
		long startTime = System.currentTimeMillis();
		
        while (gapSize < n) gapSize = 3*gapSize + 1;
        
        
		
        // perform shell sort while gap size is bigger than 0
        while (gapSize > 0){     
        	
        	k = gapSize;

            boolean hasExchanged = true;
            
            // reset list pointers to the beginning
            current = list.getHead();
            runner = list.getHead();
            prevCurrent = null;
            prevRunner = null;

            // set the runner to the right position
            for (int i = 0; i < gapSize; i++) {
                prevRunner = runner;
                runner = runner.getNext();
            }

            // go through the list while there are elements to sort for this gap
            while (hasExchanged) {
                hasExchanged = false;

                while (runner != null) {


                    // compare the two nodes
                	cmp++;
                    if (current.compareTo(runner.getData()) > 0) {
                    	exch++;
                
                    	//System.out.println("1: " + list.printList());
                        
                    	// exchange the nodes
                    	if(gapSize == 1) {
                    		// for the case when we're going node by node then we need to update nodes slightly differently
                    		// than the other case
                    		LinkedNode<T> tmp = runner.getNext();
	                    	runner.setNext(current);
	                        if(prevCurrent != null)
	                        	prevCurrent.setNext(runner);
	                        else
	                        	list.setHead(runner);
	                        
	                        current.setNext(tmp);
	                        prevRunner = runner;
                    	
                    	}else{
	                    
                    		prevRunner.setNext(runner.getNext());
	                        runner.setNext(current.getNext());
	                        if(prevCurrent != null) prevCurrent.setNext(runner);
	                        else { list.setHead(runner); prevCurrent = list.getHead(); }
	                        current.setNext(prevRunner.getNext());
	                        prevRunner.setNext(current);
                    	}
                    	//System.out.println("2: " + list.printList());

                        hasExchanged = true;
                    }

                    // move nodes to the next positions
                	if(prevCurrent != null)
                		prevCurrent = prevCurrent.getNext();
                	else
                		prevCurrent = list.getHead();
                    
                	if(prevRunner != null)
                    	prevRunner = prevRunner.getNext();
                    else
                    	prevRunner = list.getHead();
                    
                    current = prevCurrent.getNext();
                    runner = prevRunner.getNext();
                }
                
                
                
                // reset list pointers to the beginning
                current = list.getHead();
                runner = list.getHead();
                prevCurrent = null;
                prevRunner = null;
                pass++;

                // set the runner to the right position
                for (int i = 0; i < gapSize; i++) {
                    prevRunner = runner;
                    runner = runner.getNext();
                }
                
                
            }

            // when nodes are all sorted for the gap then we update gap size and do it again
            
            col = 0;

    		twoDTable2[row][col++] = k;
    		twoDTable2[row][col++] = pass;
    		twoDTable2[row][col++] = cmp;
    		twoDTable2[row][col++] = exch;
    		
    		row++;
    		
            gapSize = gapSize / 3;

        }
        
		long time = System.currentTimeMillis() - startTime;
		

		tE = time;

        
		addInto2DTable(twoDTable2);
        
     
	}

public void addInto2DTable(int[][] twoDTable2){
	
		twoDTable = twoDTable2;

}

public StringBuilder resultBubbleSort(LinkedList<T> list){
	
	BubbleSort(list);
	
	StringBuilder sb = new StringBuilder();
	
	
	sb.append("\n");
	sb.append("BUBBLESORT\n");
	sb.append("Random" + list.getSize() + "\n");
	sb.append("It took:  " + tE/1e3 + " seconds\n");
	sb.append("pass     cmp     exch\n");
	sb.append("--------------------\n");


		for(int j = 0; j < 4; j++){
			
			sb.append(twoDTable[0][j] + "     ");

		}
		
		sb.append("\n");
	
	sb.append("--------------------\n");


	return sb;

	
}

public StringBuilder resultShellSort(LinkedList<T> list){
	
	ShellSort(list);
	
	int totalK = 0;
	int totalPass = 0;
	int totalCmp = 0;
	int totalExch = 0;
	
	StringBuilder sb = new StringBuilder();
	sb.append("\n");
	sb.append("SHELLSORT\n");
	sb.append("Random" + list.getSize() + "\n");
	sb.append("It took:  " + tE/1e3 + " seconds\n");
	sb.append("k     pass     cmp     exch\n");
	sb.append("--------------------\n");

	for(int i = 0; i < 30; i++){
		for(int j = 0; j < 4; j++){
			
			sb.append(twoDTable[i][j] + "     ");
			
			if(j == 0){
				totalK += twoDTable[i][j];
//				System.out.println(totalK);
				
			}
			else if(j == 1){
				
				totalPass += twoDTable[i][j];
//				System.out.println(totalPass);
			}
			else if(j == 2){
				totalCmp += twoDTable[i][j];
//				System.out.println(totalCmp);
				
			}
			else if(j == 3){
				totalExch += twoDTable[i][j];
		
	
			}
			
			

		}
		
		sb.append("\n");
	
	}
	
	sb.append("--------------------\n");
	sb.append(totalK +" " + totalPass + " " + totalCmp + " " + totalExch + "\n");

	return sb;
	

}

	

}
