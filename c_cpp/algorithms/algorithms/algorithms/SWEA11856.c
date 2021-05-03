#include<stdio.h>
int main(int argc, char** argv)
{
	int test_case;
	int T;
	scanf("%d", &T);
	for (test_case = 1; test_case <= T; ++test_case)
	{
		char S[5];
		scanf("%s", S);
		int check = 0;
		if (S[0] == S[1] && S[2] == S[3] && S[1] != S[2])
			check = 1;
		else if (S[0] == S[2] && S[1] == S[3] && S[2] != S[1])
			check = 1;
		else if (S[0] == S[3] && S[1] == S[2] && S[3] != S[1])
			check = 1;
		printf("#%d %s", test_case, check == 1 ? "Yes" : "No");
	}
	return 0;
}