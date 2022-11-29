package com.example.lucky_wheel

import com.example.lucky_wheel.Word.GetWord.GetWord
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun randomizer(){
        var i = 0
        while(i!=100) {
            var ran = Word.GetWord.GetWord(Category.GetCategory.GetCategory())
            println(ran)
            i++
        }
    }

    @Test
    fun catRandomizer(){
        var i = 0
        while(i!=100){
            var ran = Category.GetCategory.GetCategory()
            println(ran)
            i++
        }
    }


}