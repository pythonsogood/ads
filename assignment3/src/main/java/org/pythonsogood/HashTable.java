package org.pythonsogood;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {
	public List<Node<K, V>> chains;
	public int M;
	private int size = 0;

	public HashTable() {
		this(11);
	}

	public HashTable(int M) {
		this.M = M;
		this.chains = new ArrayList<Node<K, V>>(M);

		for (int i=0; i<M; i++) {
			this.chains.add(null);
		}
	}

	private int hash(K key) {
		return Math.floorMod(this._hash(key), this.M);
	}

	protected int _hash(Object key) {
		if (key == null) {
			return 0;
		}

		int hash = 0;

		switch (key) {
			case String x:
				for (int i=0; i<x.length(); i++) {
					hash = x.charAt(i) + (31 * hash);
				}
				break;

			case Integer x:
				hash = x;
				break;

			case List<?> x:
				hash = 1;

				for (int i=0; i<x.size(); i++) {
					hash = 31 * hash + this._hash(x.get(i));
				}
				break;

			default:
				hash = key.hashCode();
				break;
		}

		return hash;
	}

	public void put(K key, V value) {
		int index = this.hash(key);
		Node<K, V> head = this.chains.get(index);
		Node<K, V> current = head;

		while (current != null) {
			if (current.key.equals(key)) {
				current.value = value;
				return;
			}

			current = current.next;
		}

		Node<K, V> node = new Node<K, V>(key, value);
		node.next = head;
		this.chains.set(index, node);
		this.size++;
	}

	public V get(K key) {
		int index = this.hash(key);
		Node<K, V> head = this.chains.get(index);
		Node<K, V> current = head;

		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}

			current = current.next;
		}

		return null;
	}

	public V remove(K key) {
		int index = this.hash(key);
		Node<K, V> head = this.chains.get(index);
		Node<K, V> current = head;
		Node<K, V> previous = null;

		while (current != null) {
			if (current.key.equals(key)) {
				if (previous == null) {
					this.chains.set(index, current.next);
				} else {
					previous.next = current.next;
				}

				this.size--;
				return current.value;
			}

			previous = current;
			current = current.next;
		}

		return null;
	}

	public boolean contains(K key) {
		return this.get(key) != null;
	}

	public K getKey(V value) {
		for (Node<K, V> head : this.chains) {
			Node<K, V> current = head;

			while (current != null) {
				if (current.value.equals(value)) {
					return current.key;
				}

				current = current.next;
			}
		}

		return null;
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		ArrayList<String> result = new ArrayList<>();
		for (int i=0; i<this.M; i++) {
			if (this.chains.get(i) != null) {
				result.add(String.format("%s", this.chains.get(i)));
			}
		}
		return "{\n\t" + String.join(",\n\t", result) + "\n}";
	}

	public static class Node<K, V> {
		public K key;
		public V value;
		public Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			String key = this.key instanceof String ? "\"" + this.key + "\"" : this.key.toString();
			String value = this.value instanceof String ? "\"" + this.value + "\"" : this.value.toString();
			return String.format("%s: %s", key, value);
		}
	}
}