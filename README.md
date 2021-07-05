# Trabajo Práctico TDD - Test Doubles

Trabajo Práctico de la asignatura **Programación Orientada a Objetos II** sobre desarrollo de test de unidad y la utilización de  _test doubles_  a lo largo del proceso de TDD.


## Inicio

* **Mantener en forma exhaustiva una suite de tests:** Producir una composición de tests y mantenerla a lo largo del programa, hasta extendiéndola en base a cada clase creada con su respectivo comportamiento con el objetivo de reducir el margen de error y poder encontrar bugs.

* **No deben utilizarse para testear otros objetos del dominio:** Queremos lograr Tests de Unidad, enfocados en testear el comportamiento de una única clase sin depender de sus objetos colaboradores. Ante esto, surge la necesidad de tener Test Doubles para estos últimos. El objetivo es que tengan un efecto nulo sobre el comportamiento de nuestra unidad bajo test o que podamos tenerlo controlado. 

* **Comunicar la intención del test:** Se debe mantener un orden y una claridad en cuanto a qué desea probar un test sobre una clase. El orden se logra, primero planteando el caso base (**setUp**), las acciones(**exercise**) y finalmente las pruebas(**verify**); y la claridad debe ser denotada por la expresividad mediante buenos nombres, comentarios e intencionalidad sobre cada prueba.



### Mockito

* En **Mockito**, puede indicarse que el **objeto mock** debe recibir un secuencia de mensajes particular en un orden preestablecido instanciando un **objeto** |InOrder|, pasándole al mismo los mocks que necesitan verificarse en orden. Ejemplo:

```java
List primero = mock(List.class);
List segundo = mock(List.class);
 
//usando cada lista mockeada
primero.add("fue llamado primero");
segundo.add("fue llamado segundo");
 
//instanciación objeto inOrder, pasándole los mocks que necesitan verificarse en orden
InOrder inOrder = inOrder(primero, segundo);
 
//verficamos que firstMock ha sido invocado antes que secondMock
inOrder.verify(primero).add("fue llamado primero");
inOrder.verify(segundo).add("fue llamado segundo");
```

* Para que un **objeto mock** esté preparado para recibir algunos mensajes sin importar el orden o la
obligatoriedad de recibirlos, podemos **programar** el comportamiento del mismo, indicando qué debe devolver cierto método.(Stubbing)

* Es posible anidar envíos de mensajes con Mockito. Al crear el mock object, debe agregarse junto a la clase a mockear, como segundo argumento, el enumerativo **RETURNS_DEEP_STUBS**, que permite y limita a cada verificación, a trabajar sobre el último mock object de la cadena, de la siguiente forma:

```java
ClasePrueba clase = mock(ClasePrueba.class, Mockito.RETURNS_DEEP_STUBS);
```


### Test Doubles

* **Test Doubles** es un concepto que hace referencia a aquellos tests unitarios en los cuales **todos** los objetos externos al **SUT** (System Under Testing), es decir, los colaboradores, son falsos. Para esto se hace uso de **Doubles** que imiten su estructura y comportamiento para verificar sólo llamadas y/o para que devuelvan en alguno de sus métodos, algo en específico que podamos programar al momento de testear.

* Los siguientes son los tipos de **Doubles** a usar en nuestros tests:


1. **Dummy Object:** Se utiliza el objeto sólo para que ocupe un lugar, pero **no** es utilizado. Generalmente usados para rellenar argumentos esperados.

2. **Stub**: Se utiliza el objeto para controlar la ejecución de algunos caminos difíciles de lograr para **inputs indirectos**; objetos utilizados para devolver ciertas respuestas a los mensajes que se les envíen. Existen 2 tipos de stubs: **OBSERVER** -> crear objeto que siempre responda a lo mismo (específico) - **SABOTEUR** -> Objeto que "se rompa" (lanzar excepción).

3. **Spy:** Utilizado para outputs indirectos. El SUT interactúa con un objeto externo y queremos testear esa interacción. En Mockito, con **verify**.

4. **Fake Object:** Objeto al que aún no tenemos acceso. A diferencia de los anteriores, este objeto tiene una lógica mas compleja y hasta podria necesitar test propios.

