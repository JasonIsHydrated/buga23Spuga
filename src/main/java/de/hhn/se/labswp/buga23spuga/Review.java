package de.hhn.se.labswp.buga23spuga;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Review")
public class Review implements Serializable {
    public Review() {
    }

    //ORM ZEUG
    /*
    private void this_setOwner(Object owner, int key) {
        if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_REVIEW_CONTENT) {
            this.content = (de.hhn.se.pmt.gruppea.model.Course) owner;
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
    @Column(name="ReviewID", nullable=false, length=10)
    @Id
    @GeneratedValue(generator="DE_HHN_SE_PMT_GRUPPEA_MODEL_REVIEW_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="DE_HHN_SE_PMT_GRUPPEA_MODEL_REVIEW_ID_GENERATOR", strategy="native")
    private int ID;

    @ManyToOne(targetEntity=de.hhn.se.labswp.buga23spuga.Course.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="CourseName", referencedColumnName="Name", nullable=false) }, foreignKey=@ForeignKey(name="exemplifies"))
    private de.hhn.se.labswp.buga23spuga.Course content;

    @Column(name="Rating", nullable=false, length=10)
    private int rating;

    @Column(name="Description", nullable=true, length=255)
    private String description;


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

    public void setRating(int value) {
        this.rating = value;
    }

    public int getRating() {
        return rating;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }

    public void setContent(de.hhn.se.labswp.buga23spuga.Course value) {
        if (content != null) {
            content.rating.remove(this);
        }
        if (value != null) {
            value.rating.add(this);
        }
    }

    public de.hhn.se.labswp.buga23spuga.Course getContent() {
        return content;
    }

    /**
     * This method is for internal use only.
     */
    /*
    public void setORM_Content(de.hhn.se.labswp.buga23spuga.Course value) {
        this.content = value;
    }

    private de.hhn.se.labswp.buga23spuga.Course getORM_Content() {
        return content;
    }
    */
    public String toString() {
        return String.valueOf(getID());
    }

}
