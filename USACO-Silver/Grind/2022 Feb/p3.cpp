#include <bits/stdc++.h>
using namespace std;
int T;

int main()
{

    int M, N, K;
    cin >> M >> N >> K;
    vector<int> f(N);
    int fa = 1;
    int cnt[M];
    fill(cnt, cnt + N, 0);
    for (int i = 0; i < N; i++)
    {
        cin >> f[i];
        cnt[f[i] - 1]++;
    }
    int ea = 0;
    while (1)
    {

        set<int> rmv;
        for (int i = ea; i < min(ea + K, (int)f.size()); i++)
        {
            if (f[i] >= fa && f[i] < fa + K)
                rmv.insert(i);
        }
        vector<int> newf;
        for (int i = 0; i < f.size(); i++)
        {
            if (rmv.count(i))
            {
                cnt[f[i] - 1]--;
            }
            else
            {
                newf.push_back(f[i]);
            }
        }
        f.clear();
        f = newf;
        if (ea > f.size() - K)
            ea = max(0, (int)f.size() - K);
        for (int i : f)
        {
            cout << i << ' ';
        }
        cout << '\n';
        cout << fa << ", " << ea << endl;
        if (rmv.empty())
        {
            ea++;
            if ()
            {
                cout << "NO" << endl;
                break;
            }
        }
        if (cnt[fa - 1] <= 0)
            fa++;
        if (f.size() == 0)
        {
            cout << "YES" << endl;
            break;
        }
    }
}