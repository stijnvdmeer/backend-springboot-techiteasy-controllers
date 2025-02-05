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
    int currentId = 0;

    @PostMapping("/add")
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        television.setId(currentId++);
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

    @GetMapping("/{id")
    public ResponseEntity<Television> getTelevisionById(@PathVariable int id) {
        Television selectedTelevision = this.televisions.get(id);
        if(selectedTelevision != null) {
            return new ResponseEntity<>(selectedTelevision, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public Television findTelevisionById(int id) {
        for(Television television : televisions) {
            if(television.getId() == id) {
                return television;
            }
        }
        return null;
    }

}
