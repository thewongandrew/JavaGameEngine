package a2.engine.singletons;

import a2.engine.Material;
import a2.engine.ShaderProgram;
import a2.engine.lighting.AmbientLight;
import a2.engine.math.Matrix;
import a2.engine.math.Vector3D;
import a2.engine.utils.RenderUtils;
import com.jogamp.opengl.GLContext;

/**
 * Singleton shader program that uses Phong lighting model
 */
public final class PhongShader extends ShaderProgram {

    private static final PhongShader INSTANCE = new PhongShader();

    public static PhongShader getInstance() {
        return INSTANCE;
    }

    private Vector3D ambientLight = new Vector3D(0.2f, 0.2f, 0.2f);

    private PhongShader() {
        super();

        this.addVertexShader("src/a2/resources/shaders/phongVertex.vert");
        this.addFragmentShader("src/a2/resources/shaders/phongFragment.frag");
        this.useUniform("transform");
        this.useUniform("baseColor");
        this.useUniform("ambientLight");
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
        this.setVectorUniform("baseColor", material.getColor());
        this.setVectorUniform("ambientLight", ambientLight);
    }
}
