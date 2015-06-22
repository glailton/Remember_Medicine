package br.com.glagzapps.remembermedicine.model;

import android.content.ContentResolver;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Glailton Costa on 15/06/2015.
 * <p/>
 * For Remember Medicine
 */
public class MessageSent implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String msg;
    private Contact contact = new Contact();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
