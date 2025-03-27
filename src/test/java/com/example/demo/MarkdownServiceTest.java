package com.example.demo;

import com.example.demo.service.MarkdownService;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarkdownServiceTest {

    private final MarkdownService markdownService = new MarkdownService();

    @Test
    void testProcessMarkdown() throws IOException {
        MockMultipartFile file = new MockMultipartFile("file", "test.md", "text/markdown", "## Title\nHello World".getBytes());
        List<Document> documents = markdownService.processMarkdown(file);
        assertFalse(documents.isEmpty());
        assertEquals("## Title\nHello World", documents.get(0).getContent());
    }
}
