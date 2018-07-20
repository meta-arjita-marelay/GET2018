package FCFS;

import java.util.Scanner;

public class Scheduling {
	/*
	 * calculateTime will perform all the calculations to find the waiting, turn
	 * around and completion time of all the processes.
	 */
	public void calculateTime(int[][] job, int size) {

		int totalTime; // will store the total time in which all the processes
						// will be calculated.
		int avgWaitingTime; // avgWaitingTime will calculate the average waiting
							// time of all the processes.
		int totalWaitingTime = 0; // totalWaitingTime will calculate the sum of
									// waiting time of all processes.
		Scanner scan = new Scanner(System.in);
		int[] waitingTime = new int[size];
		int[] turnAroundTime = new int[size];
		int[] completionTime = new int[size];
		for (int i = 0; i < size; i++) // waiting, completion and turnaround
										// time will be initialised to 0 for all
										// process.
		{
			waitingTime[i] = 0;
			completionTime[i] = 0;
			turnAroundTime[i] = 0;
		}
		totalTime = 0;
		int idleTime = 0;
		for (int i = 0; i < size; i++) {
			idleTime = totalTime - job[i][0];
			if (idleTime >= 0) {
				waitingTime[i] = idleTime;
				totalTime += job[i][1];
			} else {
				totalTime = totalTime + job[i][1] - idleTime;
				waitingTime[i] = 0;
			}
			completionTime[i] = waitingTime[i] + job[i][0] + job[i][1];
			turnAroundTime[i] = waitingTime[i] + job[i][1];
		}
		System.out.println("Waiting Completion and Turnaround time:");
		for (int i = 0; i < size; i++) {
			System.out.println(waitingTime[i] + " " + completionTime[i] + " "
					+ turnAroundTime[i]);
		}
		for (int i = 0; i < size; i++) {
			totalWaitingTime += waitingTime[i];
		}
		avgWaitingTime = totalWaitingTime / size;
		System.out.println("Average Waiting Time: " + avgWaitingTime);

		scan.close();
	}
}
