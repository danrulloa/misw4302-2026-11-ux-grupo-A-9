# Gestión de Medicamentos de la Familia

**La app que cuida a tu familia cuando tú no puedes estar ahí.**

Esta app nace de un problema real: las familias colombianas cuidan a múltiples personas — hijos, padres mayores que viven lejos, incluso mascotas — y no existe una forma unificada de saber si todos están tomando sus medicamentos correctamente. Una dosis olvidada puede ser una molestia; una dosis doble puede ser peligrosa.

Nuestra investigación con 30 usuarios reveló que el 40% usa las alarmas del celular para recordar medicamentos, pero ninguna app del mercado ofrece visibilidad compartida entre cuidadores. Esta app resuelve esto: un solo lugar donde toda la familia puede gestionar alarmas de medicamentos, confirmar la toma y coordinar el cuidado, desde la web o desde el celular.

## Proyecto académico

| | |
|---|---|
| **Curso** | UX - Mejoramiento de la Experiencia de Usuario |
| **Programa** | Maestría en Ingeniería de Software (MISO) - Universidad de los Andes |
| **Equipo** | Grupo A-9: Daniel Ulloa · David Cruz |
| **Repositorio** | https://github.com/danrulloa/misw4302-2026-11-ux-grupo-A-9.git |

## Estructura del repositorio

```
misw4302-2026-11-ux-grupo-A-9/
├── web/              → Aplicación Web (Angular 21)
│   ├── src/app/
│   │   ├── pages/                # Pantallas de la aplicación
│   │   ├── components/           # Componentes de layout
│   │   └── shared/
│   │       ├── components/       # Design System (componentes reutilizables)
│   │       └── services/         # Servicios compartidos
│   └── public/assets/            # Imágenes y recursos
└── mobile/           → Aplicación Mobile (Android - Jetpack Compose)
    └── app/src/main/java/.../ui/
        ├── screens/              # Pantallas
        ├── components/           # Componentes reutilizables
        ├── navigation/           # Navegación
        └── theme/                # Tema y estilos
```

---

## Aplicación Web

Prototipo interactivo de alta fidelidad desarrollado en **Angular 21** con SCSS y Material Icons.

### Requisitos previos

- [Node.js](https://nodejs.org/) v18 o superior (incluye npm)

### Instalación y ejecución

```bash
# Clonar el repositorio
git clone https://github.com/danrulloa/misw4302-2026-11-ux-grupo-A-9.git

# Entrar a la carpeta web
cd misw4302-2026-11-ux-grupo-A-9/web

# Instalar dependencias
npm install

# Iniciar servidor de desarrollo
npx ng serve
```

Abrir en el navegador: **http://localhost:4200/**

### Pantallas y flujo de navegación

```
Registro → Selección de Perfil → Crear Perfil Familiar → Selección con Familiar
                                        ↑ Cancelar vuelve
```

| Pantalla | Ruta | Descripción |
|---|---|---|
| Registro | `/registro` | Formulario de registro con validación de campos |
| Selección de Perfil | `/seleccion-perfil` | Perfil del usuario con opción de agregar familiares |
| Crear Perfil Familiar | `/crear-perfil` | Formulario con dropdown de relación y campo de correo condicional |
| Selección con Familiar | `/seleccion-perfil-familiar` | Vista con perfil propio y perfil familiar creado |

### Design System

| Token | Valor |
|---|---|
| Primario | `#3A7CA5` |
| Secundario | `#6BA2BA` |
| Acento | `#4EC5C1` |
| Error | `#D9534F` |
| Fuente primaria | Nunito |
| Fuente secundaria | Roboto |

Componentes reutilizables: `text-field`, `ds-button`, `profile-card`, `navbar-auth`, `page-background`, `divider`, `add-family-card`, `confirm-dialog`

### Build de producción

```bash
cd web
npx ng build
```

Archivos generados en `web/dist/medicamentos-app/`.

---

## Aplicación Mobile

Prototipo interactivo de alta fidelidad desarrollado en **Kotlin** con **Jetpack Compose** para Android.

### Requisitos previos

- [Android Studio](https://developer.android.com/studio) (última versión estable)

### Instalación y ejecución con Android Studio

```bash
# Clonar el repositorio
git clone https://github.com/danrulloa/misw4302-2026-11-ux-grupo-A-9.git
```

1. Abrir **Android Studio**
2. **File → Open** → seleccionar la carpeta `mobile/` del repositorio
3. Esperar a que **Gradle sincronice** las dependencias (puede tomar varios minutos la primera vez)
4. **Tools → Device Manager** → **Create Virtual Device** → seleccionar un dispositivo (ej: Pixel 7) → descargar imagen del sistema (API 34) → Finish
5. Iniciar el emulador desde Device Manager
6. Click en **Run ▶** (o Shift+F10) para compilar e instalar la app

### Instalación con APK

También se puede instalar directamente el archivo APK en un dispositivo o emulador Android:

1. Descargar el archivo APK de la entrega
2. En el dispositivo Android: Ajustes → Seguridad → Permitir instalación de fuentes desconocidas
3. Abrir el archivo APK e instalar

### Generar el APK desde Android Studio

1. **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. El archivo se genera en `mobile/app/build/outputs/apk/debug/app-debug.apk`

### Pantallas y flujo de navegación

```
Login → Selección de Usuario → Home Personal (Alejandra/Cecilia/Polo) → Crear Alarma
  ↓                                    ↓                                      ↑
Registro                           Historial                            (Agregar vuelve)
```

| Pantalla | Descripción |
|---|---|
| Login | Inicio de sesión con navegación a Registro |
| Registro | Registro de nuevo usuario |
| Selección de Usuario | Selección de perfil a gestionar (Alejandra, Cecilia, Polo) |
| Home Personal Alejandra | Dashboard de alarmas con switches ON/OFF |
| Home Personal Cecilia | Dashboard de alarmas (perfil Mamá) |
| Home Personal Polo | Dashboard de alarmas (perfil Mascota) |
| Crear Alarma | Formulario con date picker, time picker, dropdown, checkboxes |
| Historial | Historial de tomas de medicamento |
