#include <cstdio>
#include<stdlib.h>
int compare1(const void *a, const void *b)
{
	return *(int *)a - *(int *)b; //ũ�� ���, ������ ���� ����
}
int compare2(const void *a, const void *b)
{
	return *(int *)b - *(int *)a; //ũ�� ���, ������ ���� ����
}
int main(){
	int n;
	scanf("%d", &n);
	int *a = new int[n];
	int *b = new int[n];

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &a[i]);
	}
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &b[i]);
	}
	qsort(a, n, sizeof(int), compare1);
	qsort(b, n, sizeof(int), compare2);
	int min = 0;
	for (int i = 0; i < n; i++)
		min += a[i] * b[i];
	printf("%d\n", min);
}
