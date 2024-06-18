package br.com.rappi.sp.persistence;

import br.com.rappi.sp.domain.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmpresasRepository extends JpaRepository<Empresas, Long> {
	
	@Query(value = "select t from Empresas t where t.ativo = 'T' and (:empresa is null or t.idEmpresa = :empresa) order by t.idEmpresa")
	List<Empresas> listarEmpresasAtivas(@Param("empresa") String pIdEmpresa);
	
}
