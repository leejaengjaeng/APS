#include<stdio.h>

int minValue(int a, int b)
{
	if (a < b) return a;
	else return b;
}

int main(void)
{
	int n = 0;
	scanf("%d", &n);
	int **input = new int*[n];
	int **cached = new int*[n];
	for (int i = 0; i < n; i++)
	{
		input[i] = new int[3];
		cached[i] = new int[3];
		cached[i][0] = -1;
		cached[i][1] = -1;
		cached[i][2] = -1;
	}
	for (int i = 0; i < n; i++)
	{
		scanf("%d %d %d", &input[i][0], &input[i][1], &input[i][2]);
	}

	//초기값 주기 
	cached[0][0] = input[0][0];
	cached[0][1] = input[0][1];
	cached[0][2] = input[0][2];

	//DP 
	for (int i = 1; i < n; i++)
	{
		cached[i][0] = input[i][0] + minValue(cached[i - 1][1], cached[i - 1][2]);
		cached[i][1] = input[i][1] + minValue(cached[i - 1][0], cached[i - 1][2]);
		cached[i][2] = input[i][2] + minValue(cached[i - 1][0], cached[i - 1][1]);
	}
	int minValue = cached[n - 1][0];
	if (cached[n - 1][1] < minValue) minValue = cached[n - 1][1];
	if (cached[n - 1][2] < minValue) minValue = cached[n - 1][2];
	printf("%d\n", minValue);
}