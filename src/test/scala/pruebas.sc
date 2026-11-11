import Anagramas.*

// ---------------------------------------------------------------------------
// Auxiliar de verificación: imprime PASA/FALLA y falla si no coincide.
// ---------------------------------------------------------------------------
def check(nombre: String, obtenido: Any, esperado: Any): Unit = {
  val ok = obtenido == esperado
  println((if (ok) "PASA  " else "FALLA ") + "| " + nombre +
    (if (!ok) s"  | obtenido = $obtenido  | esperado = $esperado" else ""))
  assert(ok, nombre)
}

// ===========================================================================
// 1. lOcPal
// ===========================================================================
check("lOcPal(\"casa\")", lOcPal("casa"), List(('a', 2), ('c', 1), ('s', 1)))
check("lOcPal(\"mocosos\")", lOcPal("mocosos"), List(('c', 1), ('m', 1), ('o', 3), ('s', 2)))
check("lOcPal(\"ocasos\")", lOcPal("ocasos"), List(('a', 1), ('c', 1), ('o', 2), ('s', 2)))
check("lOcPal(\"cayo\")", lOcPal("cayo"), List(('a', 1), ('c', 1), ('o', 1), ('y', 1)))
check("lOcPal(\"moco\")", lOcPal("moco"), List(('c', 1), ('m', 1), ('o', 2)))
check("lOcPal(\"\")", lOcPal(""), Nil)

// ===========================================================================
// 2. lOcFrase
// ===========================================================================
check("lOcFrase([mocosos, y])", lOcFrase(List("mocosos", "y")),
  List(('c', 1), ('m', 1), ('o', 3), ('s', 2), ('y', 1)))

check("lOcFrase([moco, y, mocosos, casa])", lOcFrase(List("moco", "y", "mocosos", "casa")),
  List(('a', 2), ('c', 3), ('m', 2), ('o', 5), ('s', 3), ('y', 1)))

check("lOcFrase([manejar, por, cinco, horas])", lOcFrase(List("manejar", "por", "cinco", "horas")),
  List(('a', 3), ('c', 2), ('e', 1), ('h', 1), ('i', 1), ('j', 1), ('m', 1),
       ('n', 2), ('o', 3), ('p', 1), ('r', 3), ('s', 1)))

check("lOcFrase([jugar, con, mis, amigos])", lOcFrase(List("jugar", "con", "mis", "amigos")),
  List(('a', 2), ('c', 1), ('g', 2), ('i', 2), ('j', 1), ('m', 2),
       ('n', 1), ('o', 2), ('r', 1), ('s', 2), ('u', 1)))

check("lOcFrase([mis, plegarias, fueron, escuchadas])",
  lOcFrase(List("mis", "plegarias", "fueron", "escuchadas")),
  List(('a', 4), ('c', 2), ('d', 1), ('e', 3), ('f', 1), ('g', 1), ('h', 1),
       ('i', 2), ('l', 1), ('m', 1), ('n', 1), ('o', 1), ('p', 1), ('r', 2),
       ('s', 4), ('u', 2)))

check("lOcFrase([])", lOcFrase(Nil), Nil)

// ===========================================================================
// 3. diccionarioPorOcurrencias
// ===========================================================================
check("diccionarioPorOcurrencias(cosas)", diccionarioPorOcurrencias(lOcPal("cosas")), List("cosas"))
check("diccionarioPorOcurrencias(como)", diccionarioPorOcurrencias(lOcPal("como")), List("como", "moco"))
check("diccionarioPorOcurrencias(moco)", diccionarioPorOcurrencias(lOcPal("moco")), List("como", "moco"))
check("diccionarioPorOcurrencias(cayo)", diccionarioPorOcurrencias(lOcPal("cayo")), List("cayo"))
check("diccionarioPorOcurrencias(sos)", diccionarioPorOcurrencias(lOcPal("sos")), List("sos"))
check("diccionarioPorOcurrencias(zzz) usa el valor por defecto",
  diccionarioPorOcurrencias(lOcPal("zzz")), Nil)

// ===========================================================================
// 4. anagramasDePalabra
// ===========================================================================
check("anagramasDePalabra(cayo)", anagramasDePalabra("cayo"), List("cayo"))
check("anagramasDePalabra(yoca)", anagramasDePalabra("yoca"), List("cayo"))
check("anagramasDePalabra(y)", anagramasDePalabra("y"), List("y"))
check("anagramasDePalabra(ingenieria)", anagramasDePalabra("ingenieria"), Nil)
check("anagramasDePalabra(\"\")", anagramasDePalabra(""), Nil)
check("anagramasDePalabra(moco)", anagramasDePalabra("moco"), List("como", "moco"))

// ===========================================================================
// 5. combinaciones
// ===========================================================================
check("combinaciones([])", combinaciones(Nil), List(Nil))
check("combinaciones([(a,1)])", combinaciones(List(('a', 1))), List(Nil, List(('a', 1))))
check("combinaciones([(o,2)])", combinaciones(List(('o', 2))),
  List(Nil, List(('o', 1)), List(('o', 2))))

