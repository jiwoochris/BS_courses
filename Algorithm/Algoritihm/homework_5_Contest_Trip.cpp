#include <stdio.h>
#include <string.h>

struct TRAIN {
	char depart_city[80];
	char arrive_city[80];
	int depart_time;
	int arrive_time;
};

struct STATION {
	char city_name[80];
	int come_time;
	int leave_time;
};

struct STATION * findStruct(STATION s[], char * name, int n) {
	for (int i = 0; i < n; i++) {
		if (strcmp(s[i].city_name, name) == 0)
			return &s[i];
	}
}

int main() {
	int repeat_n;
	int city_number;
	int railroad_number;
	struct TRAIN t[100];
	struct STATION s[100];
	int lines;
	char start_city[80];
	char destination_city[80];
	int starting_time;
	int output_departure;
	int output_arrival;
	
	scanf_s("%d", &repeat_n);

	for (int n = 0; n < repeat_n; n++) {
		lines = 0;
		scanf_s("%d", &city_number);

		for (int i = 0; i < city_number; i++) {
			scanf_s("%s", s[i].city_name, 80);
		}

		scanf_s("%d", &railroad_number);

		for (int i = 0; i < railroad_number; i++) {
			int line_number;
			int time;
			char station[80];

			scanf_s("%d", &line_number);
			for (int j = 0; j < line_number; j++) {
				if (j == 0) {
					scanf_s("%d %s", &time, station, 80);
					strcpy_s(t[lines].depart_city, station);
					t[lines].depart_time = time;
				}

				if ((0 < j) && (j < line_number - 1)) {
					scanf_s("%d %s", &time, station, 80);
					strcpy_s(t[lines].arrive_city, station);
					t[lines].arrive_time = time;
					lines++;

					strcpy_s(t[lines].depart_city, station);
					t[lines].depart_time = time;
				}

				if (j == line_number - 1) {
					scanf_s("%d %s", &time, station, 80);
					strcpy_s(t[lines].arrive_city, station);
					t[lines].arrive_time = time;
					lines++;
				}
			}
		}

		scanf_s("%d", &starting_time);
		scanf_s("%s", start_city, 80);
		scanf_s("%s", destination_city, 80);


		//printf("%d\n", lines);
		//for (int i = 0; i < lines; i++) {
		//	printf("%s %d %s %d\n", t[i].depart_city, t[i].depart_time, t[i].arrive_city, t[i].arrive_time);
		//}


		for (int i = 0; i < city_number; i++) {
			if (strcmp(s[i].city_name, start_city) == 0) {
				s[i].come_time = starting_time;
				s[i].leave_time = starting_time;
			}
			else if (strcmp(s[i].city_name, destination_city) == 0) {
				s[i].come_time = 9999;
				s[i].leave_time = 0;
			}
			else {
				s[i].come_time = 9999;
				s[i].leave_time = 9999;
			}
		}

		for (int i = 0; i < city_number; i++) {
			for (int j = 0; j < railroad_number; j++) {
				if ((findStruct(s, t[j].depart_city, city_number)->come_time <= t[j].depart_time) && (findStruct(s, t[j].arrive_city, city_number)->come_time >= t[j].arrive_time)) {
					findStruct(s, t[j].depart_city, city_number)->leave_time = t[j].depart_time;
					findStruct(s, t[j].arrive_city, city_number)->come_time = t[j].arrive_time;
				}
			}
		}

		output_arrival = findStruct(s, destination_city, city_number)->come_time;
		output_departure = findStruct(s, start_city, city_number)->leave_time;

		for (int j = 0; j < railroad_number; j++) {
			if ((findStruct(s, t[j].depart_city, city_number)->come_time <= t[j].depart_time) && (findStruct(s, t[j].arrive_city, city_number)->come_time >= t[j].arrive_time) && (findStruct(s, t[j].arrive_city, city_number)->leave_time != 9999)) {
				findStruct(s, t[j].depart_city, city_number)->leave_time = t[j].depart_time;
				findStruct(s, t[j].arrive_city, city_number)->come_time = t[j].arrive_time;
				if (output_departure < findStruct(s, start_city, city_number)->leave_time)
					output_departure = findStruct(s, start_city, city_number)->leave_time;
			}
		}

		if (output_arrival == 9999)
			printf("No connection");
		else
			printf("\nDeparture\t%04d\t%s\nArrival\t%04d\t%s\n", output_departure, start_city, output_arrival, destination_city);
	}

	return 0;
}