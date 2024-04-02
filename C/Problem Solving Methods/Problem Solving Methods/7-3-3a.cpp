#include <stdio.h>

int secs(int hours, int minutes, int seconds) {
	seconds = hours * 3600 + minutes * 60 + seconds;
	return seconds;
}


int main() {
	int hours[] = { 5, 3, 12, 0 };
	int minutes[] = { 1, 40, 59, 23 };
	int seconds[] = { 4, 47, 20, 0 };

	for (int i = 0; i < 4; i++) {
		printf("\n");
		printf(" hours : %d, minutes : %d, second : %d", hours[i], minutes[i], seconds[i]);
		printf(" ==> total number of seconds : %d", secs(hours[i], minutes[i], seconds[i]));
		printf("\n");
	}

	return 0;
}