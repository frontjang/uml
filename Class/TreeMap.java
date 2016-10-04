public class TreeMap {
  TreeMapNode topNode = null;

  public void add(Comparable key, Object value) {
    if (topNode == null)
      topNode = new TreeMapNode(key, value);
    else
      topNode.add(key, value);
  }

  public Object get(Comparable key) {
    return topNode == null ? null : topNode.find(key);
  }
}

class TreeMapNode {
  private final static int LESS = 0;
  private final static int GREATER = 1;
  private Comparable itsKey;
  private Object itsValue;
  private TreeMapNode nodes[] = new TreeMapNode[2];

  public TreeMapNode(Comparable key, Object value) {
       itsKey = key;
       itsValue = value;
  }

  public Object find(Comparable key) {
    if (key.compareTo(itsKey) == 0) return itsValue;
    return findSubNodeForKey(selectSubNode(key), key);
  }

  private int selectSubNode(Comparable key) {
    return (key.compareTo(itsKey) < 0) ? LESS : GREATER;
  }

  private Object findSubNodeForKey(int node, Comparable key) {
    return nodes[node] == null ? null : nodes[node].find(key);
  }

  public void add(Comparable key, Object value) {
    if (key.compareTo(itsKey) == 0)
      itsValue = value;
    else
      addSubNode(selectSubNode(key), key, value);
  }

  private void addSubNode(int node, Comparable key, Object value) {
    if (nodes[node] == null)
      nodes[node] = new TreeMapNode(key, value);
    else
      nodes[node].add(key, value);
  }
} 