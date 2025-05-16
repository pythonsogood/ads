package org.pythonsogood;

public class Main {
	public static void task_1() {
		Graph cityMap = new Graph(false);
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");

		cityMap.addEdge(a, b, 2);
		cityMap.addEdge(a, c, 4);
		cityMap.addEdge(b, c, 1);
		cityMap.addEdge(b, d, 7);
		cityMap.addEdge(c, e, 3);

		System.out.println("City Transport Network:");
		System.out.println(cityMap);

		Pair<Iterable<Vertex>, Integer> result = cityMap.shortestPath(a, e);
		System.out.println(String.format("Shortest path from A to E: %s (%d)", result.a, result.b));
	}

	public static void task_2() {
		Graph deliveryMap = new Graph(true);
		Vertex restaurant = new Vertex("Restaurant");
		Vertex customer1 = new Vertex("Customer1");
		Vertex customer2 = new Vertex("Customer2");
		Vertex hub = new Vertex("Hub");

		deliveryMap.addEdge(restaurant, hub, 3);
		deliveryMap.addEdge(hub, customer1, 2);
		deliveryMap.addEdge(hub, customer2, 5);
		deliveryMap.addEdge(restaurant, customer2, 10);

		System.out.println("Delivery Route Map:");
		System.out.println(deliveryMap);

		Pair<Iterable<Vertex>, Integer> deliveryPath = deliveryMap.shortestPath(restaurant, customer1);
		System.out.println(String.format("Optimal delivery path to Customer1: %s (%d)", deliveryPath.a, deliveryPath.b));
	}

	public static void task_3() {
		Graph airlineRoutes = new Graph(true);
		Vertex ny = new Vertex("New York");
		Vertex london = new Vertex("London");
		Vertex paris = new Vertex("Paris");
		Vertex dubai = new Vertex("Dubai");
		Vertex tokyo = new Vertex("Tokyo");

		airlineRoutes.addEdge(ny, london, 7);
		airlineRoutes.addEdge(london, paris, 1);
		airlineRoutes.addEdge(paris, dubai, 6);
		airlineRoutes.addEdge(dubai, tokyo, 9);
		airlineRoutes.addEdge(ny, dubai, 10);

		System.out.println("Airline Flight Routes:");
		System.out.println(airlineRoutes);

		Pair<Iterable<Vertex>, Integer> flightPath = airlineRoutes.shortestPath(ny, tokyo);
		System.out.println(String.format("Fastest flight path from New York to Tokyo: %s (%d)", flightPath.a, flightPath.b));
	}

	public static void task_4() {
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

		System.out.println(graph.shortestPath(glasgow, dundee));
	}

	public static void main(String[] args) {
		System.out.println("Task 1:");
		task_1();
		System.out.println("Task 2:");
		task_2();
		System.out.println("Task 3:");
		task_3();
		System.out.println("Task 4:");
		task_4();
	}
}