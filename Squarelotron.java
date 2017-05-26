package squarelotron;

class Squarelotron implements SquarelotronMethods {
	public int[][] squarelotron; //initiates instance variable 2D array squarelotron	
	public int size; //initiates instance variable size
	
	/*
	 * constructor that creates a squarelotron based on integer n, creates nxn matrix,
	 * numbers increase sequentially
	 */
	
	public Squarelotron(int n){
		//defines size as n
		size = n;
		//assigns the 2D array/matrix as n x n
		this.squarelotron = new int[n][n];
		//loops from the 0 index to the last index in the rows
		for(int i = 1; i <= size; i++){
			//loops through each row by defining the length of the row as the max length defined by n
			for(int j = 0; j < n; j++){
				//fills in the matrix from 1 to the n squared
				squarelotron[i-1][j] = (i*size)-size+j+1;
			
		}
		}
	}

	
	public Squarelotron(int[] array){
		//gets length of array
		int n = array.length;
		//converts the size to a double
		double size2 = (double) n;
		//finds the square root of the length and converts it to an integer, n
		size = (int) Math.sqrt(size2);
		//assigns squarelotron as an nxn matrix
		this.squarelotron = new int[size][size];
		//sets c to track position in the array starting at 0
		int c=0;
		//loops from 0 to the sqrt of the array to define the rows
		for(int i = 0; i < size; i++){
			//loops from 0 to the sqrt of the array to define the columns
			for(int j = 0; j < size; j++){
				//sets the squarelotrons position in sequential values of the array
				this.squarelotron[i][j] = array[c];
				c=c+1;
			}
			
			//int newmatrix[][] = {{array[i],2,3,4},{1,2,3,4}};
		}
		}
	
	public static Squarelotron makeSquarelotron(int[] array){
		//assigns the local variable check to hold a boolean to make sure the input is correct
		boolean check = true;
		int size = array.length;
		//converts the size to a double
		double size2 = (double) size;
		//finds the square root of the length and converts it to an integer, n
		int n = (int) Math.sqrt(size2);
		//checks to make sure that the input array is a perfect square
		if (size/n == n){
			check = true;
		}
		else{
			check = false;
		}
		//checks to make sure that each element within the array is between 0 and 99
		for(int i : array){
			if(i>-1 && i<100){
				check = true;
			}
			else{
				check = false;
			}
		}
		if (check ==true){
			Squarelotron newSquarelotron = new Squarelotron(array);
			return newSquarelotron;
		}
		//throws a bad array comment if one of the conditions is violated
		else{
			throw new IllegalArgumentException("bad array provided");
		}

	}
	@Override
	public int[] numbers() {
		//finds size of the squareletron;
		int length = squarelotron.length;
		//sets the first count to 0
		int count = 0;
		//loops through each outer and then inner variable in the squarelotron and records a count for each
		for(int i = 0; i < length; i++){
			for(int j = 0; j < squarelotron[i].length; j++){
				count = count +1;
			}
		}
		//sets count2 as zero, this will do the same thing as the original count but use it as an index marker for the array
		int count2 = 0;
		//defines a new array having the length of the total number of variables
		int[] array = new int[count];
		//loops through the squarelotron and stores each variable in the array
		for(int a = 0; a < length; a++){
			for(int j = 0; j < squarelotron[a].length; j++){
				int d = squarelotron[a][j];
				array[count2]=d;
				count2 = count2 + 1;
			}
		}
		return array;
	}

