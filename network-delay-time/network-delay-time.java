class Solution {
    //DS
    List<List<Node>> adj;
    int[] dist;
    Set<Integer> settled;
    PriorityQueue<Node> nonSettled;
    
    class Node implements Comparator<Node>{
            int node;
            int cost;
            public Node(int n,int c){node = n;cost =c;}
            public int compare(Node n1,Node n2)            {
                if(n1.cost<n2.cost) return -1;
                if(n1.cost>n2.cost) return 1;
                return 0;
            }
        }
    public int networkDelayTime(int[][] times, int n, int k) {
       
       //Construct the graph
        int V =n;
        
        //Dijkstra Algo DS
        dist = new int[V+1];
        settled = new HashSet<Integer>();
        nonSettled = new PriorityQueue<Node>((n1,n2) -> {
             if(n1.cost<n2.cost) return -1;
                if(n1.cost>n2.cost) return 1;
                return 0;
        });           

        adj = new ArrayList<List<Node>>(V+1);
        for(int i =0;i<=V;i++){
            adj.add(new ArrayList<Node>());
        }
        //construct the graph
        for(int i =0;i<times.length;i++){
            adj.get(times[i][0]).add(new Node(times[i][1],times[i][2]));
        }
        
        //Dijkstra
        //Assign infinity to dist array
        for(int i =0;i<=V;i++){
            dist[i]= Integer.MAX_VALUE;
        }
        
        //Assign 0 to src
        dist[k] = 0;
        dist[0] = Integer.MIN_VALUE;
        
        //add the src to nonSettled
        nonSettled.add(new Node(k,0));
        
        //Loop till all vertex move to settled set
        while(settled.size() != V){
            
            //if settled set doesn't contains all vertex but in nonSettled queue if you don't have node then that means some vertex is not reachable from src
            if(nonSettled.isEmpty())
                return -1;
            
            int next = nonSettled.remove().node;
            
            //if next is already settled then continue the loop
            if(settled.contains(next)) continue;
            
            //else add it to settled
            settled.add(next);
            
            updateNeighbours(next);
        }
       
        //if get the max of the dist array and return it becoz by the time signal reach the node which is at max distance ,signal will reach all other nodes
        int max = Integer.MIN_VALUE;
        for(int i =0;i<=n;i++){
          //  System.out.println("Distance is "+ dist[i]);
            if(max < dist[i])
                max = dist[i];
        }
        
        return max;
                        
    }
    
    public void updateNeighbours(int curr){
        //loop through the neighbour and update their distance
        for(int i =0;i<adj.get(curr).size();i++){
            Node neighbour = adj.get(curr).get(i);
            
            //if the neighbour is not settled
            if(!settled.contains(neighbour.node)){
                int edgeDistance = neighbour.cost;
                int newDistance = edgeDistance + dist[curr];
                //if the newDistance is lesser than already existing distance then update it
                if(newDistance < dist[neighbour.node]){
                    dist[neighbour.node] = newDistance;
                }
                //add the neighbour to nonSettled pq with its cost
                nonSettled.add(new Node(neighbour.node,dist[neighbour.node]));
            }
        }
    }
    
    
}