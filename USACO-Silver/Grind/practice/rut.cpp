#include <bits/stdc++.h>
using namespace std;

int N;
vector<array<int, 3>> n, e;
int inf = 1e9;
const int maxN = 1e4;
vector<int> p(maxN), ans(maxN);
// cause, victim, time
priority_queue<array<int, 3>> inter;
bool stuck[maxN];

int main()
{
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        string dir;
        int x, y;
        cin >> dir >> x >> y;
        if (dir[0] == 'E')
            e.push_back({i, x, y});
        else
            n.push_back({i, x, y});
    }

    for (auto i : n)
    {
        for (auto j : e)
        {
            if (i[1] >= j[1] && j[2] >= i[2])
            {
                int distx = i[1] - j[1], disty = j[2] - i[2];
                if (distx < disty)
                    inter.push({j[0], i[0], distx});
                else if (disty < distx)
                    inter.push({i[0], j[0], disty});
            }
        }
    }
}