package a2.engine;

public class SceneObject {
	private Mesh mesh;
	private Transform worldTransform;
	private Transform projectedTransform;
	
	public SceneObject() {
		
	}
	
	public void draw() {
		
	}

	public Mesh getMesh() {
		return mesh;
	}

	public void setMesh(Mesh mesh) {
		this.mesh = mesh;
	}

	public Transform getWorldTransform() {
		return worldTransform;
	}

	public void setWorldTransform(Transform worldTransform) {
		this.worldTransform = worldTransform;
	}

	public Transform getProjectedTransform() {
		return projectedTransform;
	}

	public void setProjectedTransform(Transform projectedTransform) {
		this.projectedTransform = projectedTransform;
	}
}
