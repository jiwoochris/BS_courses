#include<stdio.h>

struct return_v {
    int x;
    int y;
    int d;
};

struct return_v r;

struct return_v Euclid(int a, int b) {
    struct return_v rv;

    if (b == 0) {
        rv.d = a;
        rv.x = 1;
        rv.y = 0;
        return rv;
    }

    else {
        r = Euclid(b, a % b);

        rv.d = r.d;
        rv.x = r.y;
        rv.y = r.x - (a / b) * r.y;

        return rv;
    }
}

void main()
{
    int a, b;

    scanf_s("%d", &a);
    scanf_s("%d", &b);

    r = Euclid(a, b);
    printf("%d %d %d\n", r.x, r.y, r.d);
}