package a2.engine.singletons;

import a2.engine.Material;
import a2.engine.ShaderProgram;
import a2.engine.math.Matrix;
import com.jogamp.opengl.GLContext;

/**
 * Singleton shader program that uses Phong lighting model
 */
public final class PhongShader extends ShaderProgram {

    private static final PhongShader INSTANCE = new PhongShader();

    public static PhongShader getInstance() {
        return INSTANCE;
    }

//    private AmbientLight ambientLight = new AmbientLight();

    private PhongShader() {
        super();

        this.addVertexShader("src/a2/resources/shaders/phongVertex.vert");
        this.addFragmentShader("src/a2/resources/shaders/phongFragment.frag");
        this.useUniform("transform");
    }

    @Override
    public void updateUniforms(Matrix worldMatrix, Matrix projectedMatrix, Material material) {
        this.bind();
        if(material.getTexture() != null){
            material.getTexture().bind(GLContext.getCurrentGL());
        }
        this.setMatrixUniform("transform", projectedMatrix);
    }
}
