package com.example.demo.controller;

import com.example.demo.service.MarkdownService;
import org.springframework.ai.document.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/markdown")
public class MarkdownController {

    private final MarkdownService markdownService;

    public MarkdownController(MarkdownService markdownService) {
        this.markdownService = markdownService;
    }

    @PostMapping("/process")
    public ResponseEntity<List<Document>> processMarkdown(@RequestParam("file") MultipartFile file) {
        try {
            List<Document> documents = markdownService.processMarkdown(file);
            return ResponseEntity.ok(documents);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
