import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class PrimPath {
    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        Edge currentNode, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge> priorityQueue;
        ArrayList<String> connectedNodes = new ArrayList<String>();

        ArrayList<Edge> mst = new ArrayList<Edge>();

        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();

        for (int index = 0; index < edges.size(); index++) {
            currentNode = edges.get(index);
            if (!adjacentEdges.containsKey(currentNode.node1)) {
                adjacentEdges.put(currentNode.node1, new ArrayList<Edge>());
            }
            if (!adjacentEdges.containsKey(currentNode.node2)) {
                adjacentEdges.put(currentNode.node2, new ArrayList<Edge>());
            }
        }

        for (int index = 0; index < edges.size(); index++) {
            currentNode = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentNode.node1);
            currentEdgeList.add(new Edge(currentNode.weight, currentNode.node1, currentNode.node2));
            currentEdgeList = adjacentEdges.get(currentNode.node2);
            currentEdgeList.add(new Edge(currentNode.weight, currentNode.node2, currentNode.node1));

        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
        priorityQueue = new PriorityQueue<Edge>();
        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
                for (int index = 0; index < adjacentEdgeNodes.size(); index++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(index);
                    if (!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        ArrayList<Edge> myedges = new ArrayList<Edge>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));

        PrimPath pObject = new PrimPath();
        System.out.println(pObject.primFunc("A", myedges));
    }
}