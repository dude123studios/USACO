#include <bits/stdc++.h>
using namespace std;

#define MAXN 100000
#define MAXM 100
int N, M, K;
int p[MAXN], l[MAXM], r[MAXM], c[MAXN];
bool v[MAXN];
int main()
{

    freopen("swap.in", "r", stdin);
    freopen("swap.out", "w", stdout);

    cin >> N >> M >> K;
    for (int i = 0; i < M; i++)
    {
        cin >> l[i] >> r[i];
        l[i]--;
    }
    for (int i = 0; i < N; i++)
        c[i] = i;
    for (int i = 0; i < M; i++)
        reverse(c + l[i], c + r[i]);
    for (int i = 0; i < N; i++)
        p[c[i]] = i;
    int ans[N];
    for (int i = 0; i < N; i++)
    {
        if (v[i] == 1)
            continue;
        int curr = i;
        vector<int> cycle;
        while (v[curr] != 1)
        {
            v[curr] = 1;
            cycle.push_back(curr);
            curr = p[curr];
        }
        int sz = cycle.size();
        int r = K % sz;
        for (int j = 0; j < sz; j++)
            ans[cycle[j]] = cycle[(j + r) % sz];
    }
    for (int i = 0; i < N; i++)
        cout << ans[i] + 1 << endl;
}