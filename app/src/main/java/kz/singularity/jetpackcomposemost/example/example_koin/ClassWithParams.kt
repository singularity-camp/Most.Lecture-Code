package kz.singularity.jetpackcomposemost.example.example_koin

class ClassWithParams(
    private val params: ClassWithoutParams,
) {

    fun execute() {
        params.execute()
    }
}
