package kz.singularity.jetpackcomposemost.example_hilt

import javax.inject.Inject

class HiltClassWithSeveralParams @Inject constructor(
    private val param1: HiltClassWithoutParams,
    private val param2: HiltClassWithParams
) {
    fun execute() {
        param1.execute()
        param2.execute()
    }
}
