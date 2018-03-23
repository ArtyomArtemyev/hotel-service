package by.bsuir.artemyev.service.impl;

import by.bsuir.artemyev.domain.IdFileName;
import by.bsuir.artemyev.repository.IdFileNameRepository;
import by.bsuir.artemyev.service.FileService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.UUID.randomUUID;

@Service
public class FileServiceImpl implements FileService {
    private static Logger logger = LogManager.getLogger(FileServiceImpl.class);

    @Autowired
    IdFileNameRepository idFileNameRepository;

    private final Path rootLocation = Paths.get("images");

    public void store(MultipartFile file) {
        logger.info("Storing file in system");
        try {
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            IdFileName idFileName = new IdFileName(String.valueOf(randomUUID()), file.getOriginalFilename());
            idFileNameRepository.save(idFileName);
        } catch (Exception e) {
            throw new RuntimeException("Problems with storing file");
        }
    }

    public Resource loadFile(String filename) {
        logger.info("Loading file from system");
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Problems with loading file");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Problems with loading file");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

}
