#include <bits/stdc++.h>
using namespace std;

#define MAX 100000

int N, M;
int comp[MAX];
vector<int> adj[MAX], ct;
int v[MAX]; // 0 -> G, 1 -> H, 2 -> V

void dfs(int n, int c)
{
    int t = v[n];
    v[n] = 2;
    comp[n] = c;
    for (int i : adj[n])
    {
        if (v[i] != t)
            continue;
        dfs(i, c);
    }
}

int main()
{
    freopen("milkvisits.in", "r", stdin);
    freopen("milkvisits.out", "w", stdout);
    string l;
    cin >> N >> M >> l;
    for (int i = 0; i < N; i++)
        v[i] = l[i] == 'G' ? 0 : 1;
    for (int i = 0; i < N - 1; i++)
    {
        int x, y;
        cin >> x >> y;
        adj[x - 1].push_back(y - 1);
        adj[y - 1].push_back(x - 1);
    }
    int c = 0;
    for (int i = 0; i < N; i++)
    {
        if (v[i] == 2)
            continue;
        ct.push_back(v[i]);
        dfs(i, c);
        c++;
    }

    for (int i = 0; i < M; i++)
    {
        int a, b;
        char c;
        cin >> a >> b >> c;
        int t = c == 'G' ? 0 : 1;
        int ca = comp[a - 1], cb = comp[b - 1];
        if (ct[ca] == t || ca != cb)
            cout << 1;
        else
            cout << 0;
    }
    cout << '\n';
}