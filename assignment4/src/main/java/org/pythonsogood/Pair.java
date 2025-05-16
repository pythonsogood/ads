package org.pythonsogood;

public class Pair<A, B> {
	public final A a;
	public final B b;

	public Pair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s)", this.a, this.b);
	}
}
