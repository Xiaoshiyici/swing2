package com.mycompany.we3;

/**
 * This class is to creat a 3D cone
 * @author Ziyu Guo
 * @version 12 April 2020
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Cone {
    private final List<Polygon3D> faces;
    private final List<Vector> vertices;

    public Cone(double radius, double height) {
        this.faces = new ArrayList<>();
        this.vertices = new ArrayList<>();
       
        double z = height / 2;
        int mode = Polygon3D.CCW;
        Polygon3D top = new Polygon3D( 100, 0, z, mode );
       
        z = -height / 2;
        mode = Polygon3D.CW;
        Polygon3D bottom = new Polygon3D( 100, radius, z, mode );
       
        this.faces.add( top );
        this.faces.add( bottom );
        this.faces.addAll( top.makeSleeve( bottom ));
       
        this.vertices.addAll( top.getVertices() );
        this.vertices.addAll( bottom.getVertices() );
    } // cone(int, double, double)

    public void transform(Matrix m) {
        for (Vector u : this.vertices) {
            u.set(m.multiply(u));
        } // for
    } // transform( Matrix )

    public List<Polygon3D> getFaces() {
        return this.faces;
    } // getFaces()

} // Cone
