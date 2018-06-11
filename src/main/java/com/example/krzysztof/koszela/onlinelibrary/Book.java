package com.example.krzysztof.koszela.onlinelibrary;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @Column(nullable = false)
    private Float rating;
    @Column(nullable = false)
    private Float price;
}
