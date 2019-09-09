package main;
import java.util.Comparator;

//Below methods define comparator operations based on type : owner, PID etc//
class SortbyID implements Comparator<Process> 
{ 
	@Override
	public int compare(Process o1, Process o2) {
		return Integer.compare(o1.getProcessID(), o2.getProcessID());
	} 
} 

class SortbyOwner implements Comparator<Process> 
{ 
	@Override
	public int compare(Process o1, Process o2) {
		return o1.getOwner().compareTo(o2.getOwner()); 
	} 
} 
class sortbyCPUTime implements Comparator<Process>{
	@Override
	public int compare(Process o1, Process o2) {
		return Integer.compare(o1.getTime(), o2.getTime());
	}

}
class sortbyName implements Comparator<Process>{
	@Override
	public int compare(Process o1, Process o2) {
		return o1.getProcessName().compareTo(o2.getProcessName());
	}
}
class sortbyPercentOfCPUTime implements Comparator<Process>{
	@Override
	public int compare(Process o1, Process o2) {
		return  Double.compare(o1.getPercentOfCPUTime(), o2.getPercentOfCPUTime());

	}
}

