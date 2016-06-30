#include <cstdio>
using namespace std;

int main(int argc, char** argv) {

	int num = 0;
	int total = 0;
	int tmp = 0;
	scanf("%d", &num);
	for (int i = 0; i < num; i++)
	{
		scanf("%d", &tmp);

		if (i != num - 1)
			total += (tmp - 1);
		else
			total += tmp;
	}
	printf("%d\n", total);
}