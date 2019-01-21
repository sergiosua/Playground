package com.example.sergiosuarez.newarchexample.hero;

import com.example.sergiosuarez.newarchexample.utils.RxResult;
import com.example.sergiosuarez.newarchexample.utils.RxUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ChildHeroFragment extends HeroesFragment {

    @Override
    public void loadPage(final int page) {
        addDisposable(
                getPresenter().startSearch(page)
                        .compose(RxUtils.transformToRxResult())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .startWith(RxResult.loading())
                        .subscribe(
                                result -> {

                                    switch (result.status) {
                                        case SUCCESS:
                                            if (result.data == null) {
                                                return;
                                            }
                                            showLoader(false);
                                            getPresenter().updateContent();
                                            break;
                                        case LOADING:
                                            showLoader(true);
                                            break;
                                        case ERROR:
                                            //TODO cover error
                                            break;
                                    }
                                }
                        )
        );
    }

    @Override
    public void loadFavorites() {
        addDisposable(
                getPresenter().getFavorites()
                        .compose(RxUtils.transformToRxResult())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(result -> {

                                    switch (result.status) {
                                        case SUCCESS:
                                            if (result.data != null && result.data) {
                                                getPresenter().updateContent();
                                            }
                                            break;
                                        case LOADING:
                                            //TODO
                                            break;
                                        case ERROR:
                                            //TODO
                                            break;
                                    }
                                }
                        )
        );
    }

    @Override
    public void markAsFavorite(Hero hero) {
        addDisposable(
                getPresenter().setHeroAsFavorite(hero)
                        .compose(RxUtils.transformToRxResult())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(result -> {
                            switch (result.status){
                                case ERROR:
                                    //TODO
                                    break;
                            }
                                }
                        )
        );
    }

    @Override
    public void unmarkAsFavorite(Hero hero) {
        addDisposable(
                getPresenter().unsetHeroAsFavorite(hero)
                        .compose(RxUtils.transformToRxResult())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe()
        );
    }

}
