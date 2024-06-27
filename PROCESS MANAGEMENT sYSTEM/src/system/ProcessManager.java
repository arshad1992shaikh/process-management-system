package system;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProcessManager {
    private List<Process> processes;
    private LinkedList<Process> pendingHistory;
    private LinkedList<Process> completedHistory;

    public ProcessManager() {
        processes = new ArrayList<>();
        pendingHistory = new LinkedList<>();
        completedHistory = new LinkedList<>();
    }

    // Add Process
    public void addProcess(Process process) {
        processes.add(process);
    }

    // Remove Process
    public boolean removeProcess(int processId) {
        for (Process process : processes) {
            if (process.getProcessId() == processId) {
                processes.remove(process);
                return true;
            }
        }
        return false;
    }

    // Search for a Process
    public Process searchProcess(int processId) {
        for (Process process : processes) {
            if (process.getProcessId() == processId) {
                return process;
            }
        }
        return null;
    }

    // List All Processes
    public List<Process> listAllProcesses() {
        return new ArrayList<>(processes);
    }

    // Update Process Status
    public boolean updateProcessStatus(int processId, String newStatus) {
        for (Process process : processes) {
            if (process.getProcessId() == processId) {
                process.setStatus(newStatus);
                if ("Pending".equals(newStatus)) {
                    addPendingProcess(process);
                } else if ("Completed".equals(newStatus)) {
                    addCompletedProcess(process);
                }
                return true;
            }
        }
        return false;
    }

    // Pending and Completed Process History
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
}
