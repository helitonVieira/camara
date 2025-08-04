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

import com.jh.domain.Vereador;
import com.jh.dto.VereadorDTO;
import com.jh.dto.VereadorNewDTO;
import com.jh.dto.VereadorResponseDTO;
import com.jh.services.VereadorService;

@RestController
@RequestMapping(value="/vereador")
public class VereadorResource {
	
	@Autowired
	private VereadorService service;

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<VereadorResponseDTO> find(@PathVariable Integer id) {
		VereadorResponseDTO obj = service.findDTO(id);
		return ResponseEntity.ok().body(obj);
	}	

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(/* @Valid */ @RequestBody VereadorNewDTO objDto) {
		Vereador obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodVereador()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{codVereador}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(/* @Valid */ @RequestBody VereadorNewDTO objDto, @PathVariable Integer codVereador) {
		Vereador obj = service.fromDTO(objDto);
		obj.setCodVereador(codVereador);
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
	public ResponseEntity<List<VereadorResponseDTO>> findAll() {
		List<Vereador> list = service.findAll();
		List<VereadorResponseDTO> listDto = list.stream().map(obj -> new VereadorResponseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<VereadorDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Vereador> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<VereadorDTO> listDto = list.map(obj -> new VereadorDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
