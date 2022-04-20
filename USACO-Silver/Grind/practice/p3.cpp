#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N, M;
    cin >> N >> M;
    pair<int, int> itv[N];
    for(int i =0; i<N; i++) {
        int a, b;
        cin >> a >> b;
        itv[i] = {a, b};
    }

    //diff between -1, 0, 1... 2 * M, 2 * M + 1
    int kdif[2 * M + 2];
    fill(kdif, kdif + 2 * M + 3, 0);
    for(int i=0; i<N; i++) {
        for(int j = 0; i<N; j++) {
            int s = itv[i].first + itv[j].first, e = itv[i].second + itv[j].second;
            kdif[e]--;
            kdif[s-1]++;
    }
}