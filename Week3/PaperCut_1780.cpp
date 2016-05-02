#include<stdio.h>
#include<iostream>
#include<vector>
#include<stack>
using namespace std;
int isAllSame(int xS, int yS, int length);
void DNQ(int xS, int yS, int length);


int **base;
int cM = 0, cZ = 0, cP = 0;

int main()
{

	int length=0;
	cin >> length;

	base = new int*[length];
	for (int i = 0; i < length; i++)
	{
		base[i] = new int[length];
	}
	for (int i = 0; i < length; i++)
	{
		for (int j = 0; j < length; j++)
		{
			//scanf_s("%d", &base[i][j]);
			cin >> base[i][j];
		}
	}

	DNQ(0, 0, length);

	cout << cM << endl;
	cout << cZ << endl;
	cout << cP << endl;

}
int isAllSame(int xS, int yS, int length)
{
	int xs = xS, ys = yS, leng = length;
	int retV = base[xs][ys];

	for (int i = 0; i<leng; i++)
	{
		for (int j = 0; j<leng; j++)
		{
			if (base[xs][ys] != retV) return -99;
			else
			{
				ys++;
			}
		}
		ys = yS;
		xs++;
	}
	return retV;
}
void DNQ(int xS, int yS, int length)
{
	//현재 종이가 모두 같은지 확인
	int tFlag = isAllSame(xS, yS, length);
	int xs = xS;
	int ys = yS;
	int leng = length / 3;

	//모두 같지않다면 9등분해서 종이 9개를 다시 넣기
	if (tFlag == -99)
	{
		DNQ(xs, ys, leng);
		DNQ(xs + leng, ys, leng);
		DNQ(xs + leng + leng, ys, leng);

		DNQ(xs, ys + leng, leng);
		DNQ(xs + leng, ys + leng, leng);
		DNQ(xs + leng + leng, ys + leng, leng);

		DNQ(xs, ys + leng + leng, leng);
		DNQ(xs + leng, ys + leng + leng, leng);
		DNQ(xs + leng + leng, ys + leng + leng, leng);
	}
	//모두 같다면 카운트 증가
	else
	{
		if (tFlag == -1)cM++;
		else if (tFlag == 0)cZ++;
		else if (tFlag == 1)cP++;
	}
}
