package com.jh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jh.domain.Municipio;
import com.jh.dto.MunicipioDTO;
import com.jh.dto.MunicipioResponseDTO;
import com.jh.repositories.MunicipioRepository;
import com.jh.services.exceptions.DataIntegrityException;
import com.jh.services.exceptions.ObjectNotFoundException;

@Service
public class MunicipioService {
	
	@Autowired
	private MunicipioRepository repo;

	
	public Municipio find(Integer id) {
		Optional<Municipio> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Municipio.class.getName()));
	}
	
	
	public MunicipioResponseDTO findDTO(Integer id) {
		
		try {
			Optional<Municipio> obj = repo.findById(id);
			return new MunicipioResponseDTO(obj.get());
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}

	}
	
	public Municipio insert(Municipio obj) {
		//obj.setCodMunicipio(null);
		return repo.save(obj);
	}
	
	public Municipio update(Municipio obj) {
		Municipio newObj = find(obj.getCodMunicipio());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma municipio que possui produtos");
		}
	}
	
	public List<Municipio> findAll() {
		return repo.findAll();
	}
	
	public Page<Municipio> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Municipio fromDTO(MunicipioDTO objDto) {
		return new Municipio(objDto.getCodMunicipio(), 
				objDto.getNomMunicipio(), 
				objDto.getUf());
	}
	
	private void updateData(Municipio newObj, Municipio obj) {
		newObj.setNomMunicipio(obj.getNomMunicipio());
	}

}
