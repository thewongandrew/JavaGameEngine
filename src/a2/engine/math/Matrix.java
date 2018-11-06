package a2.engine.math;

import graphicslib3D.Matrix3D;
import graphicslib3D.Vector3D;

@SuppressWarnings("serial")
public class Matrix extends Matrix3D {
		
	public Matrix() {
		super();
	}
	
	public Matrix initTranslationMatrix(Vector3D translation) {
		this.translate(translation.getX(), translation.getY(), translation.getZ());
		return this;
	}
	
	public Matrix initTranslationMatrix(float x, float y, float z) {
		this.translate(x, y, z);
		return this;
	}
	
	public Matrix initScaleMatrix(Vector3D scale) {
		this.scale(scale.getX(), scale.getY(), scale.getZ());
		return this;
	}

	public Matrix initRotationMatrix(Vector3D rotation) {
		this.rotate(rotation.getX(), rotation.getY(), rotation.getZ());
		return this;
	}

	public Matrix initProjectionMatrix(float fov, float width, float height, float near, float far) {		
		float aspect = width/height;
		float q = 1.0f / ((float) Math.tan(Math.toRadians(0.5f * fov)));
		float A = q / aspect;
		float B = (near + far) / (near - far);
		float C = (2.0f * near * far) / (near - far);
		
		this.setElementAt(0,0,A);
		this.setElementAt(1,1,q);
		this.setElementAt(2,2,B);
		this.setElementAt(3,2,-1.0f);
		this.setElementAt(2,3,C);
		this.setElementAt(3,3,0.0f);
		return this;
	}
	
	public Matrix initCameraMatrix(Vector3D forward, Vector3D up) {
		Vector3D f = forward.normalize();
		Vector3D r = up.normalize();
		
		r = r.cross(f);
		
		Vector3D u = f.cross(r);
		
		this.setRow(0, new Vector3D(r.getX(), u.getX(), f.getX(), 0));
		this.setRow(1, new Vector3D(r.getY(), u.getY(), f.getY(), 0));
		this.setRow(2, new Vector3D(r.getZ(), u.getZ(), f.getZ(), 0));
		this.setRow(3, new Vector3D(0, 0, 0, 1));
		
		return this;
	}
}
