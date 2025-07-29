package com.jh.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jh.domain.Votacao;
import com.jh.dto.VotacaoDTO;
import com.jh.services.VotacaoService;

@RestController
@RequestMapping(value = "/votacao")
public class VotacaoResource {

	@Autowired
	private VotacaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Votacao> find(@PathVariable Integer id) {
		Votacao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(/* @Valid */ @RequestBody VotacaoDTO objDto) {
		Votacao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodVotacao()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{codVotacao}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(/* @Valid */ @RequestBody VotacaoDTO objDto, @PathVariable Integer codVotacao) {
		Votacao obj = service.fromDTO(objDto);
		obj.setCodVotacao(codVotacao);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VotacaoDTO>> findAll() {
		List<Votacao> list = service.findAll();
		List<VotacaoDTO> listDto = list.stream().map(obj -> new VotacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<VotacaoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Votacao> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<VotacaoDTO> listDto = list.map(obj -> new VotacaoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
