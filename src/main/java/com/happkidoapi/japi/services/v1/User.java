package com.happkidoapi.japi.services.v1;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "user")

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
