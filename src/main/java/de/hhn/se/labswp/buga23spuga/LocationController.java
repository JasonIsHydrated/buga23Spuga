package de.hhn.se.labswp.buga23spuga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
@CrossOrigin
@RequestMapping(path="/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Location> getAllCourses() { return locationRepository.findAll(); }
}
