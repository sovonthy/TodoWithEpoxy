package com.example.epoxy.view

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.ColorSpace
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.example.epoxy.R
import com.example.epoxy.view.setting.CardModel
import com.example.epoxy.view.setting.CardModel_
import com.example.epoxy.view.setting.card
import java.util.concurrent.CopyOnWriteArrayList

class HomeController(
    private var context: Context,

    ) : EpoxyController() {

    private var cash: CopyOnWriteArrayList<HomeModel> = CopyOnWriteArrayList()
    private var transactions: CopyOnWriteArrayList<TransactionModel> = CopyOnWriteArrayList()

    fun submitTransaction(list: ArrayList<TransactionModel>) {
        transactions.clear()
        transactions.addAll(list)
        requestModelBuild()
    }

    fun submitCash(list: ArrayList<HomeModel>) {
        cash.clear()
        cash.addAll(list)
        requestModelBuild()
    }

    override fun buildModels() {
        List(1) {
           home {  id("cash${it}")
               showDetails("See Details")
               cashTextView("Cash Flow")
               textView("Am I spending less than I make?")
           }
        }
        List(1){
            month { id("month $it")
                monthTextView("This Month")
                price("$500.86")
                lastMonth("vs last month")
                fee("+5.05%")
            }
        }
        List(1){
            incomeOutCome { id("income $it")
                inComePrice("$200.1")
                expensesPrice("$241.0")
            }
        }
        List(1){
            recentTransaction {
                id("recent $it")
                recentTransaction("Recent Transaction")
                seeAll("See All")

            }
        }
        List(1) {
            transaction {
                id(it)
                title("Cafe")
                price("$4.01")
                subTitle("BCA Card")
            }
        }
        List(1) {
            transaction {
                id(it)
                title("Shopping")
                price("$510.0")
                subTitle("GoPay")
            }
        }

        val carouselList: ArrayList<CardModel_> = ArrayList()
        List(5){
            carouselList.add(
               CardModel_().id("card_${it}").title("Experience").body("Hi, Sis Cute! <33")
           )
        }          
        carousel {
            id("carousel")
            models(carouselList)
//            numViewsToShowOnScreen(2f)
        }

    }

}