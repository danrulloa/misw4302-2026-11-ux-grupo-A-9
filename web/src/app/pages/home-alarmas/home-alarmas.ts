import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { PageBackground } from '../../shared/components/page-background/page-background';
import { NavbarAuth } from '../../shared/components/navbar-auth/navbar-auth';
import { DsButton } from '../../shared/components/ds-button/ds-button';
import { Divider } from '../../shared/components/divider/divider';
import { UserService } from '../../shared/services/user.service';

@Component({
  selector: 'app-home-alarmas',
  imports: [FormsModule, PageBackground, NavbarAuth, DsButton, Divider],
  templateUrl: './home-alarmas.html',
  styleUrl: './home-alarmas.scss',
})
export class HomeAlarmas {
  userService = inject(UserService);

  constructor(private router: Router) {}

  onAgregarAlarma(): void {
    this.router.navigate(['/crear-alarma']);
  }

  onTabChange(index: number): void {
    if (index === 2) {
      if (this.userService.hasFamilyProfile()) {
        this.router.navigate(['/seleccion-perfil-familiar']);
      } else {
        this.router.navigate(['/seleccion-perfil']);
      }
    }
  }

  toggleAlarma(i: number): void {
    if (this.userService.activeProfile() === 'own') {
      this.userService.ownAlarmas.update(list =>
        list.map((a, idx) => idx === i ? { ...a, activa: !a.activa } : a)
      );
    } else {
      this.userService.familyAlarmas.update(list =>
        list.map((a, idx) => idx === i ? { ...a, activa: !a.activa } : a)
      );
    }
  }
}
