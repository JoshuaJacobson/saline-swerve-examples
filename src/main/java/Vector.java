/*
 * This class is designed to optimize speed at the cost of memory
 * When created, the class will calculate both the cartesian and
 * polar representations of the vector, and leave them as immutable
 * instance variables, which can then be accessed using the associated
 * getX(), getY(), getMagnitude(), and getRotation() methods
 */
public class Vector {

    //Store cartesian computations of coordinates
    private double x, y;
    public double getX() {return this.x;}
    public double getY() {return this.y;}

    //Store polar computations of coordinates
    private double rotation, magnitude;
    public double getMagnitude() {return this.magnitude;}
    public double getRotation() {return this.rotation;}

    /*
     * This constructor is private, because we will use static methods
     * like Vector.fromCartesian(x,y) and Vector.fromPolar(r,t) to
     * instansiate this class
     */
    private Vector() {
        this.x = 0;
        this.y = 0;
        this.magnitude = 0;
        this.rotation = 0;
    }

    public static Vector fromCartesian(double x, double y) {
        Vector vector = new Vector();
        vector.x = x;
        vector.y = y;
        vector.magnitude = toPolarMagnitude(x, y);
        vector.rotation = toPolarRotation(x, y);
        return vector;
    }

    public static Vector fromPolar(double magnitude, double rotation) {
        Vector vector = new Vector();
        vector.x = toCartX(magnitude, rotation);
        vector.y = toCartY(magnitude, rotation);
        vector.magnitude = magnitude;
        vector.rotation = rotation;
        return vector;
    }

    // These helper methods hide the mathy implimentation of polar - cartesian conversions
    private static double toPolarMagnitude(double x, double y) {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    private static double toPolarRotation(double x, double y) {
        return Math.atan(y / x);
    }

    private static double toCartX(double r, double t) {
        return r * Math.cos(t);
    }

    private static double toCartY(double r, double t) {
        return r * Math.sin(t);
    }

    public static void main(String[] args) {}
}
