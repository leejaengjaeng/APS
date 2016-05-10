#include <cstdio>  
#include <math.h>

inline double calDist(int x1, int x2, int y1, int y2){ return sqrt((x1 - x2)*(x1 - x2)*1.0 + (y1 - y2)*(y1-y2)*1.0); }

int main(){
	int n;
	scanf("%d", &n);
	int x1, x2, y1, y2, r1, r2, p;
	double dist,distP;
	int shorter, longer;
	for (int i = 0; i < n;i++)
	{
		scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);
		
		shorter = ((r1 < r2) ? r1 : r2);
		longer = ((r1 < r2) ? r2 : r1);
		distP = calDist(x1, x2, y1, y2);

		//중심이 같다면
		if (x1 == x2 && y1 == y2)
		{
			if (r1 == r2) p = -1;
			else p = 0;
		}
		
		//한 점이 다른 원 내부에 있다면
		else if (distP <= r1 || distP <= r2)
		{
			if (distP + shorter == longer) p = 1;
			else if (distP + shorter < longer) p = 0;
			else p = 2;
		}

		// 두점 사이의 거리가 충분히 먼 나머지 경우
		else
		{
			if (shorter + longer == distP) p = 1;
			else if (shorter + longer < distP) p = 0;
			else p = 2;
		}
		printf("%d\n", p);
	}
	return 0;
}