package org.pythonsogood;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	private final boolean isDirected;
	private Map<Vertex, List<Vertex>> map = new HashMap<>();

	public Graph() {
		this(false);
	}

	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public void addVertex(Vertex v) {
		this.map.put(v, new LinkedList<>());
	}

	public void addEdge(Edge edge) {
		if (!this.hasVertex(edge.source)) {
			this.addVertex(edge.source);
		}

		if (!this.hasVertex(edge.dest)) {
			this.addVertex(edge.dest);
		}

		if (this.hasEdge(edge || source.equals(dest)) {
			return;
		}

		this.map.get(source).add(dest);

		if (!this.isDirected) {
			this.map.get(dest).add(source);
		}
	}

	public int getVertexCount() {
		return this.map.size();
	}

	public boolean hasVertex(Vertex v) {
		return this.map.containsKey(v);
	}

	public boolean hasEdge(Edge edge) {
		return this.map.get(edge.source).contains(edge.dest);
	}

	public Iterable<Vertex> adj() {}
}
