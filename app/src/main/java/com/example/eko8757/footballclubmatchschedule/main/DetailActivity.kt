package com.example.eko8757.footballclubmatchschedule.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.eko8757.footballclubmatchschedule.api.ApiRepository
import com.example.eko8757.footballclubmatchschedule.model.DetailEvent
import com.example.eko8757.footballclubmatchschedule.model.Team
import com.example.eko8757.footballclubmatchschedule.presenter.DetailPresenter
import com.example.eko8757.footballclubmatchschedule.R
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {

    private var idEvent: String = ""
    private var idHomeTeam: String = ""
    private var idAwayTeam: String = ""
    private lateinit var presenter: DetailPresenter

    override fun getDetailEvent(data: DetailEvent) {
        idHomeTeam = data.homeTeamId.toString()
        idAwayTeam = data.awayTeamId.toString()
        when (data.eventId) {
            idEvent -> {

                eventName.text = data.event
                leagueName.text = data.league
                homeTeam.text = data.homeTeam
                awayTeam.text = data.awayTeam
                homeScore.text = data.homeScore
                awayScore.text = data.awayScore
                goalHomeDetail.text = data.homeGoalDetail
                goalAwayDetail.text = data.awayGoalDetail
                homeRedCardDetail.text = data.homeRedCards
                awayRedCardDetail.text = data.awayRedCards
                homeYellowCardDetail.text = data.homeYellowCards
                awayYellowCardDetail.text = data.awayYellowCards
                vs.text = "VS"
            }
        }

        presenter.getTeam(idHomeTeam)
        presenter.getTeam(idAwayTeam)
    }

    override fun showTeam(data: Team) {
        Log.d("idHome2", idHomeTeam)
        when (data.teamId) {

            idHomeTeam -> {
                Picasso.get().load(data.teamBadge).into(homeBadge)
            }

            idAwayTeam -> {
                Picasso.get().load(data.teamBadge).into(awayBadge)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Event Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        idEvent = intent.getStringExtra("idEvent")

        val request = ApiRepository()
        val gson = Gson()
        presenter = DetailPresenter(this, request, gson)

        presenter.getDetailEvent(idEvent)
    }
}
