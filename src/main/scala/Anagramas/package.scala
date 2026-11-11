package object Anagramas {
  import scala.annotation.tailrec

  type Palabra = String
  type Frase = List[Palabra]
  type Ocurrencias = List[(Char, Int)]

  val diccionario: List[Palabra] = List(
    "cosas", "como", "yo", "y", "ocasos", "cayo", "mocosos", "roca", "moco", "sos"
  )

  def lOcPal(p: Palabra): Ocurrencias = {
    p.toList
      .groupBy(c => c)
      .toList
      .map({
        case (c, lista) => (c, lista.size)
      }).sortBy(_._1)
  }

  def lOcFrase(f: Frase): Ocurrencias = {
    val palabraUnida = f.mkString
    lOcPal(palabraUnida)
  }

  lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
    diccionario.groupBy(palabra => lOcPal(palabra)).withDefaultValue(Nil)
  }

  def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
    diccionarioPorOcurrencias(lOcPal(palabra))
  }

  def combinaciones(locurrencias: Ocurrencias): List[Ocurrencias] = {
    locurrencias match {
      case Nil => List(Nil)
      case (c, n) :: resto =>
        val combResto = combinaciones(resto)
        for {
          comb <- combResto
          cant <- 0 to n
        } yield if (cant == 0) comb else (c, cant) :: comb
    }
  }

  def complemento(lOc: Ocurrencias, slOc: Ocurrencias): Ocurrencias = {
    @tailrec
    def aux(acc: Ocurrencias, l: Ocurrencias, sl: Ocurrencias): Ocurrencias = {
      (l, sl) match {
        case (Nil, _) => acc.reverse
        case (resto, Nil) => acc.reverse ::: resto
        case ((c1, n1) :: t1, (c2, n2) :: t2) =>
          if (c1 == c2) {
            val dif = n1 - n2
            if (dif > 0) aux((c1, dif) :: acc, t1, t2)
            else aux(acc, t1, t2)
          } else {
            // Por el orden lexicográfico, c1 < c2, luego c1 no se resta
            aux((c1, n1) :: acc, t1, sl)
          }
      }
    }
    aux(Nil, lOc, slOc)
  }

  def anagramasDeFrase(sentence: Frase): List[Frase] = {
    def resolver(oc: Ocurrencias): List[Frase] = {
      if (oc.isEmpty) List(Nil)
      else {
        for {
          subOc <- combinaciones(oc)
          palabra <- diccionarioPorOcurrencias(subOc)
          restoFrase <- resolver(complemento(oc, subOc))
        } yield palabra :: restoFrase
      }
    }
    resolver(lOcFrase(sentence))
  }
}