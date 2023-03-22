package de.hhn.se.labswp.buga23spuga;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;


@Entity
public class Offer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer offerid;

  private Integer locationid;

  private String coursename;

  private Integer courseorganizercourseorganizerid;

  private Timestamp start;



  public void setOfferid(Integer id) {
    this.offerid = id;
  }

  public Integer getOfferid() {
    return offerid;
  }

  public Integer getLocationid() {
    return locationid;
  }

  public void setLocationid(Integer locationid) {
    this.locationid = locationid;
  }

  public String getCoursename() {
    return coursename;
  }

  public void setCoursename(String courseName) {
    this.coursename = courseName;
  }

  public Integer getCourseorganizercourseorganizerid() {
    return courseorganizercourseorganizerid;
  }

  public void setCourseorganizercourseorganizerid(Integer courseorganizercourseorganizerid) {
    this.courseorganizercourseorganizerid = courseorganizercourseorganizerid;
  }

  public Timestamp getStart() {
    return start;
  }

  public void setStart(Timestamp start) {
    this.start = start;
  }
}
