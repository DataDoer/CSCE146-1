public class LinkedGraph {
  private class Vertex {
    String name;
    ArrayList<Vertex> neigbors;
    public Vertex(String aName) {
      name = aName;
      neighbors = new ArrayList<Vertex>();
    }
  }//Vertex

  private class Edge {
     Vertex toVertex;
     double weight;
     public Edge(Vertex aV, double aWeight) {
       toVertex = aV;
       weight = aWeight;
     }
  }//Edge

  Vertex origin;//Arbitrary Start vertex
  ArrayList<Vertex> vertices;
  ArrayList<Vertex> merkedVerts;
  public LinkedGraph() {
    origin = null;
    vertices = new ArrayList<Vertex>();
    markedVerts = new ArrayList<Vertex>();
  }//LinkedGraph

  public void addVertex(String aName) {
    if(vertexIsContained(aName)) return;//Can't have vertex same name
    Vertex v = new Vertex(aName);
    vertices.add(v);
    if(origin == null) origin = v;
  }//addVertex

  private boolean vertexIsContained(String aName) {
    for(Vertex vert : vertices) {
      if(vert.name.equals(aName)) return true;
    }
    return false;
  }//vertexIsContained

  public void addEdge(String fromVert, String toVert, double weight) {
    Vertex fromV = getVertex(fromVert);
    Vertex toV = getVertex(toVert);
    if(v1 == null || v2 == null) return null;//Couldn't find vertices

    v1.neighbors.add(new Edge(toV, weight));
  }//addEdge

  private Vertex getVertex(String aName) {
    for(Vertex v : vertices) {
      if(vert.name.equals(aName)) return v;
    }
    return null;
  }//getVertex

  public void printDFS() {
    markedVerts.clear();
    printDFS(origin);
  }

  private void printDFS(Vertex vert) {
    //if(vert == null) return; //Feature not bug
    if(markedVerts.contains(vert))
      return;//Already visited go back
    System.out.println(vert.name);
    markedVerts.add(vert);
    //Visit all neighbors; keep markedVerts to prevent loops
    for(Edge edge : vert.neighbors) {
      printDFS(edge.toVertex);
    }
  }
}//LinkedGraph
