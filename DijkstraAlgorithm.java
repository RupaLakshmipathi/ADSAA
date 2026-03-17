//implementation of Dijkstra Algorithm using greedy method when graph is represented by adjacency matrix
import java.util.Scanner;
public class DijkstraAlgorithm{
	static final int INF = 9999;
		private static int chooseMinVertex(int [] dist,boolean[] S,int n){
		int minIndex=-1,min = INF;
			for(int i = 0;i<n;i++){
				if(!S[i] && dist[i] < min){
				min = dist[i];
				minIndex = i;
				}
			}	
				return minIndex;
		}	
		public static void shortestPaths(int v,int[][] cost,int[] dist,int n){
			boolean[] S = new boolean[n];
		    for(int i =0;i<n;i++){
		    	dist[i] = cost[v][i];
		    	S[v] = true;
		    }
		    for(int num = 1;num<n;num++){
		    	int u = chooseMinVertex(dist,S,n);
		    	if(u==-1) break;
		    	S[u] = true;
		       for(int w = 0; w < n; w++){
					if(!S[w] && dist[u] + cost[u][w]<dist[w])
							dist[w] = dist[u] + cost[u][w];
				}			
		    }
		}	    
		public static void main(String args[]){
			Scanner sc = new Scanner(System.in);
			System.out.print("enter no of vertices");
			int n = sc.nextInt();
			int[][] cost = new int[n][n];
			System.out.println("enter cost adjacency matrix(use 9999 for INF)");
			for(int i = 0; i<n;i++)
				for(int j= 0;j<n;j++)
					cost[i][j] = sc.nextInt();
			System.out.print("enter source vertex");
			int source = sc.nextInt();
			int[] dist = new int[n];
			shortestPaths(source,cost,dist,n);
			System.out.println("shortest distances from source"+source+"");
			for(int i = 0;i<n;i++)
				System.out.println("vertex"+i+":"+(dist[i]==INF? "INF":dist[i]));
			sc.close();	
		}
}	
					
					    			
				
		
