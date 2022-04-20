#include <bits/stdc++.h>
using namespace std;

using P = pair<long long, long long>;
P operator+(P a, P b) { return {a.first + b.first, a.second + b.second}; }
P operator-(P a, P b) { return {a.first - b.first, a.second - b.second}; }
struct hsh
{
    size_t operator()(const P &p) const
    {
        return p.first * 239 + p.second;
    }
};
int N;
unordered_map<P, multiset<int>, hsh> mp;
vector<P> all(40);
int ans[41];
P g;

int main()
{
    cin >> N >> g.first >> g.second;
    for (int i = 0; i < N; i++)
        cin >> all[i].first >> all[i].second;
    int F = N / 2, S = N - F;
    for (int i = 0; i < (1 << F); i++)
    {
        int cnt = 0;
        P s;
        for (int j = 0; j < F; j++)
            if ((i & (1 << j)) == 1)
            {
                s = s + all[j];
                cnt++;
            }

        if (mp.find(s) == mp.end())
        {
            multiset<int> nset;
            nset.insert(cnt);
            mp[s] = nset;
        }
        else
            mp[s].insert(cnt);
    }
    for (int i = 0; i < (1 << S); i++)
    {
        int cnt = 0;
        P s;
        for (int j = 0; j < S; j++)
            if ((i & (1 << j)) == 1)
            {
                s = s + all[j + F];
                cnt++;
            }
        P r = g - s;
        if (mp.find(r) != mp.end())
        {
            for (const auto &n : mp[r])
            {
                ans[n + cnt]++;
            }
        }
    }
    for (int i = 1; i <= N; i++)
        cout << ans[i] << endl;
}