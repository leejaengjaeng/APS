#include <cstdio>

int main()
{
	int n[5];
	scanf("%d\n%d\n%d\n%d\n%d", &n[0], &n[1], &n[2], &n[3], &n[4]);
	int sum = 0;
	for (int i = 0; i < 5; i++)
	{
		if (n[i] < 40) sum += 40;
		else sum += n[i];
	}
	printf("%d", sum / 5);
}