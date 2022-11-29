package com.fincomp.Dev_FinComp.Controllers;

import com.fincomp.Dev_FinComp.Entities.Consult;
import com.fincomp.Dev_FinComp.Entities.Result;
import com.fincomp.Dev_FinComp.Services.Implements.OfacSdnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/search")
public class SearchController {

    @Autowired
    OfacSdnService service;

    @PostMapping(value = "/")
    public ResponseEntity<Result> searchInformation(@RequestBody Consult consult){
        return service.searchInformation(consult);
    }
}

