package a2.engine.sceneObjects;

import graphicslib3D.Point3D;

import static java.lang.Math.*;

import a2.engine.Mesh;
import a2.engine.math.Vector3D;
import a2.engine.math.Vertex3D;

public class Dodecahedron extends Mesh {
	private int prec=48;
	
	public Dodecahedron(int p) {	
		prec = p;
		InitDodecahedron();
	}
	
	private void InitDodecahedron() {	
		int numVertices = (prec+1) * (prec+1);
		int numIndices = prec * prec * 6;
		Vertex3D[] vertices = new Vertex3D[numVertices];
		int[] indices = new int[numIndices];

		for (int i=0; i<numVertices; i++) { vertices[i] = new Vertex3D(); }

		// calculate triangle vertices
		for (int i=0; i<=prec; i++)	{	
			for (int j=0; j<=prec; j++)	{	
				float y = (float)cos(toRadians(180-i*180/prec));
				float x = -(float)cos(toRadians(j*360.0/prec))*(float)abs(cos(asin(y)));
				float z = (float)sin(toRadians(j*360.0f/(float)(prec)))*(float)abs(cos(asin(y)));
				vertices[i*(prec+1)+j].setLocation(new Point3D(x,y,z));
				vertices[i*(prec+1)+j].setS((float)j/prec);
				vertices[i*(prec+1)+j].setT((float)i/prec);
				vertices[i*(prec+1)+j].setNormal(new Vector3D(vertices[i*(prec+1)+j].getLocation()));
			}	
		}
		
		// calculate triangle indices
		for(int i=0; i<prec; i++) {	
			for(int j=0; j<prec; j++) {	
				indices[6*(i*prec+j)+0] = i*(prec+1)+j;
				indices[6*(i*prec+j)+1] = i*(prec+1)+j+1;
				indices[6*(i*prec+j)+2] = (i+1)*(prec+1)+j;
				indices[6*(i*prec+j)+3] = i*(prec+1)+j+1;
				indices[6*(i*prec+j)+4] = (i+1)*(prec+1)+j+1;
				indices[6*(i*prec+j)+5] = (i+1)*(prec+1)+j;
			}	
		}	
		
		this.setVertices(vertices, indices);
	}
}
