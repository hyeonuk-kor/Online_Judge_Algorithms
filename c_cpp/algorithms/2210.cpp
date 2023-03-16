#include <bits/stdc++.h>
using namespace std;
int n = 5;
int a[5][5];
set<int> ans;
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
void go(int x, int y, int num, int len) {
    if(len==6) {
        ans.insert(num);
        return;
    }
    for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];
        if(0 <= nx && nx < n && 0<=ny && ny < n) {
            go(nx, ny, num * 10 + a[nx][ny], len + 1);
        }
    }
}
int main() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> a[i][j];
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            go(i, j, a[i][j], 1);
        }
    }
    cout << ans.size();
    return 0;
}