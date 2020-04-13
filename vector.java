package com.mycompany.we3;

/**
 * Models a 4 component vector
 * @author Ziyu Guo
 * @version 10 April 2020
 */


public class Vector {
    
    private double x;
    private double y;
    private double z;
    private double h;//h is the homogeneous
   
    
    /**
     * A constructor that have 3 parameters:x,y,z
     * The homogeneous component is set to 1
     * @param x
     * @param y
     * @param z 
     */public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = 1.0;

    } // Vector(double, double, double)
   
   
   /**
    * A constructor that have 4 parameters:x,y,z,h
    * @param x
    * @param y
    * @param z
    * @param h 
    */
    public Vector(double x, double y, double z, double h) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = h;

    } // Vector(double, double, double, double)


/**
 * Multiply a vector by another vector
 * And return their sum
 * @param v
 * @return 
 */
  /**
 * Return different values through different conditions
 * @param num
 * @return 
 */

public double get(int num) {
        switch (num) {
            case 1:
                return this.x;
            case 2:
                return this.y;
            case 3:
                return this.z;
            case 4:
                return this.h;
            default:
                return this.x;

        } // switch
    } // get()


/**
 * The normalised vector
 * @return 
 */
 public Vector normalize() {
        double m = this.magnitude();
        return new Vector(this.get(1) / m, this.get(2) / m, this.get(3) / m,
                this.get(4) / m);
    } // normalize()


/**
 * Returns the cross product of this vector with another vector
 * @param v
 * @return 
 */

public Vector cross(Vector v){
double xC = this.get(2) * v.get(3) - this.get(3) * v.get(2);
        double yC = this.get(3) * v.get(1) - this.get(1) * v.get(3);
        double zC = this.get(1) * v.get(2) - this.get(2) * v.get(1);
        return new Vector(xC, yC, zC);
        
    } // cross(Vector)
} // Vector
        
@Override
public String toString() {
        return "(" + get(1) + ", " + get(2) + ", " + get(3) + ", " + get(4)
                + ")";
        }//toString()
      }//vector
