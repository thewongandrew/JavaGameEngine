package a2.utils;

import graphicslib3D.Matrix3D;
import graphicslib3D.Vector3D;

@SuppressWarnings("serial")
public class Matrix extends Matrix3D {
	public Matrix() {
		super();
	}
	
	public Matrix initTranslationMatrix(Vector3D translation) {
		double x = translation.getX();
		double y = translation.getY();
		double z = translation.getZ();
		double[] translationMatrix = { 1.0, 0.0, 0.0,  x,
									   0.0, 1.0, 0.0,  y,
									   0.0, 0.0, 1.0,  z,
									   0.0, 0.0, 0.0, 1.0
									 };
		this.setValues(translationMatrix);
		return this;
	}
	
	public Matrix initScaleMatrix(Vector3D scale) {
		double x = scale.getX();
		double y = scale.getY();
		double z = scale.getZ();
		double[] scaleMatrix = {  x , 0.0, 0.0, 0.0,
							     0.0,  y , 0.0, 0.0,
							     0.0, 0.0,  z , 0.0,
							     0.0, 0.0, 0.0, 1.0
							   };
		this.setValues(scaleMatrix);
		return this;
	}

	public Matrix initRotationMatrix(Vector3D rotation) {
		
		double x = Math.toRadians(rotation.getX());
		double y = Math.toRadians(rotation.getY());
		double z = Math.toRadians(rotation.getZ());
		
		double cosx = Math.cos(x);
		double sinx = Math.sin(x);
		double cosy = Math.cos(y);
		double siny = Math.sin(y);
		double cosz = Math.cos(z);
		double sinz = Math.sin(z);

		Matrix rx = new Matrix();
		Matrix ry = new Matrix();
		Matrix rz = new Matrix();
		
		double[] xRotationMatrix = { 1.0,  0.0,   0.0, 0.0,
								     0.0, cosx, -sinx, 0.0,
								     0.0, sinx,  cosx, 0.0,
								     0.0,  0.0,   0.0, 1.0
								   };
		rx.setValues(xRotationMatrix);
		
		double[] yRotationMatrix = { cosy, 0.0, -siny, 0.0,
				   					  0.0, 1.0,   0.0, 0.0,
				   					 siny, 0.0,  cosy, 0.0,
				   					  0.0, 0.0,   0.0, 1.0
			   					   };
		ry.setValues(yRotationMatrix);
		
		double[] zRotationMatrix = { cosz, -sinz, 0.0, 0.0,
									 sinz,  cosz, 0.0, 0.0,
									  0.0,   0.0, 1.0, 0.0,
									  0.0,   0.0, 0.0, 1.0
			   					   };
		rx.setValues(zRotationMatrix);
		
		rz.concatenate(ry);
		rz.concatenate(rx);
		
		return rz;
	}

	public Matrix initProjectionMatrix(float fovy, float width, float height, float near, float far) {
		float aspect = width/height;
		float q = 1.0f / ((float) Math.tan(Math.toRadians(0.5f * fovy)));
		float A = q / aspect;
		float B = (near + far) / (near - far);
		float C = (2.0f * near * far) / (near - far);
		
		double[] projectionMatrix = {  A , 0.0,  0.0, 0.0,
							     	  0.0,  q ,  0.0, 0.0,
							     	  0.0, 0.0,   B ,  C,
							     	  0.0, 0.0, -1.0, 1.0
							   		};
		this.setValues(projectionMatrix);
		return this;
	}
}
