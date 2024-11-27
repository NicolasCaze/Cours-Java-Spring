package com.ynov.ai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    String name;
    String version;
    String api_Key;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private ModelUser user;



}
