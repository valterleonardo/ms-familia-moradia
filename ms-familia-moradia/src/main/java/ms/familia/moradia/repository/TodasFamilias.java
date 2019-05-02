package ms.familia.moradia.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import ms.familia.moradia.models.Familias;
import ms.familia.moradia.repository.impl.TodasFamiliasImpl;

public interface TodasFamilias extends JpaRepository<Familias, Long>, TodasFamiliasImpl{

	@Cacheable(value = "familias")
	Familias findById(long id);
	
	@Cacheable(value = "familias")
	List<Familias> findAll();
	
	@Cacheable(value = "familias")
	List<Familias> findByStatus(Integer status);
}
