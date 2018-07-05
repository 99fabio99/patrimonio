package com.fabiozanela.patrimonio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fabiozanela.patrimonio.domain.Categoria;
import com.fabiozanela.patrimonio.domain.Cidade;
import com.fabiozanela.patrimonio.domain.Departamento;
import com.fabiozanela.patrimonio.domain.Empresa;
import com.fabiozanela.patrimonio.domain.Endereco;
import com.fabiozanela.patrimonio.domain.Estado;
import com.fabiozanela.patrimonio.domain.Item;
import com.fabiozanela.patrimonio.domain.Sala;
import com.fabiozanela.patrimonio.domain.Senha;
import com.fabiozanela.patrimonio.domain.Usuario;
import com.fabiozanela.patrimonio.repositories.CategoriaRepository;
import com.fabiozanela.patrimonio.repositories.CidadeRepository;
import com.fabiozanela.patrimonio.repositories.DepartamentoRepository;
import com.fabiozanela.patrimonio.repositories.EmpresaRepository;
import com.fabiozanela.patrimonio.repositories.EnderecoRepository;
import com.fabiozanela.patrimonio.repositories.EstadoRepository;
import com.fabiozanela.patrimonio.repositories.ItemRepository;
import com.fabiozanela.patrimonio.repositories.SalaRepository;
import com.fabiozanela.patrimonio.repositories.SenhaRepository;
import com.fabiozanela.patrimonio.repositories.UsuarioRepository;

