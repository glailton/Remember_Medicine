package br.com.glagzapps.remembermedicine.util;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.ContactsContract;

import br.com.glagzapps.remembermedicine.model.Contact;

/**
 * Created by Glailton Costa on 15/06/2015.
 * <p/>
 * For Remember Medicine
 */
public class Contacts {

    public static Contact getContact(int id, Context context){
        ContentResolver cr  = context.getContentResolver();

        Contact contact = null;
        contact.setName(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        contact.setPhone(ContactsContract.CommonDataKinds.Phone.NUMBER);

        return contact;
    }
}
