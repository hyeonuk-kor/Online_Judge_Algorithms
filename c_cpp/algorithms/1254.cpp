#include <bits/stdc++.h>
using namespace std;
string input;
int go(int l, int r) {
    for (int i = l; i < r; i++) {
        bool check = true;
        for (int j = i; j < r; j++) { 
            if(input.at(j)!=input.at(r-(j-i)-1)) {
                check = false;
                break;
            }
        }
        if(check) {
            return r + i;
        }
    }
    return 0;
}
int main() {
    cin >> input;
    int length = input.length();
    cout << go(0, length);
    return 0;
}