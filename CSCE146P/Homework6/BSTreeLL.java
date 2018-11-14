public class BSTreeLL <T extends Comparable> {
  private class Node {//Vertex
    public T data;
    private Node leftChild;
    private Node rightChild;
    public Node(T aData) {
      data = aData;
      leftChild = rightChild = null;
    }//Node
  }//Node

  private Node root;

  public BSTreeLL() {
    root = null;
  }//BSTreeLL
  public void insert(T aData) {
    if(root == null) {//Empty Tree
      root = new Node(aData);
    } else {
      insert(root, aData);//Calls recursive insert
    }//if else
  }//insert

  public Node insert(Node aNode, T aData) {
    if(aNode == null) {//Found leaf
      aNode = new Node(aData);
    } else if(aData.compareTo(aNode.data) < 0) {//Go left
      aNode.leftChild = insert(aNode.leftChild, aData);
    } else if(aData.compareTo(aNode.data) > 0) {//Go right
      aNode.rightChild = insert(aNode.rightChild, aData);
    }
    return aNode;
  }//insert

  public void printPreOrder() {
    printPreOrder(root);
  }//printPreOrder

  private void printPreOrder(Node aNode) {
    if(aNode == null) return;
    System.out.println(aNode.data + " ");
    printPreOrder(aNode.leftChild);
    printPreOrder(aNode.rightChild);
  }//printPreOrder
  public void printPostOrder() {
    printPostOrder(root);
  }
  private void printPostOrder(Node aNode) {
      if(aNode == null) return;
      printPreOrder(aNode.leftChild);
      printPreOrder(aNode.rightChild);
      System.out.println(aNode.data);
    }//printPostOrder

  public void printInOrder() {
    printInOrder(root);
  }//printInOrder

  private void printInOrder(Node aNode) {
    if(aNode == null) return;
    printInOrder(aNode.leftChild);
    System.out.println(aNode.data + " ");
    printInOrder(aNode.rightChild);
  }//printInOrder

  public void delete(T value) {
    if(root == null) return;
    delete(root, value);
  }//delete

  private Node delete(Node aNode, T value) {
    //Search
    if(aNode == null) return null;//Didn't find the value
    if(value.compareTo(aNode.data) < 0){//Go left
      aNode.leftChild = delete(aNode.leftChild, value);
    } else if(value.compareTo(aNode.data) > 0) {
      aNode.rightChild = delete(aNode.rightChild, value);
    } else if(value.equals(aNode.data)) {//else
      //Handles both cases
      if(aNode.rightChild == null) {
        return aNode.leftChild;
      }//if
      if(aNode.leftChild == null) {
        return aNode.rightChild;
      }//if

      //Handles case 3... Two children
      Node temp = aNode;
      aNode = findMinInTree(aNode.rightChild);

      //delete the min
      deleteMinFromTree(aNode.rightChild);
      aNode.leftChild = temp.leftChild;
    } else {}//if else else
    return null;
  }//delete

  private void deleteMinFromTree(Node aNode) {
    if(aNode == null) {
      return;
    }
    if(aNode.leftChild == null) {
      //Found bottom;
      aNode.leftChild = null;
      return;
    }
    deleteMinFromTree(aNode.leftChild);
  }

  private Node findMinInTree(Node aNode) {
    if(aNode == null) return null;
    if(aNode.leftChild == null) return aNode;
    return findMinInTree(aNode.leftChild);
  }//findMinInTree

  private Node findMaxInTree(Node aNode) {
    if(aNode == null) return null;
    if(aNode.rightChild == null) return aNode;
    return findMaxInTree(aNode.rightChild);
  }//findMaxInTree

}//BSTreeLL


/*
Traversals
  Pre-order trequires acessing each of the values of the node then traversing the left subtree and then the right subtree(Left side)
  Preorder would be 8 3 1 6 4 3 7 10 14 13

*/
