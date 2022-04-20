#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, C;
    cin >> N >> C;
    bool a[8][6] = {{0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0}, {0, 1, 0, 1, 0, 1}, {0, 1, 1, 0, 1, 1}, {1, 0, 0, 1, 0, 0}, {1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1}};
    int next;
    bool t[6];
    while (true)
    {
        cin >> next;
        if (next == -1)
            break;
        on.push_back(next);
    }
    while (true)
    {
        cin >> next;
        if (next == -1)
            break;
        off.push_back(next);
    }
}