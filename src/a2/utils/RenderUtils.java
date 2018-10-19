package a2.utils;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;

public class RenderUtils {
	
	public static void clearScreen() {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		gl.glClear(GL4.GL_COLOR_BUFFER_BIT | GL4.GL_DEPTH_BUFFER_BIT);
	}
	
	public static void enableTextures(boolean enable) {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		if(enable) 
			gl.glEnable(GL4.GL_TEXTURE_2D);
		else 
			gl.glDisable(GL4.GL_TEXTURE_2D);
	}
	
	public static void initGLSettings() {
		GL4 gl = (GL4) GLContext.getCurrentGL();
		
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		gl.glFrontFace(GL4.GL_CCW);
		gl.glCullFace(GL4.GL_BACK);
		gl.glEnable(GL4.GL_CULL_FACE);
		gl.glEnable(GL4.GL_DEPTH_TEST);
		gl.glEnable(GL4.GL_TEXTURE_2D);
	}
}
