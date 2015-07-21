package intership.dev.contact;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import intership.dev.contact.Adapter.ContactAdapter;
import intership.dev.contact.Model.Contact;


public class MainActivity extends Activity {
    ArrayList<Contact> mArrayListContacts = new ArrayList<Contact>();
    ListView mListViewContact;
    String[] name = new String[]{
            "Hugh Helbert", "Steven Seo", "Dwight Pera", "Francis Cipriano",
            "Walter Chavis", "Wilbert Rowen", "Andrea Gruber", "Dario Bennington",
            "Hugh Helbert", "Steven Seo", "Dwight Pera", "Francis Cipriano",
            "Walter Chavis", "Wilbert Rowen", "Andrea Gruber", "Dario Bennington",
            "Hugh Helbert", "Steven Seo", "Dwight Pera", "Francis Cipriano"
    };

    int[] avarta = new int[]{
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4,
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4,
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4,
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4,
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4
    };

    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();

        final int pos = info.position;
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataContact();
        mListViewContact = (ListView) findViewById(R.id.lvContact);
        final ContactAdapter adapter = new ContactAdapter(this, R.layout.item_list_contact, mArrayListContacts);
        mListViewContact.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getDataContact() {
        for (int i = 0; i < 20; i++) {
            Contact mcontact = new Contact();
            mcontact.setNameUser(name[i]);
            mcontact.setAvatar(avarta[i]);
            mArrayListContacts.add(mcontact);
        }

    }
}