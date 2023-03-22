package de.hhn.se.labswp.buga23spuga;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping(path = "/offer")
public class OfferController {
  @Autowired
  private OffersRepository offersRepository;


  @GetMapping(path="/get")
  public @ResponseBody Optional<Offer> getOffer() {
    // This returns a JSON or XML with the users
    return offersRepository.findById(1);
  }
  @GetMapping(path="/all")
  public @ResponseBody Iterable<Offer> getOfferName() {

    return offersRepository.findAll();
  }

}

