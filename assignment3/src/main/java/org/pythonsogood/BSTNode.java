package org.pythonsogood;

public class BSTNode<T extends Comparable<T>> {
	public T value;
	public BSTNode<T> left;
	public BSTNode<T> right;

	public BSTNode(T value) {
		this.value = value;
	}

	public void insert(T value) {
		if (value.compareTo(this.value) < 0) {
			if (this.left == null) {
				this.left = new BSTNode<T>(value);
			} else {
				this.left.insert(value);
			}
		} else {
			if (this.right == null) {
				this.right = new BSTNode<T>(value);
			} else {
				this.right.insert(value);
			}
		}
	}

	public T getMin() {
		if (this.left == null) {
			return this.value;
		} else {
			return this.left.getMin();
		}
	}

	public T getMax() {
		if (this.right == null) {
			return this.value;
		} else {
			return this.right.getMax();
		}
	}

	public BSTNode<T> delete(T value) {
		if (value.compareTo(this.value) < 0) {
			if (this.left == null) {
				return null;
			}
			this.left = this.left.delete(value);
		} else if (value.compareTo(this.value) > 0) {
			if (this.right == null) {
				return null;
			}
			this.right = this.right.delete(value);
		} else {
			if (this.left == null && this.right == null) {
				return null;
			} else if (this.left == null) {
				return this.right;
			} else if (this.right == null) {
				return this.left;
			} else {
				this.value = this.right.getMin();
				this.right = this.right.delete(this.value);
			}
		}
		return this;
	}

	public boolean contains(T value) {
		if (value.compareTo(this.value) < 0) {
			if (this.left == null) {
				return false;
			}
			return this.left.contains(value);
		} else if (value.compareTo(this.value) > 0) {
			if (this.right == null) {
				return false;
			}
			return this.right.contains(value);
		} else {
			return true;
		}
	}

	public void inOrder() {
		this.inOrder(true);
	}

	private void inOrder(boolean root) {
		if (this.left != null) {
			this.left.inOrder(false);
		}
		System.out.print(this.value + " ");
		if (this.right != null) {
			this.right.inOrder(false);
		}

		if (root) {
			System.out.println();
		}
	}
}
