package org.pythonsogood;

import org.pythonsogood.types.DoublyLinkedList;
import org.pythonsogood.types.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
		System.out.println("Initializing empty Singly Linked List");
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.print();

		System.out.println("Putting some data in the Singly Linked List");
		list.push(1);
		list.push(2);
		list.push(3);
		list.print();

		System.out.println("Removing node at index 1");
		list.remove(1);
		list.print();

		System.out.println("Searching for node with value 3");
		System.out.println(list.find(3));

		System.out.println("Initializing Doubly Linked List with initial data");
		DoublyLinkedList<String> list2 = new DoublyLinkedList<>("hello");
		list2.print();

		System.out.println("Putting some data in Doubly Linked List");
		list2.push("world");
		list2.addToStart("hey");
		list2.print();

		System.out.println("Reversing Doubly Linked List");
		list2.reverse();
		list2.print();

		System.out.println("Getting middle element of Doubly Linked List");
		System.out.println(list2.getMiddle().data);
    }
}