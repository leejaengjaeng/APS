#include <cstdio>

int main(){
	int x,y,w,h;
	scanf("%d %d %d %d", &x,&y,&w,&h);
	
	// ->
	int min = w - x;
	// <-
	if (x < min) min = x;
	// ��
	if ((h - y) < min) min = (h - y);
	//�Ʒ�
	if (y < min) min = y;

	printf("%d\n", min);
}
