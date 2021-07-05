# Trabajo Práctico TDD - Test Doubles

Trabajo Práctico de la asignatura **Programación Orientada a Objetos II** sobre desarrollo de test de unidad y la utilización de  _test doubles_  a lo largo del proceso de TDD.


## Inicio

* **Mantener en forma exhaustiva una suite de tests:** Producir una composición de tests y mantenerla a lo largo del programa, hasta extendiéndola en base a cada clase creada con su respectivo comportamiento con el objetivo de reducir el margen de error y poder encontrar bugs.

* **No deben utilizarse para testear otros objetos del dominio:** Queremos lograr Tests de Unidad, enfocados en testear el comportamiento de una única clase sin depender de sus objetos colaboradores. Ante esto, surge la necesidad de tener Test Doubles para estos últimos. El objetivo es que tengan un efecto nulo sobre el comportamiento de nuestra unidad bajo test o que podamos tenerlo controlado. 

* **Comunicar la intención del test:** Se debe mantener un orden y una claridad en cuanto a qué desea probar un test sobre una clase. El orden se logra, primero planteando el caso base (**setUp**), las acciones(**exercise**) y finalmente las pruebas(**verify**); y la claridad debe ser denotada por la expresividad mediante buenos nombres, comentarios e intencionalidad sobre cada prueba.



## Mockito

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



