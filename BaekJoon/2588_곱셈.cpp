#include <cstdio>

int main()
{
	int n[6];
	scanf("%d", &n[0]);
	scanf("%d", &n[1]);

	n[2] = n[0] * (n[1] % 10);
	n[3] = n[0] * (n[1] % 100 - n[1] % 10)/10;
	n[4] = n[0] * (n[1] / 100);
	n[5] = n[0] * n[1];
	printf("%d\n%d\n%d\n%d\n", n[2], n[3], n[4], n[5]);
}