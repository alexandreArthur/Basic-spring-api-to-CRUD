package basic.api.resources;

import basic.api.domain.Regiao;
import basic.api.services.regiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/regioes")
public class RegiaoResource {

    @Autowired
    private regiaoService regiaoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Regiao> find(@PathVariable Integer id){

        Regiao obj = regiaoService.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}
