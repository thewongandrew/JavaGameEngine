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
		this.addInputs();
	}
	
	public Camera(Vector3D position, Vector3D forward, Vector3D up) {
		this.position = position;
		this.forward = forward;
		this.up = up;
		
		forward = new Vector3D(forward.normalize().getX(), forward.normalize().getY(), forward.normalize().getZ());
		up = new Vector3D(up.normalize().getX(), up.normalize().getY(), up.normalize().getZ());
		this.addInputs();
	}
	
	private void addInputs() {
		Input.addAction(KeyEvent.VK_W, new MoveForward());
		Input.addAction(KeyEvent.VK_A, new MoveLeft());
		Input.addAction(KeyEvent.VK_S, new MoveBackwards());
		Input.addAction(KeyEvent.VK_D, new MoveRight());
		Input.addAction(KeyEvent.VK_UP, new LookUp());
		Input.addAction(KeyEvent.VK_DOWN, new LookDown());
		Input.addAction(KeyEvent.VK_LEFT, new LookLeft());
		Input.addAction(KeyEvent.VK_RIGHT, new LookRight());
	}
	
	@SuppressWarnings({ "serial" })
	private class MoveForward extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			move(getForward(), -.05f);
		}
	}
	
	@SuppressWarnings({ "serial" })
	private class MoveBackwards extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			move(getForward(), .05f);
		}
	}
	
	@SuppressWarnings({ "serial" })
	private class MoveLeft extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			move(getLeft(), .05f);
		}
	}
	
	@SuppressWarnings({ "serial" })
	private class MoveRight extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			move(getRight(), .05f);
		}
	}
	
	@SuppressWarnings({ "serial" })
	private class LookUp extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			rotateX(-.5f);
		}
	}
	
	@SuppressWarnings({ "serial" })
	protected class LookDown extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			rotateX(.5f);
		}
	}
	
	@SuppressWarnings({ "serial" })
	private class LookLeft extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			rotateY(-.5f);
		}
	}
	
	@SuppressWarnings({ "serial" })
	private class LookRight extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			rotateY(.5f);
		}
	}
	
	
	
	public void rotateX(float degrees) {
		Vector3D hAxis = new Vector3D (yAxis.cross(forward).normalize().getX(),
									   yAxis.cross(forward).normalize().getY(),
									   yAxis.cross(forward).normalize().getZ());
		
		this.forward = new Vector3D (this.forward.rotate(hAxis, degrees).normalize().getX(),
									 this.forward.rotate(hAxis, degrees).normalize().getY(),
									 this.forward.rotate(hAxis, degrees).normalize().getZ());
		
		this.up = new Vector3D (this.forward.cross(hAxis).normalize().getX(),
								this.forward.cross(hAxis).normalize().getY(),
								this.forward.cross(hAxis).normalize().getZ());
	}
	
	public void rotateY(float degrees) {
		Vector3D hAxis = new Vector3D (yAxis.cross(forward).normalize().getX(),
				   					   yAxis.cross(forward).normalize().getY(),
				   					   yAxis.cross(forward).normalize().getZ());
		
		this.forward = new Vector3D (this.forward.rotate(yAxis, degrees).normalize().getX(),
				 					 this.forward.rotate(yAxis, degrees).normalize().getY(),
				 					 this.forward.rotate(yAxis, degrees).normalize().getZ());
		
		this.up = new Vector3D (this.forward.cross(hAxis).normalize().getX(),
								this.forward.cross(hAxis).normalize().getY(),
								this.forward.cross(hAxis).normalize().getZ());
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
		float x = (float) this.forward.cross(this.up).normalize().getX();
		float y = (float) this.forward.cross(this.up).normalize().getY();
		float z = (float) this.forward.cross(this.up).normalize().getZ();
		return new Vector3D(x, y, z);
	}
	
	public Vector3D getRight() {
		float x = (float) this.up.cross(this.forward).normalize().getX();
		float y = (float) this.up.cross(this.forward).normalize().getY();
		float z = (float) this.up.cross(this.forward).normalize().getZ();
		return new Vector3D(x, y, z);
	}	
}
