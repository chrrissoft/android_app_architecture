package com.chrrissoft.marvel.framework.characters.models.info

import com.chrrissoft.marvel.data.characters.models.CharacterInfo
import com.chrrissoft.marvel.framework.characters.models.Thumbnail
import com.google.gson.annotations.SerializedName

data class CharacterInfo(
    @SerializedName("id"           ) override val id:           Int = 0,
    @SerializedName("name"         ) override val name:         String = "",
    @SerializedName("description"  ) override val description:  String = "",
    @SerializedName("thumbnail"    ) override val thumbnail:    Thumbnail = Thumbnail(),
    @SerializedName("comics"       ) override val comics:       Comics = Comics(),
    @SerializedName("series"       ) override val series:       Series = Series(),
    @SerializedName("stories"      ) override val stories:      Stories = Stories(),
    @SerializedName("events"       ) override val events:       Events = Events(),
) : CharacterInfo
