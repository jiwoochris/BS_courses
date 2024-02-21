#include <stdio.h>
#include <math.h>

struct DOT {
	double x;
	double y;
}dot[30];

void get_input(int* num) {
	scanf_s("%d", num);

	for (int i = 0; i < *num; i++) {
		scanf_s("%lf %lf", &dot[i].x, &dot[i].y);
	}
}

double distance(DOT a, DOT b) {
	return sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
}

void get_distance(DOT dot[], int num, double distance_table[30][30], int used_set[30]) {
	for (int i = 0; i < num; i++) {
		for (int j = 0; j < num; j++) {
			distance_table[i][j] = distance(dot[i], dot[j]);
		}
		used_set[i] = 0;
	}
}

void get_minimum_ink(int num, double distance_table[30][30], int used_set[30], double * output) {
	int selected_set[30];
	int selceted_num = 0;
	double min = 9999;
	int min_i;
	int min_j;

	selected_set[selceted_num] = 0;
	selceted_num++;

	while (num != selceted_num) {
		for (int i = 0; i < num; i++) {
			for (int j = i + 1; j < num; j++) {
				for (int s = 0; s < selceted_num; s++) {
					if (i == selected_set[s] && (used_set[i] == 0 || used_set[j] == 0)) {
						if (min > distance_table[i][j]) {
							min = distance_table[i][j];
							min_i = i;
							min_j = j;
						}
					}
				}
			}
		}
		used_set[min_i] = 1;
		used_set[min_j] = 1;

		selected_set[selceted_num] = min_j;
		selceted_num++;
		*output += min;
		min = 9999;
	}
}

int main() {
	int num;
	double distance_table[30][30];
	int used_set[30];
	double output=0;

	get_input(&num);

	get_distance(dot, num, distance_table, used_set);

	get_minimum_ink(num, distance_table, used_set, &output);

	printf("Output : %lf\n", output);

	return 0;
}