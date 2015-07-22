package intership.dev.contact.Adapter;

/**
 * Created by thanhitbk on 21/07/2015.
 */

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import intership.dev.contact.Fragment.EditContactFragment;
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHolder mViewHolder;

        if (convertView == null) {
            LayoutInflater inflate = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflate.inflate(R.layout.item_list_contact, null);
            mViewHolder = new ViewHolder();

            mViewHolder.mAvarta = (ImageView) convertView.findViewById(R.id.imgAvarta);
            mViewHolder.mNameContact = (TextView) convertView.findViewById(R.id.tvNameContact);
            mViewHolder.mImageDelete = (ImageView) convertView.findViewById(R.id.imgDelete);
            mViewHolder.mImageEdit = (ImageView) convertView.findViewById(R.id.imgEdit);

            convertView.setTag(mViewHolder);
        } else {

            mViewHolder = (ViewHolder) convertView.getTag();
        }
        final Contact mContact = mLists.get(position);
        mViewHolder.mNameContact.setText(mContact.getNameUser());
        mViewHolder.mAvarta.setImageResource(mContact.getAvatar());

        //Click Imagge Delete on item listview
        mViewHolder.mImageDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(mContext, R.style.styleDialog);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setContentView(R.layout.dialog_delete_contact);

                TextView mOkDialog = (TextView) dialog.findViewById(R.id.tvOkDialog);
                TextView mCancelDialog = (TextView) dialog.findViewById(R.id.tvCancelDialog);
                TextView mMessage = (TextView) dialog.findViewById(R.id.tvMessageDialog);
                String mName = mViewHolder.mNameContact.getText().toString();
                mMessage.setText(Html.fromHtml("Are you sure you want to delete " + "<b>" + mName + "</b>" + " ?"));
                dialog.show();

                //Click Cancel on dialog delete
                mCancelDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                //Click Ok on dialog delete
                mOkDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mLists.remove(position);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
            }
        });

        //Click Image Edit on item listview
        mViewHolder.mImageEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                FragmentManager mFragmentManager = ((Activity) mContext).getFragmentManager();
                FragmentTransaction FragmentTransaction = mFragmentManager.beginTransaction();
                EditContactFragment mEditContactFragment = new EditContactFragment();
                FragmentTransaction.replace(R.id.rlcontacts, mEditContactFragment);
                FragmentTransaction.addToBackStack(null);
                FragmentTransaction.commit();
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView mNameContact;
        ImageView mAvarta;
        ImageView mImageDelete;
        ImageView mImageEdit;
    }
}

