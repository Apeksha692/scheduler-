package com.example.chidambar.projectfinal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Chidambar on 28-10-2015.
 */
class Contact  implements Parcelable {


    protected Contact(Parcel in) {
        name = in.readString();
        number = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public Contact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String name;
    private String number;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(number);
    }


}

/**
 * Created by Chidambar on 30-10-2015.
 */
public class Conact {
}
