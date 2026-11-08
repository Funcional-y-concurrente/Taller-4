package object Anagramas {
  type Palabra = String
  type Frase = List[Palabra]
  type Ocurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List(
    "cosas", "como", "yo", "y", "ocasos", "cayo", "mocosos", "roca", "moco", "sos"
  )

  def lOcPal(p: Palabra): Ocurrencias = {
    //
  }

  def lOcFrase(f: Frase): Ocurrencias = {
    //
  }

  lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
    //
  }

  def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
    //
  }

  def combinaciones(locurrencias: Ocurrencias): List[Ocurrencias] = {
    //
  }

  def complemento(lOc: Ocurrencias, slOc: Ocurrencias): Ocurrencias = {
    //
  }

  def anagramasDeFrase(sentence: Frase): List[Frase] = {
    //
  }
}
