package com.apple.io.dto;

import com.apple.io.model.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDto {
    //for create it can be optional
    //we need it for update
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private @NotNull String name;


    private @NotNull double price;
    private @NotNull String description;
    private String imagePath;

    private @NotNull Long categoryId;


    public ProductDto(Product product, MultipartFile file) {
        this.setId(product.getId());
        this.setName(product.getName());
//        this.setBrand(product.getBrand());
//        this.setImageURL(product.getImageURL());
//        this.setImage(product.getImage());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
//        this.setCategoryId(product.getCategory().getId());
//        this.setCategoryId(Math.toIntExact(product.getCategory().getId()));

//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        if (fileName.contains("..")) {
//
//            System.out.println("Not a valid file");
//        }
//        try {
//            product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
