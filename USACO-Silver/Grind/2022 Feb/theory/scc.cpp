#include <bits/stdc++.h>
using namespace std;

#define MAX 100005

int N, M;
vector<int> adj[MAX], radj[MAX];
bool v[MAX];

vector<int> q;
void ff(int n)
{
    v[n] = 1;
    for (int i : adj[n])
    {
        if (!v[i])
            ff(i);
    }
    q.push_back(n);
}

int comp[MAX];
void dfs(int n, int c)
{
    v[n] = 1;
    comp[n] = c;
    for (int i : radj[n])
    {
        if (!v[i])
            dfs(i, c);
    }
}

void scc()
{
    for (int i = 0; i < N; i++)
        if (!v[0])
            ff(i);
    reverse(begin(q), end(q));
    fill(v, v + N, 0);

    int c = 0;
    for (int n : q)
    {
        if (!v[n])
            dfs(n, c++);
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a - 1].push_back(b - 1);
        radj[b - 1].push_back(a - 1);
    }
    scc();
}