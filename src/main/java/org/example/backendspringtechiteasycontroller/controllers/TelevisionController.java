package org.example.backendspringtechiteasycontroller.controllers;

import org.example.backendspringtechiteasycontroller.exceptions.RecordNotFoundException;
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
    long currentId = 0;

    @PostMapping("/add")
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        television.setId(currentId++);
        televisions.add(television);
        return ResponseEntity.created(null).body(television);
    }

    @GetMapping()
    public ResponseEntity<List<Television>> getAllTelevisions() {
            return ResponseEntity.ok(this.televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable long id) {
        Television foundTelevision = findTelevisionById(id);

        return ResponseEntity.ok(foundTelevision);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable long id, @RequestBody Television television) {
        Television foundTelevision = findTelevisionById(id);

        foundTelevision.setBrand(television.getBrand());
        foundTelevision.setModel(television.getModel());

        return ResponseEntity.ok("Succesvol aangepast");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable long id) {
        Television foundTelevision = findTelevisionById(id);
        televisions.remove(foundTelevision);
        return ResponseEntity.noContent().build();
    }

    public Television findTelevisionById(long id) {

        for(Television television : televisions) {                                                                      // Searching the list of televisions for the object that corresponds with the given id
            if(television.getId() == id) {
                return television;                                                                                      // When the object is found return it and leave the function
            }
        }
        throw new RecordNotFoundException(id);                                                                          // If no object can be found with the corresponding Id Throw not found error.
    }
}
