package com.book.dan.beatbox;

import com.book.dan.beatbox.model.BeatBox;
import com.book.dan.beatbox.model.Sound;
import com.book.dan.beatbox.view.SoundViewModel;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SoundViewModelTest {
    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;
    @Before
    public void setUp() throws Exception {
        mBeatBox = mock(BeatBox.class);
        mSound = new Sound("assetPath");
        mSubject =new SoundViewModel(mBeatBox);
        mSubject.setSound(mSound);
    }

    @Test
    public void expressSoundNameAsTitle(){
        assertThat(mSubject.getTitle(),is(mSound.getName()));
    }

    @Test
    public void callsBeatBoxPlayOnButtonClicked(){
        mSubject.onButtonClicked();
        verify(mBeatBox).play(mSound);
    }

}