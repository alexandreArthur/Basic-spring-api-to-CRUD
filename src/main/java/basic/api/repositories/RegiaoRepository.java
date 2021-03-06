package basic.api.repositories;

import basic.api.domain.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiaoRepository  extends JpaRepository<Regiao, Integer> {
}
