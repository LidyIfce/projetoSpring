package com.lidi.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidi.cursomc.domain.Categoria;
import com.lidi.cursomc.repositories.CategoriaRepository;
import com.lidi.cursomc.services.excepions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) {
		Categoria obj = categoriaRepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

}
