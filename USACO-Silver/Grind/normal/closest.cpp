#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int N, K, M;
int f[200000];
vector<pair<int, int>> patches;
vector<ll> gains;

int main()
{
    cin >> K >> M >> N;
    for (int i = 0; i < K; i++)
    {
        int p, t;
        cin >> p >> t;
        patches.push_back({p, t});
    }
    sort(patches.begin(), patches.end());
    for (int i = 0; i < M; i++)
        cin >> f[i];
    sort(f, f + M);
    int patch = 0;
    // left side
    int leftgain = 0;
    while (patches[patch].first < f[0])
    {

        leftgain += patches[patch].second;
        patch++;
    }
    gains.push_back(leftgain);

    // inside
    for (int i = 1; i < N; i++)
    {
        ll maxsum = 0, sum = 0;
        ll length = (f[i] - f[i - 1]) / 2;
        int l = patch, r = patch;
        while (1)
        {
            while (r < patches.size() && patches[r].first < f[i] && patches[r].first <= patches[l].first + length)
            {
                sum += patches[r++].first;
                maxsum = max(maxsum, sum);
            }
            if (r >= patches.size() || patches[r].first >= f[i])
                break;
            while (patches[r].first > patches[i].first + length)
            {
                sum -= patches[i].first;
                i++;
            }
        }
    }
}