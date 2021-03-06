import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito

class TrigonometricFunctionTest {

    @Nested
    inner class TrigonometricFunctionUnitTest {
        @ParameterizedTest
        @CsvFileSource(resources = ["/trig.csv"], numLinesToSkip = 1)
        fun `it compute sinus`(
            x: Double,
            sin: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            precision: Double
        ) {
            val mockSinApprox = Mockito.mock(ISinApprox::class.java)
            Mockito.`when`(mockSinApprox.sin(eq(x), anyDouble())).thenReturn(sin)
            Assertions.assertEquals(sin, TrigonometricFunctions(mockSinApprox).sin(x, precision), precision)
        }

        @ParameterizedTest
        @CsvFileSource(resources = ["/trig.csv"], numLinesToSkip = 1)
        fun `it compute tan`(
            x: Double,
            sin: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            precision: Double
        ) {
            val mockSinApprox = Mockito.mock(ISinApprox::class.java)
            Mockito.`when`(mockSinApprox.sin(eq(x), anyDouble())).thenReturn(sin)
            Mockito.`when`(mockSinApprox.sin(eq(x + Math.PI / 2), anyDouble())).thenReturn(cos)

            Assertions.assertEquals(tan, TrigonometricFunctions(mockSinApprox).tan(x, precision), precision)
        }

        @ParameterizedTest
        @CsvFileSource(resources = ["/trig.csv"], numLinesToSkip = 1)
        fun `it compute cotangent`(
            x: Double,
            sin: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            precision: Double
        ) {
            val mockSinApprox = Mockito.mock(ISinApprox::class.java)
            Mockito.`when`(mockSinApprox.sin(eq(x), anyDouble())).thenReturn(sin)
            Mockito.`when`(mockSinApprox.sin(eq(x + Math.PI / 2), anyDouble())).thenReturn(cos)

            Assertions.assertEquals(cot, TrigonometricFunctions(mockSinApprox).cot(x, precision), precision)
        }


        @ParameterizedTest
        @CsvFileSource(resources = ["/trig-invalid.csv"], numLinesToSkip = 1)
        fun `UnsupportedValueException for invalid parameters`(
            x: Double,
            sin: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            precision: Double
        ) {
            val mockSinApprox = Mockito.mock(ISinApprox::class.java)
            Mockito.`when`(mockSinApprox.sin(doubleThat { !it.isFinite() }, anyDouble()))
                .thenThrow(UnsupportedValueException::class.java)
            Mockito.`when`(mockSinApprox.sin(anyDouble(), doubleThat { !it.isFinite() }))
                .thenThrow(UnsupportedValueException::class.java)

            Assertions.assertThrows(UnsupportedValueException::class.java) {
                TrigonometricFunctions(mockSinApprox).sin(x, precision)
            }
            Assertions.assertThrows(UnsupportedValueException::class.java) {
                TrigonometricFunctions(mockSinApprox).cos(x, precision)
            }
            Assertions.assertThrows(UnsupportedValueException::class.java) {
                TrigonometricFunctions(mockSinApprox).tan(x, precision)
            }
            Assertions.assertThrows(UnsupportedValueException::class.java) {
                TrigonometricFunctions(mockSinApprox).cot(x, precision)
            }
        }
    }


    @Nested
    inner class TrigonometricFunctionIntegrationTest {
        @ParameterizedTest
        @CsvFileSource(resources = ["/trig.csv"], numLinesToSkip = 1)
        fun `it compute sinus`(
            x: Double,
            sin: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            precision: Double
        ) {
            Assertions.assertEquals(sin, TrigonometricFunctions(SinApprox).sin(x, precision), precision)
        }

        @ParameterizedTest
        @CsvFileSource(resources = ["/trig.csv"], numLinesToSkip = 1)
        fun `it compute tan`(
            x: Double,
            sin: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            precision: Double
        ) {
            Assertions.assertEquals(tan, TrigonometricFunctions(SinApprox).tan(x, precision), precision)
        }

        @ParameterizedTest
        @CsvFileSource(resources = ["/trig.csv"], numLinesToSkip = 1)
        fun `it compute cotangent`(
            x: Double,
            sin: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            precision: Double
        ) {
            Assertions.assertEquals(cot, TrigonometricFunctions(SinApprox).cot(x, precision), precision)
        }

        @ParameterizedTest
        @CsvFileSource(resources = ["/trig-invalid.csv"], numLinesToSkip = 1)
        fun `UnsupportedValueException for invalid parameters`(
            x: Double,
            sin: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            precision: Double
        ) {
            Assertions.assertThrows(UnsupportedValueException::class.java) {
                TrigonometricFunctions(SinApprox).sin(x, precision)
            }
            Assertions.assertThrows(UnsupportedValueException::class.java) {
                TrigonometricFunctions(SinApprox).cos(x, precision)
            }
            Assertions.assertThrows(UnsupportedValueException::class.java) {
                TrigonometricFunctions(SinApprox).tan(x, precision)
            }
            Assertions.assertThrows(UnsupportedValueException::class.java) {
                TrigonometricFunctions(SinApprox).cot(x, precision)
            }
        }
    }
}
