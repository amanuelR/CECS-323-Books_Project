package csulb.cecs323.model;

import javax.persistence.*;

@Entity
@NamedNativeQuery(
        name="ReturnBookISBN",
        query = "SELECT * " +
                "FROM   BOOKS " +
                "WHERE  ISBN = ? ",
        resultClass = Books.class
)
@NamedNativeQuery(
        name="ReturnBookTitle",
        query = "SELECT * " +
                "FROM   BOOKS " +
                "WHERE  TITLE = ? ",
        resultClass = Books.class
)
@NamedNativeQuery(
        name="ReturnBookTitleForUpdate",
        query = "SELECT * " +
                "FROM   BOOKS " +
                "WHERE  TITLE = ? ",
        resultClass = Books.class
)
public class Books {
    @Id
    @Column(nullable = false, length = 17)
    private String ISBN;

    @Column(nullable = false, unique = true, length = 80)
    private String title;

    @Column(nullable = false)
    private Integer year_published;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHORING_ENTITY_NAME", referencedColumnName ="EMAIL", nullable = false)
    private authoring_entities authoring_entities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PUBLISHER_NAME", referencedColumnName ="NAME", nullable = false)
    private Publishers publishers;


    /** Getter and Setter methods for the attributes **/
    /*We don't need a setter method for ISBN since it's a primary key */
    /* public void setISBN(String ISBN) {this.ISBN = ISBN;} */

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear_published(Integer year_published) {
        this.year_published = year_published;
    }

    public void setPublishers(Publishers publishers) {
        this.publishers = publishers;
    }

    public void setAuthoring_entities(authoring_entities authoring_entities) {
        this.authoring_entities = authoring_entities;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear_published() {
        return year_published;
    }

    public Publishers getPublishers() {
        return publishers;
    }

    public authoring_entities getAuthoring_entities() {
        return authoring_entities;
    }

    /** a Books default Constructor **/
    public Books(){}

    /** a Books constructor that takes five parameters (attributes) **/
    public Books(String ISBN, String title, Integer year_published,authoring_entities authoring_entities , Publishers publishers) {
        this.ISBN = ISBN;
        this.title = title;
        this.year_published = year_published;
        this.authoring_entities = authoring_entities;
        this.publishers = publishers;
    }//End of constructor

    @Override
    public String toString() {
        return "\n" +
                "ISBN: " + ISBN + '\n' +
                "Title: " + title + '\n' +
                "Year Published: " + year_published +"\n" +
                "Authoring Entity Name: " + authoring_entities.getEmail() +"\n" +
                "Publisher Name: " + publishers.getName() + "\n";
    }
}
