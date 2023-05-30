package com.cibertec.cibertecapp

fun main() {

    var nume = 6
    print(nume++)
    print(nume--)

    // 1. Variables
    var edad = 30
    val correo = "jorge@gmail.com"

    // 2. Deducción de Tipos
    var pais: String = "Perú"
    var anio: Int = 2023

    // 3. Tipos de Datos
    val status: Boolean = false

    val intShort: Short // 16 bits
    var intLong: Long // 64 bits
    var intStan: Int // 32 bits
    var int: Byte //8 bits

    val cost: Double = 12.56 // 64 bits
    var myFloat: Float = 12.56F // 32 bits

    var myChar: Char = 'a'

    // 4. Arreglos
    // Array Simple
    val myArray = arrayOf(4,2,4,7,8)
    print(myArray[0])

    // Array Mixto
    val myArrayMix = arrayOf(4,2, "Jorge", false)
    print(myArrayMix[0])

    val myArrayInt = arrayOf<Int> (1,2,3,4,5)
    val myArrayInt2 = intArrayOf(1,2,3,4,5)
    charArrayOf('a', 'e')
    booleanArrayOf(true, false)
    longArrayOf(1,2)
    shortArrayOf(1,2)
    byteArrayOf(1,2)

    // Listas
    val frutas = listOf("manzana", "mandarina", "mango")
    for (fruta in frutas) {
        println(fruta)
    }

    // 5. Operadores
    println(4 + 4)
    println(5 - 4)
    println(5 * 5)
    println(20 / 5)
    println(9 % 4) // modulo
    var num = 9
    println(++num)
    println(--num)

    // 6. Condicionales
    val numeroDia: Int = 3
    if (numeroDia == 3) {
        println("Los numero son iguales")
    } else if (numeroDia > 5) {
        println("El numero es mayor")
    } else {
        println("El numero es menor")
    }

    // 7. FOR
    val frutasAlt = listOf("manzana", "mandarina", "mango")
    for (fruta in frutasAlt) {
        println(fruta)
    }

    val lenguajesProgramacion = listOf("java", "kotlin", "swift")
    for (index in lenguajesProgramacion.indices) {
        println("El lenguaje es " + lenguajesProgramacion[index])
    }

    // 8. While
    var i = 1
    while (i <= 5) {
        println("Linea $i")
        ++i
    }

    // 9. Do While
    var maximo: Int = 10
    var contador: Int = 0
    do {
        println("Contador es: $contador")
        ++contador
    } while (contador <= maximo)


    // 10. When
    val mes: Int = 4
    val salida: String = when(mes) {
        1 -> "Enero"
        2 -> "Febrero"
        else -> "Verifique el dato"
    }

    val n = 4
    when(n) {
        1, 2, 3 -> println("Valor positivo menor a 4")
        0 -> println("Valor cero")
        -1, -2 -> println("Valor negativo mayor a -3")
    }




}



