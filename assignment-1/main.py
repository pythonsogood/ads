def task_1(n: int) -> int:
	return n ** 2 + task_1(n-1) if n != 1 else 1

def task_2(n: int, arr: list[int]) -> int:
	return (arr[n-1] if len(arr) > n else 0) + task_2(n-1, arr) if n > 0 else 0

def task_3(n: int) -> int:
	return n + task_3(n-1) if n > 0 else 0

def task_4(n: int, b: int) -> int:
	return b ** n + task_4(n-1, b) if n >= 0 else 0

def task_5(n: int, *seq: tuple[int, ...]) -> str:
	if n > 0:
		a, b = seq[n-1], task_5(n-1, *seq)
		return f"{a} {b}" if len(b) > 0 else f"{a}"
	return ""

def task_6(n: int, *strs: tuple[str, ...]) -> str:
	if n > 0:
		a, b = strs[n-1], task_6(n-1, *strs)
		return f"{a}\n{b}" if len(b) > 0 else f"{a}"
	return ""

def task_7(n: int, _stage: int=0) -> str:
	if _stage > n :
		return ""
	res = ""
	if _stage % 4 == 0:
		for i in range(n):
			res += str(i + n * _stage) + " "
	elif _stage % 2 == 0:

	return res + "\n" + task_7(n, _stage+1) if _stage+1 < n else res


if __name__ == "__main__":
	print(task_1(4))
	print(task_2(4, [1, 2, 3, 4, 5]))
	print(task_3(4))
	print(task_4(3, 4))
	print(task_5(3, 1, 2, 3))
	print(task_6(3, "Abc", "bcdh", "abcdef"))
	print(task_7(3))
