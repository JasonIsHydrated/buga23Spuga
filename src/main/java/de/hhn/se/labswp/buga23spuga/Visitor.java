package de.hhn.se.labswp.buga23spuga;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Visitor {

  public Integer getVisitorid() {
    return visitorid;
  }

  public void setVisitorid(Integer visitorid) {
    this.visitorid = visitorid;
  }

  public String getProfileusername() {
    return profileusername;
  }

  public void setProfileusername(String profileusername) {
    this.profileusername = profileusername;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer visitorid;

  private String profileusername;
}
