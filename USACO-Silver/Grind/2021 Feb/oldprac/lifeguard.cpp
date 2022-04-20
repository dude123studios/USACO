#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "lifeguards")
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
    int t;
    int l;
    bool s;
    bool operator<(const E &e) { return t < e.t; }
};

int main()
{
    setIO();
    int N;
    cin >> N;
    vector<E> events;
    for (int i = 0; i < N; i++)
    {
        int t1, t2;
        cin >> t1 >> t2;
        events.push_back({t1, i, 1});
        events.push_back({t2, i, 0});
    }
    sort(events.begin(), events.end());

    set<int> active;
    vector<int> alone(N, 0);
    int totalTime = 0;
    int prevTime = 0;
    for (auto ev : events)
    {
        if (active.size() > 0)
            totalTime += ev.t - prevTime;
        if (active.size() == 1)
            alone[*active.begin()] += ev.t - prevTime;
        if (ev.s)
            active.insert(ev.l);
        else
            active.erase(ev.l);
        prevTime = ev.t;
    }

    int m(1e9);
    for (int i = 0; i < N; i++)
    {
        m = min(m, alone[i]);
    }
    cout << totalTime - m << endl;
}