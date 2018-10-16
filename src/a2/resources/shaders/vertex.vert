#version 430

layout (location = 0) in vec3 position;

out vec3 color;

uniform float uniformFloat;

void main(void) {	

	gl_Position = vec4(0.25 * position, 1.0);
	color = vec3(clamp(position, 0.0, uniformFloat));
}