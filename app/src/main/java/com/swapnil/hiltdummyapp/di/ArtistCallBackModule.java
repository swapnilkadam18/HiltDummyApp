package com.swapnil.hiltdummyapp.di;

import com.swapnil.hiltdummyapp.model.interfaces.RepositoryCallback;
import com.swapnil.hiltdummyapp.viewmodel.ArtistViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;

@InstallIn(ActivityComponent.class)
@Module
abstract class ArtistCallBackModule {

    @Binds
    abstract RepositoryCallback provideRepoCallback(ArtistViewModel viewModel);

}
