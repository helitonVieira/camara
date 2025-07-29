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

import com.jh.domain.Municipio;
import com.jh.dto.MunicipioDTO;
import com.jh.dto.MunicipioResponseDTO;
import com.jh.services.MunicipioService;

@RestController
@RequestMapping(value = "/municipio")
public class MunicipioResource {

	@Autowired
	private MunicipioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MunicipioResponseDTO> find(@PathVariable Integer id) {
		MunicipioResponseDTO obj = service.findDTO(id);
		return ResponseEntity.ok().body(obj);
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(/* @Valid */ @RequestBody MunicipioDTO objDto) {
		Municipio obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodMunicipio()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{codMunicipio}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(/* @Valid */ @RequestBody MunicipioDTO objDto, @PathVariable Integer codMunicipio) {
		Municipio obj = service.fromDTO(objDto);
		obj.setCodMunicipio(codMunicipio);
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
	public ResponseEntity<List<MunicipioDTO>> findAll() {
		List<Municipio> list = service.findAll();
		List<MunicipioDTO> listDto = list.stream().map(obj -> new MunicipioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<MunicipioDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Municipio> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<MunicipioDTO> listDto = list.map(obj -> new MunicipioDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
