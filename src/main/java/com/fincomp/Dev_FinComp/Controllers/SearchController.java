package com.fincomp.Dev_FinComp.Controllers;

import com.fincomp.Dev_FinComp.Entities.Consult;
import com.fincomp.Dev_FinComp.Entities.Result;
import com.fincomp.Dev_FinComp.Respositories.ConsultRespository;
import com.fincomp.Dev_FinComp.Services.Implements.OfacSdnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/search")
public class SearchController {

    @Autowired
    OfacSdnService service;

    @Autowired
    ConsultRespository form;

    @PostMapping(value = "/find")
    public ResponseEntity<ArrayList<Result>> searchInformation(@RequestBody Consult consult){
        ArrayList<Result> respuesta = new ArrayList<>();
        respuesta.add(service.searchInformation(consult));
        Optional<ArrayList<Result>> obj = Optional.of(respuesta);
        return obj.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/")
    public List<Consult> searchInformation(){
        return form.findAll();
    }
}

