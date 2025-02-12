package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.Ressource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController {
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Ressource> downloadFile(@PathVariable String fileName) {
        // Logic to retrieve the resource by file name
        // You can load the resource from the filesystem, database, or any other storage
        // Example: Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Set the appropriate headers for the download response
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                // Set the content type based on the resource type
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new Ressource());
    }
}
