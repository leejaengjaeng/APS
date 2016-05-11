#include <cstdio>


int main(){
	int *arr;
	int n, toFind;

	scanf("%d %d", &n, &toFind);

	arr = new int[n];

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}

	for (int i = 0; i < n; i++)
	{
		if (arr[i] >= toFind) continue;
		else printf("%d ", arr[i]);
	}
	
}
