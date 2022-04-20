#include <bits/stdc++.h>
using namespace std;

#define MAX 100005

int N, M;

/*----------------------------------------------
Union find is an effecient way to keep track of
connected components while initializing a graph
*/
int link[MAX], sz[MAX];

// representative
int find(int x)
{
    // move up component
    while (x != link[x])
        x = link[x];
    return x;
}

bool same(int a, int b) { return find(a) == find(b); }

void unite(int a, int b)
{
    // finds representatives
    a = find(a);
    b = find(b);
    if (sz[a] < sz[b])
        swap(a, b);
    sz[a] += sz[b];
    // connect hypothetical components
    link[b] = a;
}

//------------------------------------------------

/*
Spanning trees are an application of union find,
using the properties of trees to genereate a tree
from a graph with the minimum or maximum edge length sum;
*/
vector<tuple<int, int, int>> edges; // length, a, b
vector<int> adj[MAX];

int min_span_tree()
{
    int length = 0;
    sort(begin(edges), end(edges));
    for (auto e : edges)
    {
        int l = get<0>(e), a = get<1>(e), b = get<2>(e);
        if (!same(a, b))
        {
            unite(a, b);
            adj[a].push_back(b);
            adj[b].push_back(a);
            length += l;
        }
    }
    return;
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        link[i] = i;
        sz[i] = 1;
    }
    for (int i = 0; i < M; i++)
    {
        int a, b, l;
        cin >> a >> b >> l;
        edges.push_back(a - 1, b - 1));
    }
    cout << min_span_tree << endl;
}