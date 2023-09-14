# SRTF (Shortest Remaining Time First) Scheduling Algorithm

This is a Java implementation of the SRTF scheduling algorithm, which is a preemptive algorithm that schedules processes based on their remaining burst time. The process with the shortest remaining burst time is executed first.

## How to Run

1. Clone or download the repository.
2. Open the project in an IDE (e.g. Eclipse, IntelliJ IDEA).
3. Run the `SRTF.java` file.

## Algorithm Details

The SRTF algorithm schedules processes based on their remaining burst time, with the process with the shortest remaining burst time being executed first. It is a preemptive algorithm, meaning that a process can be interrupted and replaced by another process with a shorter remaining burst time.

The algorithm works by first initializing the remaining time of each process to its burst time. Then, it selects the process with the shortest remaining burst time that has arrived, and executes it for one time unit. If another process with a shorter remaining burst time arrives while a process is executing, the executing process is preempted and replaced by the new process. The algorithm repeats until all processes have been executed.

## Input

The input to the algorithm is an array of `Process` objects, where each object represents a process and contains the following fields:

- `pid`: process ID
- `arrival_time`: arrival time of the process
- `burst_time`: burst time of the process

## Output

The output of the algorithm is an array of `Process` objects, where each object represents a process and contains the following fields:

- `pid`: process ID
- `arrival_time`: arrival time of the process
- `burst_time`: burst time of the process
- `completion_time`: completion time of the process
- `waiting_time`: waiting time of the process
- `turnaround_time`: turnaround time of the process

The output also includes the average waiting time and average turnaround time.

## Example

Suppose we have the following input:

```
Enter the number of processes: 5
Enter the arrival and burst time of process 1: 0 3
Enter the arrival and burst time of process 2: 1 2
Enter the arrival and burst time of process 3: 2 1
Enter the arrival and burst time of process 4: 3 4
Enter the arrival and burst time of process 5: 4 6
```

After running the algorithm, we get the following output:

```
pid    at    bt    wt    tat    ct
1      0     3     0     3      3
3      2     1     1     2      4
2      1     2     2     4      5
4      3     4     3     7      8
5      4     6     6     8      14
avg wt: 2.4
avg tat: 4.8
```
