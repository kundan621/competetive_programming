package stack;

public class StackImplementationUsingArrays {
	
	public static void main(String[] args) {
		//normal way
		Stack stack= new Stack(5);
		stack.push(5);
		stack.push(6);
		System.out.println("top element"+stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println("isempty? "+stack.isEmpty());
		System.out.println(stack.pop());
		stack.push(6);
		System.out.println(stack.pop());
	}

}

