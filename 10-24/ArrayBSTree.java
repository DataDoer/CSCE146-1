public class ArrayBSTree <T extends Comparable> {
  private T[] tree;
  private static final int DEFAULT_SIZE = 128;

  public ArrayBSTree(int size) {
    init(size);
  }//ArrayBSTree
  public ArrayBSTree() {
    init(DEFAULT_SIZE);
  }//ArrayBSTree

  private void init(int size) {
    if(size > 0) tree = (T[])(new Comparable[size]);
  }//init

  public void insert(T data) {
    if(tree[0] == null) tree[0] = data;
    else insert(0, data);
  }//insert

  private void insert(int index, T data) {
    if(tree[index] == null) tree[index] = data;
    else if(data.compareTo(tree[index]) < 0) {// Go left
      if(index*2+1 < tree.length) insert(index*2+1, data);
    } else if(data.compareTo(tree[index]) >= 0) {//Go right
      if(index*2+2 < tree.length) insert(index*2+2, data);
    }
  }//insert recursive

  public void printPostOrder() {
    printPostOrder(0);
  }//printPostOrder

  private void printPostOrder(int index) {
    if(tree[index] == null) return;
    if(index*2+1 < tree.length) printPostOrder(index*2+1);//Go left
    if(index*2+2 < tree.length) printPostOrder(index*2+2);//Go right
    System.out.println(tree[index]);
  }//printPostOrder

  public void printBreathOrder() {
    for(T data : tree) {
      if(data != null) System.out.println(data);
      else System.out.println("Null");
    }//for
  }//printBreathOrder

  public void delete(T value) {
    delete(0, value);
  }
  private void delete(int index, T value) {
    if(index >= tree.length || tree[index] == null)//Value not Found
      return;
    if(value.compareTo(tree[index]) < 0) //Go left
      delete(index*2+1, value);
    else if(value.compareTo(tree[index] > 0) > 0) //Go right
      delete(index*2+2, value);
    else {//Found it
      if(index*2+2 < tree.length || tree[index*2+2] == null) {
        //No right children
      }
    }
  }//delete

  private void moveLeftSubTree(int index) {
    if(index >= tree.length) return;
    boolean isleft = index%2==1;
    if(isleft || index == 0) {
      if(index*2+1 < tree.length) tree[index] = tree[index*2+1];
      else tree[index] = null;
    } else {
      if((index-1)*2+2 < tree.length)
        tree[index] = tree[(index-1)*2+1];
      else
        tree[index] = null;
    }//if else
    moveLeftSubTree(index*2+1);
  }//moveLeftSubTree
}//ArrayBSTree

/*
Deletion
  First search for the value
  Then 3 cases:
    If the item has no children
      Just delete
    If only one child
      Child takes place of parent
    If element has more than 1 child
      Go right, then left all the way, and switch,
      and its funky
*/
