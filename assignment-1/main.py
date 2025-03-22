from typing import Literal


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

def task_7(n: int, matrix: dict[str, int]=None, horizontal: int=0, vertical: int=0, direction: Literal["UP", "DOWN", "RIGHT", "LEFT"]="RIGHT", top: int=0, bottom: int=None, right: int=None, left: int=0, step: int=1) -> str:
	if matrix is None:
		matrix = {}

	if bottom is None:
		bottom = n - 1

	if right is None:
		right = n - 1

	if f"{vertical} {horizontal}" not in matrix:
		matrix[f"{vertical} {horizontal}"] = step
	else:
		step-=1

	if top >= bottom and left >= right:
		res = ""
		for i in range(n):
			for j in range(n):
				res += f"{matrix[f'{i} {j}']} "
			res += "\n"
		return res[:-1]

	if direction == "RIGHT":
		if horizontal >= right:
			return task_7(n, matrix, horizontal, vertical + 1, "DOWN", top, bottom, right-1, left, step + 1)

		return task_7(n, matrix, horizontal + 1, vertical, direction, top, bottom, right, left, step + 1)
	elif direction == "DOWN":
		if vertical >= bottom:
			return task_7(n, matrix, horizontal - 1, vertical, "LEFT", top, bottom - 1, right, left, step + 1)

		return task_7(n, matrix, horizontal, vertical + 1, direction, top, bottom, right, left, step + 1)
	elif direction == "LEFT":
		if horizontal <= left:
			return task_7(n, matrix, horizontal, vertical - 1, "UP", top, bottom, right, left + 1, step + 1)

		return task_7(n, matrix, horizontal - 1, vertical, direction, top, bottom, right, left, step + 1)
	elif direction == "UP":
		if vertical <= top:
			return task_7(n, matrix, horizontal + 1, vertical + 1, "RIGHT", top + 1, bottom, right, left, step + 1)

		return task_7(n, matrix, horizontal, vertical - 1, direction, top, bottom, right, left, step + 1)

def task_8(n: int, k: int, arr: list[list[int]]=None) -> str:
	if arr is None:
		arr = []

	if len(arr) == n:
		return " ".join(str(i) for i in arr)

	return "\n".join([task_8(n, k, arr+[i]) for i in range(1, k+1)])

def task_9(s: str, _current: str="") -> str:
	if len(s) == 1:
		return _current + s

	return "\n".join([task_9(s.replace(i, ""), _current + i) for i in s])

def task_10(n: int, _i: int=1) -> str:
	if _i > n:
		return f"{n} is not a power of two"

	if _i == n:
		return f"{n} is power of two"

	return task_10(n, _i*2)


if __name__ == "__main__":
	print(task_1(4))
	print(task_2(4, [1, 2, 3, 4, 5]))
	print(task_3(4))
	print(task_4(3, 4))
	print(task_5(3, 1, 2, 3))
	print(task_6(3, "Abc", "bcdh", "abcdef"))
	print(task_7(3))
	print(task_8(n=2, k=3))
	print(task_9("AB"))
	for i in range(10):
		print(task_10(i))
