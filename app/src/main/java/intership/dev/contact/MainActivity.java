package intership.dev.contact;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataPeople();
        //lay doi tuong listview dua vao id
        mListViewContact = (ListView) findViewById(R.id.lvContact);

        //tao Adapter
        ContactAdapter adapter = new ContactAdapter(this, R.layout.item_list_contact, mArrayListContacts);

        //do data len list
        mListViewContact.setAdapter(adapter);

        mListViewContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String val = name[position];
                Toast.makeText(getApplicationContext(), "" + val, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getDataPeople() {
        for (int i = 0; i < 20; i++) {
            // Create a new object for each list item
            Contact mcontact = new Contact();
            mcontact.setNameUser(name[i]);
            mcontact.setAvatar(avarta[i]);
            // Add this object into the ArrayList myList
            mArrayListContacts.add(mcontact);
        }

    }
}