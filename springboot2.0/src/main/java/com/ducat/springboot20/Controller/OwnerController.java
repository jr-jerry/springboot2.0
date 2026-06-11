package com.ducat.springboot20.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.springboot20.Entity.Owner;
import com.ducat.springboot20.Service.OwnerService;

@RestController
public class OwnerController {
    private final OwnerService ownerService;
    public OwnerController(OwnerService ownerService){
        this.ownerService=ownerService;
    }
    @PostMapping("/save-owner")
    public Owner saveOwnerController(@RequestBody Owner ownerData){
        return ownerService.saveOwner(ownerData);
    }
}
