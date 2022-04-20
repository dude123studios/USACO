#include <bits/stdc++.h>
using namespace std;

int N, M;
vector<int> adj[100000];
pair<int, int> pos[100000];

bool v[100000];
vector<vector<int>> clusters;
vector<int> curr;

void dfs(int i)
{
    v[i] = true;
    curr.push_back(i);
    for (int j : adj[i])
    {
        if (v[j] == 1)
            continue;
        dfs(j);
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        int x, y;
        cin >> x >> y;
        pos[i] = {x, y};
    }
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a - 1].push_back(b - 1);
        adj[b - 1].push_back(a - 1);
    }

    for (int i = 0; i < N; i++)
    {
        if (v[i] == 1)
            continue;
        dfs(i);
        clusters.push_back(curr);
        curr.clear();
    }

    int ans = 1e9;
    for (vector<int> c : clusters)
    {
        int minx = 1e9, miny = 1e9, maxx = 0, maxy = 0;
        for (int i : c)
        {
            int x = pos[i].first, y = pos[i].second;
            minx = min(minx, x);
            miny = min(miny, y);
            maxx = max(maxx, x);
            maxy = max(maxy, y);
        }
        ans = min(ans, 2 * (maxx - minx) + 2 * (maxy - miny));
    }
    cout << ans << endl;
}