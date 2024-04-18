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
                    "In this groundbreaking work, renowned psychologist Carol S. Dweck explores the power of mindsets and how they shape our lives. She delves into the fundamental differences between a fixed mindset, which assumes intelligence and abilities are static, and a growth mindset, which embraces the potential for growth and development. Through engaging examples and insightful analysis, Dweck demonstrates how our mindsets influence our behavior, relationships, and overall success in various domains of life.",
                    "The book begins by introducing the two types of mindsets: fixed and growth. It then dives deeper into the characteristics and implications of each mindset, exploring how they shape our beliefs about ourselves and our abilities. Dweck also examines the relationship between mindset and accomplishment, challenging the notion of innate talent and emphasizing the power of effort and perseverance.",
                    "In the realm of sports, Dweck highlights the mindsets of champion athletes and how a growth mindset fosters resilience, adaptability, and a relentless pursuit of improvement. The book also explores the impact of mindsets in the business world, analyzing how leaders with a growth mindset can cultivate a culture of innovation, collaboration, and continuous learning.",
                    "Lastly, Dweck explores the role of mindsets in personal relationships, offering insights into how our mindsets influence our approach to love, communication, and conflict resolution. The book encourages readers to embrace a growth mindset in all aspects of their lives, empowering them to unlock their full potential and achieve lasting success."
                )
            ),
            News(
                "Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones",
                "James Clear presents a practical guide to understanding how habits work and how to build better ones.",
                "James Clear",
                "https://fastly.picsum.photos/id/77/450/300.jpg?hmac=V_LawevwSaVitpQs2t7AnuBi84UPSNl1Qp3PmKkmaXc",
                listOf(
                    "In 'Atomic Habits,' James Clear presents a comprehensive and practical framework for building good habits and breaking bad ones. He introduces the concept of 'habit stacking' and offers actionable strategies based on four fundamental laws: making habits obvious, attractive, easy, and satisfying. With engaging narratives and scientific insights, Clear empowers readers to take control of their habits, cultivate self-discipline, and create lasting positive change in their lives.",
                    "The book begins by laying out the fundamentals of habit formation, including the habit loop and the importance of small, incremental changes. Clear then introduces the four laws of behavior change, each with its own set of strategies and techniques.",
                    "The first law, 'Make It Obvious,' focuses on creating environmental cues and reminders that trigger desired behaviors. The second law, 'Make It Attractive,' explores ways to increase the appeal and motivation for certain habits, such as by leveraging temptation bundling or creating a motivating environment.",
                    "The third law, 'Make It Easy,' emphasizes the importance of reducing friction and making habits as effortless as possible. Clear offers practical tips for creating an environment that supports desired behaviors and removes obstacles.",
                    "The fourth law, 'Make It Satisfying,' delves into the role of immediate rewards and positive reinforcement in habit formation. Clear provides strategies for creating a sense of satisfaction and progress, which can help solidify new habits.",
                    "In the final section, 'Advanced Tactics,' Clear explores more advanced concepts and techniques for habit change, such as habit tracking, accountability partners, and the power of identity-based habits. Throughout the book, Clear draws from real-life examples and scientific research to provide a comprehensive and actionable guide for readers seeking to transform their lives through the power of habits."
                )
            ),
            News(
                "The Da Vinci Code",
                "Dan Brown's thriller follows symbologist Robert Langdon as he investigates a murder in the Louvre Museum, leading to a trail of clues hidden in the works of Leonardo da Vinci.",
                "Dan Brown",
                "https://fastly.picsum.photos/id/796/200/200.jpg?hmac=TabKFVb5_IyNIu3LHpgEW6YnI0AxHo3G6fyHubk1OY8",
                listOf(
                    "In Dan Brown's thrilling novel, 'The Da Vinci Code,' symbologist Robert Langdon finds himself embroiled in a fascinating mystery that intertwines art, religion, and ancient secrets. When a curator at the Louvre is brutally murdered, Langdon is summoned to decipher the baffling codes and symbols left at the crime scene. Joined by a gifted French cryptologist, Sophie Neveu, they embark on a breathtaking journey through the works of Leonardo da Vinci and uncover a shocking conspiracy that challenges the very foundations of Christianity.",
                    "Chapter 1 the prologue sets the stage with a gruesome murder at the Louvre Museum, leaving behind a cryptic trail of symbols and codes. In Chapter 1, Robert Langdon, a renowned symbologist, is introduced as he prepares to deliver a lecture at a university in Paris.",
                    "Chapter 2 follows Langdon as he is summoned to the Louvre to assist with the investigation of the curator's murder. There, he meets Sophie Neveu, a cryptologist from the French judicial police, and together they begin unraveling the intricate web of symbols and clues.",
                    "In Chapter 3, Langdon and Neveu uncover shocking revelations about the victim's involvement in a secret society and the existence of a centuries-old conspiracy. As they delve deeper into the mystery, they must navigate a dangerous path filled with powerful adversaries determined to keep the truth buried."
                )
            ),
            News(
                "Gone Girl",
                "Gillian Flynn's psychological thriller tells the story of Nick Dunne, whose wife, Amy, disappears on their fifth wedding anniversary, leading to a media frenzy and a twisting investigation.",
                "Gillian Flynn",
                "https://picsum.photos/200/300?grayscale",
                listOf(
                    "In Gillian Flynn's gripping psychological thriller, 'Gone Girl,' the disappearance of Amy Dunne on her fifth wedding anniversary sets off a whirlwind of events that captivate the nation. As the investigation unfolds, the seemingly perfect marriage between Nick and Amy is revealed to be a complex web of lies, secrets, and twisted games. With masterful storytelling and unexpected twists, Flynn takes readers on a roller-coaster ride of suspense, exploring the dark depths of human nature and the fragility of trust in relationships.",
                    "Part One introduces Nick Dunne, a struggling writer who returns home to find his wife Amy missing under mysterious circumstances. As the investigation intensifies, Nick's strange behavior and damaging secrets from his past fuel public suspicion and media scrutiny.",
                    "Part Two delves into the backstory of Nick and Amy's relationship, revealing their initial courtship and the gradual erosion of their marriage. Through a series of flashbacks and Amy's diary entries, a chilling portrait of their dysfunctional dynamic emerges.",
                    "In Part Three, the investigation takes a shocking turn as new evidence surfaces, challenging everything readers thought they knew about the case. Flynn masterfully weaves together multiple narratives and unreliable perspectives, keeping readers guessing until the very end."
                )
            )
        )
        _newsList.value = dummyNewsList
    }
}