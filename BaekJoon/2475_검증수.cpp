#include <cstdio>

int main(){
	int *a = new int[5];
	int t = 0;

	for (int i = 0; i < 5;i++)
		scanf("%d",&a[i]);
	
	for (int i = 0; i < 5; i++)
		t += a[i] * a[i];

	printf("%d\n", t%10);
}
