
package com.example.pokemonapp.features.details.data.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class GameIndex {

    @SerializedName("game_index")
    private Long mGameIndex;
    @SerializedName("version")
    private Version mVersion;

    public Long getGameIndex() {
        return mGameIndex;
    }

    public void setGameIndex(Long gameIndex) {
        mGameIndex = gameIndex;
    }

    public Version getVersion() {
        return mVersion;
    }

    public void setVersion(Version version) {
        mVersion = version;
    }

}
