//Implementing Job Sequencing Problem using Greedy Algorithm
import java.util.*;

class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];

        System.out.println("Enter Job details (id deadline profit):");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        // Step 1: Sort jobs by profit (descending)
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find max deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline)
                maxDeadline = job.deadline;
        }

        int[] slot = new int[maxDeadline];
        Arrays.fill(slot, -1);

        int totalProfit = 0;

        // Step 2: Assign jobs to slots
        for (Job job : jobs) {
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (slot[j] == -1) {
                    slot[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Output
        System.out.println("Selected Jobs:");
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i] != -1)
                System.out.print("J" + slot[i] + " ");
        }

        System.out.println("\nTotal Profit: " + totalProfit);

        sc.close();
    }
}