val comb2 = combinaciones(List(('a', 1), ('b', 1)))
check("combinaciones([(a,1),(b,1)]) tiene 4 sublistas", comb2.length, 4)
check("combinaciones([(a,1),(b,1)]) conjunto correcto", comb2.toSet,
  Set[List[(Char, Int)]](Nil, List(('a', 1)), List(('b', 1)), List(('a', 1), ('b', 1))))

val comb3 = combinaciones(List(('x', 2), ('y', 1)))
check("combinaciones([(x,2),(y,1)]) tiene 6 sublistas", comb3.length, 6)

val comb4 = combinaciones(List(('a', 2), ('b', 2)))
check("combinaciones([(a,2),(b,2)]) tiene 9 sublistas", comb4.length, 9)
check("combinaciones([(a,2),(b,2)]) conjunto correcto", comb4.toSet,
  Set[List[(Char, Int)]](
    Nil,
    List(('a', 1)),
    List(('a', 2)),
    List(('b', 1)),
    List(('a', 1), ('b', 1)),
    List(('a', 2), ('b', 1)),
    List(('b', 2)),
    List(('a', 1), ('b', 2)),
    List(('a', 2), ('b', 2))
  ))

// ===========================================================================
// 6. complemento
// ===========================================================================
check("complemento total", complemento(List(('a', 2), ('b', 1)), List(('a', 2), ('b', 1))), Nil)
check("complemento con slOc vacío", complemento(List(('a', 2), ('b', 1)), Nil),
  List(('a', 2), ('b', 1)))
check("complemento parcial", complemento(List(('a', 3), ('b', 2)), List(('a', 1), ('b', 2))),
  List(('a', 2)))
check("complemento con letra intermedia", complemento(List(('a', 1), ('c', 2), ('o', 1)), List(('c', 1))),
  List(('a', 1), ('c', 1), ('o', 1)))
check("complemento frase cayo", complemento(
  List(('a', 1), ('c', 2), ('m', 1), ('o', 4), ('s', 2), ('y', 1)),
  List(('a', 1), ('c', 1), ('o', 1), ('y', 1))),
  List(('c', 1), ('m', 1), ('o', 3), ('s', 2)))
check("complemento con cabeza distinta", complemento(List(('a', 1), ('b', 1)), List(('b', 1))),
  List(('a', 1)))

// ===========================================================================
// 7. anagramasDeFrase
// ===========================================================================
check("anagramasDeFrase([])", anagramasDeFrase(Nil), List(Nil))
check("anagramasDeFrase([sol, azul])", anagramasDeFrase(List("sol", "azul")), Nil)

val anaMoco = anagramasDeFrase(List("moco"))
check("anagramasDeFrase([moco]) tiene 2 anagramas", anaMoco.length, 2)
check("anagramasDeFrase([moco]) conjunto correcto", anaMoco.toSet,
  Set[List[String]](List("como"), List("moco")))

val frase1 = List("cayo", "mocosos")
val ana1 = anagramasDeFrase(frase1)
check("anagramasDeFrase([cayo, mocosos]) tiene 38 anagramas", ana1.length, 38)
check("anagramasDeFrase([cayo, mocosos]) contiene [cayo, mocosos]",
  ana1.contains(List("cayo", "mocosos")), true)
check("anagramasDeFrase([cayo, mocosos]) contiene [mocosos, cayo]",
  ana1.contains(List("mocosos", "cayo")), true)
check("anagramasDeFrase([cayo, mocosos]) conserva las ocurrencias",
  ana1.forall(f => lOcFrase(f) == lOcFrase(frase1)), true)
check("anagramasDeFrase([cayo, mocosos]) no tiene duplicados",
  ana1.distinct.length, ana1.length)

val frase2 = List("cosas", "como", "yo")
val ana2 = anagramasDeFrase(frase2)
check("anagramasDeFrase([cosas, como, yo]) tiene 38 anagramas", ana2.length, 38)
check("anagramasDeFrase([cosas, como, yo]) contiene la frase original",
  ana2.contains(List("cosas", "como", "yo")), true)
check("anagramasDeFrase([cosas, como, yo]) contiene [yo, como, cosas]",
  ana2.contains(List("yo", "como", "cosas")), true)
check("anagramasDeFrase([cosas, como, yo]) contiene [y, como, ocasos]",
  ana2.contains(List("y", "como", "ocasos")), true)
check("anagramasDeFrase([cosas, como, yo]) contiene [cayo, mocosos]",
  ana2.contains(List("cayo", "mocosos")), true)
check("anagramasDeFrase([cosas, como, yo]) conserva las ocurrencias",
  ana2.forall(f => lOcFrase(f) == lOcFrase(frase2)), true)
check("anagramasDeFrase([cosas, como, yo]) no tiene duplicados",
  ana2.distinct.length, ana2.length)

val frase3 = List("yo", "como", "cosas")
val ana3 = anagramasDeFrase(frase3)
check("anagramasDeFrase([yo, como, cosas]) tiene 38 anagramas", ana3.length, 38)
check("anagramasDeFrase([yo, como, cosas]) contiene la frase original",
  ana3.contains(List("yo", "como", "cosas")), true)
check("anagramasDeFrase: [cayo,mocosos] y [cosas,como,yo] producen el mismo conjunto",
  ana1.toSet, ana2.toSet)

println("TODAS LAS PRUEBAS PASARON")
