package com.ynov.ai.controller;

import dto.PostAIDTO;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping("/post")
    public String post() {
        return "post";
    }

    @PostMapping("/post2")
    public String post2(@RequestParam String reponse) {
        return "Retour du post:"+ reponse.toString();
    }

    @PostMapping("/post3")
    public String PostAIDTO(@RequestBody PostAIDTO PostAIDTO) {
        return "Retour du post: " + PostAIDTO.age() + " ans, " +
                "nom: " + PostAIDTO.nom()
                + " prénom: " + PostAIDTO.prenom();
    }

    @PostMapping("/post4")
    public String PostAIDTO2(@RequestBody PostAIDTO PostAIDTO, @RequestParam String reponse) {
        return "Retour du params: "+ reponse +
                "Retour du body: " + PostAIDTO.age() + " ans, " +
                "nom: " + PostAIDTO.nom()
                + " prénom: " + PostAIDTO.prenom();
    }

    @PostMapping("/post5")
    public String postList(@RequestBody List<PostAIDTO> postAIDTOList) {
        StringBuilder sb = new StringBuilder("Messages reçus: ");
        for (PostAIDTO postAIDTO : postAIDTOList) {
            sb.append("[Age: ")
                    .append(postAIDTO.age())
                    .append(", Nom: ")
                    .append(postAIDTO.nom())
                    .append(", Prénom: ")
                    .append(postAIDTO.prenom())
                    .append("], ");
        }
        return sb.toString();
    }

    @PostMapping("/post6")
    public String postHighValue(@RequestBody List<PostAIDTO> postAIDTOList) {
        if (postAIDTOList == null || postAIDTOList.isEmpty()) {
            return "La liste des objets est vide.";
        }

        int maxAge = Integer.MIN_VALUE;
        for (PostAIDTO postAIDTO : postAIDTOList) {
            if (postAIDTO.age() > maxAge) {
                maxAge = postAIDTO.age();
            }
        }

        List<PostAIDTO> maxAgeList = new ArrayList<>();
        for (PostAIDTO postAIDTO : postAIDTOList) {
            if (postAIDTO.age() == maxAge) {
                maxAgeList.add(postAIDTO);
            }
        }

        StringBuilder sb = new StringBuilder("Messages avec l'âge le plus grand: ");
        for (PostAIDTO postAIDTO : maxAgeList) {
            sb.append("[Age: ")
                    .append(postAIDTO.age())
                    .append(", Nom: ")
                    .append(postAIDTO.nom())
                    .append(", Prénom: ")
                    .append(postAIDTO.prenom())
                    .append("], ");
        }

        return sb.toString();
    }
    private List<String> Data = new ArrayList<>();

    @PostMapping(path="/PostListStatic")
    public String insert(@RequestBody String data) {
        Data.add(data);
        return "Data added: " + data;
    }
    @GetMapping("/all")
    public List<String> getAllData() {
        return Data;
    }

    @DeleteMapping("/allelement")
    public List<String> DeleteAllData() {
        Data.clear();
        return Data;
    }

    @PostMapping("/add")
    public String addValues(@RequestBody List<String> newValues) {
        Data.addAll(newValues);
        return "Valeurs ajoutées: " + newValues;
    }
}

