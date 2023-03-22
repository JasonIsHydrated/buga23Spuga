package de.hhn.se.labswp.buga23spuga;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Visitor")
public class Visitor implements Serializable {
    public Visitor() {
    }

    //ORM ZEUG
    /*
        private java.util.Set this_getSet (int key) {
            if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_VISITOR_EVENT) {
                return ORM_event;
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
    @Column(name="VisitorID", nullable=false, length=10)
    @Id
    @GeneratedValue(generator="DE_HHN_SE_PMT_GRUPPEA_MODEL_VISITOR_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="DE_HHN_SE_PMT_GRUPPEA_MODEL_VISITOR_ID_GENERATOR", strategy="native")
    private int ID;


    @OneToOne(optional=false, targetEntity=de.hhn.se.labswp.buga23spuga.Profile.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="profileusername", referencedColumnName="Username", nullable=false) }, foreignKey=@ForeignKey(name="represents2"))

    private de.hhn.se.labswp.buga23spuga.Profile profile;

    @OneToMany(mappedBy="participant", targetEntity=de.hhn.se.labswp.buga23spuga.Appointment.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    protected java.util.Set event = new java.util.HashSet();


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
                profile.setVisitor(this);
            }
            if ((lprofile != null) && (lprofile.getVisitor() == this)) {
                lprofile.setVisitor(null);
            }
        }
    }
    @JsonManagedReference
    public de.hhn.se.labswp.buga23spuga.Profile getProfile() {
        return profile;
    }

    /*
    private void setORM_Event(java.util.Set value) {
        this.ORM_event = value;
    }

    private java.util.Set getORM_Event() {
        return ORM_event;
    }

    /*
    @Transient
    public final de.hhn.se.pmt.gruppea.model.AppointmentSetCollection event = new de.hhn.se.pmt.gruppea.model.AppointmentSetCollection(this, _ormAdapter, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_VISITOR_EVENT, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_APPOINTMENT_PARTICIPANT, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_MUL_ONE_TO_MANY);

    public String toString() {
        return String.valueOf(getID());
    }
    */
}
