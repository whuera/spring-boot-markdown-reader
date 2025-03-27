package com.example.demo;

import com.example.demo.controller.MarkdownController;
import com.example.demo.service.MarkdownService;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarkdownControllerTest {

    private final MarkdownService markdownService = new MarkdownService();
    private final MarkdownController markdownController = new MarkdownController(markdownService);

    @Test
    void testProcessMarkdown() throws IOException {
        MockMultipartFile file = new MockMultipartFile("file", "test.md", "text/markdown", "## Title\nHello World".getBytes());
        ResponseEntity<List<Document>> response = markdownController.processMarkdown(file);
        assertEquals(200, response.getStatusCodeValue());
        assertFalse(response.getBody().isEmpty());
    }
}
