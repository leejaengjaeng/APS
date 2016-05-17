#include <cstdio>

void quickSort(int st, int end);
int arr[50];

int main()
{
	int n = 0,output=0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}
	
	if (n == 1) output = arr[0] * arr[0];
	else
	{
		quickSort(0, n - 1);
		output = arr[0] * arr[n - 1];
	}
	printf("%d", output);
}
void quickSort(int st, int end)
{
	int stP = st;
	int endP = end;
	int mid = arr[(st + end) / 2];
	int tmp=0;
	do{
		while (arr[stP] < mid)stP++;
		while (arr[endP] > mid)endP--;
		if(stP <= endP)
		{
			tmp = arr[stP];
			arr[stP] = arr[endP];
			arr[endP] = tmp;
			stP++; endP--;
		}
	} while (stP <= endP);

	if (st < endP) quickSort(st, endP);
	if (end > stP) quickSort(stP, end);
}