#include <stdio.h>

int main() {
	int num;
	int student[100];
	int sum = 0;
	int avg;
	int output=0;


	while (1) {
		printf("Type the number of students (End: '0') : ");
		scanf_s("%d", &num);

		if (num == 0)
			break;

		for (int i = 0; i < num; i++) {
			printf("%d-th money spent : ", i + 1);
			scanf_s("%d", &student[i]);
		}

		for (int i = 0; i < num; i++)
			sum += student[i];

		avg = sum / num;

		for (int i = 0; i < num; i++)
			if (student[i] - avg > 0)
				output += student[i] - avg;

		printf("The money exchange is %d (Won)\n\n", output);

		sum = 0;
		output = 0;
	}
}