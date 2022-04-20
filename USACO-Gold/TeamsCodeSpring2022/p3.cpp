#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, K, ans = 0;
    cin >> N >> K;
    for (int i = 0; i < N; i++)
    {
        int a, b;
        cin >> a >> b;
        int r = b * K;
        int diff = abs(a - r);
        int currans = (diff / K) + diff % K;
        int o = (diff / K + 1) + K - (diff % K);
        ans += min(o, min(currans, a + b));
    }
    cout << ans << endl;
}