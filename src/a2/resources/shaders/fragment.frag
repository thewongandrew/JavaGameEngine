#version 430

in vec4 varyingColor;

out vec4 out_color;

void main(void) {
	out_color = varyingColor;
}