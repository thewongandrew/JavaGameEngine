package a2.engine;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import a2.engine.math.Vector3D;

public class Camera {
	private static final Vector3D yAxis = new Vector3D(0, 1, 0);
	private Vector3D position;
	private Vector3D forward;
	private Vector3D up;
	
	public Camera() {
		// Default position is at the origin
		this.position = new Vector3D(0, 0, 0);
		// Default forward is set to -Z direction
		this.forward = new Vector3D(0, 0, 1);
		// Default up is set to Y direction
		this.up = new Vector3D(0, 1, 0);
//		this.addInputs();
	}
	
	public Camera(Vector3D position, Vector3D forward, Vector3D up) {
		this.position = position;
		this.forward = forward;
		this.up = up;
		
		forward = new Vector3D(forward.normalize().getX(), forward.normalize().getY(), forward.normalize().getZ());
		up = new Vector3D(up.normalize().getX(), up.normalize().getY(), up.normalize().getZ());
//		this.addInputs();
	}
	
	private void addInputs() {
		Input.addAction(KeyEvent.VK_W, new MoveForward());
		Input.addAction(KeyEvent.VK_A, new MoveLeft());
		Input.addAction(KeyEvent.VK_S, new MoveBackwards());
		Input.addAction(KeyEvent.VK_D, new Moveright());
	}
	
	@SuppressWarnings({ "serial" })
	private class MoveForward extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {Camera.this.move(Camera.this.getForward(), .01f);}
	}
	
	@SuppressWarnings({ "serial" })
	protected class MoveBackwards extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {Camera.this.move(Camera.this.getForward(), -.01f);}
	}
	@SuppressWarnings({ "serial" })
	private class MoveLeft extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {Camera.this.move(Camera.this.getLeft(), .01f);}
	}
	@SuppressWarnings({ "serial" })
	private class Moveright extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {Camera.this.move(Camera.this.getRight(), .01f);}
	}
	
	public void rotateX(float degrees) {
		Vector3D hAxis = (Vector3D) yAxis.cross(forward).normalize();
		
		this.forward.rotate(hAxis, degrees);
		this.forward.normalize();
		
		this.up = (Vector3D) this.forward.cross(hAxis).normalize();
	}
	
	public void rotateY(float degrees) {
		Vector3D hAxis = (Vector3D) yAxis.cross(forward).normalize();
		
		this.forward.rotate(yAxis, degrees);
		this.forward.normalize();
		
		this.up = (Vector3D) this.forward.cross(hAxis).normalize();
	}
	
	public void move(Vector3D direction, float amt) {
		float x = (float) this.position.add(direction.normalize().mult(amt)).getX();
		float y = (float) this.position.add(direction.normalize().mult(amt)).getY();
		float z = (float) this.position.add(direction.normalize().mult(amt)).getZ();
		this.position = new Vector3D (x, y, z);
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
		return (Vector3D) this.forward.cross(this.up).normalize();
	}
	
	public Vector3D getRight() {
		return (Vector3D) this.up.cross(this.forward).normalize();
	}	
}
