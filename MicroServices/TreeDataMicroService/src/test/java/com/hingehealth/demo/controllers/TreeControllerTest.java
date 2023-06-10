package com.hingehealth.demo.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.hingehealth.demo.dto.AddChildRequestDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TreeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetTree() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/tree", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        // Additional assertions on the response body can be added here
    }

    @Test
    public void testAddChild() {
        AddChildRequestDTO request = new AddChildRequestDTO();
        request.setParent("1"); // Provide the parent ID
        request.setLabel("child"); // Provide the label for the new child node

        ResponseEntity<Void> response = restTemplate.postForEntity("/api/tree", request, Void.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        // Additional assertions can be added here if needed
    }

    @Test
    public void testHelloWorld() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/tree/hello/", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello World!", response.getBody());
    }
}

