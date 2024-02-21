#include <stdio.h>
#include <string.h>

int subsequenceCount(char* S, char* T) {

	int j_len = strlen(S);
	int i_len = strlen(T);
	int table[20][20];

	for (int i = 0; i < i_len + 1; i++) {
		for (int j = 0; j < j_len + 1; j++) {
			if (i == 0)
				table[i][j] = 1;
			else if (i > j)
				table[i][j] = 0;
			else if (T[i-1] == S[j-1])
				table[i][j] = table[i][j-1] + table[i - 1][j - 1];
			else if (T[i-1] != S[j-1])
				table[i][j] = table[i][j - 1];
		}
	}

	/*for (int i = 0; i < i_len + 1; i++) {
		for (int j = 0; j < j_len + 1; j++) {
			printf("%d ", table[i][j]);
		}
		printf("\n");
	}*/

	return table[i_len][j_len];
}

int main() {
	int N;
	char X[20];
	char Z[20];

	printf("Number of test cases : ");
	scanf_s("%d", &N);

	for(int i=0; i< N; i++){
		printf("string X : ");
		scanf_s("%s", X, sizeof(X));
		printf("string Z : ");
		scanf_s("%s", Z, sizeof(Z));

		printf("Output : %d\n\n", subsequenceCount(X, Z));
	}
	


	return 0;
}