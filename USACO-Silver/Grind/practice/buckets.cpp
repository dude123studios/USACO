#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "blist")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}
struct E
{
    int t, id;
    bool s;
    bool operator<(const E &o)
    {
        return t < o.t;
    }
};

int main()
{
    setIO();
    int N;
    vector<E> ev;
    int b[N];
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int s, t;
        cin >> s >> t >> b[i];
        ev.push_back({s, i, 1});
        ev.push_back({t, i, 0});
    }
    sort(ev.begin(), ev.end());
    int active = 0, maxval;
    for (auto &it : ev)
    {
        if (it.s)
            active += b[it.id];
        else
            active -= b[it.id];
        maxval = max(active, maxval);
    }
    cout << maxval << endl;
}