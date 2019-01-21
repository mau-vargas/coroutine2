package payroll.base.com.coroutines2.presentation.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.main_fragment.*
import payroll.base.com.coroutines2.R


class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel


        button.setOnClickListener {
            viewModel.getIfo().observe(this, Observer { it ->
                it.takeIf { it?.status == (Status.SUCCESS) }
                    .apply { Toast.makeText(context, it?.data, Toast.LENGTH_SHORT).show() }
            })
        }
    }

}
