#include <stdio.h>

int main() {
	int r, c;
	int matrix[10][100];
	int way[10][100];
	int path[100];
	int up, down, go;
	int min;

	while (1){
		printf("\nEnter number of rows and columns (exit : 0) : ");
		scanf_s("%d %d", &r, &c);

		if (r == 0)
			return 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				scanf_s("%d", &matrix[i][j]);
			}
		}

		for (int j = 0; j < c; j++) {
			for (int i = 0; i < r; i++) {
				way[i][j] = 9999;

				up = i + 1;
				go = i;
				down = i - 1;

				if (i == 0)
					down = r - 1;
				else if (i == r - 1)
					up = 0;

				if (i == 0 && j == 0)
					way[i][j] = matrix[i][j];

				if (j > 0 && (way[up][j - 1] != 9999 || way[go][j - 1] != 9999 || way[down][j - 1] != 9999)) {
					min = way[up][j - 1];

					if (min > way[go][j - 1])
						min = way[go][j - 1];

					if (min > way[down][j - 1])
						min = way[down][j - 1];

					way[i][j] = matrix[i][j] + min;
				}
			}
		}

		path[0] = 0;
		path[c - 1] = r - 1;

		for (int j = c - 1; j > 0; j--) {
			int i = path[j];

			up = i + 1;
			go = i;
			down = i - 1;

			if (i == 0)
				down = r - 1;
			else if (i == r - 1)
				up = 0;

			min = way[up][j - 1];
			path[j - 1] = up;

			if (min > way[go][j - 1]) {
				min = way[go][j - 1];
				path[j - 1] = go;
			}

			if (min > way[down][j - 1]) {
				min = way[down][j - 1];
				path[j - 1] = down;
			}
		}

		printf("\n");
		for (int i = 0; i < c; i++)
			printf("%d ", path[i] + 1);
		printf("\n%d\n", way[r - 1][c - 1]);
	}

	return 0;
}