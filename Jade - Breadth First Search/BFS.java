/*
 *	BFS.java / Breadth First Search
 *  15 - Nov - 2016
 * 	Author : Gourav Siddhad
 */

import java.util.Iterator;
import java.util.LinkedList;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

@SuppressWarnings("serial")
public class BFS extends Agent {
	protected void setup() {
		addBehaviour(new mybehaviour(this));
		// doDelete();
	}

	class mybehaviour extends SimpleBehaviour {
		private boolean finished = false;

		public mybehaviour(Agent a) {
			super(a);
		}

		public void action() {
			Graph g = new Graph(4);

			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);

			System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
			g.BFS(1);
			finished = true;
		}

		public boolean done() {
			return finished;
		}
	}
}

class Graph {
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
}
