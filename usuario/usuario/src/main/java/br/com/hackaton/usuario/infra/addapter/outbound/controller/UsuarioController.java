package br.com.hackaton.usuario.infra.addapter.outbound.controller;

import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuario;
import br.com.hackaton.usuario.application.usecase.inbound.create.CreateUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.delete.DeleteUsuario;
import br.com.hackaton.usuario.application.usecase.inbound.delete.DeleteUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.list.ListUsuario;
import br.com.hackaton.usuario.application.usecase.inbound.list.ListUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.search.SearchUsuario;
import br.com.hackaton.usuario.application.usecase.inbound.search.SearchUsuarioOutput;
import br.com.hackaton.usuario.application.usecase.inbound.update.UpdateUsuario;
import br.com.hackaton.usuario.application.usecase.inbound.update.UpdateUsuarioOutput;
import br.com.hackaton.usuario.infra.addapter.inbound.dto.CreateUsuarioDTO;
import br.com.hackaton.usuario.infra.addapter.inbound.dto.UpdateUsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    private final CreateUsuario createUsuario;
    private final UpdateUsuario updateUsuario;
    private final SearchUsuario searchUsuario;
    private final ListUsuario listUsuario;
    private final DeleteUsuario deleteUsuario;

    public UsuarioController(CreateUsuario createUsuario, UpdateUsuario updateUsuario, SearchUsuario searchUsuario, ListUsuario listUsuario, DeleteUsuario deleteUsuario) {
        this.createUsuario = createUsuario;
        this.updateUsuario = updateUsuario;
        this.searchUsuario = searchUsuario;
        this.listUsuario = listUsuario;
        this.deleteUsuario = deleteUsuario;
    }

    @PostMapping("/usuario/create")
    public ResponseEntity<CreateUsuarioOutput> createUsuario (@RequestBody CreateUsuarioDTO createUsuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUsuario.createUsuario(CreateUsuarioDTO.to(createUsuarioDTO)));
    }

    @GetMapping("/usuario/list")
    public ResponseEntity<List<ListUsuarioOutput>> listUsuario () {
        return ResponseEntity.status(HttpStatus.OK).body(listUsuario.listUsuario());
    }

    @GetMapping("/usuario/search/{cpf}")
    public ResponseEntity<SearchUsuarioOutput> searchUsuario (@PathVariable (value = "cpf") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(searchUsuario.searchUsuario(cpf));
    }

    @DeleteMapping("/usuario/delete/{cpf}")
    public ResponseEntity<DeleteUsuarioOutput> deleteUsuario (@PathVariable (value = "cpf") String  cpf) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deleteUsuario.deleteUsuario(cpf));
    }

    @PutMapping("/usuario/update")
    public ResponseEntity<UpdateUsuarioOutput> updateUsuario (@RequestBody UpdateUsuarioDTO updateUsuarioDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateUsuario.deleteUsuario(UpdateUsuarioDTO.to(updateUsuarioDTO)));
    }

}
