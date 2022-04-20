#include <bits/stdc++.h>
using namespace std;

void setIO(string name = "mixmilk")
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
    int c[3], m[3];
    for (int i = 0; i < 3; i++)
        cin >> c[i] >> m[i];
    for (int i = 0; i < 100; i++)
    {
        int a = i % 3;
        int b = (i + 1) % 3;
        int amnt = min(c[b] - m[b], m[a]);
        m[b] += amnt;
        m[a] -= amnt;
    }
    cout << m[0] << '\n'
         << m[1] << '\n'
         << m[2] << endl;
}