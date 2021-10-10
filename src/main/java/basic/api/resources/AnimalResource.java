package basic.api.resources;

import basic.api.domain.Animal;
import basic.api.dto.animalDTO;
import basic.api.dto.animalFullDTO;
import basic.api.dto.animalNEWDTO;
import basic.api.services.animalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody animalFullDTO objDto){

        Animal obj = animalService.fromDTO(objDto);
        obj = animalService.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value="/findAll")
    public ResponseEntity<List<animalDTO>> findAll(){
        List<Animal> list = animalService.findAll();
        List<animalDTO> listDto = list.stream().map(animalDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@Valid @PathVariable Integer id, @RequestBody animalNEWDTO objN){
        Animal obj = animalService.findById(id);
        animalService.put(obj, objN);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
