package intership.dev.contact.Adapter;

/**
 * Created by thanhitbk on 21/07/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import intership.dev.contact.Model.Contact;
import intership.dev.contact.R;


public class ContactAdapter extends ArrayAdapter<Contact> {
    Context mContext;
    ArrayList<Contact> mLists = new ArrayList<Contact>();

    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        // TODO Auto-generated constructor stub
        this.mContext = context;
        this.mLists = new ArrayList<Contact>(objects);
    }

    @Override
    public int getCount() {
        return mLists.size();
    }

    @Override
    public Contact getItem(int position) {
        return mLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder mViewHolder;
        if (convertView == null) {
            LayoutInflater inflate = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflate.inflate(R.layout.item_list_contact, null);
            mViewHolder = new ViewHolder();
            mViewHolder.mAvarta = (ImageView) convertView.findViewById(R.id.imgAvarta);
            mViewHolder.mNameContact = (TextView) convertView.findViewById(R.id.tvNameContact);
            convertView.setTag(mViewHolder);
        } else {

            mViewHolder = (ViewHolder) convertView.getTag();
        }
        Contact people = mLists.get(position);
        mViewHolder.mNameContact.setText(people.getNameUser());
        mViewHolder.mAvarta.setImageResource(people.getAvatar());
        return convertView;
    }

    static class ViewHolder {
        TextView mNameContact;
        ImageView mAvarta;
    }
}

