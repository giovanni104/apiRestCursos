package com.api.rest.controller.v2;


import com.api.rest.exception.ResourceNotFoundException;
import com.api.rest.model.Encuesta;
import com.api.rest.repositories.EncuestaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.net.URI;
import java.util.Optional;

@RestController("EncuestaControllerV2")
@RequestMapping("/v2")
public class EncuestaController {


    @Autowired
    private EncuestaRepository encuestaRepository;


    @GetMapping("/encuestas")
    public ResponseEntity<Iterable<Encuesta>> listarTodasLasEncuestas(Pageable pageable){
        Page<Encuesta> encuestas = encuestaRepository.findAll(pageable);
        return new ResponseEntity<>(encuestas, HttpStatus.OK);
    }

    @PostMapping("/encuestas")
    public ResponseEntity<?> crearEncuesta(@Valid @RequestBody Encuesta encuesta) {
        encuesta = encuestaRepository.save(encuesta);

        HttpHeaders httpHeaders = new HttpHeaders();
        URI newEncuestaUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(encuesta.getId()).toUri();
        httpHeaders.setLocation(newEncuestaUri);

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/encuestas/{encuestaId}")
    public ResponseEntity<?> obtenerEncuesta(@PathVariable Long encuestaId) {
        verifyEncuesta(encuestaId);
        Optional<Encuesta> encuesta = encuestaRepository.findById(encuestaId);

        if (encuesta.isPresent()) {
            return new ResponseEntity<>(encuesta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/encuestas/{encuestaId}")
    public ResponseEntity<?> actualizarEncuesta(@Valid @RequestBody Encuesta encuesta, @PathVariable Long encuestaId) {
        verifyEncuesta(encuestaId);
        encuesta.setId(encuestaId);
        encuestaRepository.save(encuesta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/encuestas/{encuestaId}")
    public ResponseEntity<?> eliminarEncuesta(@PathVariable Long encuestaId) {
        verifyEncuesta(encuestaId);
        encuestaRepository.deleteById(encuestaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    protected void verifyEncuesta(Long encuestaId){

        Optional<Encuesta> encuesta = encuestaRepository.findById(encuestaId);
        if(!encuesta.isPresent()){
            throw new ResourceNotFoundException("Encuesta con el ID : " + encuestaId + " no encontrada");
        }}
}
