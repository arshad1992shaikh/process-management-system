package system;

public class Main {
    public static void main(String[] args) {
        ProcessManager processManager = new ProcessManager();

        // Adding processes
        Process process1 = new Process(1, "Data Analysis", "Pending");
        Process process2 = new Process(2, "Report Generation", "Running");
        Process process3 = new Process(3, "Data Cleaning", "Completed");

        processManager.addProcess(process1);
        processManager.addProcess(process2);
        processManager.addProcess(process3);

        // Listing all processes
        System.out.println("All Processes:");
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }

        // Searching for a process
        System.out.println("\nSearch for Process ID 2:");
        Process foundProcess = processManager.searchProcess(2);
        if (foundProcess != null) {
            System.out.println(foundProcess);
        } else {
            System.out.println("Process not found.");
        }

        // Updating process status
        System.out.println("\nUpdating status of Process ID 1 to 'Running':");
        processManager.updateProcessStatus(1, "Running");

        // Removing a process
        System.out.println("\nRemoving Process ID 3:");
        boolean isRemoved = processManager.removeProcess(3);
        System.out.println("Process removed: " + isRemoved);

        // Listing all processes after update and removal
        System.out.println("\nAll Processes after update and removal:");
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }

        // Displaying pending and completed process histories
        System.out.println("\nPending Processes History:");
        for (Process process : processManager.getPendingProcessesHistory()) {
            System.out.println(process);
        }

        System.out.println("\nCompleted Processes History:");
        for (Process process : processManager.getCompletedProcessesHistory()) {
            System.out.println(process);
        }
    }
}
