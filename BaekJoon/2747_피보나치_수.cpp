#include <cstdio>

int main()
{
	int arr[46];
	int pivoNum=0;
	scanf("%d", &pivoNum);
	arr[0] = 0;
	arr[1] = 1;
	for (int i = 2; i <= pivoNum; i++)
	{
		arr[i] = arr[i - 1] + arr[i - 2];
	}
	printf("%d", arr[pivoNum]);
}