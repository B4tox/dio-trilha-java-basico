package br.com.rappi.sp.service.interfaces;

import br.com.rappi.sp.dto.RappiRecordsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import feign.Headers;

@FeignClient(url = "${configuracao.rappi.url}", name = "produtos")
public interface RappiClient {

	@PostMapping()
	@Headers({ "Accept: application/json", "Content-Type: application/json"})
	public ResponseEntity<Object> enviarProdutos(@RequestBody RappiRecordsDTO t);

}
