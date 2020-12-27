import kotlin.math.*

interface ITrigonometricFunctions {
    fun sin(x: Double, precision: Double): Double
    fun cos(x: Double, precision: Double): Double
    fun tan(x: Double, precision: Double): Double
    fun cot(x: Double, precision: Double): Double
}

class TrigonometricFunctions(
    private val sinApprox: ISinApprox
) : ITrigonometricFunctions {

    override fun sin(x: Double, precision: Double): Double {
        val sin = sinApprox.sin(x, precision)
        return if (abs(sin) < precision) 0.0 else sin
    }

    override fun cos(x: Double, precision: Double): Double = sin(x + Math.PI / 2, precision)

    override fun tan(x: Double, precision: Double): Double {
        val cos = cos(x, precision)
        return if (cos == 0.0) Double.NaN else (sin(x, precision) / cos)
    }

    override fun cot(x: Double, precision: Double): Double {
        val tan = tan(x, precision)
        return if (tan == 0.0) Double.NaN else (1.0 / tan)
    }

}