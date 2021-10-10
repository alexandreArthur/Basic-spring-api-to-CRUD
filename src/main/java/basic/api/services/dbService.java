package basic.api.services;

import basic.api.domain.Animal;
import basic.api.domain.Habitat;
import basic.api.domain.Regiao;
import basic.api.enums.Tipo;
import basic.api.repositories.AnimalRepository;
import basic.api.repositories.HabitatRepository;
import basic.api.repositories.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class dbService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private HabitatRepository habitatRepository;

    @Autowired
    private RegiaoRepository regiaoRepository;

    public void instantiateTestDataBase() throws ParseException {

        Habitat habitat1 = new Habitat(null,"Árido");
        Regiao regiao1 = new Regiao(null, "Cerrado",habitat1);

        Animal animal1 = new Animal(null,"Anta", habitat1, Tipo.VERTEBRADO);
        Animal animal2 = new Animal(null,"Ariranha", habitat1, Tipo.VERTEBRADO);
        Animal animal3 = new Animal(null,"Cachorro-vinagre", habitat1, Tipo.VERTEBRADO);
        Animal animal4 = new Animal(null,"Cachorro-do-mato", habitat1, Tipo.VERTEBRADO);
        Animal animal5 = new Animal(null,"Cervo-do-pantanal", habitat1, Tipo.VERTEBRADO);
        Animal animal6 = new Animal(null,"Cateto", habitat1, Tipo.VERTEBRADO);
        Animal animal7 = new Animal(null,"Borboleta-ribeirinha", habitat1, Tipo.INVERTEBRADO);

        habitatRepository.save(habitat1);
        regiaoRepository.save(regiao1);
        animalRepository.saveAll(Arrays.asList(animal1,animal2,animal3,animal4,animal5,animal6, animal7));




    }



}
