package com.jh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jh.domain.Votacao;
import com.jh.dto.VotacaoRequestDTO;
import com.jh.repositories.VotacaoRepository;
import com.jh.services.exceptions.DataIntegrityException;
import com.jh.services.exceptions.ObjectNotFoundException;

@Service
public class VotacaoService {
	
	@Autowired
	private VotacaoRepository repo;

	public Votacao find(Integer id) {
		Optional<Votacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Votacao.class.getName()));
	}
	
	public Votacao insert(Votacao obj) {
		obj.setCodVotacao(null);
		return repo.save(obj);
	}
	
	public Votacao update(Votacao obj) {
		Votacao newObj = find(obj.getCodVotacao());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma votacao que possui produtos");
		}
	}
	
	public List<Votacao> findAll() {
		return repo.findAll();
	}
	
	public Page<Votacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Votacao fromDTO(VotacaoRequestDTO objDto) {
		return new Votacao(objDto);
	}


	private void updateData(Votacao newObj, Votacao obj) {
		newObj.setVereador(obj.getVereador());
	}

}
