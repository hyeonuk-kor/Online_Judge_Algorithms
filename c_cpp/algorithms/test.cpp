#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    vector<int> a(n), b(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i] >> b[i];
    }

    int k;
    if (m == 1) {
        k = n - 1;
    } else {
        k = n * (n - 1) / 2;
    }

    double prob = 1.0;
    for (int i = 0; i < n; i++) {
        double p = 1.0;
        for (int j = 0; j < b[i]; j++) {
            p *= (k - j) / (double)(k - j + n - i - 1);
        }
        prob *= (1 - p);
        k -= b[i];
    }

    cout.precision(15);
    cout  << prob << endl;

    return 0;
}
