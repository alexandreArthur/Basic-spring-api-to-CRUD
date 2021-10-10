package basic.api.services;

import basic.api.domain.Animal;
import basic.api.domain.Habitat;
import basic.api.dto.animalDTO;
import basic.api.dto.animalFullDTO;
import basic.api.dto.animalNEWDTO;
import basic.api.enums.Tipo;
import basic.api.exceptions.DataIntegrityException;
import basic.api.exceptions.ObjectNotFoundException;
import basic.api.repositories.AnimalRepository;
import basic.api.repositories.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class animalService {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    HabitatRepository habitatRepository;

    @Autowired
    habitatService habitatService;

    public Animal findById(Integer id){
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: "+id +", type:" + Animal.class.getName()));
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    @Transactional
    public Animal insert(Animal obj){
        obj.setId(null);
        obj = animalRepository.save(obj);
        habitatRepository.save(obj.getHabitat());
        return  obj;
    }

    public Animal fromDTO(animalFullDTO objDto){
        Animal animal = new Animal();
        animal.setId(null);
        animal.setNome(objDto.getNome());

        Habitat habitat = habitatService.findById(objDto.getHabitatID());
        animal.setHabitat(habitat);
        animal.setTipo(Tipo.toEnum(objDto.getTipo()));

        return animal;
    }

    public Animal put(Animal obj, animalNEWDTO objN) {
        findById(obj.getId());
        updateData(obj, objN);
        return animalRepository.save(obj);
    }

    private void updateData(Animal obj, animalNEWDTO objN){
        obj.setNome(objN.getNome());
    }

    public void delete(Integer id){
        findById(id);
        try{
            animalRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir um cliente com pedidos!");
        }
    }


}
