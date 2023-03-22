package de.hhn.se.labswp.buga23spuga;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="courseorganizer")
public class Courseorganizer implements Serializable {
    public Courseorganizer() {
    }

    //ORM ZEUG
    /*
        private java.util.Set this_getSet (int key) {
            if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSEORGANIZER_EVENT) {
                return ORM_event;
            }
            else if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSEORGANIZER_COURSE) {
                return ORM_course;
            }

            return null;
        }

        @Transient
        org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
            public java.util.Set getSet(int key) {
                return this_getSet(key);
            }

        };
    */

    //TABELLENSPALTEN UND VERBINDUNGEN ZU ANDEREN TABELLEN
    @Column(name="courseorganizerid", nullable=false, length=10)
    @Id
    @GeneratedValue(generator="DE_HHN_SE_PMT_GRUPPEA_MODEL_COURSEORGANIZER_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="DE_HHN_SE_PMT_GRUPPEA_MODEL_COURSEORGANIZER_ID_GENERATOR", strategy="native")
    private int ID;

    @OneToOne(optional=false, targetEntity=de.hhn.se.labswp.buga23spuga.Profile.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="profileusername", referencedColumnName="Username", nullable=false) }, foreignKey=@ForeignKey(name="represents"))
    private de.hhn.se.labswp.buga23spuga.Profile profile;

    @OneToMany(mappedBy="responsible", targetEntity=de.hhn.se.labswp.buga23spuga.Offer.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    protected java.util.Set event = new java.util.HashSet();

    @OneToMany(mappedBy="organizer", targetEntity=de.hhn.se.labswp.buga23spuga.Course.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    protected java.util.Set course = new java.util.HashSet();


    //GETTER UND SETTER
    private void setID(int value) {
        this.ID = value;
    }

    public int getID() {
        return ID;
    }

    /*
        public int getORMID() {
            return getID();
        }
    */

    public void setProfile(de.hhn.se.labswp.buga23spuga.Profile value) {
        if (this.profile != value) {
            de.hhn.se.labswp.buga23spuga.Profile lprofile = this.profile;
            this.profile = value;
            if (value != null) {
                profile.setOrganizer(this);
            }
            if (lprofile != null && lprofile.getOrganizer() == this) {
                lprofile.setOrganizer(null);
            }
        }
    }
    @JsonBackReference
    public de.hhn.se.labswp.buga23spuga.Profile getProfile() {
        return profile;
    }

    private void setEvent(java.util.Set value) {
        this.event = value;
    }
    @JsonBackReference
    private java.util.Set getEvent() {
        return event;
    }

    /*
        @Transient
        public final de.hhn.se.pmt.gruppea.model.OfferSetCollection event = new de.hhn.se.pmt.gruppea.model.OfferSetCollection(this, _ormAdapter, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSEORGANIZER_EVENT, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_OFFER_RESPONSIBLE, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
    */

    private void setCourse(java.util.Set value) {
        this.course = value;
    }

    private java.util.Set getCourse() {
        return course;
    }

    /*
        @Transient
        public final de.hhn.se.pmt.gruppea.model.CourseSetCollection course = new de.hhn.se.pmt.gruppea.model.CourseSetCollection(this, _ormAdapter, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSEORGANIZER_COURSE, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSE_ORGANIZER, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
    */

    public String toString() {
        return String.valueOf(getID());
    }

}
