#include <bits/stdc++.h>
using namespace std;

int main()
{
    freopen("moop.in", "r", stdin);
    freopen("moop.out", "w", stdout);
    int N;
    vector<pair<int, int>> p;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int a, b;
        cin >> a >> b;
        p.push_back({a, b});
    }
    sort(begin(p), end(p));
    int lmin[N], rmax[N];
    lmin[0] = p[0].second;
    rmax[N - 1] = p[N - 1].second;
    for (int i = 1; i < N; i++)
    {
        lmin[i] = min(lmin[i - 1], p[i].second);
        rmax[N - 1 - i] = max(rmax[N - i], p[N - 1 - i].second);
    }
    int ans = 1;
    for (int i = 0; i < N - 1; i++)
        ans += lmin[i] > rmax[i + 1] ? 1 : 0;
    cout << ans << endl;
}