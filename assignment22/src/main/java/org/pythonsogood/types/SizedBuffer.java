package org.pythonsogood.types;

import java.util.ArrayList;

public class SizedBuffer<T> {
	private int size;

	private ArrayList<T> buffer = new ArrayList<T>();

	public SizedBuffer(int size) {
		this.size = size;
	}

	public void add(T t) {
		this.buffer.add(t);
		if (this.buffer.size() > size) {
			this.buffer.remove(0);
		}
	}

	public T get(int index) {
		return this.buffer.get(index);
	}

	public int getSize() {
		return this.size;
	}

	public int getLength() {
		return this.buffer.size();
	}

	public T remove(int index) {
		return this.buffer.remove(index);
	}

	public void clear() {
		this.buffer.clear();
	}

	public void print() {
		System.out.println(this.buffer);
	}
}
