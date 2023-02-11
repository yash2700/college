package com.student.student.Controller;

import com.student.student.Models.Hod;
import com.student.student.Service.HodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hod")
public class HodController {
    @Autowired
    HodService hodService;

    @PostMapping("/add")
    public ResponseEntity<String> addHod(@RequestBody() Hod hod){
        return new ResponseEntity<>(hodService.addHod(hod), HttpStatus.CREATED);
    }

    @GetMapping("/getHodMobileByMaximumPass")
    public ResponseEntity<String> getHodMobileByMaximumPass(){
        return new ResponseEntity<>(hodService.getHodMobileByMaximumPass(),HttpStatus.FOUND);
    }

    @GetMapping("/findMaxGrant")
    public ResponseEntity<Integer> getMaximumGrant(){
        return new ResponseEntity<>(hodService.getMaximumGrant(),HttpStatus.OK);
    }
}
