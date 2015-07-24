package intership.dev.contact.Utility;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import intership.dev.contact.R;

/**
 * Created by hoai on 23/07/2015.
 */
public class DeleteDialog extends Dialog implements View.OnClickListener {
    private TextView mMessage;
    private TextView mBtnOK;
    private TextView mBtnCancel;
    private int mPosition;
    private OnClickContactDialog mListener;


    public DeleteDialog(Context context) {
        super(context, R.style.CustomThemeDialog);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_delete_contact);
        mMessage = (TextView) findViewById(R.id.tvMessageDialog);
        mBtnOK = (TextView) findViewById(R.id.tvOkDialog);
        mBtnCancel = (TextView) findViewById(R.id.tvCancelDialog);
        mBtnOK.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);


    }

    /**
     * set message for dialog with Model name is bold
     * @param contact
     */
    public void setDialogMessage(intership.dev.contact.Model.Contact contact) {
        mMessage.setText(Html.fromHtml("Are you sure you want to delete " + "<b>" +
                contact.getName() + "</b>" + "?"));
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int mPosition) {
        this.mPosition = mPosition;
    }


    public void setOnClickListViewContactListener(OnClickContactDialog listener) {
        mListener = listener;
    }


    @Override
    public void onClick(View v) {
        if (mListener == null) {
            return;
        }
        int id = v.getId();
        if (id == mBtnOK.getId()) {
            mListener.onClickBtnOK(v);
        }
        if (id == mBtnCancel.getId()) {
            mListener.onClickBtnCancel(v);
        }


    }

    public interface OnClickContactDialog {
        /**
         * Called when a button OK has been clicked.
         *
         * @param v The view that was clicked.
         */
        void onClickBtnOK(View v);

        /**
         * Called when the button Cancel has been clicked.
         *
         * @param v The view that was clicked.
         */
        void onClickBtnCancel(View v);
    }
}
