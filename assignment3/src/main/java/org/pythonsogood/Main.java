package org.pythonsogood;

public class Main {
	public static void task_1() {
		HashTable<String, String> library = new HashTable<>();
		library.put("4854994630", "Barchester Chronicles");
		library.put("1581668376", "Human Comedy");
		library.put("053439762X", "Fireworks (Hana-bi)");
		library.put("7672614797", "Arthur Newman");
		library.put("3547475252", "Biloxi Blues");
		System.out.println(library);
	}

	public static void task_2() {
		HashTable<Integer, Pair<String, Integer>> employees = new HashTable<>();
		employees.put(1, new Pair<>("John", 50000));
		employees.put(2, new Pair<>("Jane", 60000));
		employees.put(3, new Pair<>("Bob", 70000));
		employees.put(4, new Pair<>("Alice", 80000));
		employees.put(5, new Pair<>("Mark", 90000));
		System.out.println(employees);
	}

	public static void task_3() {
		HashTable<Integer, String> playlist = new HashTable<>();
		playlist.put(1, "carefully memory");
		playlist.put(2, "age source lose");
		playlist.put(3, "organization");
		playlist.put(4, "living pet");
		playlist.put(5, "motor eye");
		System.out.println(playlist);
	}

	public static void task_4() {
		BSTNode<Integer> tree = new BSTNode<>(5);
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		System.out.println(tree.contains(30));
		System.out.println(tree.contains(40));
		System.out.println(tree.getMax());
		tree.inOrder();
	}

	public static void task_5() {
		HashTable<Integer, String> students = new HashTable<>();
		students.put(1, "Jacob");
		students.put(2, "Francis");
		students.put(3, "Jessie");
		students.put(4, "Joseph");
		students.put(5, "Pearl");
		System.out.println(students);
	}

	public static void task_6() {
		FTNode ivan = new FTNode("Ivan", 'M', 1940);

		FTNode alex = new FTNode("Alex", 'M', 1965);
		FTNode david = new FTNode("David", 'M', 1990);
		alex.addChild(david);

		ivan.addChild(alex);

		FTNode anna = new FTNode("Anna", 'F', 1970);
		FTNode mary = new FTNode("Mary", 'F', 1995);
		anna.addChild(mary);

		ivan.addChild(anna);

		ivan.print();
	}

    public static void main(String[] args) {
		System.out.println("Task 1:");
		task_1();
		System.out.println("Task 2:");
		task_2();
		System.out.println("Task 3:");
		task_3();
		System.out.println("Task 4:");
		task_4();
		System.out.println("Task 5:");
		task_5();
		System.out.println("Task 6:");
		task_6();
    }
}