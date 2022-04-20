#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, M;
    cin >> N >> M;
    vector<vector<int>> adj(N);
    for (int i = 0; i < M; i++)
    {
        int j, k;
        cin >> j >> k;
        adj[j - 1].push_back(k - 1);
        adj[k - 1].push_back(j - 1);
    }
    int dist[N];
    bool v[N];
    queue<int> is, ts;
    v[0] = true;
    dist[0] = 0;
    is.push(0);
    ts.push(0);
    while (!is.empty())
    {
        int i = is.front();
        is.pop();
        int t = ts.front();
        ts.pop();
        dist[i] = t;
        for (int el : adj[i])
        {
            if (v[el] == 1)
                continue;
            v[el] = true;
            is.push(el);
            ts.push(t + 1);
        }
    }
    int m = 0, cnt = 0, first;
    for (int i = 0; i < N; i++)
    {
        m = max(m, dist[i]);
    }
    for (int i = 0; i < N; i++)
    {
        if (dist[i] == m)
        {
            cnt++;
            first = min(i, first);
        }
    }
    cout << first + 1 << ' ' << m << ' ' << cnt << endl;
}