#include <bits/stdc++.h>
using namespace std;
int N;

int a[252][252];
bool v[252][252];
pair<int, int> comp[252][252];
int dr[4] = {0, 0, 1, -1}, dc[4] = {1, -1, 0, 0};

set<pair<int, int>> adj[1000000]; // v-> edges with {id, cluster num}
vector<int> clusters[10000000];
void dfs(int r, int c, int id)
{
    v[r][c] = 0;
    for (int i = 0; i < 4; i++)
    {
        int nr = dr[i] + r;
        int nc = dc[i] + c;
        if (v[nr][nc] == 1)
            dfs(nr, nc, id);
    }
}

int main()
{
    freopen("multimoo.in", "r", stdin);
    freopen("multimoo.out", "w", stdout);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> a[i + 1][j + 1];
            v[i + 1][j + 1] = 1;
        }
    }
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            if (v[i][j] == 1)
            {
                dfs(i, j, a[i][j]);
            }
        }
    }
}