package com.apple.io.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    //for create it can be optional
    //we need it for update

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String description;

    private String imagePath;
//
//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    Set<Product> products;

//    public CategoryDto(Category category, MultipartFile file) {
//        this.setId(category.getId());
//        this.setCategoryName(category.getCategoryName());
//        this.setDescription(category.getDescription());
//
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        if (fileName.contains("..")) {
//            System.out.println("Not a valid file");
//        }
//        try {
//            this.setImage(file.getBytes());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
