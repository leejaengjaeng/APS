#include<stdio.h>

int main(void)
{
	int cost = 0;
	int n = 0;
	int money = 0;
	scanf("%d %d %d", &cost, &n, &money);
	int need = cost*n - money;
	if (need < 0) need = 0;
	printf("%d", need);
}