	@Override
	/*
	 * 	This method performs the Upside-Down Flip of the squarelotron, as described above,
		and returns the new squarelotron. The original squarelotron should not be modified
		(we will check for this).(non-Javadoc)
	 * @see squarelotron.SquarelotronMethods#upsideDownFlip(int)
	 */
	public Squarelotron upsideDownFlip(int ring) {
		//calls numbers to create an array from the input squarelotron
		int[] array = numbers();
		//converts the array into a new Squarelotron
		Squarelotron copySquarelotron = makeSquarelotron(array);
		//copies the 2D array associated with the Squarelotron 
		int[][] newSquarelotron = copySquarelotron.squarelotron;
		//finds length of squarelotron and takes the square root
		int length = array.length;
		double sqrtLength = Math.sqrt(length);
		int size =(int) sqrtLength;
		//this loop takes the first and last rows and flips their numbers
		//starts at the ring-1 [so for ring 1, this is [0], for ring 2 [1], etc.] goes until j = the length of current row minus the ring
		//therefore if the ring is one and the current row is 0, it finds the length of [0] and then subtracts one; for example
		//if the squarelotron is a 5x5 with input of ring 1 the starting point would be 0 and ending point of j would be 4, advances by 1
		for(int j = ring-1; j <= newSquarelotron[ring-1].length - ring; j++){
			//assigns number to the first row and first index so if the ring is 1, [0][0] and then iterates
			//the second iteration would be [0][1], the third [0][2], etc. For example if it is the second ring: first iteration 
			//[1][1], second->[1][2]
			int number = newSquarelotron[ring-1][j];
			//selects example: r 1 [0][0] and sets it equal to (if 5x5) [4][0], second iteration, [4][1]
			newSquarelotron[ring-1][j]=newSquarelotron[size-ring][j];
			//sets the [4][0] to [0][0] for the first iteration
			newSquarelotron[size-ring][j] = number;
		}
		
		//the following method flips the non-1st and last parts of the rings needs to only go half way
		//example size 7x7, ring 1; i = 1 ends at 7-1=5/2 =2 or for 8x8: ring1 starts at i=1 ends at 8-2=6/2=3
		for(int i = ring; i <=(size-2)/2; i++){
			//left side
			//using example 7x7: 1st iteration -> [1][0], i=2, 2nd iteration [2][0] 
			int numberLft = newSquarelotron[i][ring-1];
			//example: 1st iteration ->[1][0] = [5][0], 2nd iteration -> [2][0]=[4][0], 3rd->[3][0]=[3][0] (wouldnt happen in 7x7)
			//example 8x8 ring 1: 1st->[1][0]=[6][0], [2][0]=[5][0],[3][0]=[4][0]; [i ends at 3]
			newSquarelotron[i][ring-1] = newSquarelotron[size-i-ring][ring-1];
			//example:1st iteration ->[5][0]=[1][0], second[4][0]=[2],no third
			newSquarelotron[size-ring-i][ring-1] = numberLft;
			//right side
			//7x7/ring=1: 1st iteration [1][6],2nd:[2][6]
			int numberRt = newSquarelotron[i][size-ring];
			newSquarelotron[i][size-ring] = newSquarelotron[size-i-ring][size-ring];
			//1st:7-1-1=[5][6]=[1][6]
			newSquarelotron[size-i-ring][size-ring] = numberRt;
		}
		//outputs the new Squarelotron with the new 2D array
		copySquarelotron.squarelotron = newSquarelotron;
		return copySquarelotron;
		
	}

	@Override
	public Squarelotron leftRightFlip(int ring) {
		//calls numbers to create an array from the input squarelotron
		int[] array = numbers();
		//converts the array into a new Squarelotron
		Squarelotron copySquarelotron = makeSquarelotron(array);
		int[][] newSquarelotron = copySquarelotron.squarelotron;
		//finds length of squarelotron and takes the square root
		int length = array.length;
		double sqrtLength = Math.sqrt(length);
		int size =(int) sqrtLength;

		//starts at the ring-1 [so for ring 1, this is [0], for ring 2 [1], etc.] goes until j = the length of current row minus the ring
		//therefore if the ring is one and the current row is 0, it finds the length of [0] and then subtracts one; for example
		//if the squarelotron is a 5x5 with input of ring 1 the starting point would be 0 and ending point of j would be 4, advances by 1
		for(int j = 0; j <= size-2*ring; j++){
			//assigns number to the first row and first index so if the ring is 1, [0][0] and then iterates
			//the second iteration would be [0][1], the third [0][2], etc. For example if it is the second ring: first iteration 
			//[1][1], second->[1][2]
			int number = newSquarelotron[ring-1+j][ring-1];
			//matrix = 3x3, size = 3, index max =2, [0][0]->[0]
			newSquarelotron[ring-1+j][ring-1]=newSquarelotron[ring-1+j][size-ring];
			//sets the [0][4] to [0][0] for the first iteration
			newSquarelotron[ring-1+j][size-ring] = number;
		}
		//the following method flips the non-1st and last parts of the rings needs to only go half way
				//example size 7x7, ring 1; i = 1 ends 7-2=5 or for 8x8: ring1 starts at i=1 ends at 8-2=6 or for 5x5 5-2=3
		for(int i = 0; i <=(size-2*ring); i++){
			//left side
			//using example 5x5: 1st iteration -> [1][0], i=2, 2nd iteration [2][0] , 3rd:i=3 [3][0]
			int numberLft = this.squarelotron[ring-1][ring+i-1];
			//for 5x5:[1][0]=[1][4]. [2][0]=[2][4], i=3: [3][0]=[3][4]
			newSquarelotron[ring-1][ring+i-1] = this.squarelotron[ring-1][size-ring-i];
			//example:1st iteration ->[1][4]=[1][0], 2nd:[2][4]=
			newSquarelotron[ring-1][size-ring-i] = numberLft;
			int numberBot = this.squarelotron[size-ring][ring+i-1];
			newSquarelotron[size-ring][ring+i-1]= this.squarelotron[size-ring][size-ring-i];
			newSquarelotron[size-ring][size-ring-i] = numberBot;
				}
		
		
		copySquarelotron.squarelotron = newSquarelotron;
		return copySquarelotron;
	}

