#include<stdio.h>

int main(void)
{
	int n = 0;
	scanf("%d", &n);
	if (n % 2 == 0)	printf("%d\n", (n + 1)*(n / 2));
	else printf("%d\n", (n + 1)*(n / 2) + (n / 2 + 1));
}
