2. Ejercicio 1
3. 
Dado el código proporcionado en la carpeta Ejercicio 1, responde a los siguientes puntos:

2.1 DESCRIPCIÓN Y RESPUÉSTAS

Escribe una breve memoria explicando el propósito del código que realiza la función combineOutputs. En ella,
contesta también a las siguientes cuestiones:
-¿Por qué en el código se usa la operación .copy?
-¿Por qué en el código se usan las operaciones .apply?
-¿Qué ocurriría si se cambiasen por un .also?
-¿Por qué es necesario utilizar la operación toMutableList?

La función combineOutputs nos devuelve un resultado de tipo CustomResult.
El objetivo de la funcion es combinar en RSuccess las variables priorityResult y secondaryResult cuando 
ambas son RSuccess segun la siguiente lógica:
Si priorityResult tiene el mismo id que secondaryResult entonces se suman las cantidades de los productos 
y se combinan las listas de proveedores.
Si no tienen los mismos Id, entonces devolvemos priorityResult sin ninguna modificación
Y devolvemos un error CustomResult.RCriticalError si priorityResult y/o secondaryResult no son RSuccess

-¿Por qué en el código se usa la operación .copy? 
Utilizamos copy para obtener una copia de product (id, amount, providers) en una instancia nueva.
De este modo no modificar el product de priorityResult.
En esta nueva copia, insertamos el nuevo amount y providers combinados.

-¿Por qué en el código se usan las operaciones .apply?
Apply nos permite utilizar un bloque de código dentro de un objeto y realizar las modificaciones 
necesarias ya que nos devolverá el objeto modificado.

-¿Qué ocurriría si se cambiasen por un .also?
Also nos pemitiría programar un bloque de codigo dentro de un objeto con la diferencia que also
no devuelve el objeto cambiado.

-¿Por qué es necesario utilizar la operación toMutableList?
Porque la lista puede que no sea Mutable, con toMutableList nos aseguramos que podemos realizar
modificaciones en ella.

2.2 TESTING

He realizado los siguientes Test que estan en el mismo archivo QuestionTest1.kt
'when both param are RSuccess and the same id return combine Outputs'
'when both param are RSuccess and not the same id return first without combine Outputs'
'when a param is not RSuccess return critical error'

Normalmente estarían ubicados estos test en la PackageName sección (test)

2.3 OPTIMIZACION

2.4 OPTIMIZACION


3. Ejercicio 2

3.1 DESARROLLO

Completada la función getMoviesInPlatforms en QuestionTest2.kt

3.2 TESTING

Realizados los siguientes tests en QuestionTest2.kt

`get movies in platforms result the movie that appears in platforms`
`get movies in platforms not return the movie that not appear in platforms`
`get movies in platforms return empty list when all movies don't have platform`

4. Ejercicio 3

Código realizado en QuestionTest3.kt


5. Ejercicio 4

5.1 DESARROLLO

Código realizado en QuestionTest4.kt

5.2 TESTING

Realizados los siguientes tests en QuestionTest4.kt

`when call combined let with two vaules execute lambda with values`
`when value1 is null does not execute lambda`
`when value2 is null does not execute lambda`
`when both values null does not execute lambda`


