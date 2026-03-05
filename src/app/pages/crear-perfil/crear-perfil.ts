import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { NavbarAuth } from '../../shared/components/navbar-auth/navbar-auth';
import { TextField } from '../../shared/components/text-field/text-field';
import { DsButton } from '../../shared/components/ds-button/ds-button';
import { Divider } from '../../shared/components/divider/divider';

@Component({
  selector: 'app-crear-perfil',
  imports: [FormsModule, PageBackground, NavbarAuth, TextField, DsButton, Divider],
  templateUrl: './crear-perfil.html',
  styleUrl: './crear-perfil.scss',
})
export class CrearPerfil {
  nombre = '';
  correo = '';
  relacionExpanded = false;
  checkboxActive = false;

  constructor(private router: Router) {}

  toggleRelacion(): void {
    this.relacionExpanded = !this.relacionExpanded;
  }

  onCancel(): void {
    this.router.navigate(['/seleccion-perfil']);
  }

  onSave(): void {
    this.router.navigate(['/seleccion-perfil-familiar']);
  }
}
