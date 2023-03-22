package de.hhn.se.labswp.buga23spuga;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Offer")
public class Offer implements Serializable {
    public Offer() {
    }

    //ORM ZEUG
    /*
        private java.util.Set this_getSet (int key) {
            if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_OFFER_SUBSCRIPTION) {
                return ORM_subscription;
            }

            return null;
        }

        private void this_setOwner(Object owner, int key) {
            if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_OFFER_RESPONSIBLE) {
                this.responsible = (de.hhn.se.pmt.gruppea.model.CourseOrganizer) owner;
            }

            else if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_OFFER_CONTENT) {
                this.content = (de.hhn.se.pmt.gruppea.model.Course) owner;
            }

            else if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_OFFER_LOCATION) {
                this.location = (de.hhn.se.pmt.gruppea.model.Location) owner;
            }
        }

        @Transient
        org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
            public java.util.Set getSet(int key) {
                return this_getSet(key);
            }

            public void setOwner(Object owner, int key) {
                this_setOwner(owner, key);
            }

        };
    */

    //TABELLENSPALTEN UND VERBINDUNGEN ZU ANDEREN TABELLEN
    @Column(name="OfferID", nullable=false, length=10)
    @Id
    @GeneratedValue(generator="DE_HHN_SE_PMT_GRUPPEA_MODEL_OFFER_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="DE_HHN_SE_PMT_GRUPPEA_MODEL_OFFER_ID_GENERATOR", strategy="native")
    private int ID;

    @ManyToOne(targetEntity=de.hhn.se.labswp.buga23spuga.Location.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="locationid", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="hosts"))
    private de.hhn.se.labswp.buga23spuga.Location location;

    @ManyToOne(targetEntity=de.hhn.se.labswp.buga23spuga.Course.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="coursename", referencedColumnName="Name", nullable=false) }, foreignKey=@ForeignKey(name="represents3"))
    private de.hhn.se.labswp.buga23spuga.Course content;

    @ManyToOne(targetEntity=de.hhn.se.labswp.buga23spuga.Courseorganizer.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="courseorganizercourseorganizerid", referencedColumnName="courseorganizerid", nullable=false) }, foreignKey=@ForeignKey(name="offers"))
    private de.hhn.se.labswp.buga23spuga.Courseorganizer responsible;

    @Column(name="`Start`", nullable=true)
    private java.sql.Timestamp start;

    @OneToMany(mappedBy="booking", targetEntity=de.hhn.se.labswp.buga23spuga.Appointment.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    protected java.util.Set subscription = new java.util.HashSet();


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

    public void setStart(java.sql.Timestamp value) {
        this.start = value;
    }

    public java.sql.Timestamp getStart() {
        return start;
    }

    public void setResponsible(de.hhn.se.labswp.buga23spuga.Courseorganizer value) {
        if (responsible != null) {
            responsible.event.remove(this);
        }
        if (value != null) {
            value.event.add(this);
            this.responsible = value;
        }
    }
    @JsonManagedReference
    public de.hhn.se.labswp.buga23spuga.Courseorganizer getResponsible() {
        return responsible;
    }

    /**
     * This method is for internal use only.
     */
    /*
    public void setORM_Responsible(de.hhn.se.pmt.gruppea.model.CourseOrganizer value) {
        this.responsible = value;
    }

    private de.hhn.se.pmt.gruppea.model.CourseOrganizer getORM_Responsible() {
        return responsible;
    }

    private void setORM_Subscription(java.util.Set value) {
        this.ORM_subscription = value;
    }

    private java.util.Set getORM_Subscription() {
        return ORM_subscription;
    }

    @Transient
    public final de.hhn.se.pmt.gruppea.model.AppointmentSetCollection subscription = new de.hhn.se.pmt.gruppea.model.AppointmentSetCollection(this, _ormAdapter, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_OFFER_SUBSCRIPTION, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_APPOINTMENT_BOOKING, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
    */

    public void setContent(de.hhn.se.labswp.buga23spuga.Course value) {
        if (content != null) {
            content.representation.remove(this);
        }
        if (value != null) {
            value.representation.add(this);
            this.content = value;
        }
    }
    @JsonBackReference
    public de.hhn.se.labswp.buga23spuga.Course getContent() {
        return content;
    }

    /**
     * This method is for internal use only.
     */
    /*
    public void setORM_Content(de.hhn.se.pmt.gruppea.model.Course value) {
        this.content = value;
    }

    private de.hhn.se.pmt.gruppea.model.Course getORM_Content() {
        return content;
    }
    */

    public void setLocation(de.hhn.se.labswp.buga23spuga.Location value) {
        if (location != null) {
            location.offer.remove(this);
        }
        if (value != null) {
            value.offer.add(this);
            this.location = value;
        }
    }
    @JsonManagedReference
    public de.hhn.se.labswp.buga23spuga.Location getLocation() {
        return location;
    }

    /**
     * This method is for internal use only.
     */
    /*
    public void setLocation(de.hhn.se.labswp.buga23testsport.Location value) {
        this.location = value;
    }

    private de.hhn.se.labswp.buga23testsport.Location getLocation() {
        return location;
    }
    */
    public void cancel() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }

    public void bookCourseOffer() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }

    public void createOffer() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return String.valueOf(getID());
    }

}
