package basic.api.services;

import basic.api.domain.Animal;
import basic.api.exceptions.ObjectNotFoundException;
import basic.api.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class animalService {

    @Autowired
    AnimalRepository animalRepository;

    public Animal findById(Integer id){
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: "+id +", type:" + Animal.class.getName()));
    }
}
