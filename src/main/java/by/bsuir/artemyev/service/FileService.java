package by.bsuir.artemyev.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void store(MultipartFile file);
    Resource loadFile(String filename);
    void deleteAll();
}