	@Override
	public Squarelotron inverseDiagonalFlip(int ring) {
		//calls numbers to create an array from the input squarelotron
		int[] array = numbers();
		//converts the array into a new Squarelotron
		Squarelotron copySquarelotron = makeSquarelotron(array);
		int[][] newSquarelotron = copySquarelotron.squarelotron;
		//finds length of squarelotron and takes the square root
		int length = array.length;
		double sqrtLength = Math.sqrt(length);
		int size =(int) sqrtLength;
		//loops through and flips with the inverse diagonal
		for(int i = ring-1; i <= (size-ring); i++){
			int numberRt = newSquarelotron[ring-1][i];
			newSquarelotron[ring-1][i] = newSquarelotron[size-i-1][size-ring];
			newSquarelotron[size-i-1][size-ring]=numberRt;
		}
		for(int i = ring; i <= (size-ring); i++){
			int numberLft = newSquarelotron[i][ring-1];
			newSquarelotron[i][ring-1] = newSquarelotron[size-ring][size-i-1];
			newSquarelotron[size-ring][size-i-1]=numberLft;
		}
		copySquarelotron.squarelotron = newSquarelotron;
		return copySquarelotron;
	}

	@Override
	public Squarelotron mainDiagonalFlip(int ring) {
		//calls numbers to create an array from the input squarelotron
		int[] array = numbers();
		//converts the array into a new Squarelotron
		Squarelotron copySquarelotron = makeSquarelotron(array);
		int[][] newSquarelotron = copySquarelotron.squarelotron;
		//finds length of squarelotron and takes the square root
		int length = array.length;
		double sqrtLength = Math.sqrt(length);
		int size =(int) sqrtLength;
		//loops through and flips along the main diagonal
		for(int i = ring; i <= (size-ring); i++){
			int numberRt = newSquarelotron[ring-1][i];
			newSquarelotron[ring-1][i] = newSquarelotron[i][ring-1];
			newSquarelotron[i][ring-1]=numberRt;
			int numberLft = newSquarelotron[i][size-ring];
			newSquarelotron[i][size-ring]= newSquarelotron[size-ring][i];
			newSquarelotron[size-ring][i]=numberLft;
		}
		copySquarelotron.squarelotron = newSquarelotron;
		return copySquarelotron;
	}

	@Override
	public Squarelotron sideFlip(String side) {
		//calls numbers to create an array from the input squarelotron
		int[] array = numbers();
		//converts the array into a new Squarelotron
		Squarelotron copySquarelotron = makeSquarelotron(array);
		int[][] newSquarelotron = copySquarelotron.squarelotron;
		//finds length of squarelotron and takes the square root
		int length = array.length;
		double sqrtLength = Math.sqrt(length);
		int size =(int) sqrtLength;
		//the following check for each input and then flip accordingly
		//top flips the top two rows
		if(side == "top"){
			for(int i = 0; i<= (size-1); i++){
				int number= newSquarelotron[0][i];
				newSquarelotron[0][i] = newSquarelotron[1][i];
				newSquarelotron[1][i]=number;
			}

		}
		//bottom flips the bottom two rows
		else if(side == "bottom"){
			for(int i = 0; i<= (size-1); i++){
				int number= newSquarelotron[size-1][i];
				newSquarelotron[size-1][i] = newSquarelotron[size-2][i];
				newSquarelotron[size-2][i]=number;
			}	

		}
		//left flips the left two rows
		else if(side == "left"){
			for(int i = 0; i<= (size-1); i++){
				int number= newSquarelotron[i][0]	;
				newSquarelotron[i][0] = newSquarelotron[i][1];
				newSquarelotron[i][1]=number;
			}

		}
		//right flips the right two rows
		else if(side == "right"){
			for(int i = 0; i<= (size-1); i++){
				int number= newSquarelotron[i][size-1];
				newSquarelotron[i][size-1] = newSquarelotron[i][size-2];
				newSquarelotron[i][size-2]=number;
			}	

		}

		copySquarelotron.squarelotron = newSquarelotron;
		return copySquarelotron;
	}

