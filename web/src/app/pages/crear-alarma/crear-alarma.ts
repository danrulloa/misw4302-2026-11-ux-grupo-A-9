import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { NavbarAuth } from '../../shared/components/navbar-auth/navbar-auth';
import { TextField } from '../../shared/components/text-field/text-field';
import { DsButton } from '../../shared/components/ds-button/ds-button';
import { Divider } from '../../shared/components/divider/divider';
import { DatePicker } from '../../shared/components/date-picker/date-picker';
import { TimePicker } from '../../shared/components/time-picker/time-picker';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-crear-alarma',
  imports: [FormsModule, PageBackground, NavbarAuth, TextField, DsButton, Divider, DatePicker, TimePicker],
  templateUrl: './crear-alarma.html',
  styleUrl: './crear-alarma.scss',
})
export class CrearAlarma {
  userService = inject(UserService);

  medicamento = '';
  fecha = '';
  hora = '';
  frecuencia = '';
  selectedUnidad = '';
  dropdownOpen = false;
  showDatePicker = false;
  showTimePicker = false;
  snoozeRepetir = false;
  snoozeEscalar = false;

  unidades = ['Minutos', 'Horas', 'Días', 'Semanas', 'Mes', 'Año'];

  constructor(private router: Router) {}

  toggleDropdown(): void {
    this.dropdownOpen = !this.dropdownOpen;
  }

  selectUnidad(unidad: string): void {
    this.selectedUnidad = unidad;
    this.dropdownOpen = false;
  }

  onDateSelected(date: string): void {
    this.fecha = date;
    this.showDatePicker = false;
  }

  onTimeSelected(time: string): void {
    this.hora = time;
    this.showTimePicker = false;
  }

  onCancelar(): void {
    this.router.navigate(['/home-alarmas']);
  }

  onAgregar(): void {
    this.userService.addAlarma({
      nombre: this.medicamento || 'Nuevo medicamento',
      hora: this.hora || '8:00 AM',
      frecuencia: this.frecuencia
        ? `Cada ${this.frecuencia} ${this.selectedUnidad || 'Horas'}`
        : 'Todos los días',
      activa: true,
    });
    this.router.navigate(['/home-alarmas']);
  }
}
