package de.hhn.se.labswp.buga23spuga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
@RequestMapping(path="/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Category> getAllCourses() { return categoryRepository.findAll(); }
}
