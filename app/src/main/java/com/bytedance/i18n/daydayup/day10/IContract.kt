package com.bytedance.i18n.daydayup.day10

interface IContract {

    interface IRelatedView{
        fun updateUI()
    }

    interface IRelatedPresenter{
        fun getData()
    }
}