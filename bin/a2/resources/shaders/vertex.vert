#version 430

layout (location = 0) in vec3 position;
layout (location = 1) in vec2 texCoord;
layout (binding=0) uniform sampler2D samp;

// out vec4 varyingColor;
out vec2 tc;

uniform mat4 transform;

void main(void) {	

	// varyingColor = vec4(position,1.0)*0.5 + vec4(0.5, 0.5, 0.5, 0.5);
	tc = texCoord;
	gl_Position = transform * vec4(position, 1.0);
}