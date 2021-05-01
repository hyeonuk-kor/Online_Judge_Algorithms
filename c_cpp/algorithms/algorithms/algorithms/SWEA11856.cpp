#include<iostream>
#include<string>
using namespace std;
int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		char S[5];
		cin >> S;
		string ptc = "#" + to_string(test_case) + " ";
		bool check = true;
		int alpha[26] = { 0, };
		for (int i = 0; i < 4; i++)
		{
			int index = S[i] - 'A';
			alpha[index] += 1;
		}
		for (int i = 0; i < 26; i++) 
		{
			if (alpha[i] % 2 == 1 || alpha[i]>2)
				check = false;
		}
		if (check)
			cout << ptc << "Yes\n";
		else
			cout << ptc << "No\n";
	}
	return 0;
}