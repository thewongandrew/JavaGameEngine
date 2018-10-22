package a2.engine.math;

public class Quaternion {
	
	private float x;
	private float y;
	private float z;
	private float w;

	public Quaternion(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public Quaternion(Vector3D axis, float degrees) {
		float sinHalfAngle = (float)Math.sin(degrees / 2);
		float cosHalfAngle = (float)Math.cos(degrees / 2);

		this.x = (float) (axis.getX() * sinHalfAngle);
		this.y = (float) (axis.getY() * sinHalfAngle);
		this.z = (float) (axis.getZ() * sinHalfAngle);
		this.w = cosHalfAngle;
	}

	public float length() {
		return (float)Math.sqrt(x * x + y * y + z * z + w * w);
	}
	
	public Quaternion normalize() {
		float length = this.length();
		
		return new Quaternion(x / length, y / length, z / length, w / length);
	}
	
	public Quaternion conjugate() {
		return new Quaternion(-x, -y, -z, w);
	}

	public Quaternion mul(float r) {
		return new Quaternion(x * r, y * r, z * r, w * r);
	}

	public Quaternion mul(Quaternion r) {
		float w_ = w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();
		float x_ = x * r.getW() + w * r.getX() + y * r.getZ() - z * r.getY();
		float y_ = y * r.getW() + w * r.getY() + z * r.getX() - x * r.getZ();
		float z_ = z * r.getW() + w * r.getZ() + x * r.getY() - y * r.getX();
		
		return new Quaternion(x_, y_, z_, w_);
	}
	
	public Quaternion mul(Vector3D r) {
		float w_ = (float) (-x * r.getX() - y * r.getY() - z * r.getZ());
		float x_ = (float) (w * r.getX() + y * r.getZ() - z * r.getY());
		float y_ = (float) (w * r.getY() + z * r.getX() - x * r.getZ());
		float z_ = (float) (w * r.getZ() + x * r.getY() - y * r.getX());
		
		return new Quaternion(x_, y_, z_, w_);
	}

	public Quaternion sub(Quaternion r) {
		return new Quaternion(x - r.getX(), y - r.getY(), z - r.getZ(), w - r.getW());
	}

	public Quaternion add(Quaternion r) {
		return new Quaternion(x + r.getX(), y + r.getY(), z + r.getZ(), w + r.getW());
	}

//	public Matrix ToRotationMatrix() {
//		Vector3D forward =  new Vector3D(2.0f * (x * z - w * y), 2.0f * (y * z + w * x), 1.0f - 2.0f * (x * x + y * y));
//		Vector3D up = new Vector3D(2.0f * (x * y + w * z), 1.0f - 2.0f * (x * x + z * z), 2.0f * (y * z - w * x));
//		Vector3D right = new Vector3D(1.0f - 2.0f * (y * y + z * z), 2.0f * (x * y - w * z), 2.0f * (x * z + w * y));
//
//		return new Matrix().InitRotation(forward, up, right);
//	}

	public float dot(Quaternion r) {
		return x * r.getX() + y * r.getY() + z * r.getZ() + w * r.getW();
	}

	public Quaternion set(float x, float y, float z, float w) { 
		this.x = x; 
		this.y = y; 
		this.z = z; 
		this.w = w; 
		
		return this; 
	}
	
	public Quaternion set(Quaternion r) { 
		set(r.getX(), r.getY(), r.getZ(), r.getW()); 
		
		return this; 
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public boolean equals(Quaternion r) {
		return x == r.getX() && y == r.getY() && z == r.getZ() && w == r.getW();
	}
}