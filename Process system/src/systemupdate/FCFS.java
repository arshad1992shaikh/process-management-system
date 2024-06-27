package systemupdate;

import java.util.List;
/*FCFS.java

This class implements the First-Come-First-Served (FCFS) scheduling strategy. It simply returns the input list of processes in the order they were received.*/
public class FCFS implements SchedulingStrategy {
    @Override
    public List<Process> scheduleProcesses(List<Process> processes) {
        // In FCFS, processes are returned in the order they were added
        return processes;
    }
}

