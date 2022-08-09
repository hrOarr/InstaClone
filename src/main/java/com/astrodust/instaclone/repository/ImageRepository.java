package com.astrodust.instaclone.repository;

import com.astrodust.instaclone.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("SELECT img FROM Image img WHERE img.user.id=:userId")
    List<Image> findByUser(@Param("userId") Integer userId);
}
