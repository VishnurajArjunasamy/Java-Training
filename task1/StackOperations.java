package task1;

interface Stack{
	void push(int num);
	int pop();
}

class FixedStack implements Stack{
	int fixedStack[];
	int size;
	int top;
	
	FixedStack(int size) {
		fixedStack=new int[size];
		this.size=size;
		top=-1;
	}
	
	public void push(int num) {
		if(!(isFull())) {
			top++;
			fixedStack[top] = num;
            System.out.println(num+" Pushed");
		}
		else {
			System.out.println("Stack is full");
		}
	}
	
	public int pop() {
		if(!isEmpty()) {
			int elementIdx=top;
			top--;
			return fixedStack[elementIdx];
		}
		return -1;
	}
	
	public boolean isEmpty() {
        return (top == -1);
    }
 
    public boolean isFull() {
        return (size - 1 == top);
    }
}

class DynamicStack implements Stack{
	int dynamicStack[];
	int size=1;
	int top;
	
	DynamicStack() {
		dynamicStack=new int[size];
		top=-1;
	}
	
	public void push(int num) {
		if(isFull()){
			size=size*2;
			reSize(size);
		} 
	
		top++;
		dynamicStack[top] = num;
        System.out.println(num+" Pushed");
		
	}
	
	public int pop() {
		if(!isEmpty()) {
			int elementIdx=top;
			top--;
			return dynamicStack[elementIdx];
		}
		return -1;
	}
	
	private void reSize(int size) {
		int resizedArray[] = new int[size];
		System.arraycopy(dynamicStack, 0, resizedArray, 0, dynamicStack.length);
		dynamicStack=resizedArray;
	}
	
	public boolean isEmpty() {
        return (top == -1);
    }
 
    public boolean isFull() {
        return (size - 1 == top);
    }
}

public class StackOperations {
	public static void main(String[] args) {
		FixedStack fixed = new FixedStack(5);
		fixed.push(20);
		fixed.push(30);
		fixed.push(40);
		fixed.push(50);
		fixed.push(60);
		fixed.push(70);
		
		System.out.println(fixed.pop());
		
		DynamicStack dynamic = new DynamicStack();
		dynamic.push(10);
		dynamic.push(20);
		dynamic.push(30);
		dynamic.push(40);
		dynamic.push(10);
		dynamic.push(20);
		dynamic.push(30);
		dynamic.push(40);
	}
}
