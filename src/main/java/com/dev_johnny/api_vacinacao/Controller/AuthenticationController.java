package com.dev_johnny.api_vacinacao.Controller;

import com.dev_johnny.api_vacinacao.DTO.AuthenticationDTO;
import com.dev_johnny.api_vacinacao.DTO.LoginResponseDTO;
import com.dev_johnny.api_vacinacao.DTO.RegisterDTO;
import com.dev_johnny.api_vacinacao.Entiny.usuarios.Usuarios;
import com.dev_johnny.api_vacinacao.Infra.security.TokenService;
import com.dev_johnny.api_vacinacao.Repository.UsuariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username() , data.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken( (Usuarios) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {

        if(this.usuariosRepository.findByUsername(data.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encrypitedPassword = new BCryptPasswordEncoder().encode(data.password());

        Usuarios newUsuario = new Usuarios(data.name(), data.username(), encrypitedPassword, data.role());

        this.usuariosRepository.save(newUsuario);

        return ResponseEntity.ok().build();
    }

}
