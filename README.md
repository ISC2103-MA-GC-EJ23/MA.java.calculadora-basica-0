## Ej-Calculadora básica

Proyecto básico de una calculadora aritmética para diversas prácticas.

En su version inicial solo suma.

* Ejecute su programa con el comando:
```
gradle run
```

* Pruebe su programa ejecutando las pruebas unitarias con el comando:
```
gradle test
```
# Instalacion Gradle

En caso de mal funcionamiento de gradle se puede desintalar/instalar:
```
sdk uninstall gradle 8.0.2
sdk install gradle
```
* Gradle disponibles en la máquina virtual
```
sdk list gradle
```

* Por cada cambio importante que haga, actualice su historia usando los comandos:
```
git add .
git commit -m "Descripción del cambio"
```

* Envíe sus actualizaciones a GitHub con el comando:

```
git push origin main
```
### Generando el archivo JAR

Asegurese de tener incluido el siguiente código en el archivo build.gradle:
```
jar {
  manifest {
   attributes 'Main-Class': 'calculadora.App'
  }
}
```
Genere el archivo jar
```
gradle jar
```
El archivo JAR se genera en el directorio:

```
app/build/libs/app.jar
```
Puede ejecutar la aplicación en la línea de comandos con:

```
java -cp wsCalculadora.jar wsCalculadora.App
```
# Trabajo en Equipo

Revisa [LiveShare](https://youtu.be/9QXwSg9-2qQ). Revisa el [uso de LiveShare](https://www.youtube.com/watch?v=nj535VbE9pQ). Disponible para este repositorio.
# Publicando la Imagen a Docker Hub
### Construyendo imagen local Docker
```
docker build -t japp .
```
### Levantando el contenedor Docker-Java a partir de la imagen creada localmente
```
docker run japp
```
### Subiendo la imagen al Docker Hub

```
docker tag local-image:tagname new-repo:tagname
docker push new-repo:tagname

** Ejemplo:
docker tag japp:latest ricardoqm/calculadora:latest
docker push ricardoqm/calculadora:latest

```

### Levantando el contenedor Docker-Java a partir de la imagen disponible en Docker Hub
```
docker run ricardoqm/calculadora:latest
```

# Publicando la Imagen a GitHub Package

### Crear un Personal Access Token en GitHub

1. Ir al perfil de usuario (esquina superior izquierda de Página princial)
2. ```Settings / Developer Settings```
3. ```Personal / Access Token /Tokens (classic) / Generate New Token / Generate New Token (classic)```
4. Capturar en ```Note``` una descripción del Token (Ej.-```PAT Package Management```)
5. Seleccionar ```Expiration``` (Tiempo de vigencia del Token)
6. Activar ```write:packages \ read:packages \ delete:packages```
7. Dar clic en ```Generate Token```.
8. Guardar la secuencia alfanumérica generada y que representa el Personal Access Token (no se volverá a mostrar).

### Construyendo imagen local Docker

En su ambiente de programación (local o Codespaces):

Crea la variable de ambiente ```CR_PAT```:

```
$ export CR_PAT=<secuencia alfanumérica del Personal Access Token>
```
Autentificarse en el Package Registry de GitHub:

```
$ echo $CR_PAT | docker login ghcr.io -u ricardo-qm --password-stdin
```

Suponiendo que se desea generar el paquete en la organización ```TMP-MA``` (si fuera en el perfil peronsal, cambiar ```TMP-MA``` por ```ricardo-qm```):

```
docker build -t ghcr.io/tmp-ma/japp:latest .
```
### Levantando el contenedor Docker-Java a partir de la imagen creada localmente
```
docker run ghcr.io/tmp-ma/japp:latest
```
### Subiendo la imagen al GitHub Package Registry:

```
docker push ghcr.io/tmp-ma/japp:latest

```
### Levantando el contenedor Docker-Java a partir de la imagen disponible en GitHub Packages
```
docker run ghcr.io/tmp-ma/japp:latest
```

Por default la imagen tendría una visibilidad ```private```, si de desea cambiar a ```public``` ir a ```Settings/Packages```
en la organización.
