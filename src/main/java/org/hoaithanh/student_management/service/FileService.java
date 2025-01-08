package org.hoaithanh.student_management.service;

import org.hoaithanh.student_management.entity.FileEntity;
import org.hoaithanh.student_management.repository.FileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {
    private final FileRepository fileRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }

    public void uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path targetLocation = Paths.get(uploadDir).resolve(fileName);

        Files.createDirectories(targetLocation.getParent());

        Files.copy(file.getInputStream(), targetLocation);

        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(fileName);
        fileEntity.setFilePath("/uploads/" + fileName);
        fileEntity.setFileSize(file.getSize());

        fileRepository.save(fileEntity);
    }

    public FileEntity getFileById(Long id) {
        return fileRepository.findById(id).orElseThrow(() -> new RuntimeException("File không tồn tại"));
    }

    public void updateFile(Long id, String fileName, MultipartFile newFile) throws IOException {
        FileEntity file = getFileById(id);
        file.setFileName(fileName);

        if (newFile != null && !newFile.isEmpty()) {
            String newFileName = newFile.getOriginalFilename();
            Path targetLocation = Paths.get(uploadDir).resolve(newFileName);

            Files.copy(newFile.getInputStream(), targetLocation);

            file.setFilePath("/uploads/" + newFileName);
            file.setFileSize(newFile.getSize());
            file.setFileName(newFileName);
        }

        fileRepository.save(file);
    }

    public void deleteFile(Long id) {
        FileEntity file = getFileById(id);

        Path filePath = Paths.get(uploadDir).resolve(Paths.get(file.getFilePath()).getFileName());
        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Không thể xóa file khỏi hệ thống: " + filePath);
        }

        fileRepository.delete(file);
    }
}

