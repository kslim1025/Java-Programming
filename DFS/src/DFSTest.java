public class DFSTest {

	/**

	 * 这里是文档说明

	 * 算法如下

	 *开始

	 *Start;

	 *

	 * procedure DFS_visit(G,u)

	 * color[u] = Gray;//白色结点u已被发现

	 * for each edge (u,v)do

	 *     if color[u] = White then

	 *     DFS_visit(G,v);

	 *     repeat color[u]=black;//完成后置u为黑色  

	 * end;

	 * 

	 * procedure DFS(G)

	 * for each vertex u 属于V do

	 * color[u] = white

	 * for vertex each u 属于 V do

	 * if color[u]=white

	 * then DFS_visit(G,u)

	 * repeat

	 * 

	 * 

	 * 构建一个无向图

	 * 无穷大表示这两个点无边，1表示两者有边

	 * 白色用1表示，灰色用2表示，黑色用3表示

	 * 初始状态均为白色

	 * 搜索中被发现的顶点置为灰色

	 * 结束时，即其邻接表被完全检索之后，其被置为黑色

	 * 构建一个color[8]数组，其中color[0]不用

	 * 初始化为0

	 * S表示无穷大

	 *   0 1 2 3 4 5 6 7 8

	 * -------------------------

	 * 0 

	 * 1   s 1 1 s s s s s

	 * 2   1 s s 1 1 s s s

	 * 3   1 s s s s 1 1 s

	 * 4   s 1 s s s s s 1

	 * 5   s 1 s s s s s 1

	 * 6   s s 1 s s s 1 s

	 * 7   s s 1 s s 1 s s

	 * 8   s s s 1 1 s s s

	 * 

	 * 深度优先搜索的结果应该为

	 * 1-2-4-8-5-3-6-7

	 * 

	 * @param args

	 */

	static int color[];

	static int d =0;

	public static void main(String[] args) {

	

		int s = Integer.MAX_VALUE;

		int G[][]={{s,s,s,s,s,s,s,s,s},

				   {s,s,1,1,s,s,s,s,s},

				   {s,1,s,s,1,1,s,s,s},

				   {s,1,s,s,s,s,1,1,s},

				   {s,s,1,s,s,s,s,s,1},

				   {s,s,1,s,s,s,s,s,1},

				   {s,s,s,1,s,s,s,1,s},

				   {s,s,s,1,s,s,1,s,s},

				   {s,s,s,s,1,1,s,s,s}};

		color = new int [9];

		

		ProcedureDFS(G,9);

	}

	

	public static void ProcedureDFS(int [][]G,int n){

		//图是以二维数组的形式保存

		//n是二维数组的维数

		

		

		for(int i=1;i <= n-1;i++){

			

			color[i]=1;//把每一个顶点都置为白色，表示还没搜索			

		}

		

		for(int i=1;i<= n-1;i++){

			

			//对于每一个顶点没被访问的顶点进行访问

			if(color[i] == 1){

				

				DFS_visit(G,i);//遍历其访问的顶点				

			}

			

		}

		

		

	}

 

	private static void DFS_visit(int[][] g, int i) {

		// TODO 自动生成的方法存根

		color[i] = 2;//标志为灰色，表示被访问过

		d++;

		if(d != g.length-1)

			System.out.print(""+i+" -> ");

	    if(d == g.length-1)

		System.out.println(""+i);

		for(int t=1;t<= g.length-1;t++){

			//邻接点没有被访问到

			if(color[t] == 1 && g[i][t] != Integer.MAX_VALUE){

				DFS_visit(g,t);

			}				

		}		

		color[i] = 3;//标志位黑色		

	}

	
}