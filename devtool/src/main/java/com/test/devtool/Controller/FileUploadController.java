package com.test.devtool.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.devtool.helper.fileUpload;

@RestController
public class FileUploadController {

    @Autowired

    private fileUpload file;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadfile(@RequestParam("File")MultipartFile File)
    {
        // System.out.println(File.getOriginalFilename());

        if(File.isEmpty()){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) .body("request must contain file");
        }

       boolean f= file.uploadFile(File);
        if(f){
            // return ResponseEntity.ok("file upload success");

            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(File.getOriginalFilename()).toUriString());
        }


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something wrong");
    }
}
