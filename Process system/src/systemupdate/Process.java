package systemupdate;

import java.util.Date;
import java.util.List;
/*The dependencies field is a list of Process objects, which means that a process can have multiple dependencies.
The startTime and endTime fields are Date objects, which means that they represent specific points in time.
The priority field is an integer, which means that it can be used to prioritize processes.
Overall, this class provides a way to represent a process in a system, including its properties and dependencies. It can be used to model and manage processes in a variety of applications.*/

public class Process {
    private int processId;
    private String processName;
    private String processDescription;
    private ProcessStatus status;
    private Date startTime;
    private Date endTime;
    private int priority;
    private List<Process> dependencies;
/*The constructor initializes the fields with the provided values and sets the startTime and endTime fields to null.
The class has getter and setter methods for each of the fields, which allow you to access and modify the properties of the process.
The class also has a toString() method that returns a string representation of the process, which includes all of its properties.*/
    public Process(int processId, String processName, String processDescription, ProcessStatus status, int priority, List<Process> dependencies) {
        this.processId = processId;
        this.processName = processName;
        this.processDescription = processDescription;
        this.status = status;
        this.priority = priority;
        this.dependencies = dependencies;
        this.startTime = null;
        this.endTime = null;
    }
//This is an enumeration of the possible process statuses: PENDING, RUNNING, and COMPLETED.
    /*Enumeration ProcessStatus
This is an enumeration that represents the possible statuses of a process:
PENDING: the process is waiting to be executed
RUNNING: the process is currently being executed
COMPLETED: the process has finished executing*/
    public enum ProcessStatus {
        PENDING, RUNNING, COMPLETED
    }

    // Getters and setters
    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessDescription() {
        return processDescription;
    }

    public void setProcessDescription(String processDescription) {
        this.processDescription = processDescription;
    }

    public ProcessStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessStatus status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<Process> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Process> dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processId=" + processId +
                ", processName='" + processName + '\'' +
                ", processDescription='" + processDescription + '\'' +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", priority=" + priority +
                ", dependencies=" + dependencies +
                '}';
    }
}

