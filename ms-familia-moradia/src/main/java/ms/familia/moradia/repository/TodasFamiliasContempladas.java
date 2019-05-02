package ms.familia.moradia.repository;

import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import ms.familia.moradia.models.FamiliasContempladas;
import ms.familia.moradia.repository.impl.TodasFamiliasContempladasImpl;

public interface TodasFamiliasContempladas extends JpaRepository<FamiliasContempladas, Long>, TodasFamiliasContempladasImpl{

	@Cacheable(value = "familiasContempladas")
	FamiliasContempladas findById(long id);
	
	@Cacheable(value = "familiasContempladas")
	List<FamiliasContempladas> findByData(Date data);
}
