#include<stdio.h>

//0~9, sum
long long base[1001][11];

int main()
{
	int n;
	scanf("%d", &n);
	for (int i = 0; i < 10; i++)
	{
		base[0][i] = 1;
	}
	base[0][10] = 0;
	for (int i = 0; i < 10; i++)
		base[0][10] += base[0][i];
	
	for (int i = 1; i < n; i++)
	{
		base[i][10] = 0;
		base[i][0] = base[i - 1][10];
		for (int j = 1; j < 10; j++)
		{
			base[i][j] = base[i][j - 1] - base[i - 1][j - 1];
		}
		
		for (int j = 0; j < 10; j++)
		{
			if (base[i][j] >= 10007)
				base[i][j] = base[i][j] % 10007;
		}

		for (int j = 0; j < 10; j++)
			base[i][10] += base[i][j];

	}
	printf("%lld \n", base[n-1][10]%10007);
}
