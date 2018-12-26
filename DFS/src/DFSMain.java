import java.util.Scanner;

public class DFSMain {

	public DFSMain() {
		// TODO Auto-generated constructor stub
		Scanner scan= new Scanner(System.in);
		System.out.println("정점의 갯수");
		int totalV = scan.nextInt();
		
		DFS dfs= new DFS(totalV);
		/*for(int i = 0; i < totalV; i++){
        dfs.insertVertex(i);
    }*/
    
    System.out.print("간선의 개수 : ");
    int totalE = scan.nextInt();
    
    System.out.print("탐색 시작 정점 : ");
    int startV = scan.nextInt();
    
    System.out.println("간선 입력");
    for(int i = 0; i < totalE; i++){
        System.out.print("#"+(i+1)+":");
        int v1, v2;
        v1 = scan.nextInt();
        v2 = scan.nextInt();
        dfs.insertEdge(v1, v2);
    }

    dfs.startSearch(startV);
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DFSMain();
	}

}
