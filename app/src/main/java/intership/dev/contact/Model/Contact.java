package intership.dev.contact.Model;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by thanhitbk on 21/07/2015.
 */
public class Contact implements Serializable {
    private int mAvatar;
    private String mNameUser;
    private String mDescription;
    //Determine btnDelete is selected or not
    private boolean isDelete;

    public Contact(String mNameUser, String mDescription, int mAvatar) {
        this.mNameUser = mNameUser;
        this.mDescription = mDescription;
        this.mAvatar = mAvatar;
        isDelete=false;
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
    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean isDelete() {
        return isDelete;
    }
}
