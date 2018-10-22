#version 430

layout (binding=0) uniform sampler2D samp;

in vec2 outTextCoord;
out vec4 color;

void main(void) {
	color = texture(samp, outTextCoord);
}