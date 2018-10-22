package a2.engine.math;

import graphicslib3D.Point3D;

@SuppressWarnings("serial")
public class Vertex3D extends graphicslib3D.Vertex3D {
	public static final int SIZE = 5;
	
	public Vertex3D() {
		super();
	}
	
	public Vertex3D(Point3D point3d) {
		super(point3d);
	}
			
	public Vertex3D(Point3D point3d, Point2D textCoords) {
		super(point3d);
		this.set2DTextureCoordinates(textCoords.GetX(), textCoords.GetY());
	}
}
