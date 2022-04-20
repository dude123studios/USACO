#include <bits/stdc++.h>
using namespace std;
#define MAXN 100000
int N, M;
int f[MAXN], s[MAXN], ans[MAXN], used[MAXN];

void update(int cow, bool first, int curr)
{
    int cereal = -1;
    if (first == 1)
        cereal = f[cow];
    else
        cereal = s[cow];
    if (used[cereal] == -1)
    {
        used[cereal] = cow;
        return;
    }
    if (used[cereal] < cow)
    {
        int next = used[cereal];
        used[cereal] = cow;
        if (cereal = f[next])
            update(next, false, curr);
        else
            ans[curr]--;
        return;
    }
    if (first)
        return update(cow, false, curr);
    ans[curr]--;
}

int main()
{
    cin >> N >> M;
    fill(used, used + M, -1);
    for (int i = 0; i < N; i++)
    {
        int first, second;
        cin >> first >> second;
        f[i] = first - 1;
        s[i] = second - 1;
    }

    reverse(f, f + N);
    reverse(s, s + N);

    ans[0] = 1;
    for (int i = 0; i < N; i++)
    {
        update(i, true, i);
        ans[i] = ans[i - 1] + 1 - ans[i];
    }
    reverse(ans, ans + N);
    for (int i = 0; i < N; i++)
        cout << ans[i] << endl;
}