package com.example.textcalc
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
//import com.example.textcalc.ui.theme.getDta
import com.example.textcalc.ui.theme.lng
import java.util.Scanner

class Convert2Numer: ViewModel() {
    var inputTx by mutableStateOf("")
    val onValueChange = { text: String -> inputTx = text }
    var numer by mutableStateOf("")
    var lnn: List<String> = mutableListOf()
    var ct by mutableStateOf("")

    fun getNum(inpt: String): String {
        val kl = lDit.keys.toList()
        val inp = inpt.toLowerCase().toList()
        val siSd = inp.filter { it in kl }
        val xs = siSd.map { lDit[it] }.toTypedArray().filterNotNull()
        numer = xs.sum().toString()
        return numer
    }
    fun matchWrd(inptS: String): List<String>{
        var cct = 0
        val lg = lng
        var lln: List<String> = mutableListOf()
        for (vb in lg.indices) {
            val cn = 0
            val st = getNum(lg[vb].toString())
            val ts = getNum(inptS)
            if (st == ts) {
                cct += cn + 1
                lln += lg[vb].toString()
                //println(lng[vb])
            }
        }
            ct = cct.toString()
            lnn = lln
        //println("Number of similar words: $cc Below: $lnn")
        return lnn
    }

}

        /*fun getNum(inpt: String): String {
            var numer by mutableStateOf("")
            val kl = lDit.keys.toList()

            val inp = inpt.toLowerCase().toList()
            val siSd = inp.filter { it in kl }
            val xs = siSd.map { lDit[it] }.toTypedArray().filterNotNull()
            numer = xs.sum().toString()
            return numer

        }*/
       /* fun matchWrd(inptS: String) {
            var cct = 0
            val lnn: MutableList<String> = mutableListOf()
            val lg = getDta()
            for (vb in lg.indices) {
                val cn = 0
                val st = getNum(lg[vb].toString())
                val ts = getNum(inptS)
                if (st == ts) {
                    cct += cn + 1
                    lnn += lg[vb].toString()
                    //println(lng[vb])
                }
            }
            val cc = cct.toString()
            //println("Number of similar words: $cc Below: $lnn")
        }
*/

    /*fun main() {
        val input = Scanner(System.`in`)
        print("provide an input: ")
        val inptS = input.nextLine().toString()
        print(matchWrd(inptS))
    }*/



