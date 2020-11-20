import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

class LogFunctionsTest {

    @Nested
    inner class LogFunctionUintTest {
        @ParameterizedTest
        @CsvFileSource(resources = ["log-any.csv"], numLinesToSkip = 1)
        fun `it computes logarithm of any base`(
            x: Double,
            y: Double,
            base: Double,
            lnX: Double,
            lnBase: Double,
            precision: Double,
        ) {
            val mockLnApprox = Mockito.mock(INaturalLogarithmApprox::class.java)
            Mockito.`when`(mockLnApprox.ln(ArgumentMatchers.eq(x), ArgumentMatchers.anyDouble()))
                .thenReturn(lnX)
            Mockito.`when`(mockLnApprox.ln(ArgumentMatchers.eq(base), ArgumentMatchers.anyDouble()))
                .thenReturn(lnBase)
            Assertions.assertEquals(y, LogarithmicFunctions(mockLnApprox).logN(x, base, precision), precision)
        }

        @ParameterizedTest
        @CsvFileSource(resources = ["log-invalid.csv"], numLinesToSkip = 1)
        fun `UnsupportedValueException for invalid parameters`(
            x: Double,
            base: Double,
            precision: Double
        ) {
            val mockLnApprox = Mockito.mock(INaturalLogarithmApprox::class.java)
            Mockito.`when`(
                mockLnApprox.ln(
                    ArgumentMatchers.doubleThat { !it.isFinite() },
                    ArgumentMatchers.anyDouble()
                )
            ).thenThrow(UnsupportedValueException::class.java)
            Mockito.`when`(
                mockLnApprox.ln(
                    ArgumentMatchers.anyDouble(),
                    ArgumentMatchers.doubleThat { !it.isFinite() }
                )
            ).thenThrow(UnsupportedValueException::class.java)
            Assertions.assertThrows(UnsupportedValueException::class.java) {
                LogarithmicFunctions(mockLnApprox).ln(x, precision)
            }
        }
    }

    @Nested
    inner class LogFunctionIntegrationTest {

        @ParameterizedTest
        @CsvFileSource(resources = ["log-any.csv"], numLinesToSkip = 1)
        fun `it computes logarithm of any base`(
            x: Double,
            y: Double,
            base: Double,
            lnX: Double,
            lnBase: Double,
            precision: Double,
        ) = Assertions.assertEquals(y, LogarithmicFunctions(NaturalLogarithmApprox).logN(x, base, precision), precision)

        @ParameterizedTest
        @CsvFileSource(resources = ["log-invalid.csv"], numLinesToSkip = 1)
        fun `UnsupportedValueException for invalid parameters`(
            x: Double,
            base: Double,
            precision: Double
        ) {
            Assertions.assertThrows(UnsupportedValueException::class.java) {
                LogarithmicFunctions(NaturalLogarithmApprox).logN(x, base, precision)
            }
        }
    }
}
