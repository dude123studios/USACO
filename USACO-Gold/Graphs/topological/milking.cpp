#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;
const int MAX = 1e5 + 1;
int N, M;
vector<pii> adj[MAX];
deque<int> top_sort;
bool possible;
int v[100001];
void dfs(int u, int x)
{
    if (v[u] == 1)
        possible = 0;
    if (!possible)
        return;
    v[u] = 1;
    for (pii n : adj[u])
        if (n.second <= x && v[n.first] != 2)
            dfs(n.first, x);
    v[u] = 2;
    top_sort.push_back(u);
}

bool check(int x)
{
    top_sort.clear();
    fill(v, v + N + 1, 0);
    possible = 1;
    for (int i = N; i >= 1; i--)
        if (!v[i])
            dfs(i, x);
    return possible;
}

int main()
{

    freopen("milkorder.in", "r", stdin);
    freopen("milkorder.out", "w", stdout);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int mi, last;
        cin >> mi >> last;
        while (--mi)
        {
            int a;
            cin >> a;
            adj[last].push_back({a, i});
            last = a;
        }
    }
    for (int i = 1; i <= N; i++)
        sort(adj[i].begin(), adj[i].end(), greater<pii>());

    int lo = 0, hi = M;
    while (lo < hi)
    { // find the last successful check()
        int mid = lo + (hi - lo + 1) / 2;
        check(mid) ? lo = mid : hi = mid - 1;
    }
    while (top_sort.size() > 1)
    {
        cout << top_sort.back() << " ";
        top_sort.pop_back();
    }
    cout << top_sort.back();
}