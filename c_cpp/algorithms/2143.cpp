#include <bits/stdc++.h>
using namespace std;
int t, n, m;
vector<int> a, b, x, y;
int main() {
    cin >> t;
    cin >> n;
    a = vector<int>(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    cin >> m;
    b = vector<int>(m);
    for (int i = 0; i < m; i++) {
        cin >> b[i];
    }

    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
            sum += a[j];
            x.push_back(sum);
        }
    }

    for (int i = 0; i < m; i++) {
        int sum = 0;
        for (int j = i; j < m; j++) {
            sum += b[j];
            y.push_back(sum);
        }
    }

    sort(x.begin(), x.end());
    sort(y.begin(), y.end());
    long long ans = 0;
    for (int i = 0; i < x.size(); i++) {
        auto p = equal_range(y.begin(), y.end(), t - x[i]);
        ans += p.second - p.first;
    }

    cout << ans;
    return 0;
}