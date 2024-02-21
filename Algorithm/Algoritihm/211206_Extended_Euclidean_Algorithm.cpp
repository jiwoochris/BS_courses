#include <stdio.h>

int extended_euclid(int a, int b, int* x, int* y) {
	if (b == 0) {
		*x = 1;
		*y = 0;
		return a;
	}
		
	else {
		int x1, y1;
		int d = extended_euclid(b, a % b, &x1, &y1);

		*x = y1;
		*y = x1 - a / b * y1;

		return d;
	}
}

int main() {

	int a = 12345;
	int b = 123;

	int x;
	int y;

	printf("%d %d %d\n", x, y, extended_euclid(a, b, &x, &y));

	return 0;
}