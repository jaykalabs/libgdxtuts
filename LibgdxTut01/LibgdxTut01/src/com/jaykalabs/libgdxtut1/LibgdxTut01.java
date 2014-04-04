package com.jaykalabs.libgdxtut1;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;


public class LibgdxTut01 implements ApplicationListener {
	
	public GL20 gl;
	public Mesh mesh;
	ShaderProgram shader;
	
	@Override
	public void create() {		
	
		gl=Gdx.gl20;
		
		shader=new ShaderProgram(Gdx.files.internal("shaders/vertex.vert"),Gdx.files.internal("shaders/fragment.frag"));
		if (shader.isCompiled() == false) {
			Gdx.app.log("ShaderTest", shader.getLog());
			Gdx.app.exit();
		}
		mesh = new Mesh(true, 3, 3, VertexAttribute.Position(), VertexAttribute.ColorUnpacked());
		mesh.setVertices(new float[] {-0.5f, -0.5f, 0, 1, 0.4f, 1, 1, 0.5f, -0.5f, 0, 1, 0.2f, 0f, 1,  0.5f, 0.5f, 0, 1, 1, 1,
			1});
		mesh.setIndices(new short[] {0, 1, 2});
	}

	@Override
	public void dispose() {
		mesh.dispose();
		
	}
	
	@Override
	public void render() {		
		
		Gdx.gl20.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		shader.begin();
		mesh.render(shader, GL20.GL_TRIANGLES);
		shader.end();
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
