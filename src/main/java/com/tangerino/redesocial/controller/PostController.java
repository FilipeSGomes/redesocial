package com.tangerino.redesocial.controller;

import com.tangerino.redesocial.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @Operation(summary = "Realiza criacao de posts", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Post cadastrado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @PostMapping
    public ResponseEntity<String> createPost(@RequestParam(required = false) MultipartFile photo,
                                             @RequestParam(required = false) String link,
                                             @RequestParam(required = false) String message) {
        service.createPost(message, link, photo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
