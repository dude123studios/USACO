#include <bits/stdc++.h>
using namespace std;

const int MAX = 1e5 + 1;
int N, M;
vector<int> adj[MAX], dist(MAX, -1), path(MAX, -1);
main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    deque<int> q;
    dist[1] = 1;
    q.push_back(1);
    while (!q.empty())
    {
        int n = q.front();
        q.pop_front();
        for (int u : adj[n])
            if (dist[u] < 0)
            {
                dist[u] = dist[n] + 1;
                path[u] = n;
                q.push_back(u);
            }
    }
    if (dist[N] < 0)
        cout << "IMPOSSIBLE" << endl;
    else
    {
        cout << dist[N] << endl;
        int curr = N;
        vector<int> pth;
        while (curr > 0)
        {
            pth.push_back(curr);
            curr = path[curr];
        }
        reverse(pth.begin(), pth.end());
        for (int i : pth)
            cout << i << " ";
        cout << "\n";
    }
}