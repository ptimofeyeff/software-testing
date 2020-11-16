interface ILogarithmicFunctions {
    fun logN(x: Double, n: Double, precision: Double): Double
    fun ln(x: Double, precision: Double): Double
}

class LogarithmicFunctions(
    private val lnApprox: INaturalLogarithmApprox
) : ILogarithmicFunctions {

    override fun logN(x: Double, n: Double, precision: Double): Double {
        if (x <= precision) throw UnsupportedValueException()
        return lnApprox.ln(x, precision / 1000) / lnApprox.ln(n, precision / 1000)
    }

    override fun ln(x: Double, precision: Double) = lnApprox.ln(x, precision / 1000)
}