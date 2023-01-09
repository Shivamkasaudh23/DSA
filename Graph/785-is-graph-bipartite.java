class Solution {
    public boolean isBipartite(int[][] graph){ 
        int len = graph.length;
        int color [] = new int[len];
    
        Arrays.fill(color,-1);
    
    for(int i=0; i<len; i++){
        if(color[i] == -1){
            if(bfs(graph,i,color) == false){
                return false;
            }
        } 
    }
        return true;
        
    }

    boolean bfs(int[][] graph, int i, int [] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int x : graph[temp]){
                if(color[x] == -1){
                    color[x] = 1-color[temp];
                    q.add(x);
                }
                else if(color[x] == color[temp]){
                    return false;
                }    
                
            }
        }
        return true;
    }
}