package com.example.common.kotlin_dagger2.viewmodel

import com.example.common.kotlin_dagger2.pojo.MyInjectionClass
import com.example.common.kotlin_dagger2.pojo.MyLocalClass
import org.junit.Test
import java.util.*
import javax.inject.Inject

class PostListViewModelTest {

    // TODO: Need to inject modules
    @Inject
    lateinit var myInjectionClass : MyInjectionClass

    lateinit var myLocalClass : MyLocalClass
    var myLocalClass1: MyLocalClass = MyLocalClass()

    @Test fun printMutableList() {
        // www.coding180.com
        val ages: MutableList <Int> = mutableListOf (23, 67, 12, 35, 12)
        println ("List of ages")
        println (ages)

        ages [0] = 60
        println ("Complete list after changing the first age")
        println (ages)

        println ("First age stored in list")
        println (ages [0])

        println ("Average age")
        println (ages.average ())
        println ("We add an age at the bottom of the list:")
        ages.add (50)
        println ("List of ages")
        println (ages)

        println ("We added an age at the top of the list:")
        ages.add (0, 17)
        println ("List of ages")
        println (ages)

        println ("We added an age and removed the age:")
        ages.add(33)
        println (ages)
        ages.remove(33)
        println (ages)

        println ("We removed the first age from the list:")
        ages.removeAt (0)
        println ("List of ages")
        println (ages)
        print ("Number of persons of legal age:")
        val cont = ages.count {it >= 18}
        println (cont)
        ages.removeAll {it == 12}
        println ("List of ages after deleting those that are 12 years old")
        println (ages)
        ages.clear ()
        println ("List of ages after deleting the list completely")
        println (ages)
        if (ages.isEmpty ())
            println ("There are no ages in the list")
    }

    @Test fun testList() {
        var list1: List<String> = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

        // Syntax errors:
        //list1.add("AA")
        //list1[0] = "BB"

        println("Print the complete list")
        println(list1)

        println("Print the first item in the list")
        println(list1[0])
        println("Print the first item in the list")
        println(list1.first())
        println("Print the last item in the list")
        println(list1.last())
        println("Print the last item in the list")
        println(list1[list1.size - 1])
        println("Print the number of items in the list")
        println(list1.size)

        println("Scroll through the complete list with a for without $")
        for (element in list1)
            print(element + " ")
        println()

        println("Scroll through the complete list with a for")
        for (element in list1)
            print("$element ")
        println()

        println("Print the item and its position without $")
        for (position in list1.indices)
            print("[" + position + "] ${list1[position]} ")

        println("Print the item and its position ")
        for (position in list1.indices)
            print("[$position] ${list1[position]} ")

        for (position in list1.indices)
            print(list1[position] )
    }

    @Test fun printMap() {

        val nzPop = mutableMapOf("AUCK" to 1500000, "WLG" to 405000, "CHCH" to 500000, "GIS" to 36100)
        println("**********$nzPop")
        // Change a existing entry in the map.
        nzPop["CHCH"] = 389700

        // Remove a entry from the map by key.
        nzPop.remove("GIS")
        // Add a entry to the map.
        nzPop["DUN"] = 118500



        println("*****1*****$nzPop")

        var tempMap = HashMap(nzPop)

        println("*****2*****$tempMap")
    }

    @Test fun printNullale() {
        val a : String
        // Syntax error
        //  println(a)
        //  a = null

        val b : String?
        b = null
        println("*****$b")


        var name: String? = "Joe"
        // If name is "null" then a "null" is returned.
        println("*******${name?.startsWith("J")}")

        name = "Mahesh"
        println("*******${name?.startsWith("J")}")

        var name1: String? = null
        // If name is "null" then a "null" is returned.
        println("*******startsWith${name1?.startsWith("J")}")
        println("*******isNullOrEmpty=${name1.isNullOrEmpty()}")

        //TODO:  Need to inject module
        //        println("*******MyInjectionClass=$myInjectionClass")

        myLocalClass= MyLocalClass()
        println("*******myLocalClass=$myLocalClass")
        println("*******myLocalClass1=$myLocalClass1")


    }
}