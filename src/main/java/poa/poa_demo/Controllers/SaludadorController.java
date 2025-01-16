package poa.poa_demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import poa.poa_demo.Services.ISaludadorService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SaludadorController {

    @Autowired
    private ISaludadorService service;

    @GetMapping("/saludador")
    public ResponseEntity<?> saludador() {

        return ResponseEntity.ok(Collections.singletonMap("saludo", service.Saludar("miamor", "pedazo de gil")));
    }
    
    @GetMapping("/error")
    public ResponseEntity<?> saludadorError() {

        return ResponseEntity.ok(Collections.singletonMap("saludo", service.SaludarError("miamor", "pedazo de gil")));
    }
}
