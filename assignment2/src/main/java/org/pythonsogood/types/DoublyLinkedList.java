package org.pythonsogood.types;

import java.util.Optional;

public class DoublyLinkedList<T> {
	private Node<T> start;

	public DoublyLinkedList(T data) {
		this.start = new Node(data);
	}

	public int size() {
		int size = 0;
		Node<T> current = this.start;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	public boolean isEmpty() {
		return this.start == null;
	}

	public Node<T> get(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> current = this.start;
		if (current == null) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = 0; i < index; i++) {
			current = current.next;

			if (current == null) {
				throw new IndexOutOfBoundsException();
			}
		}

		return current;
	}

	public Optional<Node<T>> getOptional(int index) {
		try {
			return Optional.of(get(index));
		} catch (IndexOutOfBoundsException e) {
			return Optional.empty();
		}
	}

	public void insert(int index, T data) {
		Node<T> current = this.start;
		if (current == null) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = 0; i < index; i++) {
			current = current.next;

			if (current == null) {
				throw new IndexOutOfBoundsException();
			}
		}

		current.data = data;
	}

	public void remove(int index) {
		Node<T> current = this.start;
		if (current == null) {
			throw new IndexOutOfBoundsException();
		}

		for (int i = 0; i < index - 1; i++) {
			current = current.next;

			if (current == null) {
				throw new IndexOutOfBoundsException();
			}
		}

		current.next = current.next.next;
	}

	public void push(T data) {
		Node<T> current = this.start;
		while (current.next != null) {
			current = current.next;
		}

		current.next = new Node(data);
	}

	public Node<T> pop() {
		Node<T> current = this.start;
		while (current.next.next != null) {
			current = current.next;
		}

		Node<T> node = current.next;
		current.next = null;
		return node;
	}

	public Node<T> shift() {
		Node<T> node = this.start;
		this.start = this.start.next;
		return node;
	}

	public int indexOf(T data) {
		Node<T> current = this.start;
		int index = 0;
		while (current != null) {
			if (current.data.equals(data)) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(T data) {
		return this.indexOf(data) != -1;
	}

	public Optional<T> find(T data) {
		Optional<Node<T>> node = this.getOptional(this.indexOf(data));
		if (node.isPresent()) {
			return Optional.of(node.get().data);
		}
		return Optional.empty();
	}

	public void clear() {
		this.start = null;
	}

	public void print() {
		Node<T> current = this.start;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public Optional<Node<T>> getMiddle() {
		int size = this.size();
		return this.getOptional(Math.floorDiv(size, 2));
	}

	public static class Node<T> {
		public T data;
		public Node<T> next;
		public Node<T> prev;

		public Node(T data) {
			this.data = data;
		}
	}
}
