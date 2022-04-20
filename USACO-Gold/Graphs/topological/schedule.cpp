#include <bits/stdc++.h>
using namespace std;
int N, M;

vector<int> adj[100001], top_sort;

// solved with dfs
bool possible = 1;
int v[100001];
void dfs(int u)
{
    if (v[u] == 1)
        possible = 0;
    if (!possible)
        return;
    v[u] = 1;
    for (int n : adj[u])
        if (v[n] != 2)
            dfs(n);
    v[u] = 2;
    top_sort.push_back(u);
}

void dfs_solve()
{
    for (int i = 1; i <= N; i++)
        if (!v[i])
            dfs(i);
    reverse(top_sort.begin(), top_sort.end());
    if (!possible)
    {
        cout << "IMPOSSIBLE" << endl;
        return;
    }
    for (int i : top_sort)
        cout << i << " ";
    cout << "\n";
}

// solved with bfs (kahns algorithm)
int indegree[100001];
void bfs_solve()
{
    deque<int> q;
    for (int i = 1; i <= N; i++)
        if (indegree[i] == 0)
            q.push_back(i);
    while (!q.empty())
    {
        int u = q.front();
        q.pop_front();
        top_sort.push_back(u);
        for (int n : adj[u])
        {
            indegree[n]--;
            if (!indegree[n])
                q.push_back(n);
        }
    }
    if (top_sort.size() != N)
    {
        cout << "IMPOSSIBLE" << endl;
        return;
    }
    for (int i : top_sort)
        cout << i << " ";
    cout << "\n";
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        indegree[b]++;
    }
    // dfs_solve();
    bfs_solve();
}