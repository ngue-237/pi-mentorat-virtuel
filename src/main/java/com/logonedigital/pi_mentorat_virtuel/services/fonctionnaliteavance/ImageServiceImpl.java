package com.logonedigital.pi_mentorat_virtuel.services.fonctionnaliteavance;


import com.logonedigital.pi_mentorat_virtuel.entities.ImageEntity;
import com.logonedigital.pi_mentorat_virtuel.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class ImageServiceImpl {

    private final ImageRepository imageRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String storeImage(MultipartFile file) throws IOException {
        // Nettoyage du nom de fichier
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path filePath = Paths.get(uploadDir, fileName);

        // Création du dossier s'il n'existe pas
        Files.createDirectories(filePath.getParent());
        Files.copy(file.getInputStream(), filePath);

        // Sauvegarde dans la base de données
        ImageEntity image = new ImageEntity();
        image.setFileName(fileName);
        image.setFilePath(filePath.toString());
        image.setUploadDate(LocalDateTime.now());
        imageRepository.save(image);

        return fileName;
    }

    public ImageEntity getImageByName(String fileName) {
        return imageRepository.findByFileName(fileName)
                .orElseThrow(() -> new RuntimeException("Fichier non trouvé"));
    }
}
