package basic.api.resources;

import basic.api.domain.Animal;
import basic.api.services.animalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/animais")
public class AnimalResource {

    @Autowired
    private animalService animalService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Animal> find(@PathVariable Integer id){

        Animal obj = animalService.findById(id);
        return ResponseEntity.ok().body(obj);

    }

}
