package com.test.devtool.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUpload {
    public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public fileUpload()throws IOException{

    }

    // public final String UPLOAD_DIR="/home/bharat/IdeaProjects/devtool/src/main/resources/static";

    public boolean uploadFile(MultipartFile file){
        boolean f=false;

        try{

           InputStream is= file.getInputStream();
           byte data[]=new byte[is.available()];
           is.read(data);

           FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
           fos.write(data);
           fos.flush();
           fos.close();

           f=true;

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return f;
    }
}
