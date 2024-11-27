package dto;

import lombok.Builder;

@Builder
public record ProductDTO(String name, String category, String description, String image) {
}


