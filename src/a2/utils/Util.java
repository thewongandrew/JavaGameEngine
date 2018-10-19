package a2.utils;

import java.io.File;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class Util {
	
	public static Texture loadTexture(String textureFileName)	{	
		Texture tex = null;
		try { tex = TextureIO.newTexture(new File(textureFileName), false); }
		catch (Exception e) { e.printStackTrace(); }
		return tex;
	}
	
	public static FloatBuffer createFloatBuffer(Vertex[] vertices) {
		// Initialize FloatBuffer with size based on number of elements(total points)
		FloatBuffer vertBuf = Buffers.newDirectFloatBuffer(vertices.length * Vertex.SIZE);
		
		for(Vertex vertex: vertices) { 
			vertBuf.put((float)vertex.getX()); 
			vertBuf.put((float)vertex.getY()); 
			vertBuf.put((float)vertex.getZ()); 
			vertBuf.put((float)vertex.getS());
			vertBuf.put((float)vertex.getT());
		}
		
		vertBuf.flip();
		
		return vertBuf;
	}
	
	public static FloatBuffer createFloatBuffer(Matrix matrix) {
		// Initialize FloatBuffer with size based on number of elements(total points)
		FloatBuffer floatBuf = Buffers.newDirectFloatBuffer(4*4);
		
		floatBuf.put(matrix.getFloatValues());
		floatBuf.flip();
		
		return floatBuf;
	}

	public static IntBuffer createIntegerBuffer(int[] indices) {
		IntBuffer intBuf = Buffers.newDirectIntBuffer(indices.length);
		
		intBuf.put(indices);
		intBuf.flip();
		
		return intBuf;
	}
}
