package a2.engine;

import a2.engine.math.Matrix;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLContext;

/**
 * Basic shader program from assignment 2 that manages transforms
 */
public class BasicShader extends ShaderProgram {
    public BasicShader() {
        super();

        this.addVertexShader("src/a2/resources/shaders/vertex.vert");
        this.addFragmentShader("src/a2/resources/shaders/fragment.frag");
        this.useUniform("transform");
    }

    public void updateUniforms(Matrix worldMatrix, Matrix projectedMatrix, Material material) {
        this.bind();
        if(material.getTexture() != null){
            material.getTexture().bind((GL4) GLContext.getCurrentGL());
        }
        this.setMatrixUniform("transform", projectedMatrix);
    }
}
