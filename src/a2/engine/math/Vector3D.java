package a2.engine.math;

import graphicslib3D.Point3D;

@SuppressWarnings("serial")
public class Vector3D extends graphicslib3D.Vector3D {

	public Vector3D() {
		super();
	}
	
	public Vector3D (float x, float y, float z) {
		super(x, y, z);
	}
	
	public Vector3D (double x, double y, double z) {
		super(x, y, z);
	}
	
	public Vector3D(Point3D location) {
		super(location);
	}
	
	/**
	 * @return rotated vector using quaternion math
	 */
	public Vector3D rotate(Vector3D axis, float degrees) {
		float sinHalfAngle = (float)Math.sin(Math.toRadians(degrees/2));
		float cosHalfAngle = (float)Math.cos(Math.toRadians(degrees/2));
		
		float qX = (float)axis.getX() * sinHalfAngle;
		float qY = (float)axis.getX() * sinHalfAngle;
		float qZ = (float)axis.getX() * sinHalfAngle;
		float qW = cosHalfAngle;
		
		Quaternion rotation = new Quaternion(qX, qY, qZ, qW);
		Quaternion conjugate = rotation.conjugate();

		Quaternion w = rotation.mul(this).mul(conjugate);
		
		this.setX(w.getX());
		this.setY(w.getY());
		this.setZ(w.getZ());
		
		return this;
	}
	
	public float[] getLocationFloats() {
		return new float[] {(float) this.getX(), (float) this.getY(), (float) this.getZ()};
	}
}
