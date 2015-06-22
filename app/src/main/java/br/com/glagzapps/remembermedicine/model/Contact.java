package br.com.glagzapps.remembermedicine.model;

import java.io.Serializable;

/**
 * Created by Glailton Costa on 15/06/2015.
 * <p/>
 * For Remember Medicine
 */
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
