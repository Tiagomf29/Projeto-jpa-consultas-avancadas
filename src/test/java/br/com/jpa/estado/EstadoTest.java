package br.com.jpa.estado;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jpa.dto.QuantidadeEstadoPorRegiaoDto;
import br.com.jpa.model.Estado;
import br.com.jpa.model.Regiao;
import br.com.jpa.repository.estado.EstadoRepository;
import br.com.jpa.repository.estado.EstadoRepositoryCustom;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EstadoTest {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EstadoRepositoryCustom estadoRepositoryCustom;
	
	@Test
	public void listaEstadosRepository(){
	
		List<Estado> lista = estadoRepository.findAll();
		lista.forEach(a->System.out.println("? Estado: "+a.getNome()+" - "+a.getRegiao().getNome()));
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaEstadosRepositoryQueryComFetch(){
	
		List<Estado> lista = estadoRepository.listarTodosEstadosComFetch();
		lista.forEach(a->System.out.println("! Estado: "+a.getNome()+" - "+a.getRegiao().getNome()));
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaEstadosRepositoryQuerySemFetch(){
	
		List<Estado> lista = estadoRepository.listarTodosEstadosSemFetch();
		lista.forEach(a->System.out.println("# Estado: "+a.getNome()+" - "+a.getRegiao().getNome()));
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaEstadosRepositoryNamedQueryComParametro(){
	
		List<Estado> lista = estadoRepositoryCustom.listaEstadosNamedQuery1("Região Norte");
		lista.forEach(a->System.out.println("& Estado: "+a.getNome()+" - "+a.getRegiao().getNome()));
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaEstadosRepositoryNamedQueryComParametro2(){
	
		List<Estado> lista = estadoRepositoryCustom.listaEstadosNamedQuery2("Região Sul");
		lista.forEach(a->System.out.println("* Estado: "+a.getNome()+" - "+a.getRegiao().getNome()));
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaTodosNomesEstadosProjecao(){
	
		List<String> lista = estadoRepositoryCustom.listaTodosNomesEstadosProjecao();
		lista.forEach(a->System.out.println("- "+a));
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void projecaoListaQuantidadeEstadosPorRegiao(){
	
		List<Object[]> lista = estadoRepositoryCustom.projecaoListaQuantidadeEstadosPorRegiao();
		lista.forEach(a->System.out.println("@ "+a[0]+" - Quantidade: "+a[1]));
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void projecaoListaQuantidadeEstadosPorRegiaoDTO(){
	
		List<QuantidadeEstadoPorRegiaoDto> lista = estadoRepositoryCustom.projecaoListaQuantidadeEstadosPorRegiaoDTO();
		lista.forEach(a->System.out.println("+ "+a.getNomeRegiao()+" - Quantidade: "+a.getQuantidade()));
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaEstadoCriteria(){
	
		List<Estado> lista = estadoRepositoryCustom.listaTodosEstadosCriteria();
		lista.forEach(a->System.out.println("] "+a.getNome()));
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	@Test
	public void listaRegioesDeEstadoCriteria(){
	
		List<Regiao> lista = estadoRepositoryCustom.listarRegiaoDosEstados(1);
		lista.forEach(a->System.out.println("; "+a.getNome()));
		
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
	
	
	@Test
	public void listaEstadosComRegioesCriteria(){
	
		List<Estado> lista = estadoRepositoryCustom.listarEstadosComRegioes();
		lista.forEach(a->System.out.println("^^ "+a.getNome()));
		
		assertTrue(lista.size()>0);
		
		System.out.println("---------------------------------------");
	}
}
