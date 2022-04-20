#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, K;
    cin >> N >> K;
    int p[N];
    vector<int> s[N];
    vector<pair<int, int>> swaps(K);
    int c[N], ans[N];
    bool v[N];
    for (int i = 0; i < K; i++)
    {
        int a, b;
        cin >> a >> b;
        swaps[i] = {a - 1, b - 1};
    }
    for (int i = 0; i < N; i++)
    {
        c[i] = i;
        s[i].push_back(i);
    }
    for (int i = 0; i < K; i++)
    {
        int a = swaps[i].first, b = swaps[i].second;
        s[c[a]].push_back(b);
        s[c[b]].push_back(a);
        int temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
    for (int i = 0; i < N; i++)
        p[c[i]] = i;

    // dfs
    for (int i = 0; i < N; i++)
    {
        if (v[i] == 1)
            continue;
        int curr = i;
        set<int> q;
        vector<int> cycle;
        while (v[curr] != 1)
        {
            v[curr] = 1;
            for (int x : s[curr])
                q.insert(x);
            cycle.push_back(curr);
            curr = p[curr];
        }
        int unique = q.size();
        for (int cow : cycle)
            ans[cow] = unique;
    }
    for (int i = 0; i < N; i++)
        cout << ans[i] << endl;
}