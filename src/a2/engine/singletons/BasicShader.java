package a2.engine.singletons;

import a2.engine.Material;
import a2.engine.ShaderProgram;
import a2.engine.math.Matrix;
import a2.engine.utils.RenderUtils;
import com.jogamp.opengl.GLContext;

/**
 * Singleton shader program from assignment 2 that manages transforms
 */
public final class BasicShader extends ShaderProgram {

    private static final BasicShader INSTANCE = new BasicShader();

    public static BasicShader getInstance() {
        return INSTANCE;
    }

    private BasicShader() {
        super();

        this.addVertexShader("src/a2/resources/shaders/basicVertex.vert");
        this.addFragmentShader("src/a2/resources/shaders/basicFragment.frag");
        this.useUniform("transform");
    }

    @Override
    public void updateUniforms(Matrix worldMatrix, Matrix projectedMatrix, Material material) {
        this.bind();
        if(material.getTexture() != null){
            material.getTexture().bind(GLContext.getCurrentGL());
        } else {
            RenderUtils.unbindTextures();
        }
        this.setMatrixUniform("transform", projectedMatrix);
    }
}
