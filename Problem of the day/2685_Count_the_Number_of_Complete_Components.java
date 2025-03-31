// Date: 22-02-2023

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

       for(int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int[] v = {0};
            int[] e = {0};
            dfs(i, adj, visited, v, e);

            if ((v[0] * (v[0] - 1)) == e[0])
                result++;
        }
        return result;
    }

    void dfs(int i, List<List<Integer>> adj, boolean[] visited, int[] v, int[] e) {
        visited[i] = true;
        v[0]++;
        e[0] += adj.get(i).size();

        for (int it : adj.get(i)) {
            if (!visited[it]) {
                dfs(it, adj, visited, v, e);
            }
        }
    }
}