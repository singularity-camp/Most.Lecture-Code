package kz.singularity.jetpackcomposemost.example_hilt

import android.util.Log
import javax.inject.Inject

class HiltClassWithoutParams @Inject constructor() {
    fun execute() {
        Log.d("ClassWithoutParams", "execute")
    }
}
