package main;

public class CircularLinkedQueueImpl {

	// Main method //
	public static void main(String[] args) {

		CircularLinkedQueue queue = new CircularLinkedQueue(4);
		//As this is a similar to task Manager, Processes are taken as programs running//
		Process wordDoc = new Process("Microsoft Word", "Microsoft", 21, 4, 23.34, 5, 20.55);
		Process excel = new Process("Microsoft Excel", "Apple", 31, 4,24.66, 5,30.78);
		Process powerPoint = new Process("Microsoft PowerPoint", "Android", 41, 4, 44.90, 5,33.22);
		Process calendar = new Process("Microsoft calender", "Linux", 51, 4, 50.00, 5,45.23);

		//Adding process objects in queue//
		queue.add(powerPoint);
		queue.add(calendar);
		queue.add(wordDoc);
		queue.add(excel);

		//queue.remove();
		queue.printQueue();
		queue.sortFunctions();

	}


}
