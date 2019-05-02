package ms.familia.moradia.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import ms.familia.moradia.models.Pessoas;

public interface TodasPessoas extends JpaRepository<Pessoas, Long>{

	@Cacheable(value = "pessoas")
	Pessoas findById(long id);
	
}
