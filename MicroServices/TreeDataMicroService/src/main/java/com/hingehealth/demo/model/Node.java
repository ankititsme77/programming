package com.hingehealth.demo.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class Node {
	private String id;
	private String label;
	private List<Node> children;

	public Node(String id, String label) {
		this.id = id;
		this.label = label;
		this.children = new ArrayList<>();
	}


	public void addChild(Node child) {
		children.add(child);
	}

	// Getters and setters


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}


	@Override
	public String toString() {
		return "Node [id=" + id + ", label=" + label + ", children=" + children + "]";
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new LinkedHashMap<>();
		Map<String, Object> nodeData = new LinkedHashMap<>();
		nodeData.put("label", label);

		List<Object> childrenList = new ArrayList<>();
		for (Node child : children) {
			Map<String, Object> childData = new LinkedHashMap<>();
			childData.put(child.getId(), child.toMap());
			childrenList.add(childData);
		}
		nodeData.put("children", childrenList);

		map.put(id, nodeData);
		return map;
	}

}

