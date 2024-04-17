package com.example.rayzal_160420103_hobbyapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rayzal_160420103_hobbyapp.model.News

class NewsViewModel : ViewModel() {

    private val _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>> = _newsList

    init {
        fetchDummyNews()
    }

    private fun fetchDummyNews() {
        val dummyNewsList = listOf(
            News(
                "Mindset: The New Psychology of Success",
                "Dweck reveals the power of our mindset and how a simple shift in perspective can lead to great success.",
                "Carol S. Dweck",
                "https://fastly.picsum.photos/id/884/200/300.jpg?hmac=VnWK-J-znCMSx2FSelz3LtT1DXhrxRLtzsX6-hkZDJk",
                listOf(
                    "The Mindsets",
                    "Inside the Mindsets",
                    "The Truth About Ability and Accomplishment",
                    "Sports: The Mindset of a Champion",
                    "Business: Mindset and Leadership",
                    "Relationships: Mindsets in Love (or Not)"
                )
            ),
            News(
                "Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones",
                "James Clear presents a practical guide to understanding how habits work and how to build better ones.",
                "James Clear",
                "https://fastly.picsum.photos/id/77/450/300.jpg?hmac=V_LawevwSaVitpQs2t7AnuBi84UPSNl1Qp3PmKkmaXc",
                listOf(
                    "The Fundamentals",
                    "The 1st Law: Make It Obvious",
                    "The 2nd Law: Make It Attractive",
                    "The 3rd Law: Make It Easy",
                    "The 4th Law: Make It Satisfying",
                    "Advanced Tactics"
                )

            ),
            News(
                "The Da Vinci Code",
                "Dan Brown's thriller follows symbologist Robert Langdon as he investigates a murder in the Louvre Museum, leading to a trail of clues hidden in the works of Leonardo da Vinci.",
                "Dan Brown",
                "https://fastly.picsum.photos/id/796/200/200.jpg?hmac=TabKFVb5_IyNIu3LHpgEW6YnI0AxHo3G6fyHubk1OY8",
                listOf(
                    "Prologue",
                    "Chapter 1: The Teacher",
                    "Chapter 2: The Meeting",
                    "Chapter 3: The Body"
                )

            ),
            News(
                "Gone Girl",
                "Gillian Flynn's psychological thriller tells the story of Nick Dunne, whose wife, Amy, disappears on their fifth wedding anniversary, leading to a media frenzy and a twisting investigation.",
                "Gillian Flynn",
                "https://picsum.photos/200/300?grayscale",
                listOf(
                    "Part One: Boy Loses Girl",
                    "Part Two: Boy Meets Girl",
                    "Part Three: Boy Gets Girl"
                )

            ),


        )
        _newsList.value = dummyNewsList
    }
}