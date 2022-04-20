#include <bits/stdc++.h>
using namespace std;

int main()
{
    freopen("planting.in", "r", stdin);
    freopen("planting.out", "w", stdout);
    int N;
    cin >> N;
    vector<int> adj[N];
    for (int i = 0; i < N - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a - 1].push_back(b - 1);
        adj[b - 1].push_back(a - 1);
    }
    int ans = 0;
    for (auto v : adj)
        ans = max(ans, 1 + (int)v.size());
    cout << ans;
}