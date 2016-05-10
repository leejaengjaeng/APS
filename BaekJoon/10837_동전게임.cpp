#include<stdio.h>

int main()
{
	int gameN;
	int n;
	scanf("%d %d",&gameN,&n);
	int *answer = new int[n];
	int **tmp = new int*[n];

	int M, N;
	for (int i = 0; i < n; i++)
	{
		scanf("%d %d", &M, &N);
		if (M == N)
		{
			answer[i] = 1;
		}
		else if (M < N)
		{
			if ((N - 1 - M) < (gameN - N + 1)) answer[i] = 1;
			else answer[i] = 0;
		}
		else
		{
			if ((M - N - 1) <= (gameN - M + 1)) answer[i] = 1;
			else answer[i] = 0;
		}
	}
	for (int i = 0; i < n; i++)
	{
		printf("%d\n",answer[i]);
	}
}