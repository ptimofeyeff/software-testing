fun main(args: Array<String>) {
    println("Hello World!")
}

fun factorial(x: Int): Int {
    if (x == 0) return 1
    var fact = 1
    for (i in 1..x) fact *= i
    return fact
}