@SpringBootApplication
public class PatrimonioApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatrimonioApplication.class, args);
	}

	//Utilizado para inserir dados no banco dados local, assim que a aplicação é iniciada
	@Override
	public void run(String... args) throws Exception {
		
		Estado est1 = new Estado(null,"Goiás");
		Estado est2 = new Estado(null,"Tocantins");
		
		Cidade cid1 = new Cidade(null,"Campos Belos",est1);
		Cidade cid2 = new Cidade(null,"Arraias", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(cid1,cid2));
		
		Usuario usu1 = new Usuario(null, "Fabio Miranda Zanela","fabio.fmz18@gmail.com","(62) 98121-8297", "999.999.999-99");
		Usuario usu2 = new Usuario(null, "Aroldo Medina","aroldo@gmail.com","(62) 9999-9999", "999.999.999-99");
		Usuario usu3 = new Usuario(null, "Osvaldo Cruz","osvaldo@gmail.com","(62) 9999-9999", "999.999.999-99");
		
		Empresa emp1 = new Empresa(null, "Marte Digital","81.906.269/0001-33");
		Empresa emp2 = new Empresa(null, "Casa de Saúde Nossa Senhora da Conceição","40.179.920/0001-33");
		Empresa emp3 = new Empresa(null, "Itafos","20.952.098/0001-94");
		
		Endereco end1 = new Endereco(null,"Rua B H Foreman 8 Quadra 15C Lote 5","100","Sala 200","Setor Aeroporto","73840-970",emp1, cid1);
		Endereco end2 = new Endereco(null,"Rua B H Foreman 8","0","teste","Setor Aeroporto","73840-000",emp2, cid1);
		Endereco end3 = new Endereco(null,"Avenida Principal","0","teste","Setor Central","77349-972",emp3, cid2);
		
		usu1.getEmpresas().addAll(Arrays.asList(emp1,emp2, emp3));
		usu2.getEmpresas().addAll(Arrays.asList(emp2));
		usu3.getEmpresas().addAll(Arrays.asList(emp3));
		
		emp1.getUsuarios().addAll(Arrays.asList(usu1));
		emp2.getUsuarios().addAll(Arrays.asList(usu1,usu2));
		emp3.getUsuarios().addAll(Arrays.asList(usu1,usu3));
		
		emp1.getEnderecos().addAll(Arrays.asList(end1));
		emp2.getEnderecos().addAll(Arrays.asList(end2));
		emp3.getEnderecos().addAll(Arrays.asList(end3));
		
		usuarioRepository.save(Arrays.asList(usu1,usu2,usu3));
		
		Departamento dep1 = new Departamento(null,"Compra", emp2);
		Departamento dep2 = new Departamento(null,"Loja",emp1);
		Departamento dep3 = new Departamento(null,"TI",emp2);
		Departamento dep4 = new Departamento(null,"TI",emp3);
		
		emp1.getDepartamentos().addAll(Arrays.asList(dep2));
		emp2.getDepartamentos().addAll(Arrays.asList(dep1,dep3));
		emp3.getDepartamentos().addAll(Arrays.asList(dep4));
		
		empresaRepository.save(Arrays.asList(emp1,emp2, emp3));
		enderecoRepository.save(Arrays.asList(end1,end2,end3));
		
		Sala sal1 = new Sala(null,"203");
		Sala sal2 = new Sala(null,"203-b");
		Sala sal3 = new Sala(null,"recepcao");
		Sala sal4 = new Sala(null,"manutencao");
		Sala sal5 = new Sala(null,"servidor");
		Sala sal6 = new Sala(null,"coordenacao");
		
		Categoria cat1 = new Categoria(null,"Monitor");
		Categoria cat2 = new Categoria(null,"Desktop");
		Categoria cat3 = new Categoria(null,"Memoria RAM");
		
		Item item1 = new Item(null,"Desktop HP G4350","G4350","HP",423423412,1,sal1,null,cat2);
		Item item2 = new Item(null,"Monitor LG L177WS","L177WS","LG",32423,3,sal2,null,cat1);
		Item item3 = new Item(null,"Desktop HP G4350","G4350","HP",532112331,1,sal3,null,cat2);
		Item item4 = new Item(null,"Desktop PowerEdge T430","T430","Dell",023121255,1,sal5,null,cat2);
		Item item5 = new Item(null,"Desktop PowerEdge T430","T430","Dell",32412312,1,sal6,null,cat2);
		Item item6 = new Item(null,"Memória Kingston HyperX FURY 16GB 2400Mhz DDR4 CL15 Red - HX424C15FR/16","HX424C15FR/16","HyperX",423432423,1,null, item5,cat3);
		
		Senha sen1 = new Senha(null,"8701B18D6113A307",item1);
		item1.setSenha(sen1);
		Senha sen2 = new Senha(null,"C9052205458A99DD",item3);
		item3.setSenha(sen2);
		Senha sen3 = new Senha(null,"220B83BAF28A64BE",item4);
		item4.setSenha(sen3);
		Senha sen4 = new Senha(null,"2CB209C29FE7547B",item5);
		item5.setSenha(sen4);
		
		sal1.getItens().addAll(Arrays.asList(item1));
		sal2.getItens().addAll(Arrays.asList(item2));
		sal3.getItens().addAll(Arrays.asList(item3));
		sal5.getItens().addAll(Arrays.asList(item4));
		sal6.getItens().addAll(Arrays.asList(item5));
		
		dep1.getSalas().addAll(Arrays.asList(sal1,sal2));
		dep2.getSalas().addAll(Arrays.asList(sal3,sal4));
		dep3.getSalas().addAll(Arrays.asList(sal5));
		dep4.getSalas().addAll(Arrays.asList(sal6));
		
		sal1.getDepartamentos().addAll(Arrays.asList(dep1));
		sal2.getDepartamentos().addAll(Arrays.asList(dep1));
		sal3.getDepartamentos().addAll(Arrays.asList(dep2));
		sal4.getDepartamentos().addAll(Arrays.asList(dep2));
		sal5.getDepartamentos().addAll(Arrays.asList(dep3));
		sal6.getDepartamentos().addAll(Arrays.asList(dep4));
		
		cat1.getItens().addAll(Arrays.asList(item2));
		cat2.getItens().addAll(Arrays.asList(item1,item3,item4,item5));
		cat3.getItens().addAll(Arrays.asList(item6));
		
		categoriaRepository.save(Arrays.asList(cat1,cat2,cat3));
		salaRepository.save(Arrays.asList(sal1,sal2,sal3,sal4,sal5,sal6));
		departamentoRepository.save(Arrays.asList(dep1,dep2,dep3,dep4));
		itemRepository.save(Arrays.asList(item1,item2,item3,item4,item5,item6));
		senhaRepository.save(Arrays.asList(sen1,sen2,sen3,sen4));
	}
}
