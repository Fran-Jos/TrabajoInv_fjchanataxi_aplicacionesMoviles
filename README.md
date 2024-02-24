Aplicación Móvil "Plaza la Merced"

Descripción
Esta aplicación móvil es un proyecto que incluye un sistema de autenticación con Firebase Authentication y utiliza el patrón de arquitectura limpia. Además, integra funcionalidades para consumir tres APIs públicas: TheCocktailDB, Fruityvice y Dog API. El proyecto está desarrollado en Kotlin y utiliza diversas dependencias para implementar características como la carga de imágenes, manipulación de datos con Room, manejo de corutinas, consumo de servicios web con KTOR, entre otros.

Funcionalidades Principales
La aplicación móvil ofrece las siguientes funcionalidades principales:

Inicio de Sesión con Firebase Authentication: Los usuarios pueden autenticarse en la aplicación utilizando sus credenciales de Firebase Authentication, lo que les permite acceder a funcionalidades personalizadas y protegidas.
Exploración de Listados: La aplicación muestra listados de datos provenientes de las APIs públicas integradas. Estos listados pueden incluir información sobre cócteles, frutas o imágenes de perros, dependiendo de la opción seleccionada por el usuario.
Visualización Detallada: Al seleccionar un elemento específico de la lista, los usuarios pueden ver detalles adicionales sobre el elemento seleccionado, como recetas de cócteles, información nutricional de frutas o detalles de razas de perros, según corresponda.
Arquitectura Limpia y Eficiente: La aplicación sigue los principios de arquitectura limpia para garantizar un código modular, mantenible y testeable. Esto permite una fácil escalabilidad y adaptabilidad a futuras actualizaciones y cambios en los requisitos del proyecto.

Dependencias Principales
Swipe RecyclerView: Se utiliza para la implementación de la vista de lista con capacidad de deslizamiento.
Room: Librería para la persistencia de datos en la base de datos local del dispositivo.
Coil: Para la carga de imágenes de manera eficiente en la aplicación.
Lottie: Librería para la reproducción de animaciones en formato Lottie.
Coroutines: Para la ejecución asíncrona de operaciones de larga duración sin bloquear el hilo principal.
Firebase Authentication y Firestore: Se utilizan para la autenticación de usuarios y la gestión de la base de datos en la nube respectivamente.
KTOR Client: Para realizar peticiones HTTP a servicios web externos.
Kotlin Serialization: Para la serialización y deserialización de datos en formato JSON.
APIs Utilizadas
TheCocktailDB: API para obtener información sobre cócteles y bebidas.
Fruityvice: API para obtener información sobre frutas y sus propiedades nutricionales.
Dog API: API para obtener imágenes y datos sobre perros.
Patrón de Arquitectura
La aplicación móvil sigue el patrón de arquitectura limpia (Clean Architecture), separando las capas de presentación, dominio y datos para lograr un código modular, mantenible y testeable.

Notas adicionales
Asegúrese de configurar adecuadamente las claves de API necesarias para el funcionamiento de las diferentes funcionalidades, así como de establecer las reglas de seguridad adecuadas en Firebase para garantizar la protección de los datos de los usuarios. Además, revise la documentación de cada API utilizada para comprender sus respectivos límites y requisitos de uso.

Anexos:
![image](https://github.com/Fran-Jos/TrabajoInv_fjchanataxi_aplicacionesMoviles/assets/117785897/53730a1f-6aa1-4866-99a3-4c40a2481108)
![image](https://github.com/Fran-Jos/TrabajoInv_fjchanataxi_aplicacionesMoviles/assets/117785897/572e2c60-e12e-47d2-9ee4-062e994fe1ae)
![image](https://github.com/Fran-Jos/TrabajoInv_fjchanataxi_aplicacionesMoviles/assets/117785897/1fc8fede-6719-4432-868b-d337fdd84329)
![image](https://github.com/Fran-Jos/TrabajoInv_fjchanataxi_aplicacionesMoviles/assets/117785897/8ddb5cbb-8cf9-4afa-9a89-0c4dd70f561b)
![image](https://github.com/Fran-Jos/TrabajoInv_fjchanataxi_aplicacionesMoviles/assets/117785897/5bae76ca-c17a-44bf-b913-43fad5fe81d0)
![image](https://github.com/Fran-Jos/TrabajoInv_fjchanataxi_aplicacionesMoviles/assets/117785897/6571ba01-c57f-43a7-ae0f-d1919f418d8e)
![image](https://github.com/Fran-Jos/TrabajoInv_fjchanataxi_aplicacionesMoviles/assets/117785897/31d07bf7-9c41-415e-be49-0b6555aa1839)
![image](https://github.com/Fran-Jos/TrabajoInv_fjchanataxi_aplicacionesMoviles/assets/117785897/c346c6a9-aa99-4486-b394-9bc10cc222b9)








