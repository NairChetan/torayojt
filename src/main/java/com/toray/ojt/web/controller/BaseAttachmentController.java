package com.toray.ojt.web.controller;

import com.toray.ojt.web.dto.BaseAttachmentInsertDto;
import com.toray.ojt.web.dto.BaseAttachmentSelectDto;
import com.toray.ojt.web.service.BaseAttachmentService;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ContentDisposition;

import java.util.Base64;


@Controller
public class BaseAttachmentController {
    private final BaseAttachmentService baseAttachmentService;
    private static final Logger logger = LoggerFactory.getLogger(BaseAttachmentController.class);


    public BaseAttachmentController(BaseAttachmentService baseAttachmentService) {
        this.baseAttachmentService = baseAttachmentService;
    }

    @GetMapping("/download/{attachClassNo}")
    public ResponseEntity<byte[]> downloadAttachment(@PathVariable Long attachClassNo) {
        try {
            logger.debug("classNo: {}",attachClassNo);
            // Fetch the BLOB file from the database using the attachClassNo

            BaseAttachmentSelectDto dto = baseAttachmentService.getFileDataByClassNumber(attachClassNo);
            byte[] fileData = dto.getFileObject();

            if (fileData != null) {
                HttpHeaders headers = new HttpHeaders();
                String originalFileName = dto.getFileName(); // Get original filename
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + (originalFileName != null ? originalFileName : "attachment.pdf") + "\"");
                return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Log the exception (consider using a logging framework)
            e.printStackTrace(); // For debugging; replace with proper logging in production
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/view/{attachClassNo}")
    public String viewAttachment(@PathVariable Long attachClassNo, Model model) {
        try {
            logger.debug("classNo: {}", attachClassNo);
            BaseAttachmentSelectDto dto = baseAttachmentService.getFileDataByClassNumber(attachClassNo);
            byte[] fileData = dto.getFileObject();

            if (fileData != null) {
                // Encode the file data to Base64
                String base64Data = Base64.getEncoder().encodeToString(fileData);
                String originalFileName = dto.getFileName(); // Get original filename
                String mimeType = determineMimeType(originalFileName);

                model.addAttribute("fileData", "data:" + mimeType + ";base64," + base64Data);
                model.addAttribute("fileName", originalFileName);
                model.addAttribute("isPdf", mimeType.equals(MediaType.APPLICATION_PDF_VALUE)); // Check if it's a PDF

                return "layout/ViewAttachment"; // Return the name of your HTML view
            } else {
                return "error"; // Return an error view if the file is not found
            }
        } catch (Exception e) {
            e.printStackTrace(); // For debugging; replace with proper logging in production
            return "error"; // Return an error view in case of exception
        }
    }

    private String determineMimeType(String fileName) {
        if (fileName != null) {
            String lowerCaseFileName = fileName.toLowerCase();
            if (lowerCaseFileName.endsWith(".pdf")) {
                return MediaType.APPLICATION_PDF_VALUE;
            } else if (lowerCaseFileName.endsWith(".png")) {
                return MediaType.IMAGE_PNG_VALUE;
            } else if (lowerCaseFileName.endsWith(".jpg") || lowerCaseFileName.endsWith(".jpeg")) {
                return MediaType.IMAGE_JPEG_VALUE;
            } else if (lowerCaseFileName.endsWith(".gif")) {
                return MediaType.IMAGE_GIF_VALUE;
            }
        }
        return MediaType.APPLICATION_OCTET_STREAM_VALUE; // Default fallback
    }


}

