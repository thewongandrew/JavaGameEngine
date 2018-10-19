package a2.models;

import graphicslib3D.Vector3D;

public class Camera {
	private Vector3D position;
	private Vector3D forward;
	private Vector3D up;
	
	public Camera() {
		this.position = new Vector3D(0.0, 0.0, 0.0);
		// Default forward is set to Y dimension
		this.forward = new Vector3D(0.0, 1.0, 0.0);
		// Default up is set to Z dimension
		this.up = new Vector3D(0.0, 0.0, 1.0);
	}
	
	public Camera(Vector3D position, Vector3D forward, Vector3D up) {
		this.position = position;
		this.forward = forward;
		this.up = up;
		
		forward.normalize();
		up.normalize();
	}
	
	public void rotateX(float degrees) {
		
	}
	
	public void move(Vector3D direction, float amt) {
		this.position.add(direction.mult(amt));
	}
	
	public void setPostion(Vector3D position) {
		this.position = position;
	}
	
	public void setPostion(float x, float y, float z) {
		this.position = new Vector3D(x, y, z);
	}
	
	public Vector3D getPosition() {
		return this.position;
	}
	
	public Vector3D getForward() {
		return this.forward;
	}
	
	public Vector3D getUp() {
		return this.up;
	}
	
	public Vector3D getLeft() {
		return this.forward.cross(this.up);
	}
	
	public Vector3D getRight() {
		return this.up.cross(this.forward);
	}	
}
