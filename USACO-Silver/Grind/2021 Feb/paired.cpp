#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "pairup")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}

int main()
{
    setIO();
    int N;
    cin >> N;
    pair<int, int> c[N];
    for (int i = 0; i < N; i++)
    {
        int x, y;
        cin >> x >> y;
        c[i] = {y, x};
    }
    sort(c, c + N);
    int left = 0, right = N - 1, ans = 0;
    while (left <= right)
    {
        ans = max(ans, c[left].first + c[right].first);
        int minVal = min(c[right].second, c[left].second);
        c[right].second -= minVal;
        c[left].second -= minVal;
        if (c[right].second <= 0)
            right--;
        if (c[left].second <= 0)
            left++;
    }
    cout << ans << endl;
}