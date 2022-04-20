#include <bits/stdc++.h>
using namespace std;

#define f first
#define s second

int main()
{

    freopen("meetings.in", "r", stdin);
    freopen("meetings.out", "w", stdout);

    int N, L, totalsum;
    cin >> N >> L;
    vector<pair<int, pair<int, int>>> cows(N); // x, w, d
    for (int i = 0; i < N; i++)
    {
        int x, d, w;
        cin >> w >> x >> d;
        cows[i] = {x, {w, d}};
        totalsum += w;
    }
    sort(begin(cows), end(cows));
    vector<int> ltimes, rtimes;
    for (auto c : cows)
    {
        if (c.s.s == 1)
            rtimes.push_back(L - c.f);
        else
            ltimes.push_back(c.f);
    }
    vector<pair<int, int>> tw;
    for (int i = 0; i < ltimes.size(); i++)
        tw.push_back({ltimes[i], cows[i].s.f});
    for (int i = 0; i < rtimes.size(); i++)
        tw.push_back({rtimes[i], cows[N - 1 - i].s.f});
    sort(begin(tw), end(tw));
    int sum = 0, T = 0, prevt;
    for (auto t : tw)
    {
        sum += t.s;
        if (prevt == t.f)
            continue;
        prevt = t.f;
        if (sum > totalsum / 2)
        {
            T = t.f;
            break;
        }
    }
    int ans = 0;
    for (int i = 0; i < N; i++)
        for (int j = i + 1; j < N; j++)
            if ((cows[j].s.s != cows[i].s.s) && (cows[j].f - cows[i].f <= 2 * T))
                ans++;

    cout << ans << endl;
}