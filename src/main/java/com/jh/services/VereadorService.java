package com.jh.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jh.domain.Vereador;
import com.jh.dto.VereadorDTO;
import com.jh.dto.VereadorResponseDTO;
import com.jh.repositories.VereadorRepository;
import com.jh.services.exceptions.DataIntegrityException;
import com.jh.services.exceptions.ObjectNotFoundException;

@Service
public class VereadorService {

	@Autowired
	private VereadorRepository repo;

	public Vereador find(Integer id) {
		Optional<Vereador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Vereador.class.getName()));
	}

	public VereadorResponseDTO findDTO(Integer id) {
		try {
			Optional<Vereador> obj = repo.findById(id);
			return new VereadorResponseDTO(obj.get());
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
	}

	public Vereador insert(Vereador obj) {
		obj.setCodVereador(null);
		return repo.save(obj);
	}

	public Vereador update(Vereador obj) {
		Vereador newObj = find(obj.getCodVereador());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma municipio que possui produtos");
		}
	}

	public List<Vereador> findAll() {
		return repo.findAll();
	}
	
	public List<VereadorResponseDTO> findAll2() {
		List<Vereador> vereadores = repo.findAll();		
		return convertListDto(vereadores);
	}
	
	private List<VereadorResponseDTO> convertListDto(List<Vereador> vereadores){
		List<VereadorResponseDTO> listDto = new ArrayList<>();
		for (Vereador vereador : vereadores) {
			listDto.add(new VereadorResponseDTO(vereador));
		}
		return listDto;
	}

	public Page<Vereador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Vereador fromDTO(VereadorDTO objDto) {
		return new Vereador(objDto.getCodVereador(), objDto.getNomVereador(), objDto.getSglPartido(), objDto.getFoto(),
				objDto.getIndPresidente(), objDto.getMunicipio());
	}

	private void updateData(Vereador newObj, Vereador obj) {
		newObj.setNomVereador(obj.getNomVereador());
	}

}
