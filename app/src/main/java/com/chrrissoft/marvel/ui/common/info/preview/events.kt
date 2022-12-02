package com.chrrissoft.marvel.ui.common.info.preview

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.chrrissoft.marvel.R.string.route_name__events
import com.chrrissoft.marvel.ui.INFO_STATE
import com.chrrissoft.marvel.ui.events.EventPreview
import com.chrrissoft.marvel.ui.events.res.EventsPrevRes
import com.chrrissoft.marvel.ui.common.info.PrevListTitle
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoError
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoLoading
import com.chrrissoft.marvel.ui.common.info.PrevOnInfoSuccess
import com.chrrissoft.marvel.ui.events.res.EventsPrevResState.*

@Composable
fun EventsPreviewsInInfo(
    res: EventsPrevRes,
    modifier: Modifier = Modifier,
    onLoadMore: () -> Unit,
) {
    Log.d(INFO_STATE, "Events on Info   ->   ${res.state}")
    Column(modifier) {
        PrevListTitle(stringResource(route_name__events))
        LazyRow {
            list(res.state.data)
            when (res.state) {
                is Error -> item { EventsError() }
                is Loading -> item { EventsLoading() }
                is Success -> item { Button(onLoadMore) {} }
            }
        }
    }
}

private fun LazyListScope.list(list: List<EventPreview>) {
    items(list) { EventsPrev(it) }
}

@Composable
private fun EventsPrev(data: EventPreview) {
    PrevOnInfoSuccess(data.title, data.image)
}

@Composable
private fun EventsError(modifier: Modifier = Modifier) {
    PrevOnInfoError(modifier)
}

@Composable
private fun EventsLoading(modifier: Modifier = Modifier) {
    Row(modifier) {
        PrevOnInfoLoading()
        PrevOnInfoLoading()
        PrevOnInfoLoading()
    }
}