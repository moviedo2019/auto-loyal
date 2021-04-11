# auto-loyal

# Preparación de entorno de testing automatizado

Esta guía sirve para ayudar a preparar el entorno de testing automatizado con todas las herramientas de software necesarias para trabajar.

En primer lugar, se necesitará descargar el siguiente software:

* Java JDK 8 (1.8.0_231)
* Maven
* TestNG 
* Eclipse IDE
* Chromedriver 89

# Ejecutar test en TestNG
1. Dirigirse a Eclipse, en la barra de Menú entrar a la opción *Run* → *Run configurations...*
2. Seleccionar el proyecto automation-app
2. Seleccionar la clase/test/suite/método/grupo que se desea ejecutar y hacer click en el botón "*Apply*".
3. Hacer click en el botón "*Run*".


# Estructura del proyecto

* En la carpeta src/main/java se encuentra las page de la web y las properties que son utilizadas en los test y pages.
* En la carpeta src/test/java se encuentra los test con su metodo que realiza los pasos del test case.
* En la carpeta drivers esta el driver del browser que van ser usados por el test.
* A nivel raiz del proyecto esta el POM y la suite testNG para ejecutar en un Jenkins.
* En la carpeta test-output se encuentra el reporte del testNG "index.html"
