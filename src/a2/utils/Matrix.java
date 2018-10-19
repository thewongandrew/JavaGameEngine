package a2.utils;

import graphicslib3D.Matrix3D;
import graphicslib3D.Vector3D;

@SuppressWarnings("serial")
public class Matrix extends Matrix3D {
		
	public Matrix() {
		super();
	}
	
	public Matrix initTranslationMatrix(Vector3D translation) {
		double tx = translation.getX();
		double ty = translation.getY();
		double tz = translation.getZ();
		this.translate(tx, ty, tz);
		return this;
	}
	
	public Matrix initScaleMatrix(Vector3D scale) {
		double sx = scale.getX();
		double sy = scale.getY();
		double sz = scale.getZ();
		this.scale(sx, sy, sz);
		return this;
	}

	public Matrix initRotationMatrix(Vector3D rotation) {
		
		double rx = rotation.getX();
		double ry = rotation.getY();
		double rz = rotation.getZ();
		
		this.rotate(rx, ry, rz);
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
}
