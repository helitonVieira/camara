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
import com.jh.domain.Projeto;
import com.jh.domain.Vereador;
import com.jh.domain.Votacao;
import com.jh.dto.ProjetoDTO;
import com.jh.dto.ProjetoResponseDTO;
import com.jh.dto.ProjetoVotacaoResponseDTO;
import com.jh.repositories.MunicipioRepository;
import com.jh.repositories.ProjetoRepository;
import com.jh.repositories.VereadorRepository;
import com.jh.repositories.VotacaoRepository;
import com.jh.services.exceptions.DataIntegrityException;
import com.jh.services.exceptions.ObjectNotFoundException;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository repo;
	
	@Autowired
	private VereadorRepository repoVereador;
	
	@Autowired
	private MunicipioRepository repoMunicipio;
	
	@Autowired
	private VotacaoRepository repoVotacao;

	public Projeto find(Integer id) {
		Optional<Projeto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Projeto.class.getName()));
	}
	
	
    public ProjetoVotacaoResponseDTO findVotacaoDTO(Integer id) {
		
		try {
			Optional<Projeto> obj = repo.findById(id);		
			
			Optional<Vereador> obj2 = buscaVereador(obj.get().getVereador().getCodVereador());
			obj.get().setVereador(obj2.get());
			
			Optional<Municipio> obj3 = repoMunicipio.findById(obj.get().getMunicipio().getCodMunicipio());
			obj.get().setMunicipio(obj3.get());
			
			List<Votacao>votacoes = repoVotacao.findByProjeto_CodProjeto(obj.get().getCodProjeto());
			obj.get().setVotacao(votacoes);
			
			/*int x =0;
			for (Votacao v : votacoes) {				 
				 Optional<Vereador> vereador = buscaVereador(v.getVereador().getCodVereador());
				 obj.get().getVotacao().get(x).setVereador(vereador.get());
					x++;
			}*/
			

			 
			return new ProjetoVotacaoResponseDTO(obj.get());
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Objeto não encontrado! Id:" + id );
		}		
	}
    
    private Optional<Vereador> buscaVereador(Integer codVereador){
    	return repoVereador.findById(codVereador);
    }
	
	public ProjetoResponseDTO findDTO(Integer id) {
		
		try {
			Optional<Projeto> obj = repo.findById(id);		
			
			Optional<Vereador> obj2 = repoVereador.findById(obj.get().getVereador().getCodVereador());
			obj.get().setVereador(obj2.get());
			
			Optional<Municipio> obj3 = repoMunicipio.findById(obj.get().getMunicipio().getCodMunicipio());
			obj.get().setMunicipio(obj3.get());
			 
			return new ProjetoResponseDTO(obj.get());
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Objeto não encontrado! Id:" + id );
		}		
	}
	
	public Projeto insert(Projeto obj) {
		obj.setCodProjeto(null);
		return repo.save(obj);
	}
	
	public Projeto update(Projeto obj) {
		Projeto newObj = find(obj.getCodProjeto());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma projeto que possui produtos");
		}
	}
	
	public List<Projeto> findAll() {
		return repo.findAll();
	}
	
	public Page<Projeto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Projeto fromDTO(ProjetoDTO objDto) {
		return new Projeto(objDto.getCodProjeto(), 
				objDto.getNumProjeto(),
				objDto.getNomProjeto(), 
				objDto.getDesProjeto(),
				objDto.getPdf(),
				objDto.getFlgVotacaoProj(),
				objDto.getDtaVotacao(),
				0,//objDto.getSim(),
				0,//objDto.getNao(),
				0,//objDto.getAbstencao(),
				objDto.getIndAbrirVotacao(),
				objDto.getIndPainelVotacao(),
				objDto.getCodMunicipio() ,
				objDto.getCodVereador());
	}
	
	private void updateData(Projeto newObj, Projeto obj) {
		newObj.setNomProjeto(obj.getNomProjeto());
	}

}
