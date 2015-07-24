package intership.dev.contact.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import intership.dev.contact.Model.Contact;
import intership.dev.contact.R;

/**
 * Created by thanhitbk on 22/07/2015.
 * display all information of listview item
 */
public class EditContactFragment extends Fragment implements View.OnClickListener {
    private ImageView imgAvatar,imgBack;
    private TextView tvName;
    private EditText edtDescription, edtName;
    private TextView btnSave, btnCancel;
    private OnChangeItemListener mListenerOnChange;

    //using for method onClick
    private intership.dev.contact.Model.Contact mModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mEditView = inflater.inflate(R.layout.fragment_edit_contact, container, false);
        init(mEditView);
        return mEditView;
    }

    private void init(View v) {
        imgAvatar = (ImageView) v.findViewById(R.id.imgAvatarEdit);
        tvName = (TextView) v.findViewById(R.id.tvName);
        edtDescription = (EditText) v.findViewById(R.id.edtDescriptionEdit);
        btnSave = (TextView) v.findViewById(R.id.tvSaveEdit);
        btnCancel = (TextView) v.findViewById(R.id.tvCancelEdit);
        edtName = (EditText) v.findViewById(R.id.edtNameEdit);
        imgBack= (ImageView)v.findViewById(R.id.imgBack);

        // give data from ListContactFragment
        Bundle dataBundle = this.getArguments();
        mModel = (Contact) dataBundle.getSerializable("dataBundle");
        tvName.setText(mModel.getName());
        imgAvatar.setImageResource(mModel.getAvatar());
        edtDescription.setText(mModel.getDescription());
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        imgBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tvSaveEdit:
                mModel.setName(edtName.getText().toString());
                mModel.setDescription(edtDescription.getText().toString());
                mListenerOnChange.onChange(mModel);
                getActivity().onBackPressed();
                break;
            case R.id.tvCancelEdit:
                getActivity().onBackPressed();
            case R.id.imgBack:
                getActivity().onBackPressed();
        }
    }

    /**
     * Register a callback to be invoked when a changed user was given from
     * EditContactFragment to ListContactFragment
     *
     * @param listener The callback will run
     */
    public void setOnChangeItemListener(OnChangeItemListener listener) {
        mListenerOnChange = listener;
    }

    public interface OnChangeItemListener {
        void onChange(Contact contactModelmodel);
    }
}
