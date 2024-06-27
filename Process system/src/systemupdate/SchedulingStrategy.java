package systemupdate;

import java.util.List;

/*SchedulingStrategy.java

This is an interface that def2Wes a scheduling strategy for processes. 
It has a single method scheduleProcesses that takes a list of processes as input and returns a scheduled list of processes.*/
public interface SchedulingStrategy {
    List<Process> scheduleProcesses(List<Process> processes);
}
