package tech.visuallatam.labo7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import tech.visuallatam.labo7.adapter.ReposAdapter
import tech.visuallatam.labo7.roomarch.database.entities.GithubRepo
import tech.visuallatam.labo7.roomarch.database.viewmodels.GithubRepoViewModel

class MainActivity : AppCompatActivity() {


    lateinit var adapter: ReposAdapter
    lateinit var viewModel: GithubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bind(){
        adapter= ReposAdapter(ArrayList())
        viewModel=ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        rv_repos.apply {
            adapter=this@MainActivity.adapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer { adapter.updateList(it) })

        btn_add.setOnClickListener { viewModel.insert(GithubRepo(et_repo_name.text.toString())) }
    }
}
