package intership.dev.contact.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import intership.dev.contact.MainActivity;
import intership.dev.contact.Model.Contact;
import intership.dev.contact.R;
import intership.dev.contact.Utility.CircleImageView;

/**
 * Created by thanhitbk on 22/07/2015.
 */
public class EditContactFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_edit_contact, container, false);

        //Receive data from activity
        final Contact mContact = (Contact) getArguments().getSerializable("contact");
        final int mposition = getArguments().getInt("mposition");

        TextView mNameContact = (TextView) rootView.findViewById(R.id.tvName);
        CircleImageView mCircleImageView = (CircleImageView) rootView.findViewById(R.id.imgAvatarEdit);
        final EditText mEditName = (EditText) rootView.findViewById(R.id.edtNameEdit);
        final EditText mEditDescription = (EditText) rootView.findViewById(R.id.edtDescriptionEdit);

        //Set data fragment
        mEditName.setText(mContact.getNameUser());
        mEditDescription.setText(mContact.getmDescription());
        mCircleImageView.setImageResource(mContact.getAvatar());
        mNameContact.setText(mContact.getNameUser());

        TextView mSave = (TextView) rootView.findViewById(R.id.tvSaveEdit);
        TextView mCancel = (TextView) rootView.findViewById(R.id.tvCancelEdit);

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                mContact.setNameUser(mEditName.getText().toString());
                mContact.setmDescription(mEditDescription.getText().toString());
                intent.putExtra("position", mposition);
                intent.putExtra("contact", mContact);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().onBackPressed();
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditName.setText(mContact.getNameUser());
                mEditDescription.setText(mContact.getmDescription());
            }
        });
        ImageView mBack = (ImageView) rootView.findViewById(R.id.imgBack);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {

        super.onResume();
    }
}
