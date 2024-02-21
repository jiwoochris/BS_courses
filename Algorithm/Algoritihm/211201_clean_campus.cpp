#include <stdio.h>

struct DOT {
	double x;
	double y;
}dot[10];

int main() {
	int t, n;

	scanf_s("%d", &t);

	scanf_s("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf_s("%lf %lf", &dot[i].x, &dot[i].y);
	}



	return 0;
}