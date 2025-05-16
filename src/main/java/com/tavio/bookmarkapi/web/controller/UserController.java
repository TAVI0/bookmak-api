package com.tavio.bookmarkapi.web.controller;

import com.tavio.bookmarkapi.domain.service.UserService;
import com.tavio.bookmarkapi.persistance.entity.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Users", description = "Operaciones CRUD y utilitarias sobre usuarios")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor         
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    /* ---------- Lectura ---------- */

    @Operation(summary = "Lista todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Listado completo")
    @GetMapping("/all")
    public List<UserEntity> getAll() {
        return userService.getAll();
    }

    @Operation(
            summary = "Obtiene un usuario por ID",
            parameters = @Parameter(name = "id", in = ParameterIn.PATH, required = true)
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "No existe el usuario")
    })
    @GetMapping("/id/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable Long id) {
        return userService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Obtiene un usuario por username",
            parameters = @Parameter(name = "username", in = ParameterIn.PATH, required = true)
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "No existe el usuario")
    })
    @GetMapping("/username/{username}")
    public ResponseEntity<UserEntity> getByUsername(@PathVariable String username) {
        return userService.getByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Verifica si existe un usuario por username",
            parameters = @Parameter(name = "username", in = ParameterIn.PATH, required = true)
    )
    @ApiResponse(responseCode = "200", description = "true si existe, false si no")
    @GetMapping("/userexist/{username}")
    public boolean userExists(@PathVariable String username) {
        return userService.getByUsername(username).isPresent();
    }

    /* ---------- Escritura ---------- */

    @Operation(summary = "Crea un nuevo usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuario creado"),
            @ApiResponse(responseCode = "409", description = "Username duplicado")
    })
    @PostMapping("/save")
    public ResponseEntity<Void> save(@Valid @RequestBody UserEntity user) {
        if (userService.getByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Actualiza un usuario existente (id obligatorio)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario actualizado"),
            @ApiResponse(responseCode = "404", description = "No existe el usuario")
    })
    @PutMapping("/update")
    public ResponseEntity<Void> update(@Valid @RequestBody UserEntity user) {
        Optional<UserEntity> existing = userService.getById(user.getId());
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return ResponseEntity.ok().build();
    }
}
