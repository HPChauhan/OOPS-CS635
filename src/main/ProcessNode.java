package main;
public class ProcessNode {

	Process value;
	ProcessNode next;
	ProcessNode previous;

	public Process getValue() {
		return value;
	}

	public void setValue(Process value) {
		this.value = value;
	}

	public ProcessNode getNext() {
		return next;
	}

	public void setNext(ProcessNode next) {
		this.next = next;
	}

	public ProcessNode getPrevious() {
		return previous;
	}

	public void setPrevious(ProcessNode previous) {
		this.previous = previous;
	}

	public String toString(){
		return value + "";
	}

}
