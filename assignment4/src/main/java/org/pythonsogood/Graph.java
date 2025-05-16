package org.pythonsogood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	private final boolean isDirected;
	private Map<Vertex, List<Pair<Vertex, Integer>>> map = new HashMap<>();

	public Graph() {
		this(false);
	}

	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public void addVertex(Vertex v) {
		this.map.put(v, new LinkedList<>());
	}

	public void addEdge(Vertex source, Vertex dest, int weight) {
		if (!this.hasVertex(source)) {
			this.addVertex(source);
		}

		if (!this.hasVertex(dest)) {
			this.addVertex(dest);
		}

		if (this.hasEdge(source, dest) || source.equals(dest)) {
			return;
		}

		this.map.get(source).add(new Pair<Vertex, Integer>(dest, weight));

		if (!this.isDirected) {
			this.map.get(dest).add(new Pair<Vertex, Integer>(source, weight));
		}
	}

	public void addEdge(Vertex source, Vertex dest) {
		this.addEdge(source, dest, 1);
	}

	public int getVertexCount() {
		return this.map.size();
	}

	public boolean hasVertex(Vertex v) {
		return this.map.containsKey(v);
	}

	public boolean hasEdge(Vertex source, Vertex dest) {
		for (Pair<Vertex, Integer> edge : this.map.get(source)) {
			if (edge.a.equals(dest)) {
				return true;
			}
		}

		return false;
	}

	public Iterable<Vertex> adj() {
		return this.map.keySet();
	}

	public Pair<Iterable<Vertex>, Integer> shortestPath(Vertex source, Vertex dest) {
		Map<Vertex, Integer> dist = new HashMap<>();
		Map<Vertex, Vertex> prev = new HashMap<>();
		List<Vertex> unvisited = new ArrayList<>();

		for (Vertex v : map.keySet()) {
			dist.put(v, Integer.MAX_VALUE);
			prev.put(v, null);
			unvisited.add(v);
		}
		dist.put(source, 0);

		while (!unvisited.isEmpty()) {
			Vertex u = null;
			int minDist = Integer.MAX_VALUE;
			for (Vertex v : unvisited) {
				if (dist.get(v) < minDist) {
					minDist = dist.get(v);
					u = v;
				}
			}

			if (u == null || u.equals(dest)) {
				break;
			}

			unvisited.remove(u);

			for (Pair<Vertex, Integer> neighbor : map.get(u)) {
				Vertex v = neighbor.a;
				int alt = dist.get(u) + neighbor.b;
				if (alt < dist.get(v)) {
					dist.put(v, alt);
					prev.put(v, u);
				}
			}
		}

		List<Vertex> path = new ArrayList<>();

		if (dist.get(dest) == Integer.MAX_VALUE) {
			return new Pair<>(path, -1);
		}

		for (Vertex at = dest; at != null; at = prev.get(at)) {
			path.add(0, at);
		}

		return new Pair<>(path, dist.get(dest));
	}

	@Override
	public String toString() {
		String result = "";

		for (Vertex source : this.map.keySet()) {
			List<Pair<Vertex, Integer>> edges = this.map.get(source);
			for (Pair<Vertex, Integer> edge : edges) {
				result += String.format("%s -> %s (%d)\n", source, edge.a, edge.b);
			}
		}

		return result;
	}
}
