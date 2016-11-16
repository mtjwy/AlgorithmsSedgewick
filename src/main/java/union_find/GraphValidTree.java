package union_find;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 * 
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false.
 */
public class GraphValidTree {
	/**
	 * Application of  Union find 
	 * 
	 * Consider two things:
	 *     1. is there a circle? if so, not a valid tree
	 *     2. all node are in a single component? if not, not a valid tree
	 *     
	 *  Traverse all nodes and do union operation on nodes, and check if there
	 *  is a circle. If no circle, and UF size is 1, nodes can make a valid tree
	 */
	public boolean validTree(int n, int[][] edges) {
		UF uf = new UF(n);
		for (int i = 0; i < edges.length; i++) {
			if (!uf.union(edges[i][0], edges[i][1])) {
				return false;
			}
		}
		return uf.count() == 1;
	}
	
	public static void main(String[] args) {
		GraphValidTree gvt = new GraphValidTree();
		int n = 5;
		int[][] edges1 = {{0,1}, {0, 2}, {0, 3}, {1, 4}};
		int[][] edges2 = {{0,1}, {1, 2}, {2,3}, {1, 3}, {1, 4}};
		int[][] edges3 = {{0,1}, {1, 2}, {3,4}};
		
		System.out.println(gvt.validTree(n, edges1));
		System.out.println(gvt.validTree(n, edges2));
		System.out.println(gvt.validTree(n, edges3));
		
	}
	private static class UF {
		private int[] parent;
		private int count;

		public UF(int N) {
			parent = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			count = N;
		}

		private int root(int i) {
			while (i != parent[i]) {
				i = parent[i];
			}
			return i;
		}

		public boolean connected(int p, int q) {
			return root(p) == root(q);
		}

		public boolean union(int p, int q) {
			int i = root(p);
			int j = root(q);
			if (i != j) {
				parent[i] = j;
				count--;
				return true;
			} else {
				return false;
			}
		}

		public int count() {
			return count;
		}
	}
	
	

}
