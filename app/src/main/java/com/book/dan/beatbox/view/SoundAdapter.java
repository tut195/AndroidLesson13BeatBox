package com.book.dan.beatbox.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.book.dan.beatbox.R;
import com.book.dan.beatbox.databinding.ListItemSoundBinding;
import com.book.dan.beatbox.model.BeatBox;
import com.book.dan.beatbox.model.Sound;

import java.util.List;

public class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{
    private List<Sound> mSounds;
    private BeatBox mBeatBox;

    public SoundAdapter(List<Sound> sounds, BeatBox mBeatBox){
        mSounds = sounds;
        this.mBeatBox = mBeatBox;
    }

    @Override
    public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemSoundBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.list_item_sound,parent,false);
        return new SoundHolder(binding, mBeatBox);
    }

    @Override
    public void onBindViewHolder(SoundHolder holder, int position) {
        Sound sound = mSounds.get(position);
        holder.bind(sound);
    }

    @Override
    public int getItemCount() {
        return mSounds.size();
    }
}
