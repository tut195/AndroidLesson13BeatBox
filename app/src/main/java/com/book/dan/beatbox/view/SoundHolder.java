package com.book.dan.beatbox.view;

import android.support.v7.widget.RecyclerView;

import com.book.dan.beatbox.databinding.ListItemSoundBinding;
import com.book.dan.beatbox.model.BeatBox;
import com.book.dan.beatbox.model.Sound;

public class SoundHolder extends RecyclerView.ViewHolder{
    private ListItemSoundBinding mBinding;

    public SoundHolder(ListItemSoundBinding binding, BeatBox mBeatBox) {
        super(binding.getRoot());
        mBinding = binding;
        mBinding.setViewModel(new SoundViewModel(mBeatBox));
    }

    public void bind(Sound sound){
        mBinding.getViewModel().setSound(sound);
        mBinding.executePendingBindings();
    }
}
