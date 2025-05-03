package org.pythonsogood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static int task_1(int n) {
		return n != 1 ? n * n + Main.task_1(n - 1) : 1;
	}

	public static int task_2(int n, ArrayList<Integer> arr) {
		return n > 0 ? (arr.size() > n ? arr.get(n - 1) : 0) + Main.task_2(n - 1, arr) : 0;
	}

	public static int task_3(int n) {
		return n > 0 ? n + Main.task_3(n - 1) : 0;
	}

	public static int task_4(double n, double b) {
		return n >= 0 ? (int) Math.pow(b, n) + task_4(n - 1, b) : 0;
	}

	public static String task_5(int n, int... seq) {
		if (n <= 0) {
			return "";
		}

		int a = seq[n - 1];
		String b = Main.task_5(n - 1, seq);

		return b.length() > 0 ? String.format("%d %s", a, b) : String.valueOf(a);
	}

	public static String task_6(int n, String... seq) {
		if (n <= 0) {
			return "";
		}

		String a = seq[n - 1];
		String b = Main.task_6(n - 1, seq);

		return b.length() > 0 ? String.format("%s\n%s", a, b) : a;
	}

	public static String task_7(int n) {
		return Main.task_7(n, new HashMap<>(), 0, 0, "RIGHT", 0, n - 1, n - 1, 0, 1);
	}

	public static String task_7(int n, HashMap<String, Integer> matrix, int horizontal, int vertical, String direction, int top, int bottom, int right, int left, int step) {
		String key = String.format("%d %d", vertical, horizontal);

		if (!matrix.containsKey(key)) {
			matrix.put(key, step);
		} else {
			step--;
		}

		if (top >= bottom && left >= right) {
			String res = "";

			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					res += String.format("%d ", matrix.get(String.format("%d %d", i, j)));
				}

				res += "\n";
			}

			return res.substring(0, res.length() - 1);
		}

		switch (direction) {
			case "RIGHT":
				return horizontal >= right ?
					Main.task_7(n, matrix, horizontal, vertical + 1, "DOWN", top, bottom, right - 1, left, step + 1)
					: Main.task_7(n, matrix, horizontal + 1, vertical, direction, top, bottom, right, left, step + 1);

			case "DOWN":
				return vertical >= bottom ?
					Main.task_7(n, matrix, horizontal - 1, vertical, "LEFT", top, bottom - 1, right, left, step + 1)
					: task_7(n, matrix, horizontal, vertical + 1, direction, top, bottom, right, left, step + 1);

			case "LEFT":
				return horizontal <= left ?
					Main.task_7(n, matrix, horizontal, vertical - 1, "UP", top, bottom, right, left + 1, step + 1)
					: Main.task_7(n, matrix, horizontal - 1, vertical, direction, top, bottom, right, left, step + 1);

			case "UP":
				return vertical <= top ?
					Main.task_7(n, matrix, horizontal + 1, vertical + 1, "RIGHT", top + 1, bottom, right, left, step + 1)
					: Main.task_7(n, matrix, horizontal, vertical - 1, direction, top, bottom, right, left, step + 1);

			default:
				break;
		}

		return "";
	}

	public static String task_8(int n, int k) {
		ArrayList<Integer> arr = new ArrayList<>();

		return Main.task_8(n, k, arr);
	}

	public static String task_8(int n, int k, ArrayList<Integer> arr) {
		if (arr.size() == n) {
			return String.join(" ", arr.stream().map(String::valueOf).toList());
		}

		ArrayList<String> result = new ArrayList<>();
		for (int i=1; i<=k; i++) {
			ArrayList<Integer> arr_i = new ArrayList<>(arr);
			arr_i.add(i);
			result.add(Main.task_8(n, k, arr_i));
		}

		return String.join("\n", result);
	}

	public static String task_9(String s) {
		return Main.task_9(s, "");
	}

	public static String task_9(String s, String _current) {
		if (s.length() == 1) {
			return _current + s;
		}

		ArrayList<String> result = new ArrayList<>();
		for (int i=0; i<s.length(); i++) {
			result.add(Main.task_9(s.replace(String.valueOf(s.charAt(i)), ""), _current + String.valueOf(s.charAt(i))));
		}

		return String.join("\n", result);
	}

	public static String task_10(int n) {
		return Main.task_10_is_power_of_two(n, 1) ? String.format("%d is a power of two", n) : String.format("%d is not a power of two", n);
	}

	public static boolean task_10_is_power_of_two(int n, int _i) {
		return _i > n ? false : _i == n ? true : Main.task_10_is_power_of_two(n, _i * 2);
	}

    public static void main(String[] args) {
		System.out.println(Main.task_1(4));
		System.out.println(Main.task_2(4, new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
		System.out.println(Main.task_3(4));
		System.out.println(Main.task_4(3, 4));
		System.out.println(Main.task_5(3, 1, 2, 3));
		System.out.println(Main.task_6(3, "Abc", "bcdh", "abcdef"));
		System.out.println(Main.task_7(3));
		System.out.println(Main.task_8(2, 3));
		System.out.println(Main.task_9("AB"));
		for (int i=0; i<=32; i++) {
			System.out.println(Main.task_10(i));
		}

		for (int i=0; i<=32; i++) {
			System.out.println(String.format("%d is power of three?: %s", i, extra.power_of_three(i)));
		}
    }
}