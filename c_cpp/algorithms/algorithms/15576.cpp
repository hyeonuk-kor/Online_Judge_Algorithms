#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* sum(char* a, char* b);
char res[1000];
char* t[101];
char a[101], b[101];
int main() {

	//Please Enter Your Code Here



	int i, j, k;
	int lenA, lenB;

	//scanf("%s", a);
	//scanf("%s", b);
	a = 1e30;
	b = 1e30;
	lenA = strlen(a);
	lenB = strlen(b);
	for (i = 0; i <= lenB - 1; i++)
	{

		for (j = 1; j <= b[i] - '0'; j++) {
			t[i] = (char*)malloc(lenA + lenB);
			strcpy(t[i], a);
			for (k = 1; k < lenB - i; k++)
				strcat(t[i], "0");
			t[i] = sum(res, t[i]);
		}

	}

	printf("%s\n", res);


	return 0;
}

char* sum(char* a, char* b)
{
	int i, j;
	int len;

	char rev_a[1000], rev_b[1000];
	char temp;
	char result[1000];


	for (j = 0, i = strlen(a) - 1; i >= 0; j++, i--)
	{
		rev_a[j] = a[i];
	}

	rev_a[j] = '\0';

	for (j = 0, i = strlen(b) - 1; i >= 0; j++, i--)
	{
		rev_b[j] = b[i];
	}
	rev_b[j] = '\0';


	if (strlen(rev_a) >= strlen(rev_b))
	{
		for (i = strlen(b); i < strlen(a); i++)
		{
			rev_b[i] = '0';
		}
		rev_b[i] = '\0';
		len = strlen(rev_a);
	}
	else
	{
		for (i = strlen(a); i < strlen(b); i++)
		{
			rev_a[i] = '0';
		}
		rev_a[i] = '\0';
		len = strlen(b);
	}


	for (i = 0; i < len; i++)
	{
		result[i] = rev_a[i] + rev_b[i] - '0';
		if (result[i] > '9')
		{
			result[i] = result[i] - 10;

			if (rev_a[i + 1] != '\0')
				rev_a[i + 1]++;
			else
			{
				result[i + 1] = '1';
				result[i + 2] = '\0';
				len = i + 2;
				break;
			}
		}
	}
	result[len] = '\0';

	for (j = 0, i = strlen(result) - 1; i >= 0; j++, i--)
	{
		res[j] = result[i];
	}
	res[j] = '\0';

	return res;

}