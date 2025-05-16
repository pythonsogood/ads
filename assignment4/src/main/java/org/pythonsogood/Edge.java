package org.pythonsogood;

public class Edge {
	public final Vertex source;
	public final Vertex dest;
	public Double weight;

	public Edge(Vertex source, Vertex dest, Double weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return String.format("%s (%d)-> %s", this.source, this.weight, this.dest);
	}
}
