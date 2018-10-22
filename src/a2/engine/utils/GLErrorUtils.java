package a2.engine.utils;

import com.jogamp.opengl.GL2ES2;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.glu.GLU;

/*
 * Extracted class from demo code
 */
public class GLErrorUtils {

    private static GL4 gl;
    
    public GLErrorUtils(GL4 gl) {
    	GLErrorUtils.gl = gl;
    }
    
    public void printShaderLog(int shader) {
        gl = (GL4) GLContext.getCurrentGL();
        int[] len = new int[1];
        int[] chWritten = new int[1];
        byte[] log = null;
        
        //Determine the length of the shader compilation log
        gl.glGetShaderiv(shader, GL2ES2.GL_INFO_LOG_LENGTH, len, 0);
        if(len[0] > 0) {
            log = new byte[len[0]];
            gl.glGetShaderInfoLog(shader, len[0], chWritten, 0, log, 0);
            System.out.println("Shader Info Log: ");
            for(int i = 0; i < log.length; i++)
                System.out.print((char) log[i]);
        }
    }
    
    public void printProgramLog(int prog) {
        gl = (GL4) GLContext.getCurrentGL();
        int[] len = new int[1];
        int[] chWritten = new int[1];
        byte[] log = null;
        
        //Determine the length of the program compilation log
        gl.glGetProgramiv(prog, GL2ES2.GL_INFO_LOG_LENGTH, len, 0);
        if(len[0] > 0) {
            log = new byte[len[0]];
            gl.glGetProgramInfoLog(prog, len[0], chWritten, 0, log, 0);
            System.out.println("Program Info Log: ");
            for(int i = 0; i < log.length; i++)
                System.out.print((char) log[i]);
        }
    }
    
    public boolean checkOpenGLError() {
        gl = (GL4) GLContext.getCurrentGL();
        boolean foundError = false;
        GLU glu = new GLU();
        int glErr = gl.glGetError();
        
        while(glErr != GL4.GL_NO_ERROR) {
            System.err.println("glError: " + glu.gluErrorString(glErr));
            foundError = true;
            glErr = gl.glGetError();
        }
        
        return foundError;
    }
}
