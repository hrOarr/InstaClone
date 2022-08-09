package com.astrodust.instaclone.service.interfaces;

import com.astrodust.instaclone.entity.Image;

import java.util.List;

public interface ImageService {
    Image saveOrUpdate(Image image);
    List<Image> findByUserId(int userId);
    Image findById(int id);
}
