#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "socdist")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}

typedef long long ll;
int N, M;
pair<ll, ll> intervals[100000];

bool check(int d)
{
    int interval = 0;
    ll last = intervals[0].first;
    for (int i = 1; i < N; i++)
    {
        while (interval < M && intervals[interval].second < last + d)
        {
            interval++;
        }
        if (interval == M)
            return false;
        last = max(intervals[interval].first, last + d);
    }
    return true;
}

int main()
{
    setIO();
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> intervals[i].first >> intervals[i].second;
    }
    sort(intervals, intervals + M);

    int x = -1;
    for (int b = intervals[M - 1].second / N + 1; b >= 1; b /= 2)
    {
        while (check(x + b))
            x += b;
    }
    cout << x;
}