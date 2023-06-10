package com.hingehealth.demo.service;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hingehealth.demo.exception.NodeNotFoundException;
import com.hingehealth.demo.model.Node;

@Service
public class TreeService {

	private static final Logger LOGGER = Logger.getLogger(TreeService.class.getName());


	private final Node root;
	private final ObjectMapper objectMapper;

	public TreeService() {
		root = new Node("1", "root");
		initializeTestData();
		objectMapper = new ObjectMapper();
	}

	/**
     * Retrieves the tree hierarchy as a JSON string.
     *
     * @return JSON representation of the tree hierarchy
     * @throws JsonProcessingException if an error occurs during JSON processing
     */
	public String getTree() throws JsonProcessingException {
		LOGGER.log(Level.INFO, "Fetching the tree");
	    if (root == null || root.getChildren().isEmpty()) {
	    	LOGGER.log(Level.INFO, "Tree Data is Empty");
	        // Handle empty tree case
	        return "[]";
	    }
		final ArrayNode rootNode = objectMapper.createArrayNode();
		final ObjectNode objectNode = objectMapper.createObjectNode();
		objectNode.set(root.getId(), createNodeObject(root));
		rootNode.add(objectNode);
		return objectMapper.writeValueAsString(rootNode);
	}


	private JsonNode createNodeObject(final Node node) {
		final ObjectNode objectNode = objectMapper.createObjectNode();		
		objectNode.put("label", node.getLabel());
		final ArrayNode childrenNode = objectMapper.createArrayNode();
		for (final Node child : node.getChildren()) {
			final ObjectNode childNode = objectMapper.createObjectNode();
			childNode.set(child.getId(), createNodeObject(child));
			childrenNode.add(childNode);
		}

		objectNode.set("children", childrenNode);
		return objectNode;
	}

	/**
     * Adds a child node to the specified parent node.
     *
     * @param parentId the ID of the parent node
     * @param label    the label of the new child node
     * @throws NodeNotFoundException if the parent node with the given ID is not found
     * @throws JsonProcessingException if an error occurs during JSON processing
     */
	public void addChild(final String parentId, final String label) throws Exception {
		final Node parent = findNode(root, parentId);
		if (parent != null) {
			
			// Check for duplicate label
	        if (hasDuplicateLabel(parent, label)) {
	            throw new IllegalArgumentException("Node with label '" + label + "' already exists under the parent node.");
	        }
			final Node child = new Node(generateUniqueId(), label);
			parent.addChild(child);
		}
		else 
			new NodeNotFoundException("Parent node not found with ID: " + parentId);
	}

	private Node findNode(final Node currentNode, final String id) {
		if (currentNode.getId().equals(id)) {
			return currentNode;
		}

		for (final Node child : currentNode.getChildren()) {
			final Node foundNode = findNode(child, id);
			if (foundNode != null) {
				return foundNode;
			}
		}

		return null;
	}
	
	private boolean hasDuplicateLabel(Node node, String label) {
	    if (node.getLabel().equals(label)) {
	        return true;
	    }
	    for (Node child : node.getChildren()) {
	        if (hasDuplicateLabel(child, label)) {
	            return true;
	        }
	    }
	    return false;
	}

	private String generateUniqueId() {
		return UUID.randomUUID().toString();
	}

	private void initializeTestData() {

		final Node ant = new Node("2", "ant");
		final Node bear = new Node("3", "bear");
		final Node cat = new Node("4", "cat");
		final Node dog = new Node("5", "dog");
		final Node elephant = new Node("6", "elephant");
		final Node frog = new Node("7", "frog");

		root.addChild(ant);
		root.addChild(bear);
		bear.addChild(cat);
		bear.addChild(dog);
		dog.addChild(elephant);
		root.addChild(frog);

	}
}