package br.com.glagzapps.remembermedicine.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.glagzapps.remembermedicine.R;
import br.com.glagzapps.remembermedicine.model.MessageSent;


public class MainActivity extends Activity {

    //Constants
    private final int ID_RETORNO_SELECIONA_CONTATO = 1234;
    private final int ID_RETORNO_SELECIONA_NUMERO = 5678;

    private MessageSent msg;

    private TextView showContactName;
    private TextView showContactPhone;
    private Button buttonSelContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = new MessageSent();

        //TextViews of current activity
        showContactName = (TextView) findViewById(R.id.show_contact_name);
        showContactName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, ID_RETORNO_SELECIONA_CONTATO);
            }
        });

        showContactPhone = (TextView) findViewById(R.id.show_contact_phone);
        showContactPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, ID_RETORNO_SELECIONA_NUMERO);
            }
        });

        //Buttons of current activity
        buttonSelContact = (Button) findViewById(R.id.sel_contact_name);
        buttonSelContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, ID_RETORNO_SELECIONA_CONTATO);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case ID_RETORNO_SELECIONA_CONTATO:
                if (resultCode == Activity.RESULT_OK){
                    Uri contactData = data.getData();
                    ContentResolver contentResolver = getContentResolver();
                    Cursor cursor = contentResolver.query(contactData, null, null, null, null);
                    if (cursor.moveToFirst()){
                        msg.getContact().setId(cursor.getInt(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID)));
                        msg.getContact().setName(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                //        msg.getContact().setPhone(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                        buttonSelContact.setVisibility(View.GONE);

                        showContactName.setText(msg.getContact().getName());
                        showContactName.setVisibility(View.VISIBLE);
                    //    showContactPhone.setText(msg.getContact().getPhone());
                    //    showContactPhone.setVisibility(View.VISIBLE);
                    }
                    cursor.close();
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
