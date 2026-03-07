import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { TextField } from '../../shared/components/text-field/text-field';
import { DsButton } from '../../shared/components/ds-button/ds-button';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-login',
  imports: [PageBackground, TextField, DsButton],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {
  correo = '';
  password = '';
  private userService = inject(UserService);

  constructor(private router: Router) {}

  onIngresar(): void {
    this.userService.setReturningUser();
    this.router.navigate(['/seleccion-perfil']);
  }

  onRegistro(): void {
    this.router.navigate(['/registro']);
  }
}
