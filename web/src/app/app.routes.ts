import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { Registro } from './pages/registro/registro';
import { SeleccionPerfil } from './pages/seleccion-perfil/seleccion-perfil';
import { CrearPerfil } from './pages/crear-perfil/crear-perfil';
import { SeleccionPerfilFamiliar } from './pages/seleccion-perfil-familiar/seleccion-perfil-familiar';
import { HomeAlarmas } from './pages/home-alarmas/home-alarmas';
import { CrearAlarma } from './pages/crear-alarma/crear-alarma';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: Login },
  { path: 'registro', component: Registro },
  { path: 'seleccion-perfil', component: SeleccionPerfil },
  { path: 'crear-perfil', component: CrearPerfil },
  { path: 'seleccion-perfil-familiar', component: SeleccionPerfilFamiliar },
  { path: 'home-alarmas', component: HomeAlarmas },
  { path: 'crear-alarma', component: CrearAlarma },
];
