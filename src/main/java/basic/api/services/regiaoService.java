package basic.api.services;

import basic.api.domain.Regiao;
import basic.api.exceptions.ObjectNotFoundException;
import basic.api.repositories.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class regiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;

    public Regiao findById(Integer id){
        Optional<Regiao> regiao = regiaoRepository.findById(id);
        return regiao.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: "+id +", type:" + Regiao.class.getName()));
    }

}
