package com.swapnil.hiltdummyapp.model.repository;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.swapnil.hiltdummyapp.model.interfaces.RepositoryCallback;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;

import static org.junit.Assert.*;

public class ArtistRepositoryTest {

    @InjectMocks
    ArtistRepository repository;

    @Rule
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        Scheduler immediate = new Scheduler() {
            @NonNull
            @Override
            public Scheduler.Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(Runnable::run, true);
            }
        };
        RxJavaPlugins.setInitNewThreadSchedulerHandler(schedulerCallable -> immediate);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> immediate);
    }

    @After
    public void tearDown() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    public void getArtistData() {
        RepositoryCallback callback = repository.callback;
        Assert.assertNotNull(callback);
    }

    @Test
    public void onErrorReceived() {
    }

    @Test
    public void onResReceived() {
    }
}