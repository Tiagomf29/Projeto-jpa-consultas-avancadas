package br.com.jpa.municipio;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jpa.repository.municipio.MunicipioRepositoryCustom;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MunicipioTest {
	
	@Autowired
	private MunicipioRepositoryCustom municipioRepositoryCustom;

	@Test
	public void listaMunicipioCustomizados() {
	
		municipioRepositoryCustom.listaMunicipiosCustomizados()
			.stream()
			.limit(10)
			.forEach(a->System.out.println("# Id: "+a[0]+" - Cód.Municipio: "+a[1]+" "
					+ " - Nome Municipio: "+a[2]+ " - Estado: "+ a[3]+" - UF: "+a[4]
							+" / "+a[5]));
		
		System.out.println("---------------------------------");
	}
	
	@Test
	public void listaMunicipioCustomizadosDTO() {
	
		municipioRepositoryCustom.listaMunicipiosCustomizadosDTO()
			.stream()
			.limit(10)
			.forEach(a->System.out.println("$ Id: "+a.getId()+" - Cód.Municipio: "+a.getCodMunicipio()+" "
					+ " - Nome Municipio: "+a.getNomeMunicipio()+ " - Estado: "+ a.getEstado()+" - UF: "+a.getUf()
							+" / "+a.getRegiao()));
		
		System.out.println("---------------------------------");
	}
	
	
	@Test
	public void listaMunicipioCustomizado() {
		
		municipioRepositoryCustom.listarDadosResumidosMunicipio()
			.stream()
			.limit(10)
			.forEach(a-> System.out.println("& Código Municipio:"+a[0]+" - Nome:"+a[1]));
		
		System.out.println("---------------------------------");
	}
	
	@Test
	public void listaTodosMunicipioCustomizadoCriteria() {
		
		municipioRepositoryCustom.listaTodosMunicipiosCriteria()
			.stream()
			.limit(10)
			.forEach(a-> System.out.println("¨ Nome Municipio:"+a.getNome()));
		
		System.out.println("---------------------------------");
	}
	
	
}
