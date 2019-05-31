
package com.example.pokemonapp.features.details.data.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Type {

    @SerializedName("name")
    private String mName;
    @SerializedName("slot")
    private Long mSlot;
    @SerializedName("type")
    private Type mType;
    @SerializedName("url")
    private String mUrl;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getSlot() {
        return mSlot;
    }

    public void setSlot(Long slot) {
        mSlot = slot;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
