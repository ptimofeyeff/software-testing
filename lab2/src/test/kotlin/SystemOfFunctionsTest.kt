import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

class SystemOfFunctionsTest {

    fun mockTrigFunctions(
        x: Double,
        cos: Double,
        tan: Double,
        cot: Double,
        precision: Double
    ): ITrigonometricFunctions = Mockito.mock(ITrigonometricFunctions::class.java).apply {
        Mockito.`when`(cos(ArgumentMatchers.eq(x), ArgumentMatchers.eq(precision))).thenReturn(cos)
        Mockito.`when`(tan(ArgumentMatchers.eq(x), ArgumentMatchers.eq(precision))).thenReturn(tan)
        Mockito.`when`(cot(ArgumentMatchers.eq(x), ArgumentMatchers.eq(precision))).thenReturn(cot)
    }

    fun mockLogFunction(
        x: Double,
        log2: Double,
        log3: Double,
        log10: Double,
        lnX: Double,
        precision: Double
    ): ILogarithmicFunctions = Mockito.mock(ILogarithmicFunctions::class.java).apply {
        Mockito.`when`(logN(ArgumentMatchers.eq(x), ArgumentMatchers.eq(2.0), ArgumentMatchers.eq(precision)))
            .thenReturn(log2)
        Mockito.`when`(logN(ArgumentMatchers.eq(x), ArgumentMatchers.eq(3.0), ArgumentMatchers.eq(precision)))
            .thenReturn(log3)
        Mockito.`when`(logN(ArgumentMatchers.eq(x), ArgumentMatchers.eq(10.0), ArgumentMatchers.eq(precision)))
            .thenReturn(log10)
        Mockito.`when`(ln(ArgumentMatchers.eq(x), ArgumentMatchers.eq(precision)))
            .thenReturn(lnX)
    }

    @Nested
    inner class SystemOfFunctionsUnitTest {
        @ParameterizedTest
        @CsvFileSource(resources = ["/main-fun.csv"], numLinesToSkip = 1)
        fun `it computes system of functions`(
            x: Double,
            y: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            log2: Double,
            log3: Double,
            log10: Double,
            lnX: Double,
            precision: Double
        ) {
            val mockTrig = mockTrigFunctions(x, cos, tan, cot, precision)
            val mockLog = mockLogFunction(x, log2, log3, log10, lnX, precision)

            Assertions.assertEquals(y, SystemOfFunctions(mockTrig, mockLog).compute(x, precision), precision)
        }

        @ParameterizedTest
        @CsvFileSource(resources = ["/main-fun.csv"], numLinesToSkip = 1)
        fun `it integrates logarithmic functions`(
            x: Double,
            y: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            log2: Double,
            log3: Double,
            log10: Double,
            lnX: Double,
            precision: Double
        ) {
            val mockTrig = mockTrigFunctions(x, cos, tan, cot, precision)
            val logFunction = LogarithmicFunctions(NaturalLogarithmApprox)

            Assertions.assertEquals(y, SystemOfFunctions(mockTrig, logFunction).compute(x, precision), precision)
        }

        @ParameterizedTest
        @CsvFileSource(resources = ["/main-fun.csv"], numLinesToSkip = 1)
        fun `it integrates trigonometric functions`(
            x: Double,
            y: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            log2: Double,
            log3: Double,
            log10: Double,
            lnX: Double,
            precision: Double
        ) {
            val trigonometricFunctions = TrigonometricFunctions(SinApprox)
            val mockLog = mockLogFunction(x, log2, log3, log10, lnX, precision)

            Assertions.assertEquals(y, SystemOfFunctions(trigonometricFunctions, mockLog).compute(x, precision), precision)
        }

        @ParameterizedTest
        @CsvFileSource(resources = ["/main-fun.csv"], numLinesToSkip = 18)
        fun `it integrates both modules`(
            x: Double,
            y: Double,
            cos: Double,
            tan: Double,
            cot: Double,
            log2: Double,
            log3: Double,
            log10: Double,
            lnX: Double,
            precision: Double
        ) {
            val trigonometricFunctions = TrigonometricFunctions(SinApprox)
            val logFunction = LogarithmicFunctions(NaturalLogarithmApprox)

            Assertions.assertEquals(y, SystemOfFunctions(trigonometricFunctions, logFunction).compute(x, precision), precision)
        }
    }
}