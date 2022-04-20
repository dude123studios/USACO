#include <bits/stdc++.h>
using namespace std;
#define pi pair<int, int>
#define f first
#define s second
#define pb push_back
#define mp make_pair
const int MAX = 1e5 + 2;
int N;
pi pts[MAX];
vector<vector<int>> dist(2, vector<int>(MAX, -1));
unordered_map<int, vector<int>> lines[2];
queue<pi> q;

int main()
{
    freopen("lasers.in", "r", stdin);
    freopen("lasers.out", "w", stdout);
    cin >> N;
    for (int i = 0; i < N + 2; i++)
    {
        cin >> pts[i].f >> pts[i].s;
        lines[0][pts[i].f].pb(i);
        lines[1][pts[i].s].pb(i);
    }

    q.push(mp(0, 0));
    q.push(mp(1, 0));
    dist[0][0] = dist[1][0] = 0;
    while (!q.empty())
    {
        int dir = q.front().f, id = q.front().s;
        q.pop();
        int ndir = dir ? 0 : 1;
        int line = dir ? pts[id].f : pts[id].s;
        for (int nid : lines[ndir][line])
            if (dist[ndir][nid] == -1)
            {
                dist[ndir][nid] = dist[dir][id] + 1;
                q.push(mp(ndir, nid));
            }
    }
    cout << min(dist[0][1], dist[1][1]) - 1 << endl;
}