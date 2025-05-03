package org.pythonsogood.types;

public class SinglyLinkedList<T> {
	private Node<T> start;

	public SinglyLinkedList(T data) {
		this.start = new Node<T>(data);
	}

	public SinglyLinkedList() {}

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

	public Node<T> getOptional(int index) {
		try {
			return get(index);
		} catch (IndexOutOfBoundsException e) {
			return null;
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

		if (current.next != null) {
			current.next = current.next.next;
		} else {
			this.start = null;
		}
	}

	public void push(T data) {
		Node<T> current = this.start;
		if (current == null) {
			this.start = new Node<T>(data);
			return;
		}
		while (current.next != null) {
			current = current.next;
		}

		current.next = new Node<T>(data);
	}

	public Node<T> pop() {
		Node<T> current = this.start;
		if (current == null) {
			return null;
		}
		while (current.next.next != null) {
			current = current.next;
		}

		Node<T> node = current.next;
		current.next = null;
		return node;
	}

	public Node<T> shift() {
		Node<T> node = this.start;
		if (node == null) {
			return null;
		}
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

	public Node<T> find(T data) {
		Node<T> node = this.getOptional(this.indexOf(data));
		if (node == null) {
			return null;
		}
		return node;
	}

	public void clear() {
		this.start = null;
	}

	public void reverse() {
		Node<T> current = this.start;
		Node<T> prev = null;
		Node<T> next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		this.start = prev;
	}

	public void print() {
		Node<T> current = this.start;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public static class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}
}
