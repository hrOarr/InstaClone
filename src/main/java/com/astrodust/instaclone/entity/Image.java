package com.astrodust.instaclone.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IMAGES")
@NoArgsConstructor
@Data
public class Image implements Serializable {
    private static final long serialVersionUID = -1867366374363763836L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int id;

    @Column(name = "type")
    private String type;

    private String name;

    @Lob
    private byte[] content;

    @Column(name = "isDeleted")
    private Boolean isDeleted;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;
}
