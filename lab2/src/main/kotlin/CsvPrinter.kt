import java.io.File
import java.util.*
import kotlin.math.abs
import kotlin.math.log10

const val precision = 1e-6

val availableFunctions = mapOf<String, (Double) -> Double>(
    "cos" to ({ x -> TrigonometricFunction(SinApprox).cos(x, precision) }),
    "tan" to ({ x -> TrigonometricFunction(SinApprox).tan(x, precision) }),
    "cot" to ({ x -> TrigonometricFunction(SinApprox).cot(x, precision) }),
    "ln" to ({ x -> LogarithmicFunctions(NaturalLogarithmApprox).ln(x, precision) }),
    "log2" to ({ x -> LogarithmicFunctions(NaturalLogarithmApprox).logN(x, 2.0, precision) }),
    "log3" to ({ x -> LogarithmicFunctions(NaturalLogarithmApprox).logN(x, 3.0, precision) }),
    "log10" to ({ x -> LogarithmicFunctions(NaturalLogarithmApprox).logN(x, 10.0, precision) }),

    "f" to ({ x ->
        SystemOfFunction(
            TrigonometricFunction(SinApprox),
            LogarithmicFunctions(NaturalLogarithmApprox)
        ).compute(x, precision)
    })
)

fun printCsv(functionName: String, from: Double, step: Double, count: Int) {
    val function = availableFunctions[functionName] ?: throw UnsupportedFunctionException()

    val xs = generateSequence(from) { (it + step).roundToPlaces(precision.getCountOfDigits()) }.take(count)
    val ys = xs.map(function)

    val csv = xs.zip(ys).joinToString("\n", prefix = "x,${functionName}(x)\n") { (x, y) ->
        "%.8f,%.8f".format(Locale.ENGLISH, x, y)
    }
    File("${functionName}.csv").writeText(csv)
}


fun Double.roundToPlaces(places: Int) = "%.${places}f".format(Locale.ENGLISH, this).toDouble()


fun Double.getCountOfDigits() = abs(log10(this).toInt())


fun main() {
    printCsv("sin", 1.0, 1.0, 9)
}