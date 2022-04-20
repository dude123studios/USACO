#include <bits/stdc++.h>
using namespace std;
int N;
struct Cow
{
    int x, y, id;
    bool north;
};
typedef pair<int, pair<Cow, Cow>> Event;
vector<Cow> ncow, ecow;
vector<Event> events;
vector<int> adj[1000];
int stuck[1000]; // what time they got stuck

void stop(int blame, int stopped, int t)
{
    stuck[stopped] = t;
    adj[blame].push_back(stopped);
}
int ans;
void dfs(int n, int p)
{
    ans++;
    for (int u : adj[n])
        if (u != p)
            dfs(u, n);
}

bool cmp(const Event &x, const Event &y) { return x.first < y.first; }
int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        char c;
        int x, y;
        cin >> c >> x >> y;
        if (c == 'N')
            ncow.push_back({x, y, i, 1});
        else
            ecow.push_back({x, y, i, 0});
        stuck[i] = 0;
    }
    for (auto nc : ncow)
    {
        for (auto ec : ecow)
        {
            if (nc.x > ec.x && nc.y < ec.y)
            {
                int distx = nc.x - ec.x;
                int disty = ec.y - nc.y;
                if (distx > disty)
                    events.push_back({disty, {ec, nc}});
                else if (disty > distx)
                    events.push_back({distx, {nc, ec}});
            }
        }
    }
    sort(events.begin(), events.end(), cmp);
    for (auto e : events)
    {
        Cow blame = e.second.second;
        Cow stopped = e.second.first;
        if (stuck[stopped.id])
            continue;
        int dist = stuck[blame.id];
        if (!stuck[blame.id])
            stop(blame.id, stopped.id, e.first);
        else if ((blame.north && (blame.y + dist > stopped.y)) || (!blame.north && (blame.x + dist > stopped.x)))
            stop(blame.id, stopped.id, e.first);
    }
    for (int i = 0; i < N; i++)
    {
        ans = -1;
        dfs(i, -1);
        cout << ans << endl;
    }
}