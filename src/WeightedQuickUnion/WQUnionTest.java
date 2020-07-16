package WeightedQuickUnion;

import org.junit.Test;
import static org.junit.Assert.*;

public class WQUnionTest {

    @Test
    public void findRoot() {
        WQUnion connections = new WQUnion(new int[]{0, 0, 1, 3, 3, 0});
        assertEquals(0, connections.findRoot(2));
    }

    @Test
    public void isConnectedTest() {
        WQUnion connections = new WQUnion(new int[]{0, 0, 1, 3, 3, 0});
        assertTrue(connections.isConnected(1,5));
        assertTrue(connections.isConnected(2,5));
        assertFalse(connections.isConnected(4,5));
    }

    @Test
    public void connectTest() {
        WQUnion connections = new WQUnion(7);

        // Testing direct connection.
        assertFalse(connections.isConnected(1, 6));
        connections.connect(1, 6);
        assertTrue(connections.isConnected(1, 6));

        // Testing indirect connection.
        connections.connect(6, 4);
        connections.connect(3, 4);
        assertTrue(connections.isConnected(1, 3));

        // Testing correct connection order - connecting smaller tree to larger.
        connections.connect(2, 5);
        connections.connect(5, 6);
        assertEquals(1, connections.findRoot(5));

    }
}
