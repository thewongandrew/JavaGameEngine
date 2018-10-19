package a2.models;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;

public class Texture {
	
	private GL4 gl;
	private int id;
	
	public Texture(int id) {
		this.id = id;
	}
	
	public void bind() {
		gl = (GL4) GLContext.getCurrentGL();
		gl.glBindTexture(GL4.GL_TEXTURE_2D, id);
	}
	
	public int getTextureID() {
		return this.id;
	}
}
