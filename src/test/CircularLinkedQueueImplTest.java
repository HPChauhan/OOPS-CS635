package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import main.CircularLinkedQueue;
import main.Process;

/**
 * @author Harpal Chauhan
 *
 */
public class CircularLinkedQueueImplTest {

	CircularLinkedQueue queue;

	@Before
	public void setup() {
		queue = new CircularLinkedQueue(5);
	}
	//Check size of the queue
	@Test
	public void testCircularLinkedQueue_SizeCheck() {

		assertEquals(5, queue.size());

		Process word = new Process("Microsoft Word", "Microsoft", 1, 4, 23.34, 5, 67.55);
		queue.add(word);
		Process excel = new Process("Microsoft Excel", "Microsoft", 2, 4, 23.34, 5,10.11);
		queue.add(excel);
		assertEquals(5, queue.size());
	}

	//Check if the node is added
	@Test
	public void testCircularLinkedQueue_AddNode() {
		Process word = new Process("Microsoft Word", "Microsoft", 1, 4, 23.34, 5, 10.66);
		queue.add(word);
		Process excel = new Process("Microsoft Excel", "Microsoft", 2, 4, 23.34, 5, 66.00);
		queue.add(excel);

		String queuePrintValue = queue.print();
		assertNotNull(queuePrintValue);
		assertEquals("1 2 ", queuePrintValue);
	}

	//Check is add and remove working correctly 
	@Test
	public void testCircularLinkedQueue_AddNode_RemoveNode() {
		Process word = new Process("Microsoft Word", "Microsoft", 1, 4, 23.34, 5, 67.76);
		queue.add(word);
		Process excel = new Process("Microsoft Excel", "Microsoft", 2, 4, 23.34, 5, 77.00);
		queue.add(excel);

		String queuePrintValue = queue.print();

		assertNotNull(queuePrintValue);
		assertEquals("1 2 ", queuePrintValue);

		// Remove Node Now
		queue.remove();

		queuePrintValue = queue.print();

		assertNotNull(queuePrintValue);
		assertEquals("2 ", queuePrintValue);
	}

	//Remove node when there is no node in queue : throws an exception
	@Test(expected = IllegalStateException.class)
	public void testCircularLinkedQueue_RemoveNode_EmptyQueue() {

		queue.remove();
	}

	//Size checked once increase
	@Test
	public void testCircularLinkedQueue_SizeCheckIncreased() {
		Process word = new Process("Microsoft Word", "Microsoft", 1, 4, 23.34, 5, 67.90);
		queue.add(word);
		Process excel = new Process("Microsoft Excel", "Microsoft", 2, 4, 23.34, 5, 7.96);
		queue.add(excel);
		Process powerpoint = new Process("Microsoft Powerpoint", "Microsoft", 3, 4, 23.34, 5, 9.90);
		queue.add(powerpoint);
		Process access = new Process("Microsoft Access", "Microsoft", 4, 4, 23.34, 5, 6.80);
		queue.add(access);
		Process skype = new Process("Microsoft Skype", "Microsoft", 5, 4, 23.34, 5, 7.90);
		queue.add(skype);


		String queuePrintValue = queue.print();

		assertNotNull(queuePrintValue);
		assertEquals("1 2 3 4 5 ", queuePrintValue);
		assertEquals(5, queue.size());

		Process git = new Process("Git", "Github", 6, 7, 8.8, 9, 77.23);
		queue.add(git);

		queuePrintValue = queue.print();

		assertNotNull(queuePrintValue);
		assertEquals("1 2 3 4 5 6 ", queuePrintValue);
		assertEquals(10, queue.size());
	}


	//Check if intermixing add and remove, queue behaves as expected
	@Test
	public void testCircularLinkedQueue_AddRemoveMixed_SizeNotIncreased() {
		Process word = new Process("Microsoft Word", "Microsoft", 1, 4, 23.34, 5, 67.90);
		queue.add(word);
		Process excel = new Process("Microsoft Excel", "Microsoft", 2, 4, 23.34, 5, 7.96);
		queue.add(excel);
		Process powerpoint = new Process("Microsoft Powerpoint", "Microsoft", 3, 4, 23.34, 5, 9.90);
		queue.add(powerpoint);

		assertEquals(5, queue.size());

		queue.remove();

		assertEquals(5, queue.size());

		Process access = new Process("Microsoft Access", "Microsoft", 4, 4, 23.34, 5, 6.80);
		queue.add(access);
		Process skype = new Process("Microsoft Skype", "Microsoft", 5, 4, 23.34, 5, 7.90);
		queue.add(skype);
		Process vsCode = new Process("Microsoft VS Code", "Microsoft", 6, 4, 23.34, 5, 7.90);
		queue.add(vsCode);

		assertEquals("2 3 4 5 6 ", queue.print());
		assertEquals(5, queue.size());
	}
}
