class Edge implements Comparable<Edge> {
    public String node;
    public int weight;

    public Edge(String node, int weight) {
        this.weight = weight;
        this.node = node;
    }

    // System.out.println() 으로 객체 자체 출력시, 다음 메서드를 호출하여, 원하는 attribute등을 출력할 수 있음
    public String toString() {
        return "(" + this.weight + ", " + this.node + ")";
    }

    @Override
    public int compareTo(Edge edge)
    {
        return this.weight - edge.weight;
    }
}