#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int pancakes[30];
int output[30];
int i = 0;
int r = 0;

void flip(int f) {
	int newpancakes[30] = { 0 };

	for (int n = 0; n < i - f + 1; n++) {
		newpancakes[n] = pancakes[i - n - f];
	}

	for (int n = 0; n < i - f + 1; n++) {
		pancakes[n] = newpancakes[n];
	}

	output[r] = f;
	r++;

	/* printf("flip! %d\n", f);
	for (int j = 0; j < i; j++)
		printf("%d ", pancakes[j]); */
}

void stacking(int i) {
	for (int k = i; k > 0; k--) {
		int max = 0, max_num = 0;

		if (k == 1)
			output[r] = 0;
		else {
			for (int j = 0; j < k; j++) {
				if (pancakes[j] > max) {
					max = pancakes[j];
					max_num = j;
				}
			}

			if (max_num == 0) {
				flip(i - k + 1);
			}
			else if (max_num != k - 1) {
				flip(i - max_num);
				flip(i - k + 1);
			}
		}
	}
}

int main() {
	char input[100];
	char* str = NULL;

	while (1) {
		gets_s(input, sizeof(input));

		char* ptr = strtok_s(input, " ", &str);
		pancakes[i] = atoi(ptr);

		while (1) {
			i++;
			ptr = strtok_s(NULL, " ", &str);
			if (ptr == NULL)
				break;
			pancakes[i] = atoi(ptr);
		}

		for (int j = 0; j < i; j++)
			printf("%d ", pancakes[j]);

		stacking(i);

		printf("\n");

		for (int j = 0; j <= r; j++)
			printf("%d ", output[j]);

		printf("\n\n");

		i = 0;
		r = 0;
		str = NULL;
	}

	return 0;
}