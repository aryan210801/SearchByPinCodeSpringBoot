package com.example.AreaByPinCode.controller;

import com.example.AreaByPinCode.model.PinCodeDto;
import com.example.AreaByPinCode.model.PostOfficeResponse;
import com.example.AreaByPinCode.service.PinCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pincode")
public class PinCodeController {
    private final PinCodeService pinCodeService;
    public PinCodeController(PinCodeService pinCodeService){
        this.pinCodeService = pinCodeService;
    }
    @GetMapping("/{pincode}")
    public ResponseEntity<List<PostOfficeResponse>> getFinalDetails(@PathVariable String pincode){

        return pinCodeService.getInfo(pincode);
    }
}
