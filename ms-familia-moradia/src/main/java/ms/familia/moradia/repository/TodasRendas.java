package ms.familia.moradia.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import ms.familia.moradia.models.Rendas;

public interface TodasRendas extends JpaRepository<Rendas, Long>{

	@Cacheable(value = "rendas")
	Rendas findById(long id);
}
