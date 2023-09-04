package com.example.webdemo.service;

import com.example.webdemo.model.Nbp;
import com.example.webdemo.model.Rates;
import com.example.webdemo.repository.NbpRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class NbpService {
    private final RestTemplate restTemplate;
    private final NbpRepository nbpRepository;

    public NbpService(RestTemplate restTemplate, NbpRepository nbpRepository) {
        this.nbpRepository = nbpRepository;
        this.restTemplate = restTemplate;
    }

    public Double show(String startDate, String endDate, String currency) {
        ResponseEntity<Nbp> response = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + startDate + "/" + endDate, Nbp.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new ResponseStatusException(response.getStatusCode());
        } else {
            Nbp nbp = response.getBody();
            Double sum = 0.0;
            Double avg = 0.0;

            for (Rates rates : nbp.getRates()) {
                sum += rates.getMid();
            }
            avg = sum / nbp.getRates().size();
            nbpRepository.addEntry(nbp.getCurrency(), startDate, endDate, avg, new Date().toString());
            return avg;
        }
    }
}
