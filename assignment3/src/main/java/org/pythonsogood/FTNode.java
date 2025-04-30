package org.pythonsogood;

import java.util.ArrayList;
import java.util.List;

public class FTNode {
	public String name;
	public char gender;
	public int birth_year;

	public List<FTNode> children = new ArrayList<>();

	public FTNode(String name, char gender, int birth_year) {
		this.name = name;
		this.gender = gender;
		this.birth_year = birth_year;
	}

	public void addChild(FTNode child) {
		this.children.add(child);
	}

	public void print() {
		this.print(0);
	}

	public void print(int level) {
		String result = this.toStringRelative(level);
		System.out.println(String.format("%s%s", "  ".repeat(level), result));
		for (FTNode child : this.children) {
			child.print(level + 1);
		}
	}

	@Override
	public String toString() {
		return String.format("%s (%c, b. %d)", this.name, this.gender, this.birth_year);
	}

	public String toStringRelative(int level) {
		if (level == 0) {
			return this.toString();
		}

		String relation = "grand".repeat(level - 1) + (this.gender == 'M' ? "son" : "daughter");

		return String.format("%s (%c, b. %d) - %s", this.name, this.gender, this.birth_year, relation);
	}
}
