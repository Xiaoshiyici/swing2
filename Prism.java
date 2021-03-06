package com.mycompany.we3;
import java.util.ArrayList;
import java.util.List;

public class Prism {
    private final List<Polygon3D> faces;
    private final List<Vector> vertices;

    public Prism(int numberOfSides, double radius, double height) {
        this.faces = new ArrayList<>();
        this.vertices = new ArrayList<>();
        
        double z = height / 2;
        int mode = Polygon3D.CCW;
        Polygon3D top = new Polygon3D( numberOfSides, radius, z, mode );
        
        z = -height / 2;
        mode = Polygon3D.CW;
        Polygon3D bottom = new Polygon3D( numberOfSides, radius, z, mode );
        
        this.faces.add( top );
        this.faces.add( bottom );
        this.faces.addAll( top.makeSleeve( bottom ));
        
        this.vertices.addAll( top.getVertices() );
        this.vertices.addAll( bottom.getVertices() );
    } // Prism()

    public void transform(Matrix m) {
        for (Vector u : this.vertices) {
            u.set(m.multiply(u));
        } // for 
    } // transform( Matrix )

    public List<Polygon3D> getFaces() {
        return this.faces;
    } // getFaces()

} // Prism
