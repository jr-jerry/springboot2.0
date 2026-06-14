package com.ducat.springboot20.Controller;

import com.ducat.springboot20.dto.OwnerDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.springboot20.Entity.Owner;
import com.ducat.springboot20.service.OwnerService;

@RestController
public class OwnerController {
    private final OwnerService ownerService;
    public OwnerController(OwnerService ownerService){
        this.ownerService=ownerService;
    }
    @PostMapping("/save-owner")
    public Owner saveOwnerController(@RequestBody OwnerDTO ownerDTO){
        return ownerService.saveOwner(ownerDTO);
    }
}
