package com.falynsky.embarkx.app.enities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_gen")
    @SequenceGenerator(name = "review_gen", sequenceName = "review_seq", allocationSize = 1)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private String review;
    private String description;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
