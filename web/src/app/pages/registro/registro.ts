import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { TextField } from '../../shared/components/text-field/text-field';
import { DsButton } from '../../shared/components/ds-button/ds-button';
import { UserService } from '../../shared/services/user.service';

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

  errorNombre = '';
  errorCorreo = '';
  errorPassword = '';
  errorConfirmPassword = '';

  private userService = inject(UserService);

  constructor(private router: Router) {}

  onSubmit(): void {
    this.clearErrors();
    const allEmpty = !this.nombre.trim() && !this.correo.trim()
      && !this.password && !this.confirmPassword;
    if (allEmpty || this.validate()) {
      this.userService.userName.set(this.nombre.trim() || 'Tu nombre');
      this.router.navigate(['/seleccion-perfil']);
    }
  }

  onCancel(): void {
    this.nombre = '';
    this.correo = '';
    this.password = '';
    this.confirmPassword = '';
    this.clearErrors();
  }

  private clearErrors(): void {
    this.errorNombre = '';
    this.errorCorreo = '';
    this.errorPassword = '';
    this.errorConfirmPassword = '';
  }

  private validate(): boolean {
    let valid = true;

    // Nombre: requerido, alfanumérico con espacios/acentos, max 100
    if (!this.nombre.trim()) {
      this.errorNombre = 'El nombre es obligatorio';
      valid = false;
    } else if (!/^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\s]+$/.test(this.nombre)) {
      this.errorNombre = 'Solo se permiten letras y espacios';
      valid = false;
    } else if (this.nombre.length > 100) {
      this.errorNombre = 'Máximo 100 caracteres';
      valid = false;
    }

    // Correo: requerido, formato XXX@YYY.SSS
    if (!this.correo.trim()) {
      this.errorCorreo = 'El correo es obligatorio';
      valid = false;
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.correo)) {
      this.errorCorreo = 'Formato inválido (ej: nombre@correo.com)';
      valid = false;
    }

    // Contraseña: requerida, min 8, letras + números + especiales
    if (!this.password) {
      this.errorPassword = 'La contraseña es obligatoria';
      valid = false;
    } else if (this.password.length < 8) {
      this.errorPassword = 'Mínimo 8 caracteres';
      valid = false;
    } else if (!/[a-zA-Z]/.test(this.password)) {
      this.errorPassword = 'Debe contener al menos una letra';
      valid = false;
    } else if (!/[0-9]/.test(this.password)) {
      this.errorPassword = 'Debe contener al menos un número';
      valid = false;
    } else if (!/[^a-zA-Z0-9]/.test(this.password)) {
      this.errorPassword = 'Debe contener al menos un carácter especial';
      valid = false;
    }

    // Confirmar contraseña: requerida, debe coincidir
    if (!this.confirmPassword) {
      this.errorConfirmPassword = 'Debes confirmar la contraseña';
      valid = false;
    } else if (this.confirmPassword !== this.password) {
      this.errorConfirmPassword = 'Las contraseñas no coinciden';
      valid = false;
    }

    return valid;
  }
}
