package com.zhm.jwt.controller;

import com.zhm.jwt.entity.AuthenticationRequest;
import com.zhm.jwt.entity.AuthenticationResponse;
import com.zhm.jwt.entity.Person;
import com.zhm.jwt.service.JWTService;
import com.zhm.jwt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MyController {

    private PasswordEncoder passwordEncoder;
    private PersonService personService;
    private AuthenticationManager authenticationManager;
    private JWTService jwtService;

    @Autowired
    public MyController(PasswordEncoder passwordEncoder, PersonService personService, AuthenticationManager authenticationManager, JWTService jwtService){
        this.passwordEncoder = passwordEncoder;
        this.personService = personService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @GetMapping("/")
    public String getDashboard(Authentication authentication, Model theModel) {
        if(authentication != null){
            String username = authentication.getName();
            System.out.println("The logged in user is : " + username);
        }
        else{
            System.out.println("No one currently authenticated");
        }
        return "dashboard";
    }

    @GetMapping("/register")
    public String showRegister(){
        return "register";
    }

    @PostMapping("/register/success")
    public String showRegisterSuccess(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                      @RequestParam("email") String email, @RequestParam("password") String password, Model theModel){

        Person person = new Person(firstName, lastName, email, passwordEncoder.encode(password), "User");
        personService.save(person);
        theModel.addAttribute("message", "User successfully registered");
        return "redirect:/login";

    }

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestBody AuthenticationRequest authenticationRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new BadCredentialsException("Authentication failed. Invalid username or password.");
        }
        String jwtToken = jwtService.generateToken(authenticationRequest.getEmail());
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));

    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
