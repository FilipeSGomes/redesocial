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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_post", nullable = false)
    private Post post;
}
