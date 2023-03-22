package de.hhn.se.labswp.buga23spuga;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer appointmentid;

  private Integer offerofferid;

  private Integer visitorvisitorid;


  public Integer getOfferofferid() {
    return offerofferid;
  }

  public void setOfferofferid(Integer offerofferid) {
    this.offerofferid = offerofferid;
  }

  public Integer getVisitorvisitorid() {
    return visitorvisitorid;
  }

  public void setVisitorvisitorid(Integer visitorvisitorid) {
    this.visitorvisitorid = visitorvisitorid;
  }

  public void setAppointmentId(Integer id) {
    this.appointmentid = id;
  }

  public Integer getAppointmentId() {
    return appointmentid;
  }
}
