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
- JDK 17 o superior

### Instalación y ejecución

_Instrucciones pendientes._

### Pantallas

| Pantalla | Descripción |
|---|---|
| Login | Inicio de sesión |
| Registro | Registro de nuevo usuario |
| Selección de Usuario | Selección de perfil a gestionar |
| Home Personal | Dashboard de alarmas por perfil (Alejandra, Cecilia, Polo) |
| Crear Alarma | Formulario de nueva alarma de medicamento |
| Historial | Historial de tomas de medicamento |
