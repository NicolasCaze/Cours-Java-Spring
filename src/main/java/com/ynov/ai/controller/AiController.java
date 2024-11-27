package com.ynov.ai.controller;


import com.ynov.ai.Repository.ModelRepo;
import com.ynov.ai.TypeModelEnum;
import com.ynov.ai.entity.ModelEntity;
import dto.ModelDTO;
import dto.ResponseAIDTO;
import dto.ResponseAIDTO2;
import dto.ResponseAIDTO3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

@RestController
//@RequestMapping(path="/ai")
public class AiController {

    @Autowired
    private ModelRepo modelRepo;



    @PostMapping(path = "/model")
    public ModelDTO postModel(@RequestBody ModelDTO modelDTO) {
        Random random = new Random();
        ModelEntity model = ModelEntity.builder()
                .name(modelDTO.name())
                .version(modelDTO.version())
                .api_Key(String.valueOf(random.nextInt(1000)))  // Example for generating a random API key
                .build();
        modelRepo.save(model);
        return modelDTO;
    }

    @GetMapping("/model")
    public List<ModelEntity> getAllModels() {
        return modelRepo.findAll();
    }

    @GetMapping("/model/{id}")
    public ModelEntity getModel(@PathVariable long id) {
        return modelRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Model not found"));
    }

    @PutMapping("/model/{id}")
    public ModelEntity updateModel(@PathVariable long id, @RequestBody ModelDTO modelDTO) {
    Optional<ModelEntity> model = modelRepo.findById(id);
    if (model.isPresent()) {
        ModelEntity modelEntity = model.get();
        modelEntity.setName(modelDTO.name());
        modelEntity.setVersion(modelDTO.version());
        modelRepo.save(modelEntity);
        return modelEntity;
    } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Model not found");
    }
    }



    @GetMapping(path="/reponse/2")
    public ResponseAIDTO3 GetReponse2() {
        return  ResponseAIDTO3
                .builder()
                .pc("Portable")
                .code(23)
                .nomPC("Asus")
                .build();
    }
    @GetMapping(path="/valeurs")
    public List<String> GetValeurs() {
        return Arrays.asList("valeur1", "valeur2", "valeur3", "valeur4", "valeur5");
    }


//EXO 2
//    @GetMapping(path="/model/{id}")
//    public String GetModel(@PathVariable Integer id) {
//        return "Model " + id;
//    }
    // 1.
    @GetMapping("/model/params  ")
    public String index2(@RequestParam String params) {
        System.out.println(params);
        return  params;
    }
    // 2.
    @GetMapping("/model/reverse")
    public String reverse(@RequestParam String reverse) {
        return StringUtils.reverse(reverse);
    }
    // 3.
    @GetMapping("/bool")
    public String bool(@RequestParam Boolean b) {
        if (b){
            return ("Bonjour les amis");
        } else if (b == false){
            return ("On ne me parle pas comme ca !");
        } else
        return null;
    }
    // 4.
    @GetMapping("/liste/{nombre}")
    public List<ResponseAIDTO3> getListe
    (@PathVariable int nombre) {
        List<ResponseAIDTO3> liste = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            ResponseAIDTO3 objet =
                    ResponseAIDTO3
                    .builder()
                    .pc("Portable")
                    .code(23)
                    .nomPC("Asus")
                    .build();

            liste.add(objet);
        }
        return liste;
    }
    @GetMapping("/papa")
    public String GET(@RequestParam String p1, String p2) {
        if (p2==null){
            return ("Bonjour p1, mais ou est diantre nomDeLaVariableP2");
        } else {
            return ("Bonjour p1, quel beau temps pour p2");
        }
    }
    }



