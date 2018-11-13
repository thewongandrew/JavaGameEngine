#version 430

layout (location = 0) in vec3 position;
layout (location = 1) in vec2 inTexCoord;

uniform mat4 transform;
out vec2 textCoord;

void main(void) {	
	textCoord = inTexCoord;
	gl_Position = transform * vec4(position, 1.0);
}