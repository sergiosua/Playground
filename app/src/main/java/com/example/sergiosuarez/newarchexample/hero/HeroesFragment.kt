package com.example.sergiosuarez.newarchexample.hero

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sergiosuarez.newarchexample.BaseFragment
import com.example.sergiosuarez.newarchexample.R
import com.example.sergiosuarez.newarchexample.adapter.CustomDividerItemDecoration
import com.example.sergiosuarez.newarchexample.adapter.EndlessRecyclerListener
import com.example.sergiosuarez.newarchexample.extensions.showToast
import kotlinx.android.synthetic.main.fragment_heroes.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class HeroesFragment : BaseFragment(), HeroesViewTranslator {

    protected val presenter by inject<HeroesPresenter>(parameters = { parametersOf(this) })
    private lateinit var endlessListener: EndlessRecyclerListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_heroes, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.onCreated()
    }

    private fun initViews() {

        endlessListener = EndlessRecyclerListener(presenter)

        with(heroList) {
            layoutManager = LinearLayoutManager(this@HeroesFragment.activity)
            adapter = HeroAdapter(
                { hero, _ -> presenter.onHeroClicked(hero) },
                { hero -> presenter.onFavoriteClicked(hero) }
            )
            setHasFixedSize(true)
            addItemDecoration(CustomDividerItemDecoration(this@HeroesFragment.activity))
            addOnScrollListener(endlessListener)
        }
    }
    /*heroSearch.addTextChangedListener(object : TextWatcherAdapter() {

        override fun afterTextChanged(s: Editable?) {
            presenter.onSearch(heroSearch.text.toString())
        }
    })*/

    override fun updateContent(heroes: MutableList<Hero>) {
        (heroList.adapter as HeroAdapter).items = heroes.toMutableList()
    }

    override fun showLoader(shouldShow: Boolean) {
        loader.visibility = if (shouldShow) View.VISIBLE else View.GONE
        heroList.visibility = if (shouldShow) View.GONE else View.VISIBLE
    }

    override fun showListLoader() {
        endlessListener.isLoading = true
        runListLoader(true)
    }

    override fun hideListLoader() {
        endlessListener.isLoading = false
        runListLoader(false)
    }

    override fun showEndReached() {
        with(activity) {
            showToast(getString(R.string.end_reached))
        }
    }

    override fun disableEndlessListener() {
        heroList.removeOnScrollListener(endlessListener)
    }

    private fun runListLoader(isLoading: Boolean) = heroList.post {
        (heroList.adapter as HeroAdapter).isLoading = isLoading
    }

    /*override fun disableSearch() {
        (heroList.adapter as HeroAdapter).items.clear()
        (heroList.adapter as HeroAdapter).shouldClearData = false
        heroList.addOnScrollListener(endlessListener)
    }

    override fun enableSearch() {
        (heroList.adapter as HeroAdapter).shouldClearData = true
        heroList.removeOnScrollListener(endlessListener)
    }*/

    /**
     *  Activity result implemented to manage favorite change
     */
    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val params = data?.getSerializableExtra(EXTRA_HERO) as Pair<Int, Boolean>?
            params?.let {
                (heroList.adapter as HeroAdapter).updateItemView(it.first, it.second)
            }
        }
    }*/

    /*override fun openDetailScreen(hero: Hero) {
        //Activity started for result to manage possible changes in hero favorite state
        context?.let {
            startActivityForResult(
                HeroDetailActivity.newIntent(it, hero.id, hero.photo),
                REQUEST_CODE,
                getTransitionParams()?.toBundle()
            )
        }
    }*/

    /*private fun getTransitionParams(): ActivityOptionsCompat? {
        //Check nullable safety
        var options: ActivityOptionsCompat? = null
        if (activity != null && transitionParams != null) {

            //More params (Pair<View, String> could be included to transition more elements of the screen)
            options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity!!, transitionParams!!.first, transitionParams!!.second)
        }
        return options
    }*/
}