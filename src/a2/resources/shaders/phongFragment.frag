#version 430

layout (binding=0) uniform sampler2D samp;

in vec2 outTextCoord;
out vec4 color;

uniform vec3 baseColor;
uniform vec3 ambientLight;

void main(void) {
    vec4 totalLight = vec4(1,1,1,1);
    vec4 color = vec3(baseColor, 1);

    if(texture )
	color = texture(samp, outTextCoord);
}