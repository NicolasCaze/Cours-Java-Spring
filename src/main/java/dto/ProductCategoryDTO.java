package dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ProductCategoryDTO(String category, String description, List<ProductDTO> products) {

}