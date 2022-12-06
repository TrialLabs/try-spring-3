package id.hadiyan.tryspring3.controller;

import id.hadiyan.tryspring3.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping
public class TestController {
    @GetMapping
    public ResponseEntity<Object> get(){

        Test test = new Test();
        test.setId("1");
        test.setName("Hadiyan");
        test.setPhone("081212121212");

        return ResponseEntity.ok(test);
    }
}
