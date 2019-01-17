package com.example.gav.randomusergenerator.users;

import com.example.gav.randomusergenerator.api.model.ResultsItem;
import com.example.gav.randomusergenerator.repository.IUsersRepository;

import androidx.annotation.NonNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UsersPresenter implements UsersContract.Presenter {

    private final IUsersRepository usersRepository;
    private final UsersContract.View usersView;
    private CompositeDisposable compositeDisposable;

    public UsersPresenter(IUsersRepository usersRepository, UsersContract.View usersView) {
        this.usersRepository = usersRepository;
        this.usersView = usersView;
    }

    @Override
    public void onCreate() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void loadUsers(int count) {
        compositeDisposable.add(
                usersRepository.getUsers(count)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(randomUserResponse -> usersView.showUsers(randomUserResponse.getResults()))
        );

    }

    @Override
    public void openUserDetails(@NonNull ResultsItem requestedTask) {

    }

    @Override
    public void onDestroy() {
        compositeDisposable.clear();
    }
}
