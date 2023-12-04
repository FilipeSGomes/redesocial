package com.tangerino.redesocial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "photos_album")
@Entity(name = "photos_album")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PhotoAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_album")
    private String nameAlbum;

    @OneToMany(mappedBy = "photoAlbum", cascade = CascadeType.ALL)
    private List<Photo> photoList;
}
