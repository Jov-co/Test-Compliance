package com.fincomp.Dev_FinComp.Controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class InitialController {

    @GetMapping(value = "/")
    public String initialize(){
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Api-Fincomp</title>
                  </head>
                  <body>
                    <h1>Api Construida</h1>
                  </body>
                </html>
                """;
    }
}
