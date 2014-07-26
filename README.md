GeoMago
=======

Introducci�n
------------
En b�squeda de satisfacer nuestro tiempo libre o de ocio en alguna actividad fue que creamos un nuevo juego de mesa llamado GeoMago. Este juego se inspira en el ajedrez pero agregando nuevas reglas y dificultades dandole un toque original. El juego requiere un m�nimo de 2 jugadores y pueden jugar hasta 4 personas. Cada jugador parte con 10 piezas, cada una con su caracter�stica especial que lo define, y debe eliminar las piezas de los contrincantes "comiendolas" con las suyas. Gana el �ltimo jugador con piezas restantes.

An�lisis
------------
Nuestra soluci�n se basa principalmente en 4 tipos de objetos:
- **Ventana principal**: Se preocupa de unir todos los elementos del juego.
- **Logica del juego**: Motor del juego.
- **Piezas**: Se definen las habilidades de cada pieza y como interactuan.
- **Tablero**: Define las caracter�sticas de cuadro del tablero como tambi�n de su tama�o.
Por supuesto que cada una de estos tipos contiene uno m�s objetos para el funcionamiento del juego.
La combinaci�n de estos elementos es lo que permite el funcionamiento del juego, en donde el �nico elemento externo al sistema es el o los jugadores humanos que deseen jugar. En caso de haber un solo jugador humano, esta disponible la modalidad de jugar contra el computador ya que se implemento una unidad de IA en el juego.
Por como se define el juego hay distintas formas de "usarlo" dependiendo de la cantidad de jugadores. A continuaci�n se presentan los casos usuales de 2 jugadores:
- **Jugador vs IA**
- **Jugador vs Jugador**
- **IA vs IA**
Los tres modos tienen su atractivo para ser empleados. El primero en caso de uno encontrarse solo y querer comprobar las habilades de uno con el computador, el segundo en caso de querer desafiar algun amigo y el tercero simplemente con el fin de distraerse y ver como se lleva acabo un "partido".

Dificultades
------------
Durante el desarrollo del proyecto se presentaron algunas dificultades, a continuaci�n se listan algunas de ellas:
- **Desarrollo de una IA**
- **Dibujar las distintas piezas**: Era necesario definir poligonos no previamente establecidos.
- **Motor del juego**: Lograr un motor que ejecutara de manera correcta el juego evitando "bugs".

Pruebas de uso
------------
A continuaci�n se presentan los 3 casos de uso planteados en el an�lisis anterior:
- **Jugador vs IA**: 
	(insertar imagen)
- **Jugador vs Jugador**:
	(insertar imagen)
- **IA vs IA**:
	(insertar imagen)