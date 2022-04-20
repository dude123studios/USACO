#include <bits/stdc++.h>
using namespace std;
int N, M;
int starts[5002], stops[5002];
long long ps[10004];

int main()
{
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        int a, b;
        cin >> a >> b;
        starts[a]++;
        stops[b]++;
    }
    for (int i = 0; i <= M; i++)
        for (int j = 0; j <= M; j++)
        {
            ps[i + j] += starts[i] * starts[j];
            ps[i + j + 1] -= stops[i] * stops[j];
        }
    for (int i = 1; i <= 2 * M; i++)
        ps[i] += ps[i - 1];
    for (int i = 0; i <= 2 * M; i++)
        cout << ps[i] << endl;
}