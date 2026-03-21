package com.example.barca;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "players")
@Data // Getter, Setter, toStringなどを自動生成
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "back_number", nullable = false)
    private Integer backNumber;

    @Column(nullable = false)
    private String position;

    @Column(name = "image_url") 
    private String imageUrl;
}