#version 430

layout (binding=0) uniform sampler2D samp;

in vec2 textCoord;
out vec4 outColor;

uniform vec3 baseColor;
uniform vec3 ambientLight;

void main(void) {
    vec4 textureColor = texture(samp, textCoord);
    vec4 totalLight = vec4(ambientLight, 1);
    vec4 color = vec4(baseColor, 1);

    if(textureColor != vec4(0, 0, 0, 0))
	    color *= textureColor;

	outColor = color * totalLight;
}