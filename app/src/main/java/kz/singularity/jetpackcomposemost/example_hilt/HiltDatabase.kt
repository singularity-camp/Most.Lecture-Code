package kz.singularity.jetpackcomposemost.example_hilt

import javax.inject.Inject

interface HiltDatabase {
    fun getUsers(): List<String>
}
class HiltRoomDatabase @Inject constructor(): HiltDatabase {
    override fun getUsers(): List<String> {
        return listOf("1", "2", "3")
    }
}
class HiltRealmDatabase @Inject constructor(): HiltDatabase {
    override fun getUsers(): List<String> {
        return listOf("4", "5", "6")
    }
}
