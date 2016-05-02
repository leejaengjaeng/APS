#include<iostream>
using namespace std;

void quickSortC(int **a, int low, int high);
void quickSortW(int **a, int low, int high);

void sortByW(int** base, int n);


int main()
{
	//base[����][����]
	int **base;

	//�ԷµǴ� ��, �ʿ��� ����
	int n = 0;
	int reqW = 0;

	//���� �䱸 ���� �Է�
	cin >> n >> reqW;

	//�� ������ �� 
	int tSum = 0;

	base = new int*[n];
	for (int i = 0; i < n; i++)
	{
		base[i] = new int[2];
		cin >> base[i][0] >> base[i][1];
		tSum += base[i][0];
	}

	//���(1)�� ������������ ����
	quickSortC(base, 0, n - 1);
	//��뺰�� ���Կ� ���� ������������ ����
	sortByW(base, n);

	//���� ����, ���� ���� �迭
	int *accC = new int[n];
	int *accW = new int[n];

	//�ʱ���(n-1)��° �� ����
	accC[n - 1] = base[n - 1][1];
	accW[n - 1] = base[n - 1][0];
	int index = -1;
	bool flag = false;
	if (reqW <= accW[n - 1])
	{
		index = n - 1;
		flag = true;
	}
	//����, �䱸 ���Ը� �ѱ�� ���� �ε��� Ž��
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
	//���� �ε������� ���� �� �ΰ� �� ���� ������ �ִ� ��찡 �ִ��� Ž�� 
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
