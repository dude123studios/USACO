#include <bits/stdc++.h>
using namespace std;

int N;
priority_queue<int, vector<int>, greater<int>> waiting; // seniority
int waiting_since[100000], length[100000];

struct event
{
    int t, s;
    int start;
    bool operator<(const event &y) const
    {
        if (t == y.t)
        {
            if (start != y.start)
                return start < y.start;
            return s > y.s;
        }
        return t > y.t;
    }
};

priority_queue<event> events; // time, {seniority, if start}
int main()
{

    freopen("convention2.in", "r", stdin);
    freopen("convention2.out", "w", stdout);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int a, t;
        cin >> a >> t;
        events.push({a, i, 1});
        length[i] = t;
    }
    bool eating = 0;
    int ans = 0;
    while (!events.empty())
    {
        auto ev = events.top();
        events.pop();
        if (ev.start == 1)
        {
            if (eating == 1)
            {
                waiting.push(ev.s);
                waiting_since[ev.s] = ev.t;
            }
            else
            {
                eating = 1;
                events.push({ev.t + length[ev.s], ev.s, 0});
            }
        }
        else
        {
            eating = 0;
            if (!waiting.empty())
            {
                eating = 1;
                int nexts = waiting.top();
                waiting.pop();
                ans = max(ans, ev.t - waiting_since[nexts]);
                events.push({ev.t + length[nexts], nexts, 0});
            }
        }
    }
    cout << ans << endl;
}