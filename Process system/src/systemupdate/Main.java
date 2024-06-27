package systemupdate;

import java.util.Arrays;

import systemupdate.Process.ProcessStatus;

/*Main.java

This is the main class that demonstrates the usage of the process management system.
It creates three processes with different attributes and adds them to the process manager.
It then searches for a process by ID, updates the status of a process, removes a process, and lists all processes.
Finally, it prints the pending and completed process histories and schedules the processes using the FCFS strategy.*/
public class Main {
    public static void main(String[] args) {
        SchedulingStrategy schedulingStrategy = new FCFS();
        ProcessManager processManager = new ProcessManager(schedulingStrategy);

        Process process1 = new Process(1, "Data Analysis", "This is a data analysis process", ProcessStatus.PENDING, 5, null);
        Process process2 = new Process(2, "Report Generation", "This is a report generation process", ProcessStatus.PENDING, 3, Arrays.asList(process1));
        Process process3 = new Process(3, "Data Cleaning", "This is a data cleaning process", ProcessStatus.COMPLETED, 1, null);

        processManager.addProcess(process1);
        processManager.addProcess(process2);
        processManager.addProcess(process3);

        System.out.println("All Processes:");
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }

        System.out.println("\nSearch for Process ID 2:");
        Process foundProcess = processManager.searchProcess(2);
        if (foundProcess != null) {
            System.out.println(foundProcess);
        } else {
            System.out.println("Process not found.");
        }

        System.out.println("\nUpdating status of Process ID 1 to 'Running':");
        processManager.updateProcessStatus(1, ProcessStatus.RUNNING);

        System.out.println("\nRemoving Process ID 3:");
        boolean isRemoved = processManager.removeProcess(3);
        System.out.println("Process removed: " + isRemoved);

        System.out.println("\nAll Processes after update and removal:");
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }

        System.out.println("\nPending Processes History:");
        for (Process process : processManager.getPendingProcessesHistory()) {
            System.out.println(process);
        }

        System.out.println("\nCompleted Processes History:");
        for (Process process : processManager.getCompletedProcessesHistory()) {
            System.out.println(process);
        }

        System.out.println("\nScheduled Processes:");
        for (Process process : processManager.schedule()) {
            System.out.println("Process ID: " + process.getProcessId() + ", Name: " + process.getProcessName());
        }
    }
}
