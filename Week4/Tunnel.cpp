#include<iostream>

using namespace std;

int main()
{
	int inCave;
	int maxIn;
	int n;
	cin >> n >> inCave;

	maxIn = inCave;

	int in, out;
	for (int i = 0; i < n; i++)
	{
		cin >> in >> out;
		inCave = inCave + in - out;
		if (inCave < 0)
		{
			maxIn = 0;
			break;
		}
		if (maxIn < inCave)
		{
			maxIn = inCave;
		}
	}
	cout << maxIn;
}