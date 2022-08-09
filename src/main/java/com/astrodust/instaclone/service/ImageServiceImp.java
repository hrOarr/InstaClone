package com.astrodust.instaclone.service;

import com.astrodust.instaclone.entity.Image;
import com.astrodust.instaclone.repository.ImageRepository;
import com.astrodust.instaclone.service.interfaces.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ImageServiceImp implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image saveOrUpdate(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> findByUserId(int userId) {
        return imageRepository.findByUser(userId);
    }

    @Override
    public Image findById(int id) {
        return imageRepository.findById(id).orElse(null);
    }
}
