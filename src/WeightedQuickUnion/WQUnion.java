package WeightedQuickUnion;

import java.util.Arrays;

public class WQUnion {

    int[] connections;
    int[] treeSize;

    /** Creates union object for N elements. */
    public WQUnion (int N) {
        connections = new int[N];
        for (int i = 0; i < N; i++) {
            connections[i] = i;
        }

        treeSize = new int[N];
        Arrays.fill(treeSize, 1);
    }

    /** Creates union object with predefined connections. */
    public WQUnion (int[] connections) {
        this.connections = connections;
    }

    /** Connects items with index1 and index2. */
    public void connect(int index1, int index2) {
        int root1 = findRoot(index1);
        int root2 = findRoot(index2);

        int bigger, smaller;
        if (treeSize[root1] >= treeSize[root2]) {
            bigger = root1;
            smaller = root2;
        } else {
            bigger = root2;
            smaller = root1;
        }

        connections[smaller] = bigger;
        treeSize[bigger] += treeSize[smaller];
    }

    /** Checks if items with 2 indexes are connected.
     * Items are connected if they share the same root. */
    public boolean isConnected(int index1, int index2) {
        return findRoot(index1) == findRoot(index2);
    }

    /** Returns index of root node for given node. */
    int findRoot(int index) {
        if (connections[index] == index) {
            return index;
        }
        return findRoot(connections[index]);
    }
}
