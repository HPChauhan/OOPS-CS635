package main;
public class Process{

	//variables declaration

	private String processName;
	private String owner;
	private int processID;
	private int threadCount;
	private Double memory;
	private int cpuTime;
	private Double percentOfCPUTime;

	//Constructor for Process class//
	public Process(String processName, String owner,int processID, int threadCount,Double memory, int cpuTime, Double percentOfCPUTime) {
		this.processName = processName;
		this.processID = processID;
		this.owner = owner;
		this.threadCount = threadCount;
		this.memory = memory;
		this.cpuTime = cpuTime;
		this.percentOfCPUTime = percentOfCPUTime;
	}


	//Getter methods for Process class//
	public String getProcessName() {
		return processName;
	}

	public String getOwner() {
		return owner;
	}

	public int getProcessID() {
		return processID;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public Double getMemory() {
		return memory;
	}
	public Double getPercentOfCPUTime() {
		return percentOfCPUTime;
	}


	public int getTime() {
		return cpuTime;
	}	
	public String toString() 
	{ 
		return this.getProcessID() + " " + this.owner ;

	} 
}