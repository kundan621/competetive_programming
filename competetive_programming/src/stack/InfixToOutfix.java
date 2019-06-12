package stack;

import java.util.Scanner;

public class InfixToOutfix {

	public static void main(String[] args) {

		//Stack stack=new Stack(20);
		java.util.Stack<Character> stack=new java.util.Stack<Character>();
		try(Scanner sc=new Scanner(System.in)) {

			System.out.println("etner no of test cases");
			int numOfTestCases=sc.nextInt();
             String result="";
			for(int i=0;i<numOfTestCases;i++) {
				System.out.println("enterr the input");
				String s=sc.next();
				char[] input = s.toCharArray(); 
				for(char c:input) {
                          if(c=='(')
                        	  stack.push(c);
                          else if( Character.isLetterOrDigit(c))
                          result=result+c;
                          else if(c==')')
                          {
                        	  while(!stack.isEmpty()&&stack.peek()!='(') {
                        		  result=result+stack.pop();
                        	  }
                        	  if(!stack.isEmpty()&&stack.peek()!='(') {
                        		  System.out.println("invalid expression");
                        		System.exit(-1);  
                        	  }else
                        		  stack.pop();
                          }
                          else {
                        	  while(!stack.isEmpty()&&precedenceChecker(c)<precedenceChecker(stack.peek())) {
                        		  result=result+stack.pop();
                        	  }
                        	  stack.push(c);
                          }
                        	  
                        	  


				}
				
				while(!stack.isEmpty()) {
					result=result+stack.pop();
				}
                System.out.println(result);

			}


		}


	}
	
	/**
	 * chheck precedence
	 * @param x char to check
	 * @return -1 or 1 or 0
	 */
	public static int precedenceChecker(char x){
		switch(x)
		{
		case '+':
		case '-':
			return 1;
			
		case '*':
		case '/':
			return 2;
		case '^': return 3;	
		}
		return -1;
		
	}

}

/**
 * Basic stack implementation
 * @author kkumar42 Kundan Kumar
 *
 */
class Stack{

	int size;
	int arr[];
	int top;
	public Stack(int size) {
		this.size=size;
		this.arr=new int[size];
	    this.top=-1;
	}
	
	/**
	 * function to push
	 * @param num num to be inserted
	 */
	public void push(int num) {
		if(top==size-1) {
			System.out.println("Stack overflow");
			System.exit(-1);
		}else {
			top++;
			arr[top]=num;
		}
	}
	/**
	 * to delete the top element of the stack
	 * @return 
	 */
	public int pop() {
		if(top==-1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		else {
			return(arr[top--]);
			
		}
	}
	/**
	 * returns the top element of the array
	 * @return top element
	 */
	public int peek() {
		if(top>-1)
			return arr[top];
		else
			return -1;
	}
	
	/**
	 * Check if stack is empty
	 * @return boolean
	 */
	public boolean isEmpty() {
		if(top==-1)
			return true;
		return false;
	}
}
