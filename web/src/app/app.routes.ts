import { Routes } from '@angular/router';
import { Registro } from './pages/registro/registro';
import { SeleccionPerfil } from './pages/seleccion-perfil/seleccion-perfil';
import { CrearPerfil } from './pages/crear-perfil/crear-perfil';
import { SeleccionPerfilFamiliar } from './pages/seleccion-perfil-familiar/seleccion-perfil-familiar';

export const routes: Routes = [
  { path: '', redirectTo: 'registro', pathMatch: 'full' },
  { path: 'registro', component: Registro },
  { path: 'seleccion-perfil', component: SeleccionPerfil },
  { path: 'crear-perfil', component: CrearPerfil },
  { path: 'seleccion-perfil-familiar', component: SeleccionPerfilFamiliar },
];
