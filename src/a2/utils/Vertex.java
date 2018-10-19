package a2.utils;

import graphicslib3D.Point3D;
import graphicslib3D.Vertex3D;

@SuppressWarnings("serial")
public class Vertex extends Vertex3D {
	public static final int SIZE = 5;
		
	public Vertex(Point3D point3d) {
		super(point3d);
	}
	
	public Vertex(Point3D point3d, Point2D textCoords) {
		super(point3d);
		this.set2DTextureCoordinates(textCoords.GetX(), textCoords.GetY());
	}
	
	public Vertex() {
		super();
	}
}
