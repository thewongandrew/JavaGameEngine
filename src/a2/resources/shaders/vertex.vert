#version 430

layout (location = 0) in vec3 position;

out vec4 varyingColor;

uniform mat4 transform;

void main(void) {	

	varyingColor = vec4(position,1.0)*0.5 + vec4(0.5, 0.5, 0.5, 0.5);
	gl_Position = transform * vec4(position, 1.0);
}