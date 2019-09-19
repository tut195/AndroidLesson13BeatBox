package com.book.dan.beatbox.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUND_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;

    private AssetManager mAssetManager;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;
    private float mSpeed;

    public BeatBox(Context context){
        mAssetManager = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);
        mSpeed = 1.0f;
        loadSamples();
    }

    private void loadSamples(){
        String[] soundNames;
        try {
            soundNames = mAssetManager.list(SOUND_FOLDER);
            Log.i(TAG,"Found "+soundNames.length+" sounds");
        } catch (IOException e) {
            Log.e(TAG,"Could not list assets", e);
            return;
        }
        for(String filename:soundNames){
            try {
                String path = SOUND_FOLDER+"/"+filename;
                Sound sound = new Sound(path);
                load(sound);
                mSounds.add(sound);
            } catch (IOException e) {
                Log.e(TAG, "Could not load sound " + filename, e);
            }
        }
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAssetManager.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd,1);
        sound.setSoundId(soundId);
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if(soundId == null){
            return;
        }
        mSoundPool.play(soundId,1.0f,1.0f,1,0,mSpeed);
    }

    public void release(){
        mSoundPool.release();
    }

    public void setSoundPoolSpeed(float speed){
        mSpeed = speed;
    }
}
