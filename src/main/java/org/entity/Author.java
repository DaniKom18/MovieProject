package org.entity;

public class Author {
    private String mFirstName;
    private String mLastName;

    public Author(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    @Override
    public String toString() {
        return "mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'';
    }
}
