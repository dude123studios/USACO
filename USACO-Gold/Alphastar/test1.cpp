#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int N, x[13], y[13];
int tp[13], adj[13];
bool v[13];
ll ans = 0;

bool check()
{
    // brute force starting at every node and looping N times (max length until a break)
    // pray this aint too slow
    for (int i = 1; i <= N; i++)
    {
        int pos = i;
        for (int j = 0; j < N; j++)
            pos = tp[adj[pos]];
        if (pos > 0)
            return 1;
    }
    return 0;
}
void mkpairs()
{
    // always pick unvisited to not count extra permuations
    int i;
    for (i = 1; i <= N; i++)
        if (tp[i] == 0)
            break;
    if (i == N + 1)
        // every pair ready
        if (check())
            ans++;
    for (int j = i + 1; j <= N; j++)
        if (tp[j] == 0)
        {
            tp[i] = j;
            tp[j] = i;
            mkpairs();
            tp[i] = 0;
            tp[j] = 0;
        }
}

int main()
{
    cin >> N;
    for (int i = 1; i <= N; i++)
        cin >> x[i] >> y[i];
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            if (i != j && y[i] == y[j] && x[j] > x[i])
                if (adj[i] == 0 || x[j] < x[adj[i]])
                    adj[i] = j;
    mkpairs();
    cout << ans << endl;
}