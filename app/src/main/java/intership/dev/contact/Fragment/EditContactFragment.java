package intership.dev.contact.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import intership.dev.contact.Model.Contact;
import intership.dev.contact.R;
import intership.dev.contact.Utility.CircleImageView;

/**
 * Created by hodachop93 on 22/07/2015.
 */
public class EditContactFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edit_contact, container, false);


        Contact mContact = (Contact) getArguments().getSerializable("contact");
        TextView mNameContact = (TextView) rootView.findViewById(R.id.tvName);
        CircleImageView mCircleImageView=(CircleImageView) rootView.findViewById(R.id.imgAvatarEdit);
        mCircleImageView.setImageResource(mContact.getAvatar());
        mNameContact.setText(mContact.getNameUser());


        return rootView;
    }
}
