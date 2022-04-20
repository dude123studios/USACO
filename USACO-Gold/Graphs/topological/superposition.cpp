#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int MAX = 1e4 + 1;
int N[2], M[2], Q;
set<int> dp[2][MAX];
vector<int> adj[2][MAX], adj_t[2][MAX];
bool possible[2001];
// solved with bfs (kahns algorithm)
int indegree[2][MAX];
void bfs_solve(int index)
{
    deque<int> q;
    for (int i = 1; i <= N[index]; i++)
        if (indegree[index][i] == 0)
            q.push_back(i);
    while (!q.empty())
    {
        int u = q.front();
        q.pop_front();
        for (int n : adj_t[index][u])
            for (int length : dp[index][n])
                dp[index][u].insert(length + 1);
        for (int n : adj[index][u])
        {
            indegree[index][n]--;
            if (!indegree[index][n])
                q.push_back(n);
        }
    }
}

int main()
{
    cin >> N[0] >> N[1] >> M[0] >> M[1];
    for (int j = 0; j < 2; j++)
    {
        for (int i = 0; i < M[j]; i++)
        {
            int a, b;
            cin >> a >> b;
            adj[j][a].push_back(b);
            adj_t[j][b].push_back(a);
            indegree[j][b]++;
        }
        dp[j][1].insert(0);
        bfs_solve(j);
    }
    for (int i : dp[0][N[0]])
        for (int j : dp[1][N[1]])
            possible[i + j] = 1;
    cin >> Q;
    while (Q--)
    {
        int q;
        cin >> q;
        if (possible[q])
            cout << "YES" << endl;
        else
            cout << "No" << endl;
    }
}