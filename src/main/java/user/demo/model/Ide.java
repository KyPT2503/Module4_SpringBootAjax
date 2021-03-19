package user.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Ide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Date date;
    @ManyToOne
    private Version version;

    public Ide() {
    }

    public Ide(String code, Date date, Version version) {
        this.code = code;
        this.date = date;
        this.version = version;
    }

    public Ide(Long id, String code, Date date, Version version) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
