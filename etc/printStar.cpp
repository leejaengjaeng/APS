#include<stdio.h>

int count0 = 0;
int count1 = 0;

int fibonacci(int n) {
	if (n == 0) {
		count0++;
		return 0;
	}
	else if (n == 1) {
		count1++;
		return 1;
	}
	else {
		return fibonacci(n‐1) + fibonacci(n‐2);
	}
}

int main(void)
{
	int n = 0;
	scanf("%d", &n);

	fibonacci(n);
	printf("%d %d", count0, count1);
}