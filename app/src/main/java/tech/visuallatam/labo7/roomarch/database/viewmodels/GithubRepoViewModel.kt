package tech.visuallatam.labo7.roomarch.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.visuallatam.labo7.roomarch.database.RoomDB
import tech.visuallatam.labo7.roomarch.database.entities.GithubRepo
import tech.visuallatam.labo7.roomarch.database.repositories.GithubRepository

class GithubRepoViewModel(app: Application) : AndroidViewModel(app) {

    private val repository: GithubRepository

    init {
        val repoDAO = RoomDB.getInstance(app).repoDAO()
        repository = GithubRepository(repoDAO)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO) { repository.insert(repo) }


}