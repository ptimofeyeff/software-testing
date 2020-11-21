import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.nio.file.Path

class CsvPrinterTest {

    private val trigFunctions = TrigonometricFunctions(SinApprox)
    private val logFunctions = LogarithmicFunctions(NaturalLogarithmApprox)
    private val mainFunction = SystemOfFunction(trigFunctions, logFunctions)
    lateinit var outPath: String

    @BeforeEach
    fun initTmpDir(@TempDir tempDir: Path) {
        outPath = tempDir.resolve("test").toString()
    }

    @Test
    fun `it computes cos(x)`() {
        printCsv("cos", -3.14159265, 0.5235987, 13, outPath)
        val (cosHeader, cosValues) = collectCsvPrinterResults(outPath)

        Assertions.assertEquals("x,cos(x)", cosHeader)
        Assertions.assertEquals(13, cosValues.size)
        cosValues.forEach { Assertions.assertEquals(trigFunctions.cos(it.first, 1e-6), it.second, 1e-6) }
    }

    @Test
    fun `it computes tan(x)`() {
        printCsv("tan", -3.14159265, 0.5235987, 13, outPath)
        val (tanHeader, tanValues) = collectCsvPrinterResults(outPath)

        Assertions.assertEquals("x,tan(x)", tanHeader)
        Assertions.assertEquals(13, tanValues.size)
        tanValues.forEach { Assertions.assertEquals(trigFunctions.tan(it.first, 1e-6), it.second, 1e-6) }
    }

    @Test
    fun `it computes cot(x)`() {
        printCsv("cot", -3.14159265, 0.5235987, 13, outPath)
        val (cotHeader, cotValues) = collectCsvPrinterResults(outPath)

        Assertions.assertEquals("x,cot(x)", cotHeader)
        Assertions.assertEquals(13, cotValues.size)
        cotValues.forEach { Assertions.assertEquals(trigFunctions.cot(it.first, 1e-6), it.second, 1e-6) }
    }

    @Test
    fun `it computes ln(x)`() {
        printCsv("ln", 0.001, 0.5, 10, outPath)
        val (logHeader, logValues) = collectCsvPrinterResults(outPath)
        Assertions.assertEquals("x,ln(x)", logHeader)
        Assertions.assertEquals(10, logValues.size)
        logValues.forEach { Assertions.assertEquals(logFunctions.ln(it.first, 1e-6), it.second, 1e-6) }
    }

    @Test
    fun `it computes log2(x)`() {
        printCsv("log2", 0.001, 0.5, 10, outPath)
        val (logHeader, logValues) = collectCsvPrinterResults(outPath)
        Assertions.assertEquals("x,log2(x)", logHeader)
        Assertions.assertEquals(10, logValues.size)
        logValues.forEach { Assertions.assertEquals(logFunctions.logN(it.first, 2.0, 1e-6), it.second, 1e-6) }
    }

    @Test
    fun `it computes log3(x)`() {
        printCsv("log3", 0.001, 0.5, 10, outPath)
        val (logHeader, logValues) = collectCsvPrinterResults(outPath)
        Assertions.assertEquals("x,log3(x)", logHeader)
        Assertions.assertEquals(10, logValues.size)
        logValues.forEach { Assertions.assertEquals(logFunctions.logN(it.first, 3.0, 1e-6), it.second, 1e-6) }
    }

    @Test
    fun `it computes log10(x)`() {
        printCsv("log10", 0.001, 0.5, 10, outPath)
        val (logHeader, logValues) = collectCsvPrinterResults(outPath)
        Assertions.assertEquals("x,log10(x)", logHeader)
        Assertions.assertEquals(10, logValues.size)
        logValues.forEach { Assertions.assertEquals(logFunctions.logN(it.first, 10.0, 1e-6), it.second, 1e-6) }
    }

    @Test
    fun `it computes f(x)`() {
        printCsv("f", -6.28318531, 1.57079633, 10, outPath)
        val (fHeader, fValues) = collectCsvPrinterResults(outPath)
        Assertions.assertEquals("x,f(x)", fHeader)
        Assertions.assertEquals(10, fValues.size)
        fValues.forEach { Assertions.assertEquals(mainFunction.compute(it.first, 1e-6), it.second, 1e-6) }
    }

    @Test
    fun `UnsupportedFunctionException for invalid functions`() {
        Assertions.assertThrows(UnsupportedFunctionException::class.java) {
            printCsv("lol", 1.0, 2.0, 3)
        }
    }

    private fun collectCsvPrinterResults(outputPath: String): Pair<String, List<Pair<Double, Double>>> {
        val lines = File(outputPath).readText().splitToSequence("\n").iterator()
        val header = lines.next()
        val values = lines.asSequence().map { it.split(",") }.map { Pair(it[0].toDouble(), it[1].toDouble()) }
        return Pair(header, values.toList())
    }

}