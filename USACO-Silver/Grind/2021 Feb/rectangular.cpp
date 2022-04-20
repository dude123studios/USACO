#include <bits/stdc++.h>
using namespace std;

typedef pair<int, int> P;

bool ycomp(P p, P q) { return p.second < q.second; }

int ps[2501][2501];

int rsum(int x2, int y2, int x1, int y1) {
    return ps[x2]
}

int main()
{
    int N;
    cin >> N;
    P coords[N];

    // compress coords
    sort(coords, coords + N);
    for (int i = 0; i < N; i++)
        coords[i].first = i;
    sort(coords, coords + N, ycomp);
    for (int i = 0; i < N; i++)
        coords[i].second = i;

    // first define ps to be regular array
    for (int i = 0; i < N; i++)
    {
        ps[coords[i].first + 1][coords[i].second + 1] = 1;
    }
    // compute ps
    for (int i = 1; i <= N; i++)
    {
        for (int j = 0; j <= N; j++)
        {
            ps[i][j] = ps[i][j] + ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
        }
    }
    long long ans = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = i + 1; j < N; j++)
        {
            ps[coords[j].second][coords[i].first]
        }
    }
}