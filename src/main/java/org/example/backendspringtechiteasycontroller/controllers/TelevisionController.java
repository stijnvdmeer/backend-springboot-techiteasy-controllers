package org.example.backendspringtechiteasycontroller.controllers;

import org.example.backendspringtechiteasycontroller.models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {
    List<Television> televisions = new ArrayList<Television>();

    @PostMapping("/add")
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        this.televisions.add(television);
        return new ResponseEntity<>(television, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Television>> getAllTelevisions() {
        if(!televisions.isEmpty()) {
            return new ResponseEntity<>(televisions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
