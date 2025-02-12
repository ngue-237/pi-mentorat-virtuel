package com.logonedigital.pi_mentorat_virtuel.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        // Process the uploaded file
        try {
            // Save the file to a specific location or perform other operations
            // Example: file.transferTo(new File("path/to/uploaded/file"));
            return "File uploaded successfully!";
        } catch (Exception e) {
            return "Failed to upload file.";
        }
    }
}
