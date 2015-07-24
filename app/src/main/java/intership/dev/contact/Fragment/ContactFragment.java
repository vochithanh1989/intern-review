package intership.dev.contact.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import intership.dev.contact.Adapter.ContactAdapter;
import intership.dev.contact.Model.Contact;
import intership.dev.contact.R;
import intership.dev.contact.Utility.LoadMoreListView;

/**
 * Created by thanhitbk on 24/07/2015.
 */
public class ContactFragment extends Fragment {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_contact, container, false);

        getDataContact();
        mListViewContact = (LoadMoreListView) rootView.findViewById(R.id.lvContact);
        mContactAdapter = new ContactAdapter(getActivity(), R.layout.item_list_contact, mArrayListContacts);
        mListViewContact.setAdapter(mContactAdapter);

        //mLoadMoreListView.setAdapter(adapter);
        mListViewContact.setOnLoadMoreListener(new LoadMoreListView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new LoadDataTask().execute();
            }
        });
        return rootView;
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
