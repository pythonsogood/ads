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
		return null;
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
