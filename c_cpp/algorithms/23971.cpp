#include <iostream>
using namespace std;
int main() {
    int h, w, n, m;
    cin >> h >> w >> n >> m;
    cout << ((h - 1) / (n + 1) + 1) * ((w - 1) / (m + 1) + 1);
    return 0;
}