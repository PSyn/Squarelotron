package squarelotron;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSquarelotronInt() {
		//creates new squarelotron that is a 2x2 matrix and makes sure the values are correct (even case 1)
		Squarelotron newSquarelotron = new Squarelotron(2);
		assertArrayEquals(newSquarelotron.squarelotron, new int[][]{{1,2},{3,4}});
		//creates new squarelotron that is a 4x4 matrix (even case 2
		Squarelotron newSquarelotron1 = new Squarelotron(4);
		assertArrayEquals(newSquarelotron1.squarelotron, new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
		//creates new squarelotron that is a 1x1 matrix and makes sure the values are correct (odd case 1)
		Squarelotron newSquarelotron2 = new Squarelotron(1);
		assertArrayEquals(newSquarelotron2.squarelotron, new int[][]{{1}});
		//creates new squarelotron that is a 1x1 matrix and makes sure the values are correct (odd case 1)
		Squarelotron newSquarelotron3 = new Squarelotron(3);
		assertArrayEquals(newSquarelotron3.squarelotron, new int[][]{{1,2,3},{4,5,6},{7,8,9}});
	}

	@Test
	public void testSquarelotronIntArray() {
		//test 2x2
		int[] array = {1,2,3,4};
		Squarelotron newSquarelotron = new Squarelotron(array);
		assertArrayEquals(newSquarelotron.squarelotron, new int[][]{{1,2},{3,4}});
		//test 3x3
		Squarelotron newSquarelotron1 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8});
		assertArrayEquals(newSquarelotron1.squarelotron, new int[][]{{0,1,2},{3,4,5},{6,7,8}});
		//test 1x1
		Squarelotron newSquarelotron2 = new Squarelotron(new int[] {5});
		assertArrayEquals(newSquarelotron2.squarelotron, new int[][]{{5}});
		//test 6x6
		Squarelotron newSquarelotron3 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35});
		assertArrayEquals(newSquarelotron3.squarelotron, new int[][]{{0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,14,15,16,17},{18,19,20,21,22,23},{24,25,26,27,28,29},{30,31,32,33,34,35}});
	}


	@Test
	public void testNumbers() {
		//test 3x3
		Squarelotron newSquarelotron = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8});
		assertArrayEquals(newSquarelotron.numbers(), new int[] {0,1,2,3,4,5,6,7,8});
		//test4x4
		Squarelotron newSquarelotron1 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
		assertArrayEquals(newSquarelotron1.numbers(), new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
		//test 1x1
		Squarelotron newSquarelotron2 = new Squarelotron(new int[] {5});
		assertArrayEquals(newSquarelotron2.numbers(), new int[] {5});
	}

	@Test
	public void testUpsideDownFlip() {
		//creates new 2x2 squarelotron
		Squarelotron newSquarelotron = new Squarelotron(new int[] {1,2,3,4});
		//assigns origMatrix to the 2x2 squarelotron
		int[][] origMatrix = {{1,2},{3,4}};
		//creates a new squarelotron called flipped squarelotron and checks the new matrix, ring 1
		Squarelotron flippedSquarelotron = newSquarelotron.upsideDownFlip(1);
		int[][] newMatrix = {{3,4},{1,2}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron.squarelotron, origMatrix);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron.squarelotron, newMatrix);
		
		//repeats above to test a 3x3 matrix, ring 1
		Squarelotron newSquarelotron1 = new Squarelotron(new int[] {1,2,3,4,5,6,7,8,9});
		int[][] origMatrix1 = {{1,2,3},{4,5,6},{7,8,9}};
		Squarelotron flippedSquarelotron1 = newSquarelotron1.upsideDownFlip(1);
		int[][] newMatrix1 = {{7,8,9},{4,5,6},{1,2,3}};
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		assertArrayEquals(flippedSquarelotron1.squarelotron, newMatrix1);
		//tests ring 2 for 3x3
		Squarelotron flippedSquarelotron2 = newSquarelotron1.upsideDownFlip(2);
		int[][] newMatrix2 = {{1,2,3},{4,5,6},{7,8,9}};
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		assertArrayEquals(flippedSquarelotron2.squarelotron, newMatrix2);
		
		//repeats above to test a 6x6 matrix, ring 1
		Squarelotron newSquarelotron3 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35});
		int[][] origMatrix3 = {{0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,14,15,16,17},{18,19,20,21,22,23},{24,25,26,27,28,29},{30,31,32,33,34,35}};
		Squarelotron flippedSquarelotron3 = newSquarelotron3.upsideDownFlip(1);
		int[][] newMatrix3 = {{30,31,32,33,34,35},{24,7,8,9,10,29},{18,13,14,15,16,23},{12,19,20,21,22,17},{6,25,26,27,28,11},{0,1,2,3,4,5}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron3.squarelotron, newMatrix3);
		//tests ring 2 for 6x6
		Squarelotron flippedSquarelotron4 = newSquarelotron3.upsideDownFlip(2);
		int[][] newMatrix4 = {{0,1,2,3,4,5},{6,25,26,27,28,11},{12,13,14,15,16,17},{18,19,20,21,22,23},{24,7,8,9,10,29},{30,31,32,33,34,35}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron4.squarelotron, newMatrix4);
		//tests ring 3 for 6x6
		Squarelotron flippedSquarelotron5 = newSquarelotron3.upsideDownFlip(3);
		int[][] newMatrix5 = {{0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,20,21,16,17},{18,19,14,15,22,23},{24,25,26,27,28,29},{30,31,32,33,34,35}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron5.squarelotron, newMatrix5);
	}

	@Test
	public void testLeftRightFlip() {
		//creates new 2x2 squarelotron
		Squarelotron newSquarelotron = new Squarelotron(new int[] {1,2,3,4});
		//assigns origMatrix to the 2x2 squarelotron
		int[][] origMatrix = {{1,2},{3,4}};
		//creates a new squarelotron called flipped squarelotron and checks the new matrix, ring 1
		Squarelotron flippedSquarelotron = newSquarelotron.leftRightFlip(1);
		int[][] newMatrix = {{2,1},{4,3}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron.squarelotron, origMatrix);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron.squarelotron, newMatrix);
		
		//repeats above to test a 3x3 matrix, ring 1
		Squarelotron newSquarelotron1 = new Squarelotron(new int[] {1,2,3,4,5,6,7,8,9});
		int[][] origMatrix1 = {{1,2,3},{4,5,6},{7,8,9}};
		Squarelotron flippedSquarelotron1 = newSquarelotron1.leftRightFlip(1);
		int[][] newMatrix1 = {{3,2,1},{6,5,4},{9,8,7}};
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		assertArrayEquals(flippedSquarelotron1.squarelotron, newMatrix1);
		//tests ring 2 for 3x3
		Squarelotron flippedSquarelotron2 = newSquarelotron1.leftRightFlip(2);
		int[][] newMatrix2 = {{1,2,3},{4,5,6},{7,8,9}};
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		assertArrayEquals(flippedSquarelotron2.squarelotron, newMatrix2);
		
		//repeats above to test a 6x6 matrix, ring 1
		Squarelotron newSquarelotron3 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35});
		int[][] origMatrix3 = {{0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,14,15,16,17},{18,19,20,21,22,23},{24,25,26,27,28,29},{30,31,32,33,34,35}};
		Squarelotron flippedSquarelotron3 = newSquarelotron3.leftRightFlip(1);
		int[][] newMatrix3 = {{5,4,3,2,1,0},{11,7,8,9,10,6},{17,13,14,15,16,12},{23,19,20,21,22,18},{29,25,26,27,28,24},{35,34,33,32,31,30}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron3.squarelotron, newMatrix3);
		//tests ring 2 for 6x6
		Squarelotron flippedSquarelotron4 = newSquarelotron3.leftRightFlip(2);
		int[][] newMatrix4 = {{0,1,2,3,4,5},{6,10,9,8,7,11},{12,16,14,15,13,17},{18,22,20,21,19,23},{24,28,27,26,25,29},{30,31,32,33,34,35}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron4.squarelotron, newMatrix4);
		//tests ring 3 for 6x6
		Squarelotron flippedSquarelotron5 = newSquarelotron3.leftRightFlip(3);
		int[][] newMatrix5 = {{0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,15,14,16,17},{18,19,21,20,22,23},{24,25,26,27,28,29},{30,31,32,33,34,35}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron5.squarelotron, newMatrix5);
		
	}

	@Test
	public void testInverseDiagonalFlip() {
		//creates new 2x2 squarelotron
		Squarelotron newSquarelotron = new Squarelotron(new int[] {1,2,3,4});
		//assigns origMatrix to the 2x2 squarelotron
		int[][] origMatrix = {{1,2},{3,4}};
		//creates a new squarelotron called flipped squarelotron and checks the new matrix, ring 1
		Squarelotron flippedSquarelotron = newSquarelotron.inverseDiagonalFlip(1);
		int[][] newMatrix = {{4,2},{3,1}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron.squarelotron, origMatrix);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron.squarelotron, newMatrix);
		
		//repeats above to test a 3x3 matrix, ring 1
		Squarelotron newSquarelotron1 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8});
		int[][] origMatrix1 = {{0,1,2},{3,4,5},{6,7,8}};
		Squarelotron flippedSquarelotron1 = newSquarelotron1.inverseDiagonalFlip(1);
		int[][] newMatrix1 = {{8,5,2},{7,4,1},{6,3,0}};
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		assertArrayEquals(flippedSquarelotron1.squarelotron, newMatrix1);
		//tests ring 2 for 3x3
		Squarelotron flippedSquarelotron2 = newSquarelotron1.inverseDiagonalFlip(2);
		int[][] newMatrix2 = {{0,1,2},{3,4,5},{6,7,8}};
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		assertArrayEquals(flippedSquarelotron2.squarelotron, newMatrix2);
		
		//repeats above to test a 6x6 matrix, ring 1
		Squarelotron newSquarelotron3 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35});
		int[][] origMatrix3 = {{0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,14,15,16,17},{18,19,20,21,22,23},{24,25,26,27,28,29},{30,31,32,33,34,35}};
		Squarelotron flippedSquarelotron3 = newSquarelotron3.inverseDiagonalFlip(1);
		int[][] newMatrix3 = {{35,29,23,17,11,5},{34,7,8,9,10,4},{33,13,14,15,16,3},{32,19,20,21,22,2},{31,25,26,27,28,1},{30,24,18,12,6,0}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron3.squarelotron, newMatrix3);
		//tests ring 2 for 6x6
		Squarelotron flippedSquarelotron4 = newSquarelotron3.inverseDiagonalFlip(2);
		int[][] newMatrix4 = {{0,1,2,3,4,5},{6,28,22,16,10,11},{12,27,14,15,9,17},{18,26,20,21,8,23},{24,25,19,13,7,29},{30,31,32,33,34,35}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron4.squarelotron, newMatrix4);
		//test ring 3 for 6x6
		Squarelotron flippedSquarelotron5 = newSquarelotron3.inverseDiagonalFlip(3);
		int[][] newMatrix5 = {{0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,21,15,16,17},{18,19,20,14,22,23},{24,25,26,27,28,29},{30,31,32,33,34,35}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron5.squarelotron, newMatrix5);
		
	}

	@Test
	public void testMainDiagonalFlip() {
		//creates new 2x2 squarelotron
		Squarelotron newSquarelotron = new Squarelotron(new int[] {1,2,3,4});
		//assigns origMatrix to the 2x2 squarelotron
		int[][] origMatrix = {{1,2},{3,4}};
		//creates a new squarelotron called flipped squarelotron and checks the new matrix, ring 1
		Squarelotron flippedSquarelotron = newSquarelotron.mainDiagonalFlip(1);
		int[][] newMatrix = {{1,3},{2,4}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron.squarelotron, origMatrix);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron.squarelotron, newMatrix);

		//repeats above to test a 3x3 matrix, ring 1
		Squarelotron newSquarelotron1 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8});
		int[][] origMatrix1 = {{0,1,2},{3,4,5},{6,7,8}};
		Squarelotron flippedSquarelotron1 = newSquarelotron1.mainDiagonalFlip(1);
		int[][] newMatrix1 = {{0,3,6},{1,4,7},{2,5,8}};
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		assertArrayEquals(flippedSquarelotron1.squarelotron, newMatrix1);
		//tests ring 2 for 3x3
		Squarelotron flippedSquarelotron2 = newSquarelotron1.mainDiagonalFlip(2);
		int[][] newMatrix2 = {{0,1,2},{3,4,5},{6,7,8}};
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		assertArrayEquals(flippedSquarelotron2.squarelotron, newMatrix2);

		//repeats above to test a 6x6 matrix, ring 1
		Squarelotron newSquarelotron3 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35});
		int[][] origMatrix3 = {{0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,14,15,16,17},{18,19,20,21,22,23},{24,25,26,27,28,29},{30,31,32,33,34,35}};
		Squarelotron flippedSquarelotron3 = newSquarelotron3.mainDiagonalFlip(1);
		int[][] newMatrix3 = {{0, 6 ,12, 18, 24, 30 },{1, 7, 8, 9, 10, 31 },{2, 13, 14, 15, 16, 32 },{3, 19, 20, 21, 22, 33 },{4, 25, 26, 27, 28, 34 },{5, 11, 17, 23, 29, 35 }};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron3.squarelotron, newMatrix3);
		//tests ring 2 for 6x6
		Squarelotron flippedSquarelotron4 = newSquarelotron3.mainDiagonalFlip(2);
		int[][] newMatrix4 = {{0,1,2,3,4,5},{6, 7, 13, 19, 25,11},{12,8, 14, 15, 26,17},{18, 9, 20, 21, 27,23},{24,10, 16, 22, 28,29},{30,31,32,33,34,35}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron4.squarelotron, newMatrix4);
		//test ring 3 for 6x6
		Squarelotron flippedSquarelotron5 = newSquarelotron3.mainDiagonalFlip(3);
		int[][] newMatrix5 = {{0,1,2,3,4,5},{6,7,8,9,10,11},{12,13,14,20,16,17},{18,19,15,21,22,23},{24,25,26,27,28,29},{30,31,32,33,34,35}};
		assertArrayEquals(newSquarelotron3.squarelotron, origMatrix3);
		assertArrayEquals(flippedSquarelotron5.squarelotron, newMatrix5);
	}

	@Test
	public void testSideFlip() {
		//creates new 2x2 squarelotron
		Squarelotron newSquarelotron = new Squarelotron(new int[] {0,1,2,3});
		//assigns origMatrix to the 2x2 squarelotron
		int[][] origMatrix = {{0,1},{2,3}};
		
		
		//creates a new squarelotron called flipped squarelotron and checks the new matrix, top
		Squarelotron flippedSquarelotron = newSquarelotron.sideFlip("top");
		int[][] topMatrix = {{2,3},{0,1}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron.squarelotron, origMatrix);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron.squarelotron, topMatrix);
		
		//creates a new squarelotron called flipped squarelotron and checks the new matrix, top
		Squarelotron flippedSquarelotron1 = newSquarelotron.sideFlip("bottom");
		int[][] bottomMatrix = {{2,3},{0,1}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron.squarelotron, origMatrix);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron1.squarelotron, bottomMatrix);

		//creates a new squarelotron called flipped squarelotron and checks the new matrix, top
		Squarelotron flippedSquarelotron2 = newSquarelotron.sideFlip("left");
		int[][] leftMatrix = {{1,0},{3,2}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron.squarelotron, origMatrix);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron2.squarelotron, leftMatrix);

		//creates a new squarelotron called flipped squarelotron and checks the new matrix, top
		Squarelotron flippedSquarelotron3 = newSquarelotron.sideFlip("right");
		int[][] rightMatrix = {{1,0},{3,2}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron.squarelotron, origMatrix);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron3.squarelotron, rightMatrix);
		
		//creates new 5x5 squarelotron
		Squarelotron newSquarelotron1 = new Squarelotron(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24});
		//assigns origMatrix to the 2x2 squarelotron
		int[][] origMatrix1 = {{0,1,2,3,4},{5,6,7,8,9},{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24}};


		//creates a new squarelotron called flipped squarelotron and checks the new matrix, top
		Squarelotron flippedSquarelotron4 = newSquarelotron1.sideFlip("top");
		int[][] topMatrix1 = {{5,6,7,8,9},{0,1,2,3,4},{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron4.squarelotron, topMatrix1);

		//creates a new squarelotron called flipped squarelotron and checks the new matrix, top
		Squarelotron flippedSquarelotron5 = newSquarelotron1.sideFlip("bottom");
		int[][] bottomMatrix1 = {{0,1,2,3,4},{5,6,7,8,9},{10,11,12,13,14},{20,21,22,23,24},{15,16,17,18,19}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron5.squarelotron, bottomMatrix1);

		//creates a new squarelotron called flipped squarelotron and checks the new matrix, top
		Squarelotron flippedSquarelotron6 = newSquarelotron1.sideFlip("left");
		int[][] leftMatrix1 = {{1,0,2,3,4},{6,5,7,8,9},{11,10,12,13,14},{16,15,17,18,19},{21,20,22,23,24}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron6.squarelotron, leftMatrix1);

		//creates a new squarelotron called flipped squarelotron and checks the new matrix, top
		Squarelotron flippedSquarelotron7 = newSquarelotron1.sideFlip("right");
		int[][] rightMatrix1 = {{0,1,2,4,3},{5,6,7,9,8},{10,11,12,14,13},{15,16,17,19,18},{20,21,22,24,23}};
		//makes sure that the original squarelotron matrix has not changed
		assertArrayEquals(newSquarelotron1.squarelotron, origMatrix1);
		//makes sure that the squarelotron has accurately flipped
		assertArrayEquals(flippedSquarelotron7.squarelotron, rightMatrix1);
	}

	@Test
	public void testRotateRight() {
		//creates new 2x2 squarelotron
		Squarelotron newSquarelotron = new Squarelotron(new int[] {0,1,2,3});
		//test case for no rotation, as well as negative and positive rotations of 4
		int[][] arrayN = {{0,1},{2,3}};
		newSquarelotron.rotateRight(0);
		assertArrayEquals(newSquarelotron.squarelotron, arrayN);
		newSquarelotron.rotateRight(4);
		assertArrayEquals(newSquarelotron.squarelotron, arrayN);
		newSquarelotron.rotateRight(-4);
		assertArrayEquals(newSquarelotron.squarelotron, arrayN);
		//test case for 1 rotation, as well as positive and negative 
		newSquarelotron.rotateRight(1);
		int[][] array = {{2,0},{3,1}};
		assertArrayEquals(newSquarelotron.squarelotron, array);
		Squarelotron newSquarelotron1 = new Squarelotron(new int[] {0,1,2,3});
		newSquarelotron1.rotateRight(5);
		assertArrayEquals(newSquarelotron1.squarelotron, array);
		Squarelotron newSquarelotron2 = new Squarelotron(new int[] {0,1,2,3});
		newSquarelotron2.rotateRight(-3);
		assertArrayEquals(newSquarelotron2.squarelotron, array);
		//test case for 2 rotations as well as positive and negative
		Squarelotron newSquarelotronA = new Squarelotron(new int[] {0,1,2,3});
		newSquarelotronA.rotateRight(2);
		int[][] array1 = {{3,2},{1,0}};
		assertArrayEquals(newSquarelotronA.squarelotron, array1);
		Squarelotron newSquarelotron3 = new Squarelotron(new int[] {0,1,2,3});
		newSquarelotron3.rotateRight(6);
		assertArrayEquals(newSquarelotron3.squarelotron, array1);
		Squarelotron newSquarelotron4 = new Squarelotron(new int[] {0,1,2,3});
		newSquarelotron4.rotateRight(-2);
		assertArrayEquals(newSquarelotron4.squarelotron, array1);
		//test case for 3 rotations as well as positive and negative
		Squarelotron newSquarelotronB = new Squarelotron(new int[] {0,1,2,3});
		newSquarelotronB.rotateRight(3);
		int[][] array2 = {{1,3},{0,2}};
		assertArrayEquals(newSquarelotronB.squarelotron, array2);
		Squarelotron newSquarelotron5 = new Squarelotron(new int[] {0,1,2,3});
		newSquarelotron5.rotateRight(-1);
		assertArrayEquals(newSquarelotron5.squarelotron, array2);
		Squarelotron newSquarelotron6 = new Squarelotron(new int[] {0,1,2,3});
		newSquarelotron6.rotateRight(7);
		assertArrayEquals(newSquarelotron6.squarelotron, array2);
	}

	@Test
	public void testEqualsObject() {
		Squarelotron newSquarelotron = new Squarelotron(new int[] {0,1,2,3});
		//test case for array of different length
		Squarelotron newSquarelotron1 = new Squarelotron(new int[] {2,0,3,1,4,5,6,7,8});
		assertFalse(newSquarelotron.equals(newSquarelotron1));
		//test case for exact match
		Squarelotron newSquarelotron2 = new Squarelotron(new int[] {0,1,2,3});
		assertTrue(newSquarelotron.equals(newSquarelotron2));
		//test case for rotated 1 turn
		Squarelotron newSquarelotron3 = new Squarelotron(new int[] {2,0,3,1});
		assertTrue(newSquarelotron.equals(newSquarelotron3));
		//test case for rotated 2 turns
		Squarelotron newSquarelotron4 = new Squarelotron(new int[] {3,2,1,0});
		assertTrue(newSquarelotron.equals(newSquarelotron4));
		//test case for rotated 3 turns
		Squarelotron newSquarelotron5 = new Squarelotron(new int[] {1,3,0,2});
		assertTrue(newSquarelotron.equals(newSquarelotron5));
	}

	@Test
	public void testToString() {
		Squarelotron newSquarelotron = new Squarelotron(new int[] {0,1,2,3});
		String string = "0" + "\t" + "1" + "\t" + "\n" + "2" + "\t" + "3" + "\t" + "\n";
		String string2= newSquarelotron.toString();
		assertEquals(string2, string);
	}


}
