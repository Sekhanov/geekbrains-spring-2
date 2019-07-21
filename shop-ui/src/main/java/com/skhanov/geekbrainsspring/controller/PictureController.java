package com.skhanov.geekbrainsspring.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.skhanov.geekbrainsspring.persist.model.Picture;
import com.skhanov.geekbrainsspring.persist.repo.PictureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PictureController {

    @Autowired
    private PictureRepository pictureRepository;

    @GetMapping("picture/{pictureId}")
    public void downloadPictureFromDb(@PathVariable("pictureId") Long pictureId,
            HttpServletResponse httpServletResponse) {
        Optional<Picture> picture = pictureRepository.findById(pictureId);
        
        if(picture.isPresent()) {
            httpServletResponse.setContentType(picture.get().getContentType());
            try {
                httpServletResponse.getOutputStream().write(picture.get().getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    
}