package com.emrekose.karchi.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.emrekose.karchi.R
import com.emrekose.karchi.data.local.entity.Repos
import com.emrekose.karchi.databinding.ActivityDetailBinding
import com.emrekose.karchi.ui.BaseActivity
import com.emrekose.karchi.utils.extensions.transact

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    companion object {
        fun newIntent(context: Context, repos: Repos?) =
                Intent(context, DetailActivity::class.java).apply { putExtra("REPOS", repos) }
    }

    override fun getLayoutRes(): Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repos: Repos? = intent.extras.getParcelable("REPOS")

        repos?.let {
            title = it.name
            supportFragmentManager.transact {
                replace(R.id.detail_activity_container, DetailFragment.newInstance(it))
            }
        }

    }
}
