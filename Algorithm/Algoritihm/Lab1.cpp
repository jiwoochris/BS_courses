//#include <stdio.h>
//
//struct extended_euclid {
//    int x;
//    int y;
//    int d;
//}result;
//
//struct extended_euclid solve(int a, int b) {
//    struct extended_euclid ee;
//    if (b == 0) {
//        ee.x = 1;
//        ee.y = 0;
//        ee.d = a;
//        return ee;
//    }
//    else {
//        result = solve(b, a % b);
//
//        ee.x = result.y;
//        ee.y = result.x - a / b * result.y;
//        ee.d = result.d;
//        return ee;
//    }
//}
//
//int main() {
//    int A, B;
//    int count = 0;
//    printf("Type the number of testing sets:");
//    scanf_s("%d", &count);
//    for (int i = 0; i < count; i++) {
//        printf("\nType the two values:");
//        scanf_s("%d %d", &A, &B);
//        printf("Result : %d %d %d\n\n", solve(A, B).x, solve(A, B).y, solve(A, B).d);
//    }
//    return 0;
//}