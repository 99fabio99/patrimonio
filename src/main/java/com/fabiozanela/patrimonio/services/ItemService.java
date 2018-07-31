package com.fabiozanela.patrimonio.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fabiozanela.patrimonio.domain.Item;
import com.fabiozanela.patrimonio.domain.Senha;
import com.fabiozanela.patrimonio.repositories.ItemRepository;
import com.fabiozanela.patrimonio.services.exceptions.DataIntegrityException;
import com.fabiozanela.patrimonio.services.exceptions.ObjectNotFoundException;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repo;
	
	private Random rand = new Random();
	
	public Item find(Integer id) {
		Item obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Item não encontrado! Id:" + id
					+ ", Tipo: " + Item.class.getName());
		}
		return obj;
	}
	
	public Item insert(Item obj) {
		obj.setId(null);
		if(obj.getCategoria().equals("Desktop")) {
			obj.setSenha(new Senha(null,newPassword(),obj));
		}
		return repo.save(obj);
	}

	public Item update(Item obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma item que possui outros itens.");
		}
	}
	
	public List<Item> findAll(){
		return repo.findAll();
	}
	
	private String newPassword() {
		char[] vet = new char[8];
		for(int i = 0; i < 8; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(2);
		if(opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		else { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
	}
}
