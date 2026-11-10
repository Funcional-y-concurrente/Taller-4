package src.test.scala


final class `pruebas$_` {
def args = pruebas_sc.`args$`
def scriptPath = """src/test/scala/pruebas.sc"""
/*<script>*/
import Anagramas.*

// Casos de prueba de ejemplo según la guía:
// lOcPal("casa")
// combinaciones(lOcPal("casa"))
// val frase = List("cosas", "como", "yo")
// combinaciones(lOcFrase(frase))
// anagramasDeFrase(frase)

// ============================================================================
// CASOS DE PRUEBA (Se requieren al menos 5 casos propios por función)
// ============================================================================

// 1.2. Pruebas para lOcPal
// Caso 1:
lOcPal("casa")
// Caso 2:
lOcPal("mocosos")
// Caso 3:
lOcPal("")
// Caso 4:
// Caso 5:

// 1.2. Pruebas para lOcFrase
// Caso 1:
// Caso 2:
// Caso 3:
// Caso 4:
// Caso 5:

// 1.3. Pruebas para diccionarioPorOcurrencias
// Caso 1:
// Caso 2:
// Caso 3:
// Caso 4:
// Caso 5:

// 1.3. Pruebas para anagramasDePalabra
// Caso 1:
// Caso 2:
// Caso 3:
// Caso 4:
// Caso 5:

// 1.4. Pruebas para combinaciones
// Caso 1:
// Caso 2:
// Caso 3:
// Caso 4:
// Caso 5:

// 1.5. Pruebas para complemento
// Caso 1:
// Caso 2:
// Caso 3:
// Caso 4:
// Caso 5:

// 1.5. Pruebas para anagramasDeFrase
// Caso 1:
// Caso 2:
// Caso 3:
// Caso 4:
// Caso 5:

/*</script>*/ /*<generated>*//*</generated>*/
}

object pruebas_sc {
  private var `args$opt0` = Option.empty[Array[String]]
  def `args$set`(args: Array[String]): Unit = {
    `args$opt0` = Some(args)
  }
  def `args$opt`: Option[Array[String]] = `args$opt0`
  def `args$`: Array[String] = `args$opt`.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new `pruebas$_`

  def main(args: Array[String]): Unit = {
    `args$set`(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export pruebas_sc.script as `pruebas`

