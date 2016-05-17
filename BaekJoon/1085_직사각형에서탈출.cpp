#include <cstdio>

int main(){
	int x,y,w,h;
	scanf("%d %d %d %d", &x,&y,&w,&h);
	
	// ->
	int min = w - x;
	// <-
	if (x < min) min = x;
	// À§
	if ((h - y) < min) min = (h - y);
	//¾Æ·¡
	if (y < min) min = y;

	printf("%d\n", min);
}
