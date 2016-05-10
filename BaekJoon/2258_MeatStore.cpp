#include<iostream>
using namespace std;

void quickSortC(int **a, int low, int high);
void quickSortW(int **a, int low, int high);

void sortByW(int** base, int n);


int main()
{
	//base[무게][가격]
	int **base;

	//입력되는 수, 필요한 무게
	int n = 0;
	int reqW = 0;

	//수와 요구 무게 입력
	cin >> n >> reqW;

	//총 무게의 합 
	int tSum = 0;

	base = new int*[n];
	for (int i = 0; i < n; i++)
	{
		base[i] = new int[2];
		cin >> base[i][0] >> base[i][1];
		tSum += base[i][0];
	}

	//비용(1)의 내림차순으로 정렬
	quickSortC(base, 0, n - 1);
	//비용별로 무게에 대해 내림차순으로 정렬
	sortByW(base, n);

	//누적 가격, 누적 무게 배열
	int *accC = new int[n];
	int *accW = new int[n];

	//초기항(n-1)번째 항 설정
	accC[n - 1] = base[n - 1][1];
	accW[n - 1] = base[n - 1][0];
	int index = -1;
	bool flag = false;
	if (reqW <= accW[n - 1])
	{
		index = n - 1;
		flag = true;
	}
	//누적, 요구 무게를 넘기는 최초 인덱스 탐색
	for (int i = n - 2; i >= 0; i--)
	{
		accW[i] = base[i][0] + accW[i + 1];

		if (base[i + 1][1] != base[i][1]) accC[i] = base[i][1];
		else accC[i] = accC[i + 1] + base[i][1];

		if (flag == true) continue;
		else if (accW[i] >= reqW)
		{
			index = i;
			flag = true;
		}
	}
	//최초 인덱스에서 보다 더 싸게 더 많이 받을수 있는 경우가 있는지 탐색 
	int minC = accC[index];
	if (flag == false) minC = -1;
	else
	{
		for (int i = index; i >= 0; i--)
		{
			if (accC[i] < minC)
			{
				minC = accC[i];
			}
		}
	}
	cout << minC << endl;
}

void quickSortC(int **a, int low, int high)
{
	int i = low, j = high, t0, t1;

	int x = a[(low + high) / 2][1];
	//partition
	do
	{
		while (a[i][1] > x)i++;
		while (a[j][1] < x)j--;
		if (i <= j)
		{
			t0 = a[i][0];
			t1 = a[i][1];
			a[i][0] = a[j][0];
			a[i][1] = a[j][1];
			a[j][0] = t0;
			a[j][1] = t1;
			i++; j--;
		}
	} while (i <= j);
	//recursion
	if (low < j) quickSortC(a, low, j);
	if (i < high) quickSortC(a, i, high);
}
void quickSortW(int **a, int low, int high)
{

	int i = low, j = high, t0, t1;
	int x = a[(low + high) / 2][0];
	//partition
	do
	{
		while (a[i][0] < x)i++;
		while (a[j][0] > x)j--;

		if (i <= j)
		{
			t0 = a[i][0];
			t1 = a[i][1];
			a[i][0] = a[j][0];
			a[i][1] = a[j][1];
			a[j][0] = t0;
			a[j][1] = t1;
			i++; j--;
		}
	} while (i <= j);
	//recursion
	if (low < j) quickSortW(a, low, j);
	if (i < high) quickSortW(a, i, high);
}

void sortByW(int** base, int n)
{
	int ts, te;
	int j, count;
	for (int i = 0; i < n; i=j)
	{
		ts = i;
		count = -1;
		for (j = i; j < n; j++, count++)
		{
			if (base[i][1] != base[j][1]) break;
		}
		if (count != 0) quickSortW(base, ts, ts + count);
	}
}
