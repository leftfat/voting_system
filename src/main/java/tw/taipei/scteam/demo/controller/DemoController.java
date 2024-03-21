package tw.taipei.scteam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tw.taipei.scteam.demo.domain.request.DemoRequest;
import tw.taipei.scteam.demo.domain.response.DemoResponse;
import tw.taipei.scteam.demo.service.DemoService;

@RestController
@RequestMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController implements DemoApi {

  @Autowired
  private DemoService service;

  @GetMapping(path = "/{number}")
  public ResponseEntity<?> method1(@PathVariable Integer number) {

    return ResponseEntity.ok(new DemoResponse(service.method1(number)));

  }

  @PostMapping(path = "")
  public ResponseEntity<?> method2(@Valid @RequestBody DemoRequest demoRequest) {

    return ResponseEntity.ok(new DemoResponse("Hello World!"));

  }
}

