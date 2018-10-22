package a2.engine;

import static com.jogamp.opengl.GL2ES2.GL_FRAGMENT_SHADER;
import static com.jogamp.opengl.GL2ES2.GL_VERTEX_SHADER;

import java.util.HashMap;

import com.jogamp.opengl.GL2ES2;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;

import a2.engine.math.Matrix;
import a2.engine.utils.GLErrorUtils;
import graphicslib3D.GLSLUtils;

public class ShaderProgram {

	private GL4 gl;
	private int program;
	
	// Hold the uniforms in HashMap to be accessed by name 
	private HashMap<String, Integer> uniforms;

	public ShaderProgram() {
	    gl = (GL4) GLContext.getCurrentGL();
		this.program = gl.glCreateProgram();
		
		uniforms = new HashMap<String, Integer>();
		
		if(this.program == 0) {
			System.err.println("Error creating shader in constuctor");
			System.exit(1);
		}
	}
	
	// Bind this program to the current gl context
	public void bind() {
		this.gl.glUseProgram(this.program);
	}
	
	// Add a uniform to be used to the HashMap
	public void useUniform(String uniform) {
		int loc = this.gl.glGetUniformLocation(this.program, uniform);
		
		if(loc == -1) {
			System.err.println("Could not find unform " + uniform  + " in shader file.");
			System.exit(1);
		}
		
		uniforms.put(uniform, loc);
	}
	
	// Wrappers around gl to set uniform variables by name
	public void setFloatUniform(String uniform, Float f) {
		this.gl.glProgramUniform1f(this.program, this.uniforms.get(uniform), f);
	}
	
	public void setIntegerUniform(String uniform, int i) {
		this.gl.glProgramUniform1i(this.program, this.uniforms.get(uniform), i);
	}
	
	public void setMatrixUniform(String uniform, Matrix m) {
		this.gl.glProgramUniformMatrix4fv(this.program, this.uniforms.get(uniform), 1, false, m.getFloatValues(), 0);
	}
	
	public void addVertexShader(String source) {
		this.attachShader(source, GL_VERTEX_SHADER);
	}
	
	public void addFragmentShader(String source) {
		this.attachShader(source, GL_FRAGMENT_SHADER);
	}
	
	private void attachShader(String source, int type) {
		GLErrorUtils glError = new GLErrorUtils(this.gl);
		String shaderSource[] = GLSLUtils.readShaderSource(source);
		int shader = this.gl.glCreateShader(type);
		int[] status = new int[1];

		if(shader == 0) {
			System.err.print("Error creating " + source + " probably wrong source");
			System.exit(1);
		}
		
		this.gl.glShaderSource(shader, shaderSource.length, shaderSource, null, 0);
		this.gl.glCompileShader(shader);
		 
		// Check shader compilation
		glError.checkOpenGLError();
        gl.glGetShaderiv(shader, GL2ES2.GL_COMPILE_STATUS, status, 0);
        if(status[0] == 1)
            System.out.println(source + " compilation Succeeded" );
        else {
            System.out.println(source + " compilation Failed");
            glError.printShaderLog(this.program);
            System.exit(1);
        }
        
		this.gl.glAttachShader(this.program, shader);
		this.gl.glLinkProgram(this.program);
		
		// Check shader linking
		glError.checkOpenGLError();
        gl.glGetProgramiv(this.program, GL2ES2.GL_LINK_STATUS, status, 0);
        if(status[0] == 1)
            System.out.println(source + " linking Succeeded");
        else {
            System.out.println(source + " linking Failed");
            glError.printProgramLog(this.program);
            System.exit(1);
        }
        
		this.gl.glDeleteShader(shader);
	}
}
