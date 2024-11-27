package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Builder
public record ResponseAIDTO2(int code, String reponse, String nomModel){

}