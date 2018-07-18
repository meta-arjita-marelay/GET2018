package FCFS;

import java.util.Scanner;

public class JobScheduler {
	public static void main(String[] args) {
		int size; // size will contain number of processes
		System.out.println("Enter number of processes.");
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		int[][] job = new int[size][2]; // job is 2D array which will take input
										// of arrival time and burst time

		System.out
				.println("Enter arrival time and waiting time of processes.\n");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 2; j++) {
				job[i][j] = scan.nextInt();
			}
		}
		Scheduling jobCalculation = new Scheduling();
		jobCalculation.calculateTime(job, size);
		scan.close();
	}
}
