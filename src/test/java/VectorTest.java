/*
 * This java class performs unit tests on the Vector class
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class VectorTest {

    //Start out with x,y
    @Test public void testFromCartesian() {
        var vector = Vector.fromCartesian(3,4);
        assertEquals(vector.getX(), 3.0, 0.001);
        assertEquals(vector.getY(), 4.0, 0.001);
        assertEquals(vector.getMagnitude(), 5.0, 0.001);
        assertEquals(vector.getRotation(), 0.927, 0.001);
    }

    //Start out with r,t
    @Test public void testFromPolar() {
        var vector = Vector.fromPolar(16.553, 2.705);
        assertEquals(vector.getX(), -15, 0.001);
        assertEquals(vector.getY(), 7, 0.001);
        assertEquals(vector.getMagnitude(), 16.553, 0.001);
        assertEquals(vector.getRotation(), 2.705, 0.001);
    }
}
