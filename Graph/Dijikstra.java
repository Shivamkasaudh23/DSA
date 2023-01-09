//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class DriverClass
    {
        public static void main(String args[]) throws IOException {
    
            BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                String str[] = read.readLine().trim().split(" ");
                int V = Integer.parseInt(str[0]);
                int E = Integer.parseInt(str[1]);
        
                ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
                for(int i=0;i<V;i++)
                {
                    adj.add(new ArrayList<ArrayList<Integer>>());
                }
                
                int i=0;
                while (i++<E) {
                    String S[] = read.readLine().trim().split(" ");
                    int u = Integer.parseInt(S[0]);
                    int v = Integer.parseInt(S[1]);
                    int w = Integer.parseInt(S[2]);
                    ArrayList<Integer> t1 = new ArrayList<Integer>();
                    ArrayList<Integer> t2 = new ArrayList<Integer>();
                    t1.add(v);
                    t1.add(w);
                    t2.add(u);
                    t2.add(w);
                    adj.get(u).add(t1);
                    adj.get(v).add(t2);
                }
                
                int S = Integer.parseInt(read.readLine());
                
                Solution ob = new Solution();
                
                int[] ptr = ob.dijkstra(V, adj, S);
                
                for(i=0; i<V; i++)
                    System.out.print(ptr[i] + " ");
                System.out.println();
            }
        }
    }
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    
    class Solution
    {
        //Function to find the shortest distance of all the vertices
        //from the source vertex S.
        static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
        {
            // Write your code here
            int dis[] = new int[V];
            
            for(int i=0; i<V; i++){
                dis[i] = 1000000001;
            }
            
            dis[S] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<Node>(new pqComparator());
            pq.add(new Node(S,0));
            
            while(!pq.isEmpty()){
                Node node = pq.poll();
                
                for(ArrayList<Integer> it : adj.get(node.vertex)){
                    if(dis[node.vertex] + it.get(1) < dis[it.get(0)]){
                        dis[it.get(0)] = dis[node.vertex] + it.get(1);
                        pq.add(new Node(it.get(0),dis[it.get(0)]));
                    }
                }
            }
            return dis;
        }
    }
    class Node{
        int vertex;
        int weight;
        Node(int vertex, int weight){
            this.vertex=vertex;
            this.weight = weight;
        }
    }
    
    class pqComparator implements Comparator<Node>{
        public int compare(Node node1,Node node2){
            if(node1.weight<node2.weight){
                return -1;
            }
            else if(node1.weight > node2.weight){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
    