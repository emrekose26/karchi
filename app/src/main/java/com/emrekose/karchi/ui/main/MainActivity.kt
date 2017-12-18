package com.emrekose.karchi.ui.main

import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.view.Menu
import android.widget.FrameLayout
import com.emrekose.karchi.R
import com.emrekose.karchi.databinding.ActivityMainBinding
import com.emrekose.karchi.ui.BaseActivity
import com.emrekose.karchi.ui.detail.DetailFragment
import com.emrekose.karchi.utils.extensions.transact

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var mSearchView: SearchView
    private var searchString: String? = null
    private val SEARCH_KEY = "search"

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState?.let {
            searchString = savedInstanceState.getString(SEARCH_KEY)
            findViewById<FrameLayout>(R.id.detail_container)?.let {
                supportFragmentManager.transact {
                        replace(R.id.list_container, RepoListFragment.newInstance(searchString))
                        replace(R.id.detail_container, DetailFragment.newInstance())
                }
            } ?: supportFragmentManager.transact { replace(R.id.list_container, RepoListFragment.newInstance(searchString)) }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater?.inflate(R.menu.options_menu, menu)

        val searchItem = menu?.findItem(R.id.search)

        mSearchView = MenuItemCompat.getActionView(searchItem) as SearchView
        MenuItemCompat.expandActionView(searchItem)
        mSearchView.maxWidth = Int.MAX_VALUE

        if (searchString != null && !searchString!!.isEmpty()) mSearchView.setQuery(searchString, true)

        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                supportFragmentManager.transact { replace(R.id.list_container, RepoListFragment.newInstance(query)) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
        return true
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        searchString = mSearchView.query.toString()
        outState?.putString(SEARCH_KEY, searchString)
    }


}
