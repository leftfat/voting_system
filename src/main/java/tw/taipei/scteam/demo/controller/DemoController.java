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
import tw.taipei.scteam.demo.service.DemoService;

@RestController
@RequestMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

  @Autowired
  private DemoService service;

  /**
   * 範例: 拋出錯誤
   * 
   * GET localhost:8080/demo/0
   * GET localhost:8080/demo/1
   * GET localhost:8080/demo/2
   * GET localhost:8080/demo/3
   */
  @GetMapping(path = "/{number}")
  public ResponseEntity<?> method1(@PathVariable Integer number) {

    String response = service.method1(number);

    return ResponseEntity.ok(response);
  }

  /**
   * 範例: Body格式錯誤
   * 
   * POST localhost:8080/demo
   * BODY { }
   */
  @PostMapping(path = "")
  public ResponseEntity<?> method2(@Valid @RequestBody DemoRequest demoRequest) {

    String response = "Hello, World!!";

    return ResponseEntity.ok(response);
  }
}
