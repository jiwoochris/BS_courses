#include <stdio.h>
#include <math.h>
#include <limits.h>

#define MAX_N 1000

struct point {
	double x, y;
};

double distance(struct point p1, struct point p2) {
	double dist;
	dist = sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	return dist;
}

int orientation(struct point p, struct point q, struct point r) {
	double val = (q.y - p.y) * (r.x - q.x) -
		(q.x - p.x) * (r.y - q.y);

	if (val == 0.0) return 0;  // collinear
	return (val > 0.0) ? 1 : 2; // clock or counterclock wise
}

void javis_convex_hull(int n, int* m, struct point* points) {
	if (n < 3)
		return;

	int first_point = points[0].y;

	for (int i = 0; i < n; i++) {
		if (points[i].y < first_point)
			first_point = i;
	}

	struct point result[MAX_N];

	result[0] = points[first_point];

	int new_point;
}


void solve(int n, struct point* p) {
	int m;
	double total_len = 0;
	double formatted_len;
	double min_dist = INT_MAX;
	int min_index = -1;
	int i;

	if (n > 1) {
		javis_convex_hull(n, &m, p);

		for (i = 0; i <= m; i++) {
			int j = (i + 1) % (m + 1);
			double dist1 = sqrt(p[i].x * p[i].x + p[i].y * p[i].y);
			double dist2 = sqrt(p[j].x * p[j].x + p[j].y * p[j].y);

			if (dist1 + dist2 < min_dist) {
				min_dist = dist1 + dist2;
				min_index = i;
			}
			total_len += distance(p[i], p[j]);
		}
		total_len -= distance(p[min_index], p[(min_index + 1) % (m + 1)]);
		total_len += min_dist;
	}
	else {
		total_len = sqrt(p[0].x + p[0].x + p[0].y * p[0].y) * 2;
	}

	total_len += 2.0;

	formatted_len = (double)((int)(total_len * 100)) / 100.0;
	if (formatted_len < total_len) formatted_len += 0.01;

	printf("\nResult: %.2lf\n", formatted_len);
}

void main(void) {
	char str[256];
	int num_of_set;
	double px, py;
	int i, j;
	struct point p[MAX_N];
	int num_of_point;

	printf("Type the number of testing sets:");
	scanf_s("%d", &num_of_set);

	for (i = 0; i < num_of_set; i++) {
		printf("\nType the number of points:");
		scanf_s("%d", &num_of_point);
		for (j = 0; j < num_of_point; j++) {
			printf("Type %d-th point position (x, y):", j);
			scanf_s("%lf %lf", &px, &py);
			p[j].x = px;
			p[j].y = py;
		}
		solve(num_of_point, p);
		if (i < num_of_set - 1) {
			printf("\n");
		}
	}
}