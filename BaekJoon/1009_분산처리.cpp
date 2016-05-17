#include <cstdio>

int main(){
	int a,b,n,toDivide,answer;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d %d", &a, &b);
		
		int startCom = a % 10;

		int tmp = a;
		int rotate = 1;

		do{
			tmp = (tmp * a) % 10 ;
			rotate++;
		} while (tmp != startCom && rotate <= b);
		rotate--;
		
		int *vArr = new int[rotate];
		tmp = startCom;
		for (int i = 0; i < rotate; i++)
		{
			if (tmp == 0) vArr[i] = 10;
			else vArr[i] = tmp;
			tmp = (tmp * a) % 10;
		}

		int toFind = b%rotate -1;
		if (toFind == -1) toFind = rotate-1;

		printf("%d\n",vArr[toFind]);
		delete(vArr);
	}
}
