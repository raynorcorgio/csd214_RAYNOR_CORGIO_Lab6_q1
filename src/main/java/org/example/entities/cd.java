package org.example.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class cd {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "CD_NAME")
    private String cdName;
    @Basic
    @Column(name = "BAND_NAME")
    private String bandName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCdName() {
        return cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cd cd = (cd) o;
        return id == cd.id && Objects.equals(cdName, cd.cdName) && Objects.equals(bandName, cd.bandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cdName, bandName);
    }
}
