<em>2. Ejercicio 1</em>

<p>Dado el código proporcionado en la carpeta Ejercicio 1, responde a los siguientes puntos:</p>

2.1 DESCRIPCIÓN Y RESPUÉSTAS

<p>Escribe una breve memoria explicando el propósito del código que realiza la función combineOutputs. En ella,
contesta también a las siguientes cuestiones:
-¿Por qué en el código se usa la operación .copy?
-¿Por qué en el código se usan las operaciones .apply?
-¿Qué ocurriría si se cambiasen por un .also?
-¿Por qué es necesario utilizar la operación toMutableList?</p>

<br>La función combineOutputs nos devuelve un resultado de tipo CustomResult.<br>
El objetivo de la funcion es combinar en RSuccess las variables priorityResult y secondaryResult cuando 
ambas son RSuccess segun la siguiente lógica:</br>
Si priorityResult tiene el mismo id que secondaryResult entonces se suman las cantidades de los productos 
y se combinan las listas de proveedores.</br>
Si no tienen los mismos Id, entonces devolvemos priorityResult sin ninguna modificación
Y devolvemos un error CustomResult.RCriticalError si priorityResult y/o secondaryResult no son RSuccess
</p>

<p>-¿Por qué en el código se usa la operación .copy? </br>
Utilizamos copy para obtener una copia de product (id, amount, providers) en una instancia nueva.
De este modo no modificar el product de priorityResult.
En esta nueva copia, insertamos el nuevo amount y providers combinados.</p>

<p>-¿Por qué en el código se usan las operaciones .apply?</br>
Apply nos permite utilizar un bloque de código dentro de un objeto y realizar las modificaciones 
necesarias ya que nos devolverá el objeto modificado.</p>

<p>-¿Qué ocurriría si se cambiasen por un .also?</br>
Also nos pemitiría programar un bloque de codigo dentro de un objeto con la diferencia que also
no devuelve el objeto cambiado.</p>

<p>-¿Por qué es necesario utilizar la operación toMutableList?</br>
Porque la lista puede que no sea Mutable, con toMutableList nos aseguramos que podemos realizar
modificaciones en ella.</p>

2.2 TESTING

<p>He realizado los siguientes Test que estan en el mismo archivo QuestionTest1.kt<br/>
'when both param are RSuccess and the same id return combine Outputs'<br/>
'when both param are RSuccess and not the same id return first without combine Outputs'<br/>
'when a param is not RSuccess return critical error'</p>

<p>Normalmente estarían ubicados estos test en la PackageName sección (test)</p>

2.3 OPTIMIZACION

2.4 OPTIMIZACION


3. Ejercicio 2

3.1 DESARROLLO

<p>Completada la función getMoviesInPlatforms en QuestionTest2.kt</p>

3.2 TESTING

<p>Realizados los siguientes tests en QuestionTest2.kt<br/>

`get movies in platforms result the movie that appears in platforms`<br/>
`get movies in platforms not return the movie that not appear in platforms`<br/>
`get movies in platforms return empty list when all movies don't have platform`</p>

4. Ejercicio 3

<p>Código realizado en QuestionTest3.kt</p>


5. Ejercicio 4

5.1 DESARROLLO

<p>Código realizado en QuestionTest4.kt</p>

5.2 TESTING

<p>Realizados los siguientes tests en QuestionTest4.kt<br/>

`when call combined let with two vaules execute lambda with values`<br/>
`when value1 is null does not execute lambda`<br/>
`when value2 is null does not execute lambda`<br/>
`when both values null does not execute lambda`<p>


