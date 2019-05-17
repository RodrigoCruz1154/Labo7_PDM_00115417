package tech.visuallatam.labo7.adapter

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.repo_cardview.view.*
import tech.visuallatam.labo7.R
import tech.visuallatam.labo7.roomarch.database.entities.GithubRepo

class ReposAdapter(var repos:List<GithubRepo>):RecyclerView.Adapter<ReposAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ReposAdapter.ViewHolder {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.repo_cardview,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(p0: ReposAdapter.ViewHolder, p1: Int) {
        p0.bind(repos[p1])
    }

    fun updateList(newRepos:List<GithubRepo>){
        this.repos=newRepos
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(repo:GithubRepo) = with(itemView){
            textView.text=repo.name
        }
    }

}