package org.pythonsogood;

import java.util.ArrayList;
import java.util.HashMap;

import org.pythonsogood.types.SizedBuffer;

public class Main {
	public static boolean task_1(String code) {
		HashMap<Character, Character> map = new HashMap<Character, Character>() {{
			put(')', '(');
			put(']', '[');
			put('}', '{');
		}};

		ArrayList<Character> stack = new ArrayList<Character>();
		for (int i=0; i<code.length(); i++) {
			if (map.values().contains(code.charAt(i))) {
				stack.add(code.charAt(i));
			} else if (stack.getLast() == map.get(code.charAt(i))) {
				stack.remove(stack.size() - 1);
			} else {
				return false;
			}
		}

		return stack.size() == 0;
	}

	public static String task_2(String s) {
		ArrayList<Character> stack = new ArrayList<Character>();

		for (int i=0; i<s.length(); i++) {
			stack.add(s.charAt(i));
		}

		String reversed = "";

		while (stack.size() > 0) {
			reversed += stack.getLast();
			stack.remove(stack.size() - 1);
		}

		return reversed;
	}

	public static SizedBuffer<Integer> task_3(int size) {
		return new SizedBuffer<Integer>(size);
	}

	public static ArrayList<Integer> task_4(ArrayList<Integer> queue) {
		ArrayList<Integer> reversed = new ArrayList<Integer>();

		for (int i=queue.size()-1; i>=0; i--) {
			reversed.add(queue.get(i));
		}

		return reversed;
	}

	public static Integer task_5(ArrayList<Integer> list, int k) {
		if (list.size() < k) {
			throw new IndexOutOfBoundsException();
		}

		ArrayList<Integer> sorted = new ArrayList<Integer>(list);
		sorted.sort(null);

		return sorted.get(k-1);
	}

	private static void task_6_heapify(ArrayList<Integer> list, int size, int i) {
		// "max-heapify" algorithm

		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < size && list.get(max) < list.get(left)) {
			max = left;
		}

		if (right < size && list.get(max) < list.get(right)) {
			max = right;
		}

		if (max != i) {
			int temp = list.get(i);
			list.set(i, list.get(max));
			list.set(max, temp);

			Main.task_6_heapify(list, size, max);
		}
	}

	public static ArrayList<Integer> task_6(ArrayList<Integer> list) {
		int n = list.size();

		if (n <= 1) {
			return list;
		}

		ArrayList<Integer> sorted = new ArrayList<Integer>();

		for (int i=0; i<list.size(); i++) {
			int x = list.get(i);
			if (!sorted.contains(x)) {
				sorted.add(x);
			}
		}

		n = sorted.size();

		for (int i=n/2; i>-1; i--) {
			Main.task_6_heapify(sorted, n, i);
		}

		for (int i=n-1; i>0; i--) {
			// swapping root element with max
			int temp = sorted.get(i);
			sorted.set(i, sorted.get(0));
			sorted.set(0, temp);

			Main.task_6_heapify(sorted, i, 0);
		}

		System.out.println(list);
		System.out.println(String.format("HEAPSORT ARRAY SIZE: %d", n));

		return sorted;
	}

	public static ArrayList<Integer> task_7(ArrayList<Integer> list) {
		int n = list.size();

		ArrayList<Integer> sorted = new ArrayList<Integer>(list);

		// "Bubble" sort
        for (int i=0; i<n-1; i++) {
			boolean swapped = false;

            for (int j=0; j<n-1-i; j++) {
                if (sorted.get(j) > sorted.get(j + 1)) {
                    int temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

		return sorted;
	}

    public static void main(String[] args) {
        System.out.println(Main.task_1("{([])}"));
        System.out.println(Main.task_1("([)]}"));

        System.out.println(Main.task_2("Hello world,"));

		SizedBuffer<Integer> buffer = Main.task_3(3);
		buffer.add(1);
		buffer.add(2);
		buffer.add(3);
		buffer.print();
		buffer.add(4);
		buffer.print();

        System.out.println(Main.task_4(new ArrayList<Integer>() {{ add(1); add(2); add(3); add(4); add(5); }}));

        System.out.println(Main.task_5(new ArrayList<Integer>() {{ add(2); add(3); add(1); add(5); add(4); }}, 2));

        System.out.println(Main.task_6(new ArrayList<Integer>() {{ add(3); add(2); add(4); add(1); add(3); add(2); }}));

        System.out.println(Main.task_7(new ArrayList<Integer>() {{ add(3); add(2); add(4); add(1); }}));
    }
}