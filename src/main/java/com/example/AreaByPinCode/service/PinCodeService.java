package com.example.AreaByPinCode.service;

import com.example.AreaByPinCode.model.PinCode;
import com.example.AreaByPinCode.model.PinCodeDto;
import com.example.AreaByPinCode.model.PostOfficeResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PinCodeService {

    RestTemplate restTemplate = new RestTemplate();
    public ResponseEntity<List<PostOfficeResponse>> getInfo(String pincode){
        String url = "https://api.postalpincode.in/pincode/" + pincode;
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<PinCode>> response = restTemplate.exchange(url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<PinCode>>() {});
        List<PinCode> allData = response.getBody();
        if (allData != null && !allData.isEmpty() && allData.get(0).getPostOfficeResponse() != null) {
            List<PostOfficeResponse> postOfficeResponses = allData.get(0).getPostOfficeResponse();
//            List<PinCodeDto> finalData = postOfficeResponses.stream().map(po -> new PinCodeDto(po.getName(), po.getDistrict(), po.getState()))
//                    .collect(Collectors.toList());
            return new ResponseEntity<>(postOfficeResponses, HttpStatus.OK);
        }
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
    }
}
