package de.hhn.se.labswp.buga23spuga;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Location")
public class Location implements Serializable {
    public Location() {
    }

    //ORM ZEUG
    /*
        private java.util.Set this_getSet (int key) {
            if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_LOCATION_OFFER) {
                return ORM_offer;
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
    @Column(name="ID", nullable=false, length=10)
    @Id
    @GeneratedValue(generator="DE_HHN_SE_PMT_GRUPPEA_MODEL_LOCATION_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="DE_HHN_SE_PMT_GRUPPEA_MODEL_LOCATION_ID_GENERATOR", strategy="native")
    private int ID;

    @Column(name="Lat", nullable=false)
    private double lat;

    @Column(name="Lon", nullable=false)
    private double lon;

    @Column(name="Name", nullable=true, length=255)
    private String name;

    @OneToMany(mappedBy="location", targetEntity=de.hhn.se.labswp.buga23spuga.Offer.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    protected java.util.Set offer = new java.util.HashSet();

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

    public void setLat(double value) {
        this.lat = value;
    }

    public double getLat() {
        return lat;
    }

    public void setLon(double value) {
        this.lon = value;
    }

    public double getLon() {
        return lon;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return name;
    }

    private void setOffer(java.util.Set value) {
        this.offer = value;
    }
    @JsonBackReference
    private java.util.Set getOffer() {
        return offer;
    }

    /*
    @Transient
    public final de.hhn.se.pmt.gruppea.model.OfferSetCollection offer = new de.hhn.se.pmt.gruppea.model.OfferSetCollection(this, _ormAdapter, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_LOCATION_OFFER, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_OFFER_LOCATION, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
    */

    public String toString() {
        return String.valueOf(getID());
    }

}
