#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 1;
int N, M;
int dist[MAX], indegree[MAX], prev_max[MAX];
vector<int> adj[MAX], adj_t[MAX];

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj_t[b].push_back(a);
        indegree[b]++;
    }

    // kahns algorithm
    deque<int> q;
    for (int i = 1; i <= N; i++)
        if (!indegree[i])
            q.push_back(i);
    while (!q.empty())
    {
        int u = q.front();
        q.pop_front();
        // find max predecessor
        int mx = -1, d = -1;
        for (int n_t : adj_t[u])
            if (dist[n_t] > d)
            {
                mx = n_t;
                d = dist[n_t];
            }
        dist[u] = d + 1;
        prev_max[u] = mx;
        // bfs
        for (int n : adj[u])
        {
            indegree[n]--;
            if (!indegree[n])
                q.push_back(n);
        }
    }
    stack<int> ans;
    int curr = N;
    while (1)
    {
        ans.push(curr);
        if (curr < 2)
            break;
        curr = prev_max[curr];
    }

    if (ans.top() != 1)
    {
        cout << "IMPOSSIBLE" << endl;
        return 0;
    }
    cout << ans.size() << endl;
    while (!ans.empty())
    {
        cout << ans.top() << " ";
        ans.pop();
    }
    cout << "\n";
}