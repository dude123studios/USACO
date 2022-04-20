#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pi;
#define f first
#define s second
#define pb push_back
#define all(x) begin(x), end(x)
#define sz(x) (int)(x).size()

int N, M;
vi adj[100005][2];
bool v[100005];

void dfs(int x, int t)
{
    v[x] = 1;
    for (int i : adj[x][t])
    {
        if (!v[i])
            dfs(i, t);
    }
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        adj[a - 1][0].pb(b - 1);
        adj[b - 1][1].pb(a - 1);
    }
    dfs(0, 0);
    for (int i = 0; i < N; i++)
    {
        if (!v[i])
        {
            cout << "NO" << endl;
            cout << 1 << " " << i + 1 << endl;
            return 0;
        }
    }
    memset(v, false, sizeof(v));
    dfs(0, 1);
    for (int i = 0; i < N; i++)
    {
        if (!v[i])
        {
            cout << "NO" << endl;
            cout << i + 1 << " " << 1 << endl;
            return 0;
        }
    }
    cout << "YES" << endl;
}