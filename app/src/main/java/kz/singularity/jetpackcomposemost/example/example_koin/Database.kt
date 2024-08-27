package kz.singularity.jetpackcomposemost.example.example_koin

interface Database {
    fun getUsers(): List<String>
}
class RoomDatabase : Database {
    override fun getUsers(): List<String> {
        return listOf("1", "2", "3")
    }
}
class RealmDatabase : Database {
    override fun getUsers(): List<String> {
        return listOf("4", "5", "6")
    }
}
