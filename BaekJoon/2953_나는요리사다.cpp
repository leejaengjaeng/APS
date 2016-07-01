#include <cstdio>
using namespace std;

int main(int argc, char** argv) {

	int base[5][4];
	int total =0;
	int best = 0;
	int bestIndex = 0;
	
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			scanf("%d", &base[i][j]);
			total += base[i][j];
		}
		if (best < total)
		{
			best = total;
			bestIndex = i;
		}
		total = 0;
	}
	printf("%d %d\n", bestIndex + 1, best);
}