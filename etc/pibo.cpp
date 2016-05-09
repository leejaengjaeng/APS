#include<stdio.h>

int main(void)
{
	int n = 0;
	scanf("%d", &n);

	//각 숫자 별로 1과 0의 수를 저장할 배열, 최대 40
	int **cached = new int*[41];

	for (int i = 0; i < 41; i++)
		cached[i] = new int[2];

	cached[0][0] = 1;
	cached[0][1] = 0;
	cached[1][0] = 0;
	cached[1][1] = 1;

	for (int i = 2; i < 41; i++)
	{
		cached[i][0] = cached[i - 1][0] + cached[i - 2][0];
		cached[i][1] = cached[i - 1][1] + cached[i - 2][1];
	}

	int input = 0;
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &input);
		printf("%d %d\n", cached[input][0], cached[input][1]);
	}
}