package intership.dev.contact.Model;

import android.widget.ImageView;

/**
 * Created by thanhitbk on 21/07/2015.
 */
public class Contact {
    private int mAvatar;
    private String mNameUser;
    private String mDescription;

    public Contact(String mNameUser, String mDescription, int mAvatar) {
        this.mNameUser = mNameUser;
        this.mDescription = mDescription;
        this.mAvatar = mAvatar;
    }
    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    private ImageView mImageEdit;
    private ImageView mImageDelete;

    public ImageView getmImageEdit() {
        return mImageEdit;
    }

    public void setmImageEdit(ImageView mImageEdit) {
        this.mImageEdit = mImageEdit;
    }

    public ImageView getmImageDelete() {
        return mImageDelete;
    }

    public void setmImageDelete(ImageView mImageDelete) {
        this.mImageDelete = mImageDelete;
    }

    public String getNameUser() {
        return mNameUser;
    }

    public void setNameUser(String mNameUser) {
        this.mNameUser = mNameUser;
    }

    public int getAvatar() {
        return mAvatar;
    }

    public void setAvatar(int mAvatar) {
        this.mAvatar = mAvatar;
    }
}
