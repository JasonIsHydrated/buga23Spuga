package de.hhn.se.labswp.buga23spuga;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.sql.Timestamp;


@Controller
@CrossOrigin
@RequestMapping(path="/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseOrganizerRepository courseOrganizerRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired CategoryRepository categoryRepository;

    @RequestMapping(path="/add", method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody String addNewCourse (@RequestParam String coursename, @RequestParam(value = "catName", required = false)String[] checkedBoxes) {

        Courseorganizer o = courseOrganizerRepository.findById(1).orElseThrow(() -> new EntityNotFoundException());
        Course c = new Course();
        c.setName(coursename);
        c.setOrganizer(o);
        courseRepository.save(c);
        courseOrganizerRepository.save(o);

        if(checkedBoxes != null) {
            for(int i = 0; i < checkedBoxes.length; i++) {
                Category cat = categoryRepository.findById(checkedBoxes[i]).orElseThrow(()-> new EntityNotFoundException());
                c.setCategory(cat);
                courseRepository.save(c);
                categoryRepository.save(cat);
            }
        }



        return "Saved";
    }
    @RequestMapping(path="/add/includingOffer", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String addNewOffer (@RequestParam String coursename, @RequestParam String locID, @RequestParam String date,
                                             @RequestParam String time, @RequestParam(value = "catName", required = false)String[] checkedBoxes) {

        Courseorganizer o = courseOrganizerRepository.findById(1).orElseThrow(() -> new EntityNotFoundException());
        Course c = new Course();
        c.setName(coursename);
        c.setOrganizer(o);
        courseRepository.save(c);
        courseOrganizerRepository.save(o);

        if(checkedBoxes != null) {
            for(int i = 0; i < checkedBoxes.length; i++) {
                Category cat = categoryRepository.findById(checkedBoxes[i]).orElseThrow(()-> new EntityNotFoundException());
                c.setCategory(cat);
                courseRepository.save(c);
                categoryRepository.save(cat);
            }
        }

        Offer offer = new Offer();
        offer.setContent(c);
        offer.setResponsible(o);
        String dateTime = date.toString() + " " + time.toString() + ":00";
        Timestamp start = Timestamp.valueOf(dateTime);
        offer.setStart(start);
        Integer locationID = Integer.valueOf(locID);
        Location location = locationRepository.findById(locationID).orElseThrow(() -> new EntityNotFoundException());
        offer.setLocation(location);
        offerRepository.save(offer);
        courseRepository.save(c);
        courseOrganizerRepository.save(o);
        locationRepository.save(location);



        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Course> getAllCourses() { return courseRepository.findAll(); }

}
