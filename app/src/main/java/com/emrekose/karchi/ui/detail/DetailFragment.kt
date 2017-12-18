package com.emrekose.karchi.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emrekose.karchi.R
import com.emrekose.karchi.data.local.entity.Repos
import com.emrekose.karchi.databinding.FragmentDetailBinding
import com.emrekose.karchi.ui.BaseFragment

class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>() {

    private var repos: Repos? = null

    override fun getViewModel(): Class<DetailViewModel> = DetailViewModel::class.java

    override fun getLayoutRes(): Int = R.layout.fragment_detail

    companion object {
        fun newInstance(repos: Repos? = null): DetailFragment {

            var args = Bundle()
            var fragment = DetailFragment()
            repos?.let { args.putParcelable("REPO", repos) }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments.let {
            repos = arguments?.getParcelable("REPO")
            dataBinding.repos = repos
        }
    }
}
