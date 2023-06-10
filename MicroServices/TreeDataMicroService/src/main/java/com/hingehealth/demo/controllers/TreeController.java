package com.hingehealth.demo.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hingehealth.demo.dto.AddChildRequestDTO;
import com.hingehealth.demo.service.TreeService;

@RestController
@RequestMapping("/api/tree")
public class TreeController {

	private static final Logger LOGGER = Logger.getLogger(TreeController.class.getName());


	@Autowired
	private  TreeService treeService;
	
	
	/**
	 * Retrieves the entire tree.
	 *
	 * @return ResponseEntity containing the JSON representation of the tree
	 * @throws JsonProcessingException if there is an error processing the JSON
	 */
	@GetMapping
	public ResponseEntity<String> getTree() throws JsonProcessingException {
		LOGGER.log(Level.INFO, "GET /api/tree");

		String responseDTO = treeService.getTree();
		return ResponseEntity.ok(responseDTO);
	}

	/**
	 * Adds a child node to the tree.
	 *
	 * @param request the AddChildRequestDTO containing the parent node ID and the label for the new child node
	 * @return ResponseEntity indicating the success or failure of adding the child node
	 * @throws Exception if there is an error adding the child node
	 */
	@PostMapping
	public ResponseEntity<String>  addChild(@RequestBody AddChildRequestDTO request) throws Exception {
		try {
			treeService.addChild(request.getParent(), request.getLabel());
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception occurred while adding child to the tree", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/hello/")
	public String helloWorld() {
		return "Hello World!";
	}


}
