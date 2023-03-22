package de.hhn.se.labswp.buga23spuga;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Appointment")
public class Appointment implements Serializable {
    public Appointment() {
    }

    //ORM ZEUG
    /*
    private void this_setOwner(Object owner, int key) {
        if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_APPOINTMENT_PARTICIPANT) {
            this.participant = (de.hhn.se.pmt.gruppea.model.Visitor) owner;
        }

        else if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_APPOINTMENT_BOOKING) {
            this.booking = (de.hhn.se.pmt.gruppea.model.Offer) owner;
        }
    }

    @Transient
    org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
        public void setOwner(Object owner, int key) {
            this_setOwner(owner, key);
        }

    };
    */

    //TABELLENSPALTEN UND VERBINDUNGEN ZU ANDEREN TABELLEN
    @Column(name="AppointmentID", nullable=false, length=10)
    @Id
    @GeneratedValue(generator="DE_HHN_SE_PMT_GRUPPEA_MODEL_APPOINTMENT_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="DE_HHN_SE_PMT_GRUPPEA_MODEL_APPOINTMENT_ID_GENERATOR", strategy="native")
    private int ID;

    @ManyToOne(targetEntity=de.hhn.se.labswp.buga23spuga.Offer.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="OfferOfferID", referencedColumnName="OfferID", nullable=false) }, foreignKey=@ForeignKey(name="represents4"))
    private de.hhn.se.labswp.buga23spuga.Offer booking;

    @ManyToOne(targetEntity=de.hhn.se.labswp.buga23spuga.Visitor.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="VisitorVisitorID", referencedColumnName="VisitorID", nullable=false) }, foreignKey=@ForeignKey(name="has"))
    private de.hhn.se.labswp.buga23spuga.Visitor participant;


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

    public void setParticipant(de.hhn.se.labswp.buga23spuga.Visitor value) {
        if (participant != null) {
            participant.event.remove(this);
        }
        if (value != null) {
            value.event.add(this);
        }
    }

    public de.hhn.se.labswp.buga23spuga.Visitor getParticipant() {
        return participant;
    }

    /**
     * This method is for internal use only.
     */
    /*
    public void setORM_Participant(de.hhn.se.pmt.gruppea.model.Visitor value) {
        this.participant = value;
    }

    private de.hhn.se.pmt.gruppea.model.Visitor getORM_Participant() {
        return participant;
    }
    */

    public void setBooking(de.hhn.se.labswp.buga23spuga.Offer value) {
        if (booking != null) {
            booking.subscription.remove(this);
        }
        if (value != null) {
            value.subscription.add(this);
        }
    }

    public de.hhn.se.labswp.buga23spuga.Offer getBooking() {
        return booking;
    }

    /**
     * This method is for internal use only.
     */
    /*
    public void setORM_Booking(de.hhn.se.pmt.gruppea.model.Offer value) {
        this.booking = value;
    }

    private de.hhn.se.pmt.gruppea.model.Offer getORM_Booking() {
        return booking;
    }
*/
    public void cancel() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return String.valueOf(getID());
    }

}