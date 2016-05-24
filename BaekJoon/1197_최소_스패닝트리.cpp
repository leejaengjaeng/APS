#include <cstdio>
#include <vector>
using namespace std;

void qSort(int** a, int low, int high);
int main()
{
	int v, e;
	int **base;
	scanf("%d %d", &v, &e);
	vector<int> ans;
	//정점 번호가 1부터 순서대로가 아니게 들어올수도 있으려나?
	for (int i = 0; i < v; i++)
		ans.push_back(i + 1);

	base = new int*[e];
	for (int i = 0; i < e; i++)
		base[i] = new int[3];
	for (int i = 0; i < e; i++)
	{
		scanf("%d %d %d", &base[i][0], &base[i][1], &base[i][2]);
	}

	qSort(base,0,e-1);

	//트리 생성
	vector< vector<int> > subAns;
	vector<int> putToSubAns;
	putToSubAns.push_back(base[0][0]);
	putToSubAns.push_back(base[0][1]);
	subAns.push_back(putToSubAns);
	putToSubAns.clear();
	int sum = base[0][2];

	int tSubAns0=-1, tSubAns1=-2;
	vector<int> tmp;
	for (int i = 1; i < e; i++)
	{
		tSubAns0 = -1; tSubAns1 = -2;
		//부분집합 목록 검색
		for (int j = 0; j < subAns.size(); j++)
		{
			tmp = subAns.at(j);
			//부분집합에 요소가 있는지 검색
			for (int k = 0; k < tmp.size() ; k++)
			{
				if (base[i][0] == tmp.at(k)) tSubAns0 = j;
				if (base[i][1] == tmp.at(k)) tSubAns1 = j;
			}
			tmp.clear();
			if (tSubAns0 == tSubAns1) break;
		}
		
		//두 정점 모두 포함 안 되어 있음				-> 추가
		if (tSubAns0 == -1 && tSubAns1 == -2)
		{
			putToSubAns.push_back(base[i][0]); 
			putToSubAns.push_back(base[i][1]);
			subAns.push_back(putToSubAns);
			putToSubAns.clear();
			sum += base[i][2];
		}
		//새로 들어올 두 점 모두 같은 정답 속에 있음	-> 버림
		else if (tSubAns0 == tSubAns1)
		{
			continue;
		}
		//각각 다른 정답에 포함되어 있음				-> 합병
		else if (tSubAns0 != -1 && tSubAns1 != -2)
		{
			tmp = subAns.at(tSubAns0);
			putToSubAns = subAns.at(tSubAns1);
	
			for (int k = 0; k < putToSubAns.size(); k++)
			{
				tmp.push_back(putToSubAns.at(k));
			}

			vector< vector<int> >::iterator erase = subAns.begin();
			if (tSubAns0 > tSubAns1)
			{
				subAns.erase(erase + tSubAns0);
				subAns.erase(erase + tSubAns1);
			}
			else
			{
				subAns.erase(erase + tSubAns1);
				subAns.erase(erase + tSubAns0);
			}		
			subAns.push_back(tmp);

			tmp.clear();
			putToSubAns.clear();
			sum += base[i][2];
			
		}
		//둘중 하나의 점만 포함 되어있음				-> 확장
		else 
		{
			int tAnsIndex = tSubAns0;
			if (tAnsIndex == -1) tAnsIndex = tSubAns1;
			tmp = subAns.at(tAnsIndex);

			if (tAnsIndex == tSubAns1) tmp.push_back(base[i][0]);
			else tmp.push_back(base[i][1]);

			vector< vector<int> >::iterator erase = subAns.begin() + tAnsIndex;
			subAns.erase(erase);
			subAns.push_back(tmp);
			tmp.clear();
			sum += base[i][2];

		}
		if (subAns.at(0).size() == v)
		{
			break;
		}
	}

	printf("%d\n", sum);

}
//내림차순 정렬
void qSort(int** a, int low, int high)
{
	int tLow = low, tHigh = high,t0,t1,t2;
	int mid = a[(low + high) / 2][2];
	do
	{
		while (a[tLow][2] < mid) tLow++;
		while (a[tHigh][2] > mid) tHigh--;
		if (tLow <= tHigh)
		{
			t0 = a[tLow][0];
			t1 = a[tLow][1];
			t2 = a[tLow][2];

			a[tLow][0] = a[tHigh][0];
			a[tLow][1] = a[tHigh][1];
			a[tLow][2] = a[tHigh][2];

			a[tHigh][0] = t0;
			a[tHigh][1] = t1;
			a[tHigh][2] = t2;
			tLow++; tHigh--;
		}
	}while (tLow <= tHigh);
	if (low < tHigh) qSort(a, low, tHigh);
	if (high > tLow) qSort(a, tLow, high);
}