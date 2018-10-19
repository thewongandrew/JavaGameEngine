package a2.models;

import static com.jogamp.opengl.GL4.GL_ARRAY_BUFFER;
import static com.jogamp.opengl.GL4.GL_ELEMENT_ARRAY_BUFFER;
import static com.jogamp.opengl.GL4.GL_UNSIGNED_INT;
import static com.jogamp.opengl.GL4.GL_STATIC_DRAW;
import static com.jogamp.opengl.GL4.GL_FLOAT;
import static com.jogamp.opengl.GL4.GL_TRIANGLES;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;

import a2.utils.Util;
import a2.utils.Vertex;

public class Mesh {

	private int vbos[] = new int[3];
	private int ibos[] = new int[1];
	private int size;
	private GL4 gl;
	
	public Mesh() {
		gl = (GL4) GLContext.getCurrentGL();
		gl.glGenBuffers(1, vbos, 0);
		gl.glGenBuffers(1, ibos, 0);
		size = 0;
	}
	
	public void setVertices(Vertex[] vertices, int[] indices) {
		this.size = indices.length;
		
		FloatBuffer vertBuf = Util.createFloatBuffer(vertices);
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbos[0]);
		gl.glBufferData(GL_ARRAY_BUFFER, vertBuf.limit()*4, vertBuf, GL_STATIC_DRAW);
		
		IntBuffer intBuf = Util.createIntegerBuffer(indices);
		gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibos[0]);
		gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, intBuf.limit()*4, intBuf, GL_STATIC_DRAW);
	}
	
	public void draw() {		
		gl.glEnableVertexAttribArray(0);
		
		gl.glBindBuffer(GL_ARRAY_BUFFER, vbos[0]);
		gl.glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE*4, 0);

		gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibos[0]);
		gl.glDrawElements(GL_TRIANGLES, this.size, GL_UNSIGNED_INT, 0);
		
		gl.glDisableVertexAttribArray(0);
	}
}
