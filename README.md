# process-management-system
Process Management System  A Java-based process management system that allows users to create, manage, and schedule processes with ease. The system provides a simple and intuitive way to track the status of processes and their dependencies, making it an ideal solution for organizations that need to manage multiple processes simultaneously.

Process Management System
Overview
This is a Java-based process management system that allows you to create, manage, and schedule processes. The system provides a simple and intuitive way to track the status of processes and their dependencies.

Features
Create and manage processes with unique IDs, names, and descriptions
Assign priorities to processes
Define dependencies between processes
Update process status (PENDING, RUNNING, COMPLETED)
Search for processes by ID
Remove processes
View pending and completed process histories
Schedule processes using a First-Come-First-Served (FCFS) strategy

Usage
Creating a Process

Process process = new Process(1, "Data Analysis", "This is a data analysis process", ProcessStatus.PENDING, 5, null);
Adding a Process to the Manager

ProcessManager processManager = new ProcessManager(new FCFS());
processManager.addProcess(process);
Updating Process Status

processManager.updateProcessStatus(1, ProcessStatus.RUNNING);
Searching for a Process



Process foundProcess = processManager.searchProcess(2);
if (foundProcess!= null) {
    System.out.println(foundProcess);
} else {
    System.out.println("Process not found.");
}
Removing a Process
boolean isRemoved = processManager.removeProcess(3);
System.out.println("Process removed: " + isRemoved);


Viewing Process Histories

System.out.println("Pending Processes History:");
for (Process process : processManager.getPendingProcessesHistory()) {
    System.out.println(process);
}

System.out.println("Completed Processes History:");
for (Process process : processManager.getCompletedProcessesHistory()) {
    System.out.println(process);
}



Scheduling Processes
System.out.println("Scheduled Processes:");
for (Process process : processManager.schedule()) {
    System.out.println("Process ID: " + process.getProcessId() + ", Name: " + process.getProcessName());
}
License
This project is licensed under the MIT License. See LICENSE for details.

Contributing
Contributions are welcome! If you'd like to contribute to this project, please fork the repository and submit a pull request.

Acknowledgments
This project was inspired by various process management systems and scheduling algorithms. Special thanks to the Java community for providing a rich ecosystem of libraries and tools.
