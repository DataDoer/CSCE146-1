=//Justin Baum
//00426510

/*
Notes
  Without a double shift(Right-Left Shift and Left-Right Shift),
our tree remains balanced except it will now have up to a 2
node difference in height.
  11/9 - FIXED.

Everything else seems to work perfectly.
*/

public class AVLTree<T extends Comparable>{
  private class Node {
    public T data;
    private Node left;
    private Node right;
    private int balanceFactor;

    private Node() {
      data = null;
      right = null;
      left = null;
      balanceFactor = 0;
    }//Node
    private Node(T aData) {
      data = aData;
      left = null;
      right = null;
      balanceFactor = 0;
    }//Node

    public String toString() {
      return data.toString() + " BF: " + balanceFactor;
    }
  }//Node
  private Node root;

  public AVLTree() {
    root = null;
  }//AVLTree

  public void insert(T aData) {
    //first case the tree is empty
    if(root == null) {
      root = new Node(aData);
      return;
    }//tree is empty

    //Other than this we're going to insert like a normal binary tree
    insert(root, aData);
    //Let's update our balanceFactors
    updateTree(root);
    //Then we're going to use a function to rotate appropriately according to the new balanceFactors
    /*while(!isBalanced()){
      printPreOrder();
      System.out.println(isBalanced());
      balanceTree(root);
    }*/
    balanceTree(root);
    balanceTree(root);
    balanceTree(root);
    balanceTree(root);


  }//insert

  public boolean isBalanced() {
    return isBalanced(root);
  }
  private boolean isBalanced(Node aNode) {
    if(aNode == null) return true;
    if(aNode.balanceFactor > 1 || aNode.balanceFactor < -1) return false;
    return isBalanced(aNode.left) && isBalanced(aNode.right);
  }


  private Node insert(Node aNode, T aData) {
    if(aNode == null) {//Found leaf
      aNode = new Node(aData);
    } else if(aData.compareTo(aNode.data) < 0) {//Go left
      aNode.left = insert(aNode.left, aData);
    } else if(aData.compareTo(aNode.data) > 0) {//Go right
      aNode.right = insert(aNode.right, aData);
    }
    return aNode;
  }//insert


  private void updateTree(Node aNode) { //+ for right heavy; - for left heavy; 0 for balanced
    if(aNode == null) return;//Go down tree
    updateTree(aNode.right);
    updateTree(aNode.left);
    aNode.balanceFactor = height(aNode.right) - height(aNode.left);
  }//updateTree

  private void balanceTree(Node aNode) {
    //The only thing missing from this tree is left-right shifts, and right-left shifts
    if(aNode == null) return;
    balanceTree(aNode.right);
    balanceTree(aNode.left);
    if(aNode.balanceFactor > 1) {//The tree is right heavy
      if(aNode.right.balanceFactor < 1 && height(aNode.right.left) >= 1) {
        //Double Shift was actually really easy........
        leftHeavy(aNode.right);
        rightHeavy(aNode);
        //rightHeavy(aNode);
      } else {
        rightHeavy(aNode);
      }
      updateTree(root);
    } else if(aNode.balanceFactor < -1) {//The tree is left heavy
      if(aNode.left.balanceFactor < 1 && height(aNode.left.right) >= 1) {
        //Double shift was actually really easy.
        rightHeavy(aNode.left);
        leftHeavy(aNode);
        //rightHeavy(aNode);
      } else {
        leftHeavy(aNode);
      }
      updateTree(root);
    }

  }

  //I know these are not the most efficient, I just tried my best to get it to work
  private void leftHeavy(Node aNode) {
    Node originalNode = new Node(aNode.data);
    originalNode.left = aNode.left;
    originalNode.right = aNode.right;
    Node nodeGoingBack = new Node(originalNode.data);
    nodeGoingBack.left = originalNode.left.right;
    nodeGoingBack.right = originalNode.right;
    aNode.right = nodeGoingBack;
    //    aNode = aNode.left;
    aNode.data = originalNode.left.data;
    aNode.left = originalNode.left.left;
    //

  }//leftHeavy
  private void rightHeavy(Node aNode) {
    Node originalNode = new Node(aNode.data);
    originalNode.left = aNode.left;
    originalNode.right = aNode.right;
    Node nodeGoingBack = new Node(originalNode.data);
    nodeGoingBack.left = originalNode.left;
    nodeGoingBack.right = originalNode.right.left;
    aNode.left = nodeGoingBack;
    //    aNode = aNode.right;
    aNode.data = originalNode.right.data;
    aNode.right = originalNode.right.right;
  }//rightHeavy

  private int height(Node aNode) {
    int left = 1;
    int right = 1;
    if(aNode == null) return 0;
    if(aNode.left != null) {//We have a left place to go
      left = height(aNode.left) + 1;
    }
    if(aNode.right != null) {
      right = height(aNode.right) + 1;
    }
    return Math.max(right,left);//Return the greaterheight
  }//height

  public void printWKids() {
    printWKids(root);
  }//printPreOrder

  private void printWKids(Node aNode) {
    if(aNode == null) return;
    System.out.println(aNode);
    System.out.println(aNode + " has children "+aNode.left);
    System.out.println(aNode + " has children "+aNode.right);
    printWKids(aNode.left);
    printWKids(aNode.right);
  }//printPreOrder

  public void printPreOrder() {
    printPreOrder(root);
  }//printPreOrder

  private void printPreOrder(Node aNode) {
    if(aNode == null) return;
    System.out.println(aNode);
    printPreOrder(aNode.left);
    printPreOrder(aNode.right);
  }//printPreOrder

  public void printPostOrder() {
    printPostOrder(root);
  }
  private void printPostOrder(Node aNode) {
      if(aNode == null) return;
      printPreOrder(aNode.left);
      printPreOrder(aNode.right);
      System.out.println(aNode);
    }//printPostOrder

  public void printInOrder() {
    printInOrder(root);
  }//printInOrder

  private void printInOrder(Node aNode) {
    if(aNode == null) return;
    printInOrder(aNode.left);
    System.out.println(aNode);
    printInOrder(aNode.right);
  }//printInOrder
}//AVLTree
