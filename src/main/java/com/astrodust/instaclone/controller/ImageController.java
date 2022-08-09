package com.astrodust.instaclone.controller;

import com.astrodust.instaclone.config.UserDetailsImp;
import com.astrodust.instaclone.dto.ImageDefinition;
import com.astrodust.instaclone.entity.Image;
import com.astrodust.instaclone.entity.User;
import com.astrodust.instaclone.service.interfaces.ImageService;
import com.astrodust.instaclone.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@RequestMapping(value = "/images")
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/upload")
    public String uploadImage(@RequestParam("file")MultipartFile file) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());
        Image image = new Image();
        image.setType(file.getContentType());
        image.setContent(file.getBytes());
        image.setName(file.getOriginalFilename());
        image.setIsDeleted(false);
        image.setUser(user);
        imageService.saveOrUpdate(image);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}", produces = {"image/jpeg", "image/jpg", "image/png", "image/gif"})
    public void showImage(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        Image image = imageService.findById(id);
        String content_type = image.getType();
        if(content_type.equalsIgnoreCase(ImageDefinition.TIFF_MIME)||content_type.equalsIgnoreCase(ImageDefinition.XTIFF_MIME)){
            content_type = ImageDefinition.JPEG_MIME;
        }
        logger.info("SoA:: " + content_type);
        ByteArrayOutputStream stream = null;
        try{
            stream = transformByteToStream(image.getContent(), ImageDefinition.getImageExt(content_type));
            response.setContentType(content_type);
            response.setHeader("Content-Disposition" , "inline; filename=\""+image.getName()+"\";");
            stream.writeTo(response.getOutputStream());
            stream.close();
        }
        catch (Exception e){
            if(stream!=null){
                stream.close();
            }
        }
    }

    public static ByteArrayOutputStream transformByteToStream(byte[] content, String imgFormat) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(content);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage originalImage = ImageIO.read(bis);
        ImageIO.write(originalImage, imgFormat, outputStream);
        return outputStream;
    }
}