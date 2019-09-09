package main;

import java.util.Comparator;


public class CircularLinkedQueue {

	private int circularLinkedQueueCapacity;
	private static final String CIRCULAR_LIST_EMPTY_MESSAGE = "Queue is Emplty";
	private int nodeCount = 0;
	private ProcessNode headNode = null;
	private ProcessNode tailNode = null;
	private ProcessNode headNodeRemove = null;

	// Constructor for CircularLinkedQueue //
	public CircularLinkedQueue(int initialCapacity) {
		circularLinkedQueueCapacity = 5;
	}

	// Function to add Process in queue //
	public void add(Process processDetails) {

		/**
		 * Is nodeCount == circularLinkedQueueSize
		 * then Increase the size.
		 * circularLinkedQueueSize = circularLinkedQueueSize * 2;
		 */
		if (nodeCount == 0) {
			headNode = new ProcessNode();
			headNode.setNext(null);
			headNode.setValue(processDetails);
			headNode.setPrevious(null);
			tailNode = headNode;
			nodeCount = 1;
		} else if(nodeCount == 1 && circularLinkedQueueCapacity > 1){

			ProcessNode newNode = new ProcessNode();
			newNode.setValue(processDetails);
			newNode.setNext(headNode);
			newNode.setPrevious(tailNode);
			tailNode = newNode;
			headNode.setPrevious(tailNode);
			headNode.setNext(newNode);
			nodeCount = 2;
		}else {
			if(circularLinkedQueueCapacity == nodeCount) {
				circularLinkedQueueCapacity *= 2;
			}
			ProcessNode updateNode = new ProcessNode();
			updateNode.setValue(processDetails);
			updateNode.setNext(headNode);
			updateNode.setPrevious(tailNode);
			tailNode.setNext(updateNode);
			headNode.setPrevious(updateNode);
			tailNode = updateNode;
			nodeCount++;
		}

	}

	// Function to remove First Process from queue//
	public void remove() {

		if(nodeCount != 0) {
			headNodeRemove = headNode;
			tailNode.setNext(headNode.next);
			headNode = headNode.next;
			headNode.next.previous = tailNode;
			nodeCount--;
		}else {
			System.out.print(CIRCULAR_LIST_EMPTY_MESSAGE);
			throw new IllegalStateException("Can not remove element. Queue empty.");
		}
	}


	// Function to return First Process from queue//
	public ProcessNode getFirstElement() {

		if(nodeCount != 0) {
			headNodeRemove = headNode;
		}else {
			System.out.print(CIRCULAR_LIST_EMPTY_MESSAGE);
		}
		return headNodeRemove;

	}

	public String print() {
		ProcessNode p = headNode;
		String queueMessage = "";
		do {
			//queueMessage += "Process ID : " + p.getValue().getProcessID() + "Process Name : " + p.getValue().getProcessName() + "Process Owner :  " + p.getValue().getOwner() + "Process CPUTime : " + p.getValue().getPercentOfCPUTime();
			queueMessage += p.getValue().getProcessID() + " ";
			p = p.next;
		}
		while(p != headNode);
		return queueMessage;
	}

	public void printQueue() {
		ProcessNode process = headNode;
		do {
			System.out.print("Head Node contents are : " + process + "\n");
			process = process.next;
		}
		while(process != headNode);

	}

	// Sorting method calls //
	public void sortFunctions() {
		sortQueueByPid();
		sortQueueByOwner();
		sortQueueByCPUTime();
		sortQueueByName();
		sortQueueByPercentOfCPUTime();
	}


	// Sorting method calls with related comparator classes : detailed reference in ProcessComparator class

	public CircularLinkedQueue sortQueueByCPUTime() {
		return sort(headNode, new sortbyCPUTime());
	}
	public CircularLinkedQueue sortQueueByPid() {
		return sort(headNode, new SortbyID());
	}
	public CircularLinkedQueue sortQueueByOwner() {
		return sort(headNode, new SortbyOwner());
	}
	public CircularLinkedQueue sortQueueByName() {
		return sort(headNode, new sortbyName());
	}

	public CircularLinkedQueue sortQueueByPercentOfCPUTime() {
		return sort(headNode, new sortbyPercentOfCPUTime());
	}

	// Calling Quick sort with Process parameter//
	private CircularLinkedQueue sort(ProcessNode headNode, Comparator<? super Process> comparator) {

		Process[] processes = queueToArray(headNode);
		quickSort(processes, 0, nodeCount-1, comparator);
		CircularLinkedQueue sortedQueue = arrayToQueue(processes);
		return sortedQueue;
	}

	//before sorting this method converts queue to an array : this will make sorting easy//
	private Process[] queueToArray(ProcessNode headNode) {

		Process[] processArray = new Process[nodeCount];
		for(int i=0;i<nodeCount;i++) {
			processArray[i] = headNode.getValue();
			headNode = headNode.next;
		}
		return processArray;
	}

	//before sorting this method converts array to queue and returns queue object//

	private CircularLinkedQueue arrayToQueue(Process[] arrayProcess) {
		CircularLinkedQueue queueObject = new CircularLinkedQueue(4);
		for(int i=0;i<nodeCount;i++) {
			queueObject.add(arrayProcess[i]);
		}
		return queueObject;
	}

	//Quick tree implementation for process //
	public void quickSort(Process[] processes, int begin, int end, Comparator<? super Process> comparator) {
		if (begin < end) {

			int partitionIndex = partition(processes, begin, end, comparator);
			quickSort(processes, begin, partitionIndex-1, comparator);
			quickSort(processes, partitionIndex+1, end, comparator);
		}
	}

	private int partition(Process[] processes, int begin, int end, Comparator<? super Process> comparator) {

		Process pivot = processes[end];

		int i = (begin-1);

		for (int j = begin; j < end; j++) {
			Process p = processes[j];
			if (comparator.compare(p, pivot) < 0) {
				i++;

				Process swapTemp = processes[i];
				processes[i] = processes[j];
				processes[j] = swapTemp;
			}
		}

		Process swapTemp = processes[i+1];
		processes[i+1] = processes[end];
		processes[end] = swapTemp;

		return i+1;
	}

	// Function to check if queue is empty //
	public boolean isEmpty() {
		return nodeCount == 0;
	}

	// Function to get size of the queue //
	public int size() {
		return circularLinkedQueueCapacity;
	}

}