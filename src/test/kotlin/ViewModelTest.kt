import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ViewModelTest {

    private lateinit var SUT: ViewModel
    private val dispatcher = StandardTestDispatcher()

    @BeforeEach
    fun setUp() {
        SUT = ViewModel(dispatcher, false)
    }

    @Test
    fun funA_isFailure_coroutineIsActive() = runTest(dispatcher) {
        SUT.isSuccess = false

        SUT.funA()
    }
}