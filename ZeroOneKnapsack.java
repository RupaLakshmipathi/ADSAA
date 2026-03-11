//java program to implement zero one kanpsack
import java.util.*;
public class ZeroOneKnapsack{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("enter no of items");
		int n = sc.nextInt();
		int[] weight = new int[n];
		int[] profit = new int[n];
		for(int i =0;i<n;i++){
			System.out.println("item" + (i+1)+":");
			System.out.println("enter weight");
			weight[i] = sc.nextInt();
			System.out.print("enter profit");
			profit[i] = sc.nextInt();
		}
		System.out.print("enter knapsack capacity");
		int capacity = sc.nextInt();
		int[][] dp = new int[n+1][capacity+1];
		for(int i =0;i<=n;i++){
			for(int w = 0;w<= capacity;w++){
				if(i==0 || w==0){
					dp[i][w] = 0;
				}
				else if(weight[i-1]<=w){
					dp[i][w] = Math.max(profit[i-1]+dp[i-1][w-weight[i-1]],dp[i-1][w]);
				}
				else{
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		System.out.println("maximum profit ="+dp[n][capacity]);
		sc.close();
	}
}							
		
