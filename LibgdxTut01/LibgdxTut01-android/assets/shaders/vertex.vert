attribute vec4 a_position;
attribute vec4 a_color;
uniform mat4 u_worldView;

varying vec4 v_color;

void main(){

	//v_texcoord=a_texcoord
	gl_Position=a_position;
	v_color=a_color;
	
	
}