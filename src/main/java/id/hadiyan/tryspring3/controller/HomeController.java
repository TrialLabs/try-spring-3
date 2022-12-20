package id.hadiyan.tryspring3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {

        @GetMapping("/")
        public ResponseEntity<String> home(@AuthenticationPrincipal String username){
            return ResponseEntity.ok(String.format("Welcome %s", username));
        }
}
