package com.example.demo.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.markdown.reader.MarkdownDocumentReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MarkdownService {

    public List<Document> processMarkdown(MultipartFile file) throws IOException {
        MarkdownDocumentReader reader = new MarkdownDocumentReader(file.getInputStream());
        return reader.read();
    }
}
