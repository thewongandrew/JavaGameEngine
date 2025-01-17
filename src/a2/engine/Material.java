package a2.engine;

import a2.engine.math.Vector3D;
import com.jogamp.opengl.util.texture.Texture;

public class Material {
	private Texture texture;
	private Vector3D color;
	private float[] ambient;
	private float[] diffuse;
	private float[] specular;
	private float shininess;
	
	public Material(Texture texture, Vector3D color) {
		this.texture = texture;
		this.color = color;
	}
	
	public float[] getAmbient() {
		return ambient;
	}

	public void setAmbient(float[] ambient) {
		this.ambient = ambient;
	}

	public float[] getDiffuse() {
		return diffuse;
	}

	public void setDiffuse(float[] diffuse) {
		this.diffuse = diffuse;
	}

	public float[] getSpecular() {
		return specular;
	}

	public void setSpecular(float[] specular) {
		this.specular = specular;
	}

	public float getShininess() {
		return shininess;
	}

	public void setShininess(float shininess) {
		this.shininess = shininess;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

    public Vector3D getColor() {
        return color;
    }

    public void setColor(Vector3D color) {
        this.color = color;
    }
}
