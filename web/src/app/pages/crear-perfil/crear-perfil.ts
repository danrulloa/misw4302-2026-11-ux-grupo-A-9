import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { NavbarAuth } from '../../shared/components/navbar-auth/navbar-auth';
import { TextField } from '../../shared/components/text-field/text-field';
import { DsButton } from '../../shared/components/ds-button/ds-button';
import { Divider } from '../../shared/components/divider/divider';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-crear-perfil',
  imports: [FormsModule, PageBackground, NavbarAuth, TextField, DsButton, Divider],
  templateUrl: './crear-perfil.html',
  styleUrl: './crear-perfil.scss',
})
export class CrearPerfil {
  nombre = '';
  correo = '';
  checkboxActive = false;
  dropdownOpen = false;
  selectedRelacion = '';

  relaciones = ['Espos@', 'Hij@', 'Mamá', 'Papá', 'Suegr@', 'Mascota'];

  get isMascota(): boolean {
    return this.selectedRelacion === 'Mascota';
  }

  get isEmailDisabled(): boolean {
    return this.isMascota || !this.checkboxActive;
  }

  private userService = inject(UserService);

  constructor(private router: Router) {}

  toggleDropdown(): void {
    this.dropdownOpen = !this.dropdownOpen;
  }

  selectRelacion(relacion: string): void {
    this.selectedRelacion = relacion;
    this.dropdownOpen = false;
    if (relacion === 'Mascota') {
      this.checkboxActive = false;
      this.correo = '';
    }
  }

  onCancel(): void {
    this.router.navigate(['/seleccion-perfil']);
  }

  onSave(): void {
    this.userService.familyName.set(this.nombre.trim() || 'Nombre perfil familiar');
    this.userService.familyRelation.set(this.selectedRelacion || 'relación contigo');
    this.router.navigate(['/seleccion-perfil-familiar']);
  }
}
