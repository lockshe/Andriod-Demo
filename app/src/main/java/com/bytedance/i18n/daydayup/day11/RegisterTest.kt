package com.bytedance.i18n.daydayup.day11

interface RegisterTest{

    fun test0(): Int

}

class RegisterClass : RegisterTest{

    override fun test0(): Int {
        println("helo")
        return 1
    }
}