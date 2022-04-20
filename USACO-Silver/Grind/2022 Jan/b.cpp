#include <bits/stdc++.h>
using namespace std;

bool beats(vector<int> f, vector<int> s)
{
    int first = 0, second = 0;
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            if (f[i] > s[j])
                first++;
            if (s[i] > f[j])
                second++;
        }
    }
    return first > second;
}

vector<vector<int>> cs;
vector<int> curr;
void generate(int el)
{
    if (el == 4)
        cs.push_back(curr);
    else
    {
        for (int i = 1; i <= 10; i++)
        {
            curr.push_back(i);
            generate(el + 1);
            curr.pop_back();
        }
    }
}

bool solve()
{
    vector<int> a(4), b(4);
    for (int i = 0; i < 4; i++)
        cin >> a[i];
    for (int i = 0; i < 4; i++)
        cin >> b[i];
    bool wins = beats(a, b);
    if (wins) // a wins
    {
        for (int i = 0; i < cs.size(); i++)
        {
            vector<int> c = cs[i];
            if (beats(c, a) && beats(b, c))
                return true;
        }
    }
    else // b wins
    {
        for (int i = 0; i < cs.size(); i++)
        {
            vector<int> c = cs[i];
            if (beats(c, b) && beats(a, c))
                return true;
        }
    }
    return false;
}

int main()
{
    int T;
    cin >> T;
    generate(0);
    for (int k = 0; k < T; k++)
    {
        if (solve())
        {
            cout << "yes" << '\n';
        }
        else
        {
            cout << "no" << '\n';
        }
    }
}