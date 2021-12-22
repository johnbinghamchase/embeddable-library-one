package com.khomotsozwane.embedapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Change implements Serializable {

    @SerializedName("subject")
    String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
