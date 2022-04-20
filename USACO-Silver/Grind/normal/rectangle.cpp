#include <bits/stdc++.h>
using namespace std;
typedef pair<int, int> pii;
int N;
int ps[2501][2501];
pii cow[2500];
bool ycmp(const pii &x, const pii &y) { return x.second < y.second; }

int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        int x, y;
        cin >> x >> y;
        cow[i] = {x, y};
    }
    sort(cow, cow + N);
    for (int i = 0; i < N; i++)
        cow[i].first = i + 1;
    sort(cow, cow + N, ycmp);
    for (int i = 0; i < N; i++)
        cow[i].second = i + 1;
    for (int i = 0; i < N; i++)
        ps[cow[i].first][cow[i].second] = 1;
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
    long long ans = 0;
    for (int i = 0; i < N; i++)
        for (int j = i + 1; j < N; i++)
        {
            int maxleft = min(cow[i].first, cow[j].first) - 1;
            int minright = max(cow[i].first, cow[j].first) - 1;
            int leftpos = ps[maxleft][j] - ps[maxleft][i] - ps[0][j] + ps[0][i];
            int rightpos = ps[N][j] - ps[N][i] - ps[minright][j] + ps[minright][i];
            ans += leftpos * rightpos;
        }
    cout << ans << endl;
}