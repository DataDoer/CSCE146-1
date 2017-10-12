public class Tree <T>{
  private class Node {
    public Node
  }
}

/*
Introduction
  Last time we discussed searching and sorting in a more efficient way
Definition
  A data structure that can be defined recursively as a collection of nodes, where each node is a..
Trees
  The big idea is a tree is a representation of a structure that has no self reference pointers, no disjoint nodes, and no cycles
  A-->B (Tree)
  A-->A (not a Tree) self reference
  A-->B-->C-->E-->D-->B (not a Tree) cycles
  A-->B C-->D-->E (not a Tree) disjointed trees
  A<-->B<-->C (not a Tree) two point to B
Definitions
  Root - top node
  Child - node reference at lower level
  Parent - converse of child, node above
  Siblings - nodes with same parent
  Leaf - node with no children
  Degree - number of sub trees of a node
  Edge - connection between one node to another
  Level - One + height of node
  Height of tree - the height of tree is the number of edges on the longest downward path between the root and a leaf
  Height of node - the height of node is the number of edges on the longest downward path between the node and a leaf
  Depth - the depth of the node is the number of edges from the node to the tree's root node

*/
