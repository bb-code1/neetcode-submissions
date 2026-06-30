class MinStack {
   private Stack<Integer> stack ;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
    }
    
    public void pop() {
        stack.pop();
        
    }
    
    public int top() {
       return stack.peek();
        
    }
    
    public int getMin() {
        Stack<Integer> tempStack = new Stack<>();
        int mini = stack.peek();
        while(!stack.isEmpty()){
            int top = stack.peek();
             mini = Math.min(mini,top);
            tempStack.push(top);
            stack.pop();
        }
        while(!tempStack.isEmpty()){
            stack.push(tempStack.peek());
            tempStack.pop();
        }

        return mini;

        
    }
}
