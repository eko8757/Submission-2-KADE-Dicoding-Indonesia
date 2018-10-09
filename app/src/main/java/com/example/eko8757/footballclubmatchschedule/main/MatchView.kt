package com.example.eko8757.footballclubmatchschedule.main

import com.example.eko8757.footballclubmatchschedule.model.Events

interface MatchView {

    fun showLoading()
    fun hideLoading()
    fun showPrevEvent(data: List<Events>)
    fun showNextEvent(data: List<Events>)
}