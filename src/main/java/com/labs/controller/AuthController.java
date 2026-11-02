package com.labs.controller;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<String> register(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        try {
            String response = userService.registerUser(email, password);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/login", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<String> login(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful.");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password.");
        }
    }
}