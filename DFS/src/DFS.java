
public class DFS {

	private int matrix[][];
	private int totalV;
	private boolean visited[];
	
	public DFS(int totalV) {
	
		matrix= new int[totalV][totalV];
		this.totalV=totalV;
		visited= new boolean[totalV];
		
		for(int i=0; i<totalV; i++) {
			visited[i]=false;
		}
		
	}
	
	 /*public void insertVertex(int v){
    	totalV ++;
		}*/
	
	public void insertEdge(int v1,int v2) {
		if(v1>totalV || v2>totalV) {
			  System.out.println("오류");
		}else{
            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }
	}
	
	public void startSearch(int V) {
		visited[V] =true;
		int next =-1;
		
		//System.out.print(V+",");
        System.out.printf("%c ", V+65);
        ArrayStack stack= new ArrayStack(totalV*totalV);
        stack.push(V);
        
        while(!stack.isEmpty()) {
        	next= getUnvisitedVertex(stack.peek());
        	
        	if(next==-1) {
        		stack.pop();
        	}else {
        		visited[next]=true;
        		//System.out.print(next+",");
        		System.out.printf("%c ", next+65);
                stack.push(next);
        	}
        }
        
	}
	 public int getUnvisitedVertex(int v) {
	        for(int i=0; i<totalV;i++) {
	        	if(matrix[v][i]==1&&visited[i]==false) {
	        		return i;
	        	}
	        }
	        	return -1;
	        }
}