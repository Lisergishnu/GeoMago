GeoMago
=======

Introducción
------------
En búsqueda de satisfacer nuestro tiempo libre o de ocio en alguna actividad fue que creamos un nuevo juego de mesa llamado GeoMago. Este juego se inspira en el ajedrez pero agregando nuevas reglas y dificultades dandole un toque original. El juego requiere un mínimo de 2 jugadores y pueden jugar hasta 4 personas. Cada jugador parte con 10 piezas, cada una con su característica especial que lo define, y debe eliminar las piezas de los contrincantes "comiendolas" con las suyas. Gana el último jugador con piezas restantes.

Análisis
------------
Nuestra solución se basa principalmente en 4 tipos de objetos:
- **Ventana principal**: Se preocupa de unir todos los elementos del juego.
- **Logica del juego**: Motor del juego.
- **Piezas**: Se definen las habilidades de cada pieza y como interactuan.
- **Tablero**: Define las características de cuadro del tablero como también de su tamaño.
Por supuesto que cada una de estos tipos contiene uno más objetos para el funcionamiento del juego.
La combinación de estos elementos es lo que permite el funcionamiento del juego, en donde el único elemento externo al sistema es el o los jugadores humanos que deseen jugar. En caso de haber un solo jugador humano, esta disponible la modalidad de jugar contra el computador ya que se implemento una unidad de IA en el juego.
Por como se define el juego hay distintas formas de "usarlo" dependiendo de la cantidad de jugadores. A continuación se presentan los casos usuales de 2 jugadores:
- **Jugador vs IA**
- **Jugador vs Jugador**
- **IA vs IA**
Los tres modos tienen su atractivo para ser empleados. El primero en caso de uno encontrarse solo y querer comprobar las habilades de uno con el computador, el segundo en caso de querer desafiar algun amigo y el tercero simplemente con el fin de distraerse y ver como se lleva acabo un "partido".

Dificultades
------------
Durante el desarrollo del proyecto se presentaron algunas dificultades, a continuación se listan algunas de ellas:
- **Desarrollo de una IA**
- **Dibujar las distintas piezas**: Era necesario definir poligonos no previamente establecidos.
- **Motor del juego**: Lograr un motor que ejecutara de manera correcta el juego evitando "bugs".

Pruebas de uso
------------
A continuación se presentan los 3 casos de uso planteados en el análisis anterior:
- **Jugador vs IA**: 
	(insertar imagen)
- **Jugador vs Jugador**:
	(insertar imagen)
- **IA vs IA**:
	(insertar imagen)