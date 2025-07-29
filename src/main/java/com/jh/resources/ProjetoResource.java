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

import com.jh.domain.Projeto;
import com.jh.dto.ProjetoDTO;
import com.jh.dto.ProjetoResponseDTO;
import com.jh.services.ProjetoService;

@RestController
@RequestMapping(value = "/projeto")
public class ProjetoResource {

	@Autowired
	private ProjetoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProjetoResponseDTO> find(@PathVariable Integer id) {
		ProjetoResponseDTO obj = service.findDTO(id);
		return ResponseEntity.ok().body(obj);
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(/* @Valid */ @RequestBody ProjetoDTO objDto) {
		Projeto obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodProjeto()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{codProjeto}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(/* @Valid */ @RequestBody ProjetoDTO objDto, @PathVariable Integer codProjeto) {
		Projeto obj = service.fromDTO(objDto);
		obj.setCodProjeto(codProjeto);
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
	public ResponseEntity<List<ProjetoDTO>> findAll() {
		List<Projeto> list = service.findAll();
		List<ProjetoDTO> listDto = list.stream().map(obj -> new ProjetoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ProjetoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Projeto> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ProjetoDTO> listDto = list.map(obj -> new ProjetoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
