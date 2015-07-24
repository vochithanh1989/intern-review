package intership.dev.contact.Adapter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import intership.dev.contact.Fragment.EditContactFragment;
import intership.dev.contact.Model.Contact;
import intership.dev.contact.R;
import intership.dev.contact.Utility.DeleteDialog;

/**
 * Create Adapter for Listview Contacts
 */
public class ContactAdapter extends BaseAdapter implements DeleteDialog.OnClickContactDialog,
        DialogInterface.OnDismissListener, EditContactFragment.OnChangeItemListener {
    private FragmentActivity mFragmentActivity;
    private ArrayList<Contact> mContacts = new ArrayList<>();
    private DeleteDialog mDeleteDialog;

    // param use for method callEditContactFragment
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private EditContactFragment mEditContactFragment;

    /**
     * Constructor
     *
     * @param mFragmentActivity
     * @param mContacts
     */
    public ContactAdapter(FragmentActivity mFragmentActivity, ArrayList<Contact> mContacts) {
        this.mFragmentActivity = mFragmentActivity;
        this.mContacts = mContacts;
        mDeleteDialog = new DeleteDialog(mFragmentActivity);
        mDeleteDialog.setOnClickListViewContactListener(this);
        mDeleteDialog.setOnDismissListener(this);

    }

    @Override
    public void onClickBtnOK(View v) {
        mContacts.remove(mDeleteDialog.getPosition());
        notifyDataSetChanged();
        mDeleteDialog.dismiss();
    }

    @Override
    public void onClickBtnCancel(View v) {
        mDeleteDialog.dismiss();
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {

    }

    @Override
    public void onChange(Contact contactModelmodel) {
        notifyDataSetChanged();
    }


    /**
     * create ViewHolder class to control convert view
     */
    private static class ViewHolder {
        ImageView imgAvatar, imgDelete, imgEdit;
        TextView tvName;
        TextView tvDesc;
    }


    /**
     * @param position    position of ArrayList<ContactModel> mContacts
     * @param convertView View of item in ListView
     * @param viewGroup   View Parent of convertView
     * @return convertView
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mFragmentActivity).inflate(R.layout.item_list_contact, viewGroup, false);
            holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.tvNameContact);
            holder.imgAvatar = (ImageView) convertView.findViewById(R.id.imgAvarta);
            holder.imgEdit = (ImageView) convertView.findViewById(R.id.imgEdit);
            holder.imgDelete = (ImageView) convertView.findViewById(R.id.imgDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        setValue(holder, position);
        setEvent(holder, position);

        return convertView;
    }


    /**
     * method intent to EditContactFragment
     *
     * @param contactModel is a object to refactor
     */
    private void callEditContactFragment(Contact contactModel) {
        mFragmentManager = mFragmentActivity.getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if (mEditContactFragment == null) {
            mEditContactFragment = new EditContactFragment();
            mEditContactFragment.setOnChangeItemListener(this);
        }
        Bundle dataBundle = new Bundle();
        dataBundle.putSerializable("sendData", contactModel);

        mEditContactFragment.setArguments(dataBundle);
        mFragmentTransaction.replace(R.id.rlContainer, mEditContactFragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    /**
     * @return count of arrayList
     */
    @Override
    public int getCount() {
        return mContacts.size();
    }

    /**
     * @param position
     * @return Object possition
     */
    @Override
    public Object getItem(int position) {
        return mContacts.get(position);
    }

    /**
     * Don't use
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * set value for view holder
     *
     * @param holder   is current convert view
     * @param position is a current possition Listview
     */
    private void setValue(ViewHolder holder, int position) {
        Contact model = (Contact) getItem(position);
        holder.tvName.setText(model.getName());
        holder.imgAvatar.setImageResource(model.getAvatar());
    }

    private void setEvent(final ViewHolder holder, final int position) {
        final Contact model = (Contact) getItem(position);
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDeleteDialog.setPosition(position);
                mDeleteDialog.show();
                mDeleteDialog.setDialogMessage(model);
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callEditContactFragment(model);
            }
        });
    }


}
