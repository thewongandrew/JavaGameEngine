package a2.engine.math;

public class Point2D {
	
	private float x;
	private float y;
	
	public Point2D(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float Length()
	{
		return (float)Math.sqrt(x * x + y * y);
	}
	
	public Point2D Add(Point2D r) {
		return new Point2D(x + r.GetX(), y + r.GetY());
	}
	
	public Point2D Add(float r) {
		return new Point2D(x + r, y + r);
	}
	
	public Point2D Sub(Point2D r) {
		return new Point2D(x - r.GetX(), y - r.GetY());
	}
	
	public Point2D Sub(float r) {
		return new Point2D(x - r, y - r);
	}
	
	public Point2D Mul(Point2D r) {
		return new Point2D(x * r.GetX(), y * r.GetY());
	}
	
	public Point2D Mul(float r) {
		return new Point2D(x * r, y * r);
	}
	
	public Point2D Div(Point2D r) {
		return new Point2D(x / r.GetX(), y / r.GetY());
	}
	
	public Point2D Div(float r) {
		return new Point2D(x / r, y / r);
	}
	
	public Point2D Abs() {
		return new Point2D(Math.abs(x), Math.abs(y));
	}
	
	public String toString() {
		return "(" + x + " " + y + ")";
	}

	public Point2D Set(float x, float y) { this.x = x; this.y = y; return this; }
	public Point2D Set(Point2D r) { Set(r.GetX(), r.GetY()); return this; }

	public float GetX()	{
		return x;
	}

	public void SetX(float x) {
		this.x = x;
	}

	public float GetY() {
		return y;
	}

	public void SetY(float y) {
		this.y = y;
	}

	public boolean equals(Point2D r) {
		return x == r.GetX() && y == r.GetY();
	}
}
