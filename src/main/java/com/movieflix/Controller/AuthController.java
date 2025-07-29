package com.movieflix.Controller;

import com.movieflix.Config.TokenService;
import com.movieflix.Controller.Request.LoginRequest;
import com.movieflix.Controller.Request.UserRequest;
import com.movieflix.Entity.User;
import com.movieflix.Exceptions.UseNameOrPasswordInvalidExeception;
import com.movieflix.Mapper.UserMapper;
import com.movieflix.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @GetMapping("/user")
    public ResponseEntity<?> list() {
        if(userService.list().isEmpty()){
            return ResponseEntity.ok("Nao exite regritros");
        } else {
            return ResponseEntity.ok(userService.list());
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody UserRequest userRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(UserMapper.toUser(userRequest)));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

       try{
           UsernamePasswordAuthenticationToken userPassword = new UsernamePasswordAuthenticationToken(loginRequest.email(),loginRequest.password());
           Authentication authentication = authenticationManager.authenticate(userPassword);
           User usuario =(User) authentication.getPrincipal();
           String token = tokenService.token(usuario);
           return ResponseEntity.ok(token);
       }catch (BadCredentialsException ex) {
           throw new UseNameOrPasswordInvalidExeception("Usuario ou senha invalidos.");
       }
    }
}