	@Override
	public void rotateRight(int numberOfTurns) {
		//calls numbers to create an array from the input squarelotron
		int[] array = numbers();
		//converts the array into a new Squarelotron
		Squarelotron copySquarelotron = makeSquarelotron(array);
		int[][] arrayCopy = copySquarelotron.squarelotron;
		for(int i = 0; i <=size-1; i++){
			for(int j = 0; j<=size-1; j++){
				//checks for each rotation to account for repeats and negatives and rotates accordingly
				if((numberOfTurns-1)%4==0){
					arrayCopy[i][j]=this.squarelotron[size-j-1][i];
				}
				else if((numberOfTurns-2)%4==0){
					arrayCopy[i][j]=this.squarelotron[size-i-1][size-j-1];
					
				}
				else if((numberOfTurns-3)%4==0){
					arrayCopy[i][j]=this.squarelotron[j][size-i-1];	
				}	
			}
		}
		this.squarelotron = arrayCopy;
	}

	
	@Override
	public boolean equals (Object object){
		Squarelotron providedSq = (Squarelotron) object;
		object.getClass();
		boolean holder = false;
		if (providedSq.squarelotron.length == this.squarelotron.length){
			for(int i = 0; i <providedSq.squarelotron.length; i++) {
				for(int j = 0; j <providedSq.squarelotron[0].length; j++){
						if (providedSq.squarelotron[i][j] == this.squarelotron[i][j]){
							holder = true;
							}
			}
				}
		}
		if (holder == false && providedSq.squarelotron.length == this.squarelotron.length){
			providedSq.rotateRight(1);
			for(int i = 0; i <providedSq.squarelotron.length; i++) {
				for(int j = 0; j <providedSq.squarelotron[0].length; j++){
						if (providedSq.squarelotron[i][j] == this.squarelotron[i][j]){
							holder = true;
							}
			}
				}
		}
		if (holder == false && providedSq.squarelotron.length == this.squarelotron.length){
			providedSq.rotateRight(2);
			for(int i = 0; i <providedSq.squarelotron.length; i++) {
				for(int j = 0; j <providedSq.squarelotron[0].length; j++){
						if (providedSq.squarelotron[i][j] == this.squarelotron[i][j]){
							holder = true;
							}
			}
				}
		}
		if (holder == false && providedSq.squarelotron.length == this.squarelotron.length){
			providedSq.rotateRight(3);
			for(int i = 0; i <providedSq.squarelotron.length; i++) {
				for(int j = 0; j <providedSq.squarelotron[0].length; j++){
						if (providedSq.squarelotron[i][j] == this.squarelotron[i][j]){
							holder = true;
							}
			}
				}
		}
		
		
		return holder;
	}
	


	@Override
	public String toString(){
		String stringOut = "";
		//creates an output with tab characters and new lines
		for(int i = 0; i <=size-1; i++){
			String stringValue = "";
			for(int j = 0; j<=size-1; j++){
				int value = this.squarelotron[i][j];
				String value1 = Integer.toString(value);
				stringValue = stringValue + value1 +"\t";			
			
		
			}
			stringOut = stringOut+stringValue + "\n";
			}
		
		return stringOut;
	}


	public static void main(String[] args) {
		//tests outside of range
		Squarelotron test = makeSquarelotron(new int[] {0,1,2,101});
		System.out.println(test.toString());
		//tests one that should be created
		Squarelotron test2 = makeSquarelotron(new int[] {0,1,2,3});
		System.out.println(test2.toString());
		//tests for too long
		Squarelotron test3 = makeSquarelotron(new int[] {0,1,2,3,5});
		System.out.println(test3.toString());
		
	}
}
