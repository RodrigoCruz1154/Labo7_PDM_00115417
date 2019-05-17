package tech.visuallatam.labo7.roomarch.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import tech.visuallatam.labo7.roomarch.database.daos.GithubRepoDAO
import tech.visuallatam.labo7.roomarch.database.entities.GithubRepo

class GithubRepository(private val repoDAO: GithubRepoDAO){

    fun getAll():LiveData<List<GithubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo:GithubRepo) = repoDAO.insert(repo)


}