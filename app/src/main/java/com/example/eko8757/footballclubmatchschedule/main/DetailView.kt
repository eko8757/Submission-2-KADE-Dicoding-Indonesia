package com.example.eko8757.footballclubmatchschedule.main

import com.example.eko8757.footballclubmatchschedule.model.DetailEvent
import com.example.eko8757.footballclubmatchschedule.model.Team

interface DetailView {

    fun showTeam(data: Team)
    fun getDetailEvent(data: DetailEvent)
}