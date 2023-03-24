package de.hhn.se.labswp.buga23spuga;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Course")
public class Course implements Serializable {
    public Course() {
    }

    public boolean equals(Object aObj) {
        if (aObj == this)
            return true;
        if (!(aObj instanceof Course))
            return false;
        Course course = (Course)aObj;
        if ((getName() != null && !getName().equals(course.getName())) || (getName() == null && course.getName() != null))
            return false;
        return true;
    }

    public int hashCode() {
        int hashcode = 0;
        hashcode = hashcode + (getName() == null ? 0 : getName().hashCode());
        return hashcode;
    }

    //ORM ZEUG
    /*
    private java.util.Set this_getSet (int key) {
        if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSE_REPRESENTATION) {
            return ORM_representation;
        }
        else if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSE_CATEGORY) {
            return ORM_category;
        }
        else if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSE_RATING) {
            return ORM_rating;
        }

        return null;
    }

    private void this_setOwner(Object owner, int key) {
        if (key == de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSE_ORGANIZER) {
            this.organizer = (de.hhn.se.pmt.gruppea.model.CourseOrganizer) owner;
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
    @Column(name="Name", nullable=false, length=255)
    @Id
    private String name;

    @ManyToOne(targetEntity= Courseorganizer.class, fetch=FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value={ @JoinColumn(name="courseorganizercourseorganizerid", referencedColumnName="courseorganizerid", nullable=false) }, foreignKey=@ForeignKey(name="manages"))
    private Courseorganizer organizer;

    @OneToMany(mappedBy="content", targetEntity=de.hhn.se.labswp.buga23spuga.Offer.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    protected java.util.Set representation = new java.util.HashSet();

    @ManyToMany(targetEntity=de.hhn.se.labswp.buga23spuga.Category.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @JoinTable(name="Category_Course", joinColumns={ @JoinColumn(name="coursename") }, inverseJoinColumns={ @JoinColumn(name="categoryname") })
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    protected java.util.Set category = new java.util.HashSet();

    @OneToMany(mappedBy="content", targetEntity=de.hhn.se.labswp.buga23spuga.Review.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    protected java.util.Set rating = new java.util.HashSet();


    //GETTER UND SETTER
    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return name;
    }

    /*
        public String getORMID() {
            return getName();
        }
    */

    private void setRepresentation(java.util.Set value) {
        this.representation = value;
    }
    @JsonManagedReference
    private java.util.Set getRepresentation() {
        return representation;
    }

    /*
    @Transient
    public final de.hhn.se.pmt.gruppea.model.OfferSetCollection representation = new de.hhn.se.pmt.gruppea.model.OfferSetCollection(this, _ormAdapter, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSE_REPRESENTATION, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_OFFER_CONTENT, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_MUL_ONE_TO_MANY);

    private void setORM_Category(java.util.Set value) {
        this.ORM_category = value;
    }

    private java.util.Set getORM_Category() {
        return ORM_category;
    }

    @Transient
    public final de.hhn.se.pmt.gruppea.model.CategorySetCollection category = new de.hhn.se.pmt.gruppea.model.CategorySetCollection(this, _ormAdapter, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSE_CATEGORY, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_CATEGORY_CONTENT, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_MUL_MANY_TO_MANY);


    private void setORM_Rating(java.util.Set value) {
        this.rating = value;
    }

    private java.util.Set getORM_Rating() {
        return rating;
    }


    @Transient
    public final de.hhn.se.pmt.gruppea.model.ReviewSetCollection rating = new de.hhn.se.pmt.gruppea.model.ReviewSetCollection(this, _ormAdapter, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_COURSE_RATING, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_REVIEW_CONTENT, de.hhn.se.pmt.gruppea.model.ORMConstants.KEY_MUL_ONE_TO_MANY);
    */

    public void setCategory(Category value) {
        if (value != null) {
            value.content.add(this);
            this.category.add(value);
        }
    }
    public void setOrganizer(Courseorganizer value) {
        if (organizer != null) {
            organizer.course.remove(this);
        }
        if (value != null) {
            value.course.add(this);
            this.organizer = value;
        }
    }
    @JsonManagedReference
    public Courseorganizer getOrganizer() {
        return organizer;
    }

    /**
     * This method is for internal use only.
     */
    /*
    public void setORM_Organizer(de.hhn.se.pmt.gruppea.model.CourseOrganizer value) {
        this.organizer = value;
    }

    private de.hhn.se.pmt.gruppea.model.CourseOrganizer getORM_Organizer() {
        return organizer;
    }
    */
    public void reviewCourse() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }

    public void createCourse() {
        //TODO: Implement Method
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return String.valueOf(getName());
    }

}