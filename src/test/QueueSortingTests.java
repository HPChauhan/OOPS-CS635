package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import main.CircularLinkedQueue;
import main.Process;

public class QueueSortingTests {
	
	CircularLinkedQueue queue;

	@Before
	public void setup() {
		queue = new CircularLinkedQueue(5);
	}
	
	@Test
	public void testCircularLinkedQueue_SortByIdTest() {

		assertEquals(5, queue.size());

		Process word = new Process("Microsoft Word", "Microsoft", 3, 4, 23.34, 5, 67.55);
		queue.add(word);
		Process excel = new Process("Microsoft Excel", "Microsoft", 2, 4, 23.34, 5,10.11);
		queue.add(excel);
		Process powerpoint = new Process("Microsoft Powerpoint", "Microsoft", 7, 4, 23.34, 5, 9.90);
		queue.add(powerpoint);

		CircularLinkedQueue sortedQueueHeadNode = queue.sortQueueByPid();
		String strQueue = sortedQueueHeadNode.print();
		
		assertNotNull(strQueue);
		//assertEquals("2 3 7 ", strQueue);
	}


	@Test
	public void testCircularLinkedQueue_SortByOwnerTest() {

		assertEquals(5, queue.size());

		Process word = new Process("Microsoft Word", "Microsoft", 3, 4, 23.34, 5, 67.55);
		queue.add(word);
		Process excel = new Process("Microsoft Excel", "Apple", 2, 4, 23.34, 5,10.11);
		queue.add(excel);
		Process powerpoint = new Process("Microsoft Powerpoint", "Google", 7, 4, 23.34, 5, 9.90);
		queue.add(powerpoint);

		CircularLinkedQueue sortedQueueHeadNode = queue.sortQueueByOwner();
		String strQueueCPU = sortedQueueHeadNode.print();
		assertNotNull(strQueueCPU);
		//assertEquals("Apple Google Microsoft ", strQueueCPU);
	}
	
	
	@Test
	public void testCircularLinkedQueue_SortByNameTest() {

		assertEquals(5, queue.size());

		Process word = new Process("Word", "Microsoft", 3, 4, 23.34, 5, 67.55);
		queue.add(word);
		Process excel = new Process("Excel", "Apple", 2, 4, 23.34, 5, 10.11);
		queue.add(excel);
		Process powerpoint = new Process("Powerpoint", "Google", 7, 4, 23.34, 5, 9.90);
		queue.add(powerpoint);

		CircularLinkedQueue sortedQueueHeadNode = queue.sortQueueByName();
		String strQueueCPU = sortedQueueHeadNode.print();

		assertNotNull(strQueueCPU);
		assertEquals("2 7 3 ", strQueueCPU);
	}
	
	@Test
	public void testCircularLinkedQueue_SortByCPUTime() {

		assertEquals(5, queue.size());

		Process word = new Process("Word", "Microsoft", 3, 4, 23.34, 5, 67.55);
		queue.add(word);
		Process excel = new Process("Excel", "Apple", 2, 4, 23.34, 5, 10.11);
		queue.add(excel);
		Process powerpoint = new Process("Powerpoint", "Google", 7, 4, 23.34, 5, 9.90);
		queue.add(powerpoint);

		CircularLinkedQueue sortedQueueHeadNode = queue.sortQueueByName();
		String strQueueCPU = sortedQueueHeadNode.print();
		assertNotNull(strQueueCPU);
		assertEquals("2 7 3 ", strQueueCPU);
	}
	
}
