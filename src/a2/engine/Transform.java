package a2.engine;

import a2.engine.math.Matrix;
import graphicslib3D.Vector3D;

public class Transform {
	
	private static float fov, width, height, near, far;
	private static Camera camera;
	
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
		
		rotationMatrix.concatenate(scaleMatrix);
		translationMatrix.concatenate(rotationMatrix);
		return translationMatrix;
	}
	
	public Matrix getProjectedTransformation() {
		Matrix transformationMatrix = this.getTransformation();
		Matrix projectionMatrix = new Matrix().initProjectionMatrix(Transform.fov, 
																	Transform.width, 
																	Transform.height, 
																	Transform.near, 
																	Transform.far);
		Matrix cameraRotationMatrix = new Matrix().initCameraMartix(camera.getForward(), camera.getUp());
		Matrix cameraTranslationMatrix = new Matrix().initTranslationMatrix(camera.getPosition().mult(-1));
		
		cameraTranslationMatrix.concatenate(transformationMatrix);
		cameraRotationMatrix.concatenate(cameraTranslationMatrix);
		projectionMatrix.concatenate(cameraRotationMatrix);
		return projectionMatrix;
	}
	
	public static void setProjection(float fov, float width, float height, float near, float far) {
		Transform.fov = fov;
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

	public static Camera getCamera() {
		return camera;
	}

	public static void setCamera(Camera camera) {
		Transform.camera = camera;
	}
	
}
