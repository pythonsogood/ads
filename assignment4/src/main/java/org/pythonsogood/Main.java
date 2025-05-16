package org.pythonsogood;

public class Main {
    public static void main(String[] args) {
		Vertex glasgow = new Vertex("Glasgow");
		Vertex stirling = new Vertex("Stirling");
		Vertex edinburgh = new Vertex("Edinburgh");
		Vertex perth = new Vertex("Perth");
		Vertex dundee = new Vertex("Dundee");

        Graph graph = new Graph();
		graph.addEdge(glasgow, stirling, 50);
		graph.addEdge(glasgow, edinburgh, 70);
		graph.addEdge(stirling, perth, 40);
		graph.addEdge(edinburgh, stirling, 50);
		graph.addEdge(edinburgh, perth, 100);
		graph.addEdge(perth, dundee, 60);

		System.out.println(graph);
    }
}