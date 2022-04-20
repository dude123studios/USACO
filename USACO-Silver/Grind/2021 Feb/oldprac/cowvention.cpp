#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "convention2")
{
    cin.tie(0)->sync_with_stdio(0); // see /general/fast-io
    if ((int)(name).size())
    {
        freopen((name + ".in").c_str(), "r", stdin); // see /general/input-output
        freopen((name + ".out").c_str(), "w", stdout);
    }
}

int main()
{
    setIO();
    int N;
    cin >> N;
    // seniority -> {arrival, time}
    vector<vector<int>> c;
    // {time, start or end of term, seniority}
    priority_queue<vector<int>> events;
    for (int i = 0; i < N; i++)
    {
        int a, t;
        cin >> a >> t;
        c.push_back({i, a, t});
        events.push({c[i][1], 1, i});
    }
    for (int i = 0; i < N; i++)
    {
        events.push({c[i][1], 1, i});
    }
    int nextDone = 0, ans = 0;
    // seniority
    set<int> waiting;
    while (!events.empty())
    {
        vector<int> e = events.top();
        events.pop();
        if (e[1])
        {
            // start of wait
            if (nextDone < e[0])
            {
                // cow can instantly go
                nextDone = e[0] + c[e[2]][1];
                events.push({nextDone, 0, e[2]});
            }
            else
                waiting.insert(e[2]);
        }
        else
        {
            if (waiting.empty())
                continue;
            int nextCow = *waiting.begin();
            nextDone = e[0] + c[e[2]][1];
            events.push()
        }
    }
}