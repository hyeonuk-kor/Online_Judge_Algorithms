#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> p;
stack<int> s, c;
long long answer;
int main() {
    cin >> n;
    p = vector<int>(n);
    for (int i = 0; i < n; i++) {
        cin >> p[i];
    }
    for (int i = 0; i < n; i++) {
        int h = p[i];
        int cnt = 1;
        while(!s.empty()) {
            if(s.top() <= p[i]) {
                answer += (long long)c.top();
                if(s.top() == p[i]) {
                    cnt += c.top();
                }
                s.pop();
                c.pop();
            } else {
                break;
            }
        }
        if(!s.empty()) {
            answer += 1LL;
        }
        s.push(h);
        c.push(cnt);
    }
    cout << answer;
}