package com.bloggish.springbloggish.entities;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Setter
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    private String imageName;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    private int status = 1;

    @Column(name = "created_at")
    @CreationTimestamp()
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp()
    private Date updateAt;

}
