#include <cstdio>

void qSort(int* a, int low, int high);
int main()
{
	int nSensor, nZipjung,result=0;
	int *road, *dist;
	scanf("%d\n%d", &nSensor, &nZipjung);
	road = new int[nSensor];
	dist = new int[nSensor-1];
	for (int i = 0; i < nSensor; i++)
	{
		scanf("%d", &road[i]);
	}
	
	qSort(road, 0, nSensor - 1);

	for (int i = 1; i < nSensor; i++)
	{
		dist[i-1] = road[i-1] - road[i];
	}

	qSort(dist, 0, nSensor - 2);

	for (int i =0; i<nZipjung-1 ; i++)
	{
		dist[i] = 0;
	}

	for (int i = 0; i < nSensor-1; i++)
		result += dist[i];
	printf("%d", result);
}
//내림차순 정렬
void qSort(int* a, int low, int high)
{
	int tLow = low, tHigh = high,t;
	int mid = a[(low + high) / 2];
	do
	{
		while (a[tLow] > mid) tLow++;
		while (a[tHigh] < mid) tHigh--;
		if (tLow <= tHigh)
		{
			t = a[tLow];
			a[tLow] = a[tHigh];
			a[tHigh] = t;
			tLow++; tHigh--;
		}
	}while (tLow <= tHigh);
	if (low < tHigh) qSort(a, low, tHigh);
	if (high > tLow) qSort(a, tLow, high);
}