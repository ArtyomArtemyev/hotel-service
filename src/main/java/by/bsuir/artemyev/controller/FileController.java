package by.bsuir.artemyev.controller;

import by.bsuir.artemyev.repository.IdFileNameRepository;
import by.bsuir.artemyev.service.impl.FileServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {
    private static Logger logger = LogManager.getLogger(FileController.class);

    @Autowired
    FileServiceImpl fileServiceImpl;

    @Autowired
    IdFileNameRepository idFileNameRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void handleFileUpload(@RequestParam("file") MultipartFile file) {
        logger.info("Request to upload file");
        try {
            fileServiceImpl.store(file);
            logger.info("Successful upload file");
        } catch (Exception e) {
            logger.info("Fail upload file");
        }
    }

    @RequestMapping(value = "/{filename:.+}\"", method = RequestMethod.GET)
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        logger.info("Request to get file with name: " + filename);
        Resource file = fileServiceImpl.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @RequestMapping(value = "/id/{fileId}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getFileById(@PathVariable String fileId) {
        logger.info("Request to get file with id: " + fileId);
        Resource file = fileServiceImpl.loadFile(idFileNameRepository.findOne(fileId).getFileName());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
