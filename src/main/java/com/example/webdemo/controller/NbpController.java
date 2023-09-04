package com.example.webdemo.controller;

import com.example.webdemo.service.NbpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/nbp")
public class NbpController {
    private final NbpService nbpService;

    public NbpController(NbpService nbpService)
    {
        this.nbpService = nbpService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "404 Not Found - nie znaleziono"),
            @ApiResponse(responseCode = "400", description = "400 Bad Request - złe zadanie")
    })
    @GetMapping(value = "/{currency}/{startDate}/{endDate}")
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "pokaże się Bad Request ale można dodać przyczynę")
    @Operation(description = "Aplikacja, która oblicza srednia kursu walut z podanego okresu czasu")
        public ResponseEntity<Double> getnbp(@PathVariable String startDate, @PathVariable String endDate, @PathVariable String currency){
        return ResponseEntity.ok(nbpService.show(startDate, endDate, currency));
    }
}
