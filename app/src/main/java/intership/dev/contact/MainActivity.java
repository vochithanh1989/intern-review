package intership.dev.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import intership.dev.contact.Adapter.ContactAdapter;
import intership.dev.contact.Model.Contact;
import intership.dev.contact.Utility.LoadMoreListView;


public class MainActivity extends Activity {
    private ArrayList<Contact> mArrayListContacts = new ArrayList<Contact>();
    private LoadMoreListView mListViewContact;
    private ContactAdapter mContactAdapter;
    private String[] mNames = new String[]{
            "Hugh Helbert", "Steven Seo", "Dwight Pera", "Francis Cipriano",
            "Walter Chavis", "Wilbert Rowen", "Andrea Gruber", "Dario Bennington",
            "Hugh Helbert", "Steven Seo", "Dwight Pera", "Francis Cipriano",
            "Walter Chavis", "Wilbert Rowen", "Andrea Gruber", "Dario Bennington",
            "Hugh Helbert", "Steven Seo", "Dwight Pera", "Francis Cipriano"
    };

    private int[] mAvatars = new int[]{
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4,
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4,
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4,
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4,
            R.drawable.img_avarta1, R.drawable.img_avarta2, R.drawable.img_avarta3, R.drawable.img_avarta4
    };

    private String[] mDescriptions = new String[]{
            "Beckham", "Rooney", "Ronaldo", "Messi", "Robben", "Cassilas", "Suarez", "Zidane", "Figo", "Carlos",
            "Beckham", "Rooney", "Ronaldo", "Messi", "Robben", "Cassilas", "Suarez", "Zidane", "Figo", "Carlos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataContact();
        mListViewContact = (LoadMoreListView) findViewById(R.id.lvContact);
        mContactAdapter = new ContactAdapter(this, R.layout.item_list_contact, mArrayListContacts);
        mListViewContact.setAdapter(mContactAdapter);

        //mLoadMoreListView.setAdapter(adapter);
        mListViewContact.setOnLoadMoreListener(new LoadMoreListView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new LoadDataTask().execute();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Contact mContact = (Contact) data.getSerializableExtra("contact");
            int mPosition = data.getIntExtra("position", -1);
            mArrayListContacts.set(mPosition, mContact);
            mContactAdapter.notifyDataSetChanged();
        }
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
        for (int i = 0; i < mNames.length; i++) {
            Contact mContact = new Contact(mNames[i], mDescriptions[i], mAvatars[i]);
            mArrayListContacts.add(mContact);
        }

    }


    /**
     * Asyntact load more list
     */
    private class LoadDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            if (isCancelled()) {
                return null;
            }
            // Simulates a background task
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getDataContact();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            // We need notify the adapter that the data have been changed
            mContactAdapter.notifyDataSetChanged();

            // Call onLoadMoreComplete when the LoadMore task, has finished
            mListViewContact.onLoadMoreComplete();

            super.onPostExecute(result);
        }

        @Override
        protected void onCancelled() {
            // Notify the loading more operation has finished
            mListViewContact.onLoadMoreComplete();
        }
    }

}