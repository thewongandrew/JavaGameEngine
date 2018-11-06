package a2.engine;

import java.util.HashMap;

import javax.xml.soap.Node;

public class SceneGraph {
	private Node rootNode;
	private HashMap<String, SceneObject> children;
	
	public SceneGraph() {
		
	}
	
	public void render() {
		
	}
	
	public void addChild(String name, SceneObject child) {
		this.children.put(name, child);
	}

	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}
}
