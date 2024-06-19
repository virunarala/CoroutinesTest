import kotlinx.coroutines.*

class ViewModel(
    private val dispatcher: CoroutineDispatcher,
    var isSuccess: Boolean
) {
    val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)


    var funAJob: Job? = null


    suspend fun funA() {
        funAJob = coroutineScope.async(dispatcher) {
            delay(1000L)
            if(isSuccess) {
                println("Executing success case...")
            } else {
                if(funAJob?.isActive == true) {
                    println("Executing failure case. funAJob is active")
                } else {
                    println("Executing failure case. funAJob is NOT active")
                }
            }
        }
    }

    fun funB() {

    }
}

fun main() {
    runBlocking {
        val viewModel = ViewModel(Dispatchers.IO, false)
        viewModel.funA()
        viewModel.funAJob?.join()
    }
}