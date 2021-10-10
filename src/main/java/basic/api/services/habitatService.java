package basic.api.services;

import basic.api.domain.Animal;
import basic.api.domain.Habitat;
import basic.api.exceptions.ObjectNotFoundException;
import basic.api.repositories.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class habitatService {

    @Autowired
    private HabitatRepository habitatRepository;

    public Habitat findById(Integer id){
        Optional<Habitat> habitat = habitatRepository.findById(id);
        return habitat.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: "+id +", type:" + Animal.class.getName()));
    }
}
