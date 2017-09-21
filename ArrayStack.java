public class ArrayStack <T> implements StackInterface {
  private T[] stack;
  private static final int MAX_STACK = 100;
  private int head;//Points to the first null element

  public ArrayStack() {
    init(MAX_STACK);
  }//ArrayStack

  public ArrayStack(int size) {
    init(size);
  }//ArrayStack

  private void init(int size) {
    if(size <= 0) return;
    stack = (T[])(new Object[size]);
    head = 0;
  }//init

  public void push(Object data){//Adding an element
    if(head >= stack.length) return; //Stack is full
    stack[head] = (T)data;
    head++;
  }//push
  public T pop(){
    if(head == 0) return null;//Empty
    return stack[--head];//Skips having the tempval and extra memory with one liner
  }//pop
  public T peek(){
    if(head <= 0) return null;
    return stack[head-1];
  }//peek
  public void print(){//Queue goes in reverse order
    for(int i = head; i >= 0; i--) {
      System.out.println(stack[i].toString());
    }//for
  }//print
}//ArrayStack
