package com.rally.santafesino.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.rally.santafesino.service.Coordenada_trayectoService;
import com.rally.santafesino.web.rest.errors.BadRequestAlertException;
import com.rally.santafesino.web.rest.util.HeaderUtil;
import com.rally.santafesino.web.rest.util.PaginationUtil;
import com.rally.santafesino.service.dto.Coordenada_trayectoDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Coordenada_trayecto.
 */
@RestController
@RequestMapping("/api")
public class Coordenada_trayectoResource {

    private final Logger log = LoggerFactory.getLogger(Coordenada_trayectoResource.class);

    private static final String ENTITY_NAME = "coordenada_trayecto";

    private final Coordenada_trayectoService coordenada_trayectoService;

    public Coordenada_trayectoResource(Coordenada_trayectoService coordenada_trayectoService) {
        this.coordenada_trayectoService = coordenada_trayectoService;
    }

    /**
     * POST  /coordenada-trayectos : Create a new coordenada_trayecto.
     *
     * @param coordenada_trayectoDTO the coordenada_trayectoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new coordenada_trayectoDTO, or with status 400 (Bad Request) if the coordenada_trayecto has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/coordenada-trayectos")
    @Timed
    public ResponseEntity<Coordenada_trayectoDTO> createCoordenada_trayecto(@Valid @RequestBody Coordenada_trayectoDTO coordenada_trayectoDTO) throws URISyntaxException {
        log.debug("REST request to save Coordenada_trayecto : {}", coordenada_trayectoDTO);
        if (coordenada_trayectoDTO.getId() != null) {
            throw new BadRequestAlertException("A new coordenada_trayecto cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Coordenada_trayectoDTO result = coordenada_trayectoService.save(coordenada_trayectoDTO);
        return ResponseEntity.created(new URI("/api/coordenada-trayectos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /coordenada-trayectos : Updates an existing coordenada_trayecto.
     *
     * @param coordenada_trayectoDTO the coordenada_trayectoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated coordenada_trayectoDTO,
     * or with status 400 (Bad Request) if the coordenada_trayectoDTO is not valid,
     * or with status 500 (Internal Server Error) if the coordenada_trayectoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/coordenada-trayectos")
    @Timed
    public ResponseEntity<Coordenada_trayectoDTO> updateCoordenada_trayecto(@Valid @RequestBody Coordenada_trayectoDTO coordenada_trayectoDTO) throws URISyntaxException {
        log.debug("REST request to update Coordenada_trayecto : {}", coordenada_trayectoDTO);
        if (coordenada_trayectoDTO.getId() == null) {
            return createCoordenada_trayecto(coordenada_trayectoDTO);
        }
        Coordenada_trayectoDTO result = coordenada_trayectoService.save(coordenada_trayectoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, coordenada_trayectoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /coordenada-trayectos : get all the coordenada_trayectos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of coordenada_trayectos in body
     */
    @GetMapping("/coordenada-trayectos")
    @Timed
    public ResponseEntity<List<Coordenada_trayectoDTO>> getAllCoordenada_trayectos(Pageable pageable) {
        log.debug("REST request to get a page of Coordenada_trayectos");
        Page<Coordenada_trayectoDTO> page = coordenada_trayectoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/coordenada-trayectos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /coordenada-trayectos/:id : get the "id" coordenada_trayecto.
     *
     * @param id the id of the coordenada_trayectoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the coordenada_trayectoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/coordenada-trayectos/{id}")
    @Timed
    public ResponseEntity<Coordenada_trayectoDTO> getCoordenada_trayecto(@PathVariable Long id) {
        log.debug("REST request to get Coordenada_trayecto : {}", id);
        Coordenada_trayectoDTO coordenada_trayectoDTO = coordenada_trayectoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(coordenada_trayectoDTO));
    }

    /**
     * DELETE  /coordenada-trayectos/:id : delete the "id" coordenada_trayecto.
     *
     * @param id the id of the coordenada_trayectoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/coordenada-trayectos/{id}")
    @Timed
    public ResponseEntity<Void> deleteCoordenada_trayecto(@PathVariable Long id) {
        log.debug("REST request to delete Coordenada_trayecto : {}", id);
        coordenada_trayectoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
