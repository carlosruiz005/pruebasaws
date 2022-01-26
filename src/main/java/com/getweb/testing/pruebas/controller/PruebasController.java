/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getweb.testing.pruebas.controller;

import com.getweb.testing.pruebas.util.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos Ruiz at getweb.mx
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(ApiConstants.PruebasControllerConstants.URL)
@Tag(name = ApiConstants.PruebasControllerConstants.NAME, description = ApiConstants.PruebasControllerConstants.DESCRIPTION)
@ApiResponses(value = {
    @ApiResponse(responseCode = ApiConstants.RESPONSE_CODE_200, description = ApiConstants.RESPONSE_CODE_200_DESCRIPTION,
            content = {
                @Content(mediaType = ApiConstants.CONTENT_TYPE_JSON_APPLICATION)}),
    @ApiResponse(responseCode = ApiConstants.RESPONSE_CODE_404, description = ApiConstants.RESPONSE_CODE_404_DESCRIPTION,
            content = @Content)})
public class PruebasController {

    @GetMapping(ApiConstants.PruebasControllerConstants.Gg.URL)
    @Operation(summary = ApiConstants.PruebasControllerConstants.Gg.SUMMARY,
            description = ApiConstants.PruebasControllerConstants.Gg.DESCRIPCION)
    @ApiResponse(content = {
        @Content(schema = @Schema(implementation = Map.class))})
    public ResponseEntity<Map<String, String>> gG(@RequestParam(required = false, name = "cadena") String cadena) {
        Map<String, String> m = new HashMap();
        String dijiste = cadena == null || cadena.trim().isEmpty() ? "¿Cómo tas?" : "Dijiste: " + cadena;
        m.put("data", "Gg: Hola, Shikixprix. " + dijiste);
        return new ResponseEntity(m, HttpStatus.OK);
    }
}
