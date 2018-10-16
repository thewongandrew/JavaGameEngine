package a2.utils;

import java.nio.FloatBuffer;

import com.jogamp.common.nio.Buffers;

public class Util {
	
	public static FloatBuffer createFloatBuffer(Vertex[] vertices) {
		// Initialize FloatBuffer with size based on number of elements(total points)
		FloatBuffer vertBuf = Buffers.newDirectFloatBuffer(vertices.length * 3);
		
		for(Vertex vertex: vertices) { 
			vertBuf.put((float)vertex.getX()); 
			vertBuf.put((float)vertex.getY()); 
			vertBuf.put((float)vertex.getZ()); 
		}
		
		vertBuf.flip();
		
		return vertBuf;
	}
}
