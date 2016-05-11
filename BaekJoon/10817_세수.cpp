#include <cstdio>

int main(){
	int *a = new int[3];
	scanf("%d %d %d", &a[0], &a[1], &a[2]);
	int tmp;
	for (int i = 0; i < 3; i++)
	{
		for (int j = i; j < 3; j++)
		{
			if (a[i]>a[j])
			{
				tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
	}
	printf("%d", a[1]);
}