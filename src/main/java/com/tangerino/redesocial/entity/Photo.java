package com.tangerino.redesocial.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "photos")
@Entity(name = "photos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private byte[] bytePhoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post", nullable = true)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_photos_album", nullable = true)
    private PhotoAlbum photoAlbum;
}


