
public class ArrayStack {

	private int top;
	private int stackSize;
	private int stack[];
	
	
	public ArrayStack(int stackSize) {
		// TODO Auto-generated constructor stub
		top=-1;
		this.stackSize= stackSize;
		stack= new int[stackSize];
		
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public boolean isFull() {
		return top== stackSize -1;
	}
	
	public void push(int item) {
		if(isFull()) {
			System.out.println("full");
		}
		else {
			stack[++top]=item;
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.print("Empty");
			return 0;
		}
		else {
			return stack[top--];
		}
	}
	 public int peek() {
         if(isEmpty()){
             System.out.println("Stack is empty!!");
             return 0;
         }
         else{
             return stack[top];
         }
     }
}
