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

    @Column(name = "review", nullable = false)
    private String review;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @JsonIgnore
    @Version
    @Column(name = "version", nullable = false)
    private Long version;

}
