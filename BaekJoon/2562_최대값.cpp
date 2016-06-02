#include<stdio.h>

int main()
{
	int big,bigIndex=1,tBig;
	scanf("%d", &big);

	for (int i = 1; i < 9; i++)
	{
		scanf("%d", &tBig);
		if (tBig > big)
		{
			bigIndex = 1 + i;
			big = tBig;
		}
	}
	printf("%d\n%d\n", big,bigIndex);
}
