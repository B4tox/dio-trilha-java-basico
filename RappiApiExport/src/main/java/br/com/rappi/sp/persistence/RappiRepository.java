package br.com.rappi.sp.persistence;

import java.util.List;
import java.util.Optional;

import br.com.rappi.sp.domain.Rappi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RappiRepository  extends JpaRepository<Rappi, Long> {
	
	// RETORNA POR LOJA
	Optional<List<Rappi>> findByStoreId(String pIdEmpresa);

}
