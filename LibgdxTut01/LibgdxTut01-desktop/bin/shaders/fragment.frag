#ifdef GL_ES
precision mediump float
#endif

varying vec4 v_color;
//varying vec2 v_texcoord;

void main()
{
	gl_FragColor =v_color;
}