package br.com.rappi.sp.service;

import br.com.rappi.sp.domain.Empresas;
import br.com.rappi.sp.domain.Rappi;
import br.com.rappi.sp.dto.RappiDTO;
import br.com.rappi.sp.dto.RappiRecordsDTO;
import br.com.rappi.sp.persistence.EmpresasRepository;
import br.com.rappi.sp.persistence.RappiRepository;
import br.com.rappi.sp.service.interfaces.RappiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RappiService {

	private static final Logger log = LogManager.getLogger(RappiService.class);

	//FeigClient
	@Autowired
	RappiClient rappiClient;

	//REPO
	@Autowired
	RappiRepository repo;

	@Autowired
	EmpresasRepository repoEmpresa;
	
	@Autowired
	Environment env;

	public void  enviarProdutos() throws IOException {

		try {
			RappiRecordsDTO rec = new RappiRecordsDTO();
			rec.setRecords(retornaProdutos());
			String response = String.valueOf(this.rappiClient.enviarProdutos(rec));
			log.info("");
			log.info( response );
			log.info( "Arquivo enviado com sucesso! ");
			log.info("");
		} catch (FeignException e) {
			log.error(e.getMessage());
		}
	}

	//RETORNA OS PRODUTOS PARA O ENVIO
	private List<RappiDTO> retornaProdutos() throws IOException {
		List<RappiDTO> lista = new ArrayList<>();

		try {
			List<Empresas> listaEmpresas = this.repoEmpresa.listarEmpresasAtivas(env.getProperty("configuracao.rappi.empresa"));

			listaEmpresas.forEach(e ->{

				Optional<List<Rappi>> produtos = this.repo.findByStoreId(String.valueOf(e.getIdEmpresa()));

				if( produtos.isPresent() ) {
					produtos.get().forEach(x ->{
						ModelMapper modelMapper = new ModelMapper();
						RappiDTO dto = modelMapper.map(x, RappiDTO.class);
						lista.add(dto);
					});
				}
			});

		} catch (Exception e) {
			log.log(Level.ERROR, () -> "Erro ao retornar produtos: " + e.getMessage()); 
		}

		return lista;
	}
	
	
	//TESTE FAZ O JSON DO BANCO EM FILE	
	@SuppressWarnings("unused")
	private void teste(List<RappiDTO> lista) {
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("c:\\temp\\rappi.json"), lista );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
