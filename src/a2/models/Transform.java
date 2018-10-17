package a2.models;

import a2.utils.Matrix;
import graphicslib3D.Vector3D;

public class Transform {
	private static float fovy, width, height, near, far;
	private Vector3D scale;
	private Vector3D rotation;
	private Vector3D translation;
	
	public Transform() {
		this.scale = new Vector3D(1.0f, 1.0f, 1.0f);
		this.rotation = new Vector3D(0.0f, 0.0f, 0.0f);
		this.translation = new Vector3D(0.0f, 0.0f, 0.0f);
	}
	
	public Matrix getTransformation() {
		Matrix scaleMatrix = new Matrix().initScaleMatrix(scale);
		Matrix rotationMatrix = new Matrix().initRotationMatrix(rotation);
		Matrix translationMatrix = new Matrix().initTranslationMatrix(translation);
		
		Matrix transformationMatrix = new Matrix();
		transformationMatrix.concatenate(translationMatrix);
		transformationMatrix.concatenate(rotationMatrix);
		transformationMatrix.concatenate(scaleMatrix);
		
		return transformationMatrix;
	}
	
	public Matrix getProjectedTransformation() {
		Matrix transformationMatrix = this.getTransformation();
		Matrix projectionMatrix = new Matrix().initProjectionMatrix(fovy, width, height, near, far);
		projectionMatrix.concatenate(transformationMatrix);
		return projectionMatrix;
	}
	
	public void setProjection(float fovy, float width, float height, float near, float far) {
		Transform.fovy = fovy;
		Transform.width = width;
		Transform.height = height;
		Transform.near = near;
		Transform.far = far;
	}
	
	public Vector3D getTranslation() {
		return this.translation;
	}
	
	public void setTranslation(Vector3D translation) {
		this.translation = translation;
	}
	
	public void setTranslation(float x, float y, float z) {
		this.translation = new Vector3D(x, y, z);
	}
	
	public Vector3D getScale() {
		return this.scale;
	}
	
	public void setScale(Vector3D scale) {
		this.scale = scale;
	}
	
	public void setScale(float x, float y, float z) {
		this.scale = new Vector3D(x, y, z);
	}
	
	public Vector3D getRotation() {
		return this.rotation;
	}
	
	public void setRotation(Vector3D rotation) {
		this.rotation = rotation;
	}
	
	public void setRotation(float x, float y, float z) {
		this.rotation = new Vector3D(x, y, z);
	}
	
}
