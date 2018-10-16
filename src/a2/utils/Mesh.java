package a2.utils;

import static com.jogamp.opengl.GL4.GL_ARRAY_BUFFER;
import static com.jogamp.opengl.GL4.GL_STATIC_DRAW;
import static com.jogamp.opengl.GL4.GL_FLOAT;
import static com.jogamp.opengl.GL4.GL_TRIANGLES;

import java.nio.FloatBuffer;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;

public class Mesh {

	int vbos[] = new int[3];
	private int size;
	private GL4 gl;
	
	public Mesh() {
		gl = (GL4) GLContext.getCurrentGL();
		gl.glGenBuffers(vbos.length, vbos, 0);
		size = 0;
	}
	
	public void setVertices(Vertex[] vertices) {
		this.size = vertices.length;
		FloatBuffer vertBuf = Util.createFloatBuffer(vertices);
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbos[0]);
		gl.glBufferData(GL_ARRAY_BUFFER, vertBuf.limit()*4, vertBuf, GL_STATIC_DRAW);
	}
	
	public void draw() {		
		gl.glEnableVertexAttribArray(0);
		
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbos[0]);
		gl.glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE*4, 0);
		gl.glDrawArrays(GL_TRIANGLES, 0, this.size);
		
		gl.glDisableVertexAttribArray(0);
	}
}
