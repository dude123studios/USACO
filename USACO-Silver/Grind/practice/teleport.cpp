#include <bits/stdc++.h>
using namespace std;
//         cow-> pos , pos -> cow
int N, M, a[10000], reva[10000], lengths[10000];
vector<pair<int, int>> w[10000];
bool v[10000];
set<int> s1, s2; // poses, cows

void dfs(int pos, int x)
{
    v[pos] = true;
    s1.insert(reva[pos]);
    s2.insert(pos);
    for (auto p : w[pos])
    {
        if (v[p.first] || p.second < x)
            continue;
        dfs(p.first, x);
    }
}

int yes(int x)
{
    for (int i = 0; i < N; i++)
        v[i] = false;
    for (int i = 0; i < N; i++)
    {
        if (v[i])
            continue;
        s1.clear();
        s2.clear();
        dfs(i, x);
        if (s1 != s2)
            return false;
    }
    return true;
}

bool sorted()
{
    for (int i = 0; i < N; i++)
        if (a[i] != i)
            return false;
    return true;
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> a[i];
        a[i]--;
        reva[a[i]] = i;
    }
    for (int i = 0; i < M; i++)
    {
        int a, b, h;
        a--;
        b--;
        w[a].push_back({b, h});
        w[b].push_back({a, h});
        lengths[i] = h;
    }
    if (sorted())
    {
        cout << -1 << endl;
        return 0;
    }

    sort(lengths, lengths + M);

    int L = 0, R = M - 1;
    while (L < R)
    {
        int mid = (L + R) / 2;
        if (yes(lengths[mid]))
            L = mid;
        else
            R = mid - 1;
    }
    cout << lengths[L] << endl;
}