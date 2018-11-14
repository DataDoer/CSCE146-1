import java.util.ArrayList;

public class Tree<T>{
  public Node root;
  public Tree(T aData) {
    root = new Node(T aData);
  }//Tree

  public void printDFS(Node aNode) {
    if(aNode == null) return;
    system.out.println(aNode);
    printDFS(aNode.child1);
    printDFS(aNode.child2);
  }//printDFS

  public Node getChild1(aNode) {
    return aNode.child1;
  }
  public Node getChild2(aNode) {
    return aNode.child2;
  }
  public Node getRoot() {
    return root;
  }
}//Tree
public class Node {
  public Node child1;
  public Node child2;
  public T data;
  public Node(T aData) {
    data = aData;
    child1 = null;
    child2 = null;
  }
}
