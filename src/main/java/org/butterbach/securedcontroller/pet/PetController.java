package org.butterbach.securedcontroller.pet;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PetController {

    @Secured({"admin", "user"}) // either this, or maybe a role-hierarchy
    @GetMapping
    public String getPet(){
        return "fancy pet";
    }
}
