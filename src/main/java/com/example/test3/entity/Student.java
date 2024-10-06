package com.example.test3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column
    private int age;

    public String getImageName() {
        return imageName;
    }

    @Column
    private String imageName;


    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageType() {
        return imageType;
    }

    @Column
    private String imageType;


    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public byte[] getImageData() {
        return imageData;
    }

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;


}
