package br.com.jpa.regiao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jpa.model.Regiao;
import br.com.jpa.repository.regiao.RegiaoRepositorioCustom;
import br.com.jpa.repository.regiao.RegiaoRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegiaoTest {
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Autowired
	private RegiaoRepositorioCustom regiaoRepositorioCustom;

	@Test
	public void listaTodasRegioesRepository(){

		List<Regiao> lista = regiaoRepository.findAll();
		lista.stream().forEach(a-> System.out.println("! "+a.getNome()));
		
		assertTrue(lista.size() > 0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaTodasRegioesJpqlCreateQuery(){
		
		List<Regiao> lista = regiaoRepositorioCustom.listarTodosJpql();
		lista.stream().forEach(a-> System.out.println("* "+a.getNome()));
		
		assertTrue(lista.size() > 0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaTodasRegioesJpqlCreateNamedQuery(){
		
		List<Regiao> lista = regiaoRepositorioCustom.listarTodosNamedQuery("%N%");
		lista.stream().forEach(a-> System.out.println("& "+a.getNome()));
		
		assertTrue(lista.size() > 0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaTodasRegioesJpqlRepositoryQuery(){
		
		List<Regiao> lista = regiaoRepository.listarTodasRegioesQuery();
		lista.stream().forEach(a-> System.out.println("@ "+a.getNome()));
		
		assertTrue(lista.size() > 0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaTodasRegioesJpqlRepositoryNativeQuery(){
		
		List<Regiao> lista = regiaoRepository.listarTodasRegioesNativeQuery();
		lista.stream().forEach(a-> System.out.println("# "+a.getNome()));
		
		assertTrue(lista.size() > 0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaTodasRegioesRepositoryQueryMethods1(){
		
		List<Regiao> lista = regiaoRepository.findByNomeContaining("NORTE");
		lista.stream().forEach(a-> System.out.println("$ "+a.getNome()));
		
		assertTrue(lista.size() > 0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaTodasRegioesCriteria(){
		
		List<Regiao> lista = regiaoRepositorioCustom.listarTodosCriteria();
		lista.stream().forEach(a-> System.out.println("% "+a.getNome()));
		
		assertTrue(lista.size() > 0);
		
		System.out.println("---------------------------------------");
	}
	
}
