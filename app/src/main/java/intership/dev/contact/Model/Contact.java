package intership.dev.contact.Model;

import java.io.Serializable;

/**
 * Created Constructor
 * Generate method Set and Get for variable
 */
public class Contact implements Serializable {
    private String mName;
    private String mDescription;
    private int mAvatar;

    public Contact() {
    }

    public Contact(String mName, String mDescription, int mAvatar) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mAvatar = mAvatar;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getAvatar() {
        return mAvatar;
    }

    public void setAvatar(int mAvatar) {
        this.mAvatar = mAvatar;
    }
}
