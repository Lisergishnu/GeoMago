GeoMago
=======

Introducción
------------
##### En búsqueda de satisfacer nuestro tiempo libre o de ocio en alguna actividad fue que creamos un nuevo juego de mesa llamado GeoMago. Este juego se inspira en el ajedrez pero agregando nuevas reglas y dificultades dandole un toque original. El juego requiere un mínimo de 2 jugadores y pueden jugar hasta 4 personas. Cada jugador parte con 10 piezas, cada una con su característica especial que lo define, y debe eliminar las piezas de los contrincantes "comiendolas" con las suyas. Gana el último jugador con piezas restantes.

Análisis
------------
### Nuestra solución se basa principalmente en 4 tipos de objetos:
- **Ventana principal**: Se preocupa de unir todos los elementos del juego.
- **Logica del juego**: Motor del juego.
- **Piezas**: Se definen las habilidades de cada pieza y como interactuan.
- **Tablero**: Define las características de cuadro del tablero como también de su tamaño.
Por supuesto que cada una de estos tipos contiene uno más objetos para el funcionamiento del juego.
La combinación de estos elementos es lo que permite el funcionamiento del juego, en donde el único elemento externo al sistema es el o los jugadores humanos que deseen jugar. En caso de haber un solo jugador humano, esta disponible la modalidad de jugar contra el computador ya que se implemento una unidad de IA en el juego.
Por como se define el juego hay distintas formas de "usarlo" dependiendo de la cantidad de jugadores.

### A continuación se presentan los casos usuales de 2 jugadores:
- 	**Desafiar IA**  
    - **Propósito**: Vencer la inteligencia artificial del juego.  
    - **Actores**: Jugador humano y jugador IA.  
    - **Pre-Condiciones**: Ejecutar el juego.  
    - **Evento**: Nuevo juego con 2 jugadores, uno jugador humano.  
    - **Pos-Condiciones**: Finaliza el juego.  
    - **Tipo**: Manual, un turno por jugador.  
- 	**Desafiar otro jugador**  
    - **Propósito**: Vencer a otra jugador humano.  
    - **Actores**: Dos jugadores humanos.  
    - **Pre-Condiciones**: Ejecutar el juego.  
    - **Evento**: Nuevo juego con 2 jugadores humanos.  
    - **Pos-Condiciones**: Finaliza el juego.  
    - **Tipo**: Manual, un turno por jugador.  
- 	**Oberservar juego**  
    - **Propósito**: Recreativo, conocer la mecánica del juego.  
    - **Actores**: Dos jugadores IA.  
    - **Pre-Condiciones**: Ejecutar el juego.  
    - **Evento**: Nuevo juego con 2 jugadores IA.  
    - **Pos-Condiciones**: Finaliza el juego.  
    - **Tipo**: Automático, un turno por jugador.  
	
	
Los tres modos tienen su atractivo para ser empleados. El primero en caso de uno encontrarse solo y querer comprobar las habilades de uno con el computador, el segundo en caso de querer desafiar algun amigo y el tercero simplemente con el fin de distraerse y ver como se lleva acabo un "partido".

Arquitectura
------------
### A continuación se presentan distintos gráficos UML que presentan la interacción enter las distintas clases que componen el juego de manera que se entienda su estructura e implementación.

- **UML General**  
![alt text](https://raw.githubusercontent.com/Lisergishnu/GeoMago/master/etc/UML/General.png)

- **UML General 2**  
![alt text](https://raw.githubusercontent.com/Lisergishnu/GeoMago/master/etc/UML/prueba.png)

- **UML Relaciones Celdas**  
![alt text](https://raw.githubusercontent.com/Lisergishnu/GeoMago/master/etc/UML/RelacionesCeldas.png)

- **UML Relaciones entre piezas**  
![alt text](https://raw.githubusercontent.com/Lisergishnu/GeoMago/master/etc/UML/RelacionesPiezas.png)


### A continuación se presentan distintos UML de secuencia para enteder el funcionamiento del juego.

(insertar imagenes) 

Dificultades
------------
Durante el desarrollo del proyecto se presentaron algunas dificultades, a continuación se listan algunas de ellas:
- **Desarrollo de una IA**
- **Dibujar las distintas piezas**: Era necesario definir poligonos no previamente establecidos.
- **Motor del juego**: Lograr un motor que ejecutara de manera correcta el juego evitando "bugs".

Pruebas de uso
------------
A continuación se presentan los 3 casos de uso planteados en el análisis anterior:
- **Desafiar IA**: 
	![alt text](https://raw.githubusercontent.com/Lisergishnu/GeoMago/master/capturas/player_vs_IA.PNG)
	
- **Desafiar otro jugador**:
	![alt text](https://raw.githubusercontent.com/Lisergishnu/GeoMago/master/capturas/player_vs_player.PNG)
	
- **Oberservar juego**:
	![alt text](enlace)
	
Otros
------------
- Enlace a directorio del proyecto: (insertar enlace directorio en html)  
- Enlace a proyecto en GitHub:
[GeoMago](https://github.com/Lisergishnu/GeoMago).