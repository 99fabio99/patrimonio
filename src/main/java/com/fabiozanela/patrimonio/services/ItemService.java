package com.fabiozanela.patrimonio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.patrimonio.domain.Item;
import com.fabiozanela.patrimonio.repositories.ItemRepository;
import com.fabiozanela.patrimonio.services.exceptions.ObjectNotFoundException;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repo;
	
	public Item buscar(Integer id) {
		Item obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Item não encontrado! Id:" + id
					+ ", Tipo: " + Item.class.getName());
		}
		return obj;
	}
}
