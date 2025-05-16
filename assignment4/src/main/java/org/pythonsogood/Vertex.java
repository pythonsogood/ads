package org.pythonsogood;

import java.util.UUID;

public class Vertex {
	public String name;

	public Vertex(String name) {
		this.name = name;
	}

	public Vertex() {
		this(UUID.randomUUID().toString());
	}

	@Override
	public String toString() {
		return this.name;
	}
}
