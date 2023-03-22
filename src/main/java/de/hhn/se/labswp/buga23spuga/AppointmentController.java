package de.hhn.se.labswp.buga23spuga;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private OffersRepository offersRepository;

    @Autowired
    private VisitorRepository visitorRepository;


  @GetMapping(path="/get")
  public @ResponseBody Iterable<Appointment> getAppointment() {
    // This returns a JSON or XML with the users
    return appointmentRepository.findAll();
  }

    @RequestMapping(path="/add", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String addNewAppointment () {

      Offer o = offersRepository.findById(1).orElseThrow(() -> new EntityNotFoundException());
      Visitor v = visitorRepository.findById(1).orElseThrow(() -> new EntityNotFoundException());

      //Die 1 bei Visitor wird durch die ID des eingeloggten profiles ersetzt
      //Die 1 bei Offer wird von der zuvor "geholten"
      //z.B. ".findById(profile.getId())"


        Appointment a = new Appointment();
        a.setOfferofferid(o.getOfferid());
        a.setVisitorvisitorid(v.getVisitorid());
        appointmentRepository.save(a);

        return "Gratulation, der Kurs wurde gebucht!";

    }
}
