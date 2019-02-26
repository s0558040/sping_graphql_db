package de.htw.ai.graphql_db.pojo;

public class Author {
    private int author_id;
    private String forename;
    private String lastname;

    public  Author(){}

    public Author(int author_id, String forname, String lastname) {
        this.author_id = author_id;
        this.forename = forname;
        this.lastname = lastname;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", forname='" + forename + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
