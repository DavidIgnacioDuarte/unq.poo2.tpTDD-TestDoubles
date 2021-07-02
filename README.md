# Trabajo Práctico TDD - Test Doubles

Trabajo Práctico de la asignatura **Programación Orientada a Objetos II** sobre desarrollo de test de unidad y la utilización de  _test doubles_  a lo largo del proceso de TDD.


## Inicio

* **Mantener en forma exhaustiva una suite de tests:** Producir una composición de tests y mantenerla a lo largo del programa, hasta extendiéndola en base a cada clase creada con su respectivo comportamiento con el objetivo de reducir el margen de error y poder encontrar bugs.

* **No deben utilizarse para testear otros objetos del dominio:** Queremos lograr Tests de Unidad, enfocados en testear el comportamiento de una única clase sin depender de sus objetos colaboradores. Ante esto, surge la necesidad de tener Test Doubles para estos últimos. El objetivo es que tengan un efecto nulo sobre el comportamiento de nuestra unidad bajo test o que podamos tenerlo controlado. 

* **Comunicar la intención del test:** Se debe mantener un orden y una claridad en cuanto a qué desea probar un test sobre una clase. El orden se logra, primero planteando el caso base (**setUp**), las acciones(**exercise**) y finalmente las pruebas(**verify**); y la claridad debe ser denotada por la expresividad mediante buenos nombres, comentarios e intencionalidad sobre cada prueba.



