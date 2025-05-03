package org.pythonsogood;

public class extra {
	public static boolean power_of_three(int n, int i_) {
		return i_ > n ? false : i_ == n ? true : power_of_three(n, i_ * 3);
	}

	public static boolean power_of_three(int n) {
		return power_of_three(n, 1);
	}
}
