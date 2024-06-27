package systemupdate;

import java.util.*;

import systemupdate.Process.ProcessStatus;
/*ProcessManager.java

This class manages a list of processes and provides methods for adding, removing, searching, and updating processes.
It also maintains two histories: pendingHistory and completedHistory, which store processes that have been pending or completed, respectively.
The schedule method uses the scheduling strategy to schedule the processes.*/
public class ProcessManager {
    private List<Process> processes;
    private LinkedList<Process> pendingHistory;
    private LinkedList<Process> completedHistory;
    private SchedulingStrategy schedulingStrategy;

    public ProcessManager(SchedulingStrategy schedulingStrategy) {
        this.schedulingStrategy = schedulingStrategy;
        this.processes = new ArrayList<>();
        this.pendingHistory = new LinkedList<>();
        this.completedHistory = new LinkedList<>();
    }

    public void addProcess(Process process) {
        processes.add(process);
    }

    public boolean removeProcess(int processId) {
        for (Process process : processes) {
            if (process.getProcessId() == processId) {
                processes.remove(process);
                return true;
            }
        }
        return false;
    }

    public Process searchProcess(int processId) {
        for (Process process : processes) {
            if (process.getProcessId() == processId) {
                return process;
            }
        }
        return null;
    }

    public List<Process> listAllProcesses() {
        return new ArrayList<>(processes);
    }

    public boolean updateProcessStatus(int processId, ProcessStatus newStatus) {
        for (Process process : processes) {
            if (process.getProcessId() == processId) {
                process.setStatus(newStatus);
                if (newStatus == ProcessStatus.PENDING) {
                    addPendingProcess(process);
                } else if (newStatus == ProcessStatus.COMPLETED) {
                    addCompletedProcess(process);
                }
                return true;
            }
        }
        return false;
    }

    public void addPendingProcess(Process process) {
        pendingHistory.add(process);
    }

    public void addCompletedProcess(Process process) {
        completedHistory.add(process);
    }

    public List<Process> getPendingProcessesHistory() {
        return new ArrayList<>(pendingHistory);
    }

    public List<Process> getCompletedProcessesHistory() {
        return new ArrayList<>(completedHistory);
    }

    public List<Process> schedule() {
        return schedulingStrategy.scheduleProcesses(new ArrayList<>(processes));
    }
}
