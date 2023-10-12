

import java.io.*;
import java.util.*;

public class Main{
	
	static int N, ans;
	static int[][] map;
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		ArrayList<Node> landNodes = new ArrayList<>();

		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==1) {
					landNodes.add(new Node( i, j));
				}else {
					visit[i][j] = true;
				}
			}
		}
		
		ans = 999999;
		ArrayList<ArrayList<Node>> lands = findLands(landNodes, visit);
//		getMinDist(lands);
		for (ArrayList<Node> arrayList : lands) {
			for (Node node : arrayList) {
				ans = Math.min(ans, bfs(node, new boolean[N][N])-1);
			}
		}
		
		
		System.out.println(ans);
		
		
	}
	//다리길이 찾기 bfs 사용
	static int bfs(Node startNode, boolean[][] visit) {
		int result = 999999;
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(startNode);
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			if (map[node.x][node.y]!=0&&map[node.x][node.y]!=startNode.landIndex) {
				result = node.depth;
				break;
			}
			if (visit[node.x][node.y]) continue;
			visit[node.x][node.y] = true;
			
			
			for (int[] mv : move) {
				int dx = mv[0]+ node.x;
				int dy = mv[1]+ node.y;
				
				if (!isIn(dx,dy)||visit[dx][dy]||map[dx][dy]==startNode.landIndex) continue;
				q.add(new Node(node.landIndex,dx,dy,node.depth+1));
			}
		}
		return result;
	}
	
	//다리길이 찾기 멘헤튼 거리 사용
	static void getMinDist(ArrayList<ArrayList<Node>> lands) {
		int landsCount = lands.size();
		boolean[][] visit = new boolean[landsCount][landsCount];
		for (int i=0; i<lands.size(); i++) {
			for (int j=0; j<lands.size(); j++) {
				
				if(j==i) continue;
				if(visit[i][j]||visit[j][i]) continue;
				visit[i][j] = true;
				
				ArrayList<Node> landA = lands.get(i);
				ArrayList<Node> landB = lands.get(j);
				
				for (Node nodeA : landA) {
					for (Node nodeB : landB) {
						ans = Math.min(ans, getDist(nodeA,nodeB)-1);//다른 섬과의 거리 중 가장 짧은 거리만 저장
					}
				}
				
			}
		}
	}
	static int getDist(Node nodeA, Node nodeB) {
		return Math.abs(nodeA.x-nodeB.x)+Math.abs(nodeA.y-nodeB.y);
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	static ArrayList<ArrayList<Node>> findLands(ArrayList<Node> landNodes, boolean[][] visit) {
		ArrayList<ArrayList<Node>> lands = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visit[i][j]) continue;
				ArrayList<Node> land = new ArrayList<>();
				ArrayDeque<Node> q = new ArrayDeque<Node>();
				q.add(new Node(lands.size()+10,i,j));
				while(!q.isEmpty()) {
					
					Node node = q.poll();
					if(visit[node.x][node.y]) continue;
					visit[node.x][node.y] = true;
					land.add(node);
					map[node.x][node.y] = node.landIndex;
					
					for (int[] mv : move) {
						int dx = mv[0] + node.x;
						int dy = mv[1] + node.y;
						if (!isIn(dx,dy)||visit[dx][dy]) continue;
						q.add(new Node(node.landIndex, dx, dy));
					}
				}
				lands.add(land);
			}
		}
		return lands;
	}
}
class Node{
	int landIndex;
	int x;
	int y;
	int depth;
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Node(int landIndex, int x, int y) {
		super();
		this.landIndex = landIndex;
		this.x = x;
		this.y = y;
		this.depth = 0;
	}
	public Node(int landIndex,int x, int y, int depth) {
		super();
		this.landIndex = landIndex;
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "Node [landIndex=" + landIndex + ", x=" + x + ", y=" + y + "]";
	}
	
}