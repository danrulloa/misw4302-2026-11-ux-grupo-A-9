import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { TextField } from '../../shared/components/text-field/text-field';
import { DsButton } from '../../shared/components/ds-button/ds-button';

@Component({
  selector: 'app-registro',
  imports: [PageBackground, TextField, DsButton],
  templateUrl: './registro.html',
  styleUrl: './registro.scss',
})
export class Registro {
  nombre = '';
  correo = '';
  password = '';
  confirmPassword = '';

  constructor(private router: Router) {}

  onSubmit(): void {
    this.router.navigate(['/seleccion-perfil']);
  }

  onCancel(): void {
    this.nombre = '';
    this.correo = '';
    this.password = '';
    this.confirmPassword = '';
  }